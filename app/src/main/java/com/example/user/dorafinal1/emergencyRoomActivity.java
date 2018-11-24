package com.example.user.dorafinal1;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class emergencyRoomActivity extends AppCompatActivity {
    public static RecyclerView recyclerView;
    public static RecyclerView.Adapter adapter;
    public static Context context;
    public static List<HospitalRecord> hospitals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_room);
        emergencyRoomActivity.context = getApplicationContext();

        recyclerView= (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));

        new HttpGetTask().execute("https://data.medicare.gov/resource/3z8n-wcgr.json?condition=Emergency%20Department&state=MA&city=BOSTON&measure_id=EDV");
    }

    private class HttpGetTask extends AsyncTask<String,Integer,String>{

        @Override
        protected String doInBackground(String... strings) {
            String queryString = strings[0];
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            String hospitalJSONString = null;
            try{
                URL requestURL = new URL(queryString);

                // Open the network connection.
                urlConnection = (HttpURLConnection) requestURL.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Get the InputStream.
                InputStream inputStream = urlConnection.getInputStream();

                // Read the response string into a StringBuilder.
                StringBuilder builder = new StringBuilder();

                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // but it does make debugging a *lot* easier if you print out the completed buffer for debugging.
                    builder.append(line + "\n");
                    publishProgress();
                }

                if (builder.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    // return null;
                    return null;
                }
                hospitalJSONString = builder.toString();
            } catch (IOException e) {
                e.printStackTrace();

                // Close the connections.
            }finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return hospitalJSONString;
        }

        @Override
        protected void onPostExecute(String s) {
            hospitals = new ArrayList<HospitalRecord>();
            String address;
            String city;
            String county;
            String condition;
            String hospitalName;
            String phoneNumber;
            String zipCode;
            Double lng;
            Double lat;

            try{
                JSONArray topLevelArray = new JSONArray(s);
                int i = 0;
                while (i<topLevelArray.length()){
                    JSONObject hospitalObject = topLevelArray.getJSONObject(i);
                    address = hospitalObject.getString("address");
                    city = hospitalObject.getString("city");
                    county = hospitalObject.getString("county_name");
                    hospitalName = hospitalObject.getString("hospital_name");
                    phoneNumber = hospitalObject.getString("phone_number");
                    zipCode = hospitalObject.getString("zip_code");
                    JSONObject location = hospitalObject.getJSONObject("location");
                    JSONArray coordinates = location.getJSONArray("coordinates");

                    List<Double> list = new ArrayList<Double>();
                    for (int k=0; k<coordinates.length(); k++) {
                        list.add(coordinates.getDouble(k));
                    }
                    lng = list.get(0);
                    lat = list.get(1);
                    System.out.println(lat);
                    HospitalRecord hospital = new HospitalRecord();
                    hospital.setAddress(address);
                    hospital.setCity(city);
                    hospital.setCounty(county);
                    hospital.setHospitalName(hospitalName);
                    hospital.setPhoneNumber(phoneNumber);
                    hospital.setZipcode(zipCode);
                    hospital.setLat(lat);
                    hospital.setLng(lng);
                    hospitals.add(hospital); //add the new hospital to the list of hospitals
                    i++;
                }
                //TODO: display on the recylcerView
                adapter= new MapAdapter(hospitals);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
