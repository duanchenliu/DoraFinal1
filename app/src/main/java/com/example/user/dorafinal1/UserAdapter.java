package com.example.user.dorafinal1;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    Context mContext;
    List<MentalRecord> items;
    AppDatabase db;
    MentalRecord txbook;
    private TextToSpeech tts;
    private String temp2;

    public UserAdapter(List<MentalRecord> items){
        this.items = items;
    }


    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_summary, parent, false);
        mContext = parent.getContext();
        db = Room.databaseBuilder(mContext, AppDatabase.class, AppDatabase.NAME).build();
        return new ViewHolder(view);
    }


        @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {
        holder.date.setText(" " + items.get(position).getDate());
        holder.anxietyScore.setText(" " + items.get(position).getAnxietyScore());
        final int index = position;
//        holder.itemView.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                texttospeech(index);
//                items.get(index);
//                txbook = items.get(index);
//                Intent moreInfo = new Intent(mContext, moreTextbookInfo.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("textbook", items.get(index));
//                moreInfo.putExtras(bundle);
//                mContext.startActivity(moreInfo);
//            }
//        });
//
//        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
//            public boolean onLongClick(View v){
//                //items.get(index);
//                //txbook = items.get(index);
//                System.out.println("index of delete item " + index );
//                System.out.println("item size before delete: " + items.size() );
//                System.out.println("id before delete " + items.get(index).getBookID());
//                //new deleteTXTBOOKID(db, recyclerView, adapter, mContext, items, index).execute(items.get(index).getBookID());
//                //new deleteOneTextBook(db, recyclerView, adapter, mContext, items, index).execute(items.get(index));
//                //new deleteTXTBOOKID(db, recyclerView, adapter, mContext, items, index).execute(items.get(index).getBookID());//????/
//                new deleteOneTextBookBaseOnInfo(db, recyclerView, adapter, mContext, items, index).execute(items.get(index));
//                return true;
//            }
//        });
    }

    @Override
    public int getItemCount() {
        if (items == null)
            return 0;
        else
            return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView date;
        public TextView anxietyScore;

        public ViewHolder(View itemView){
            super(itemView);
            date = itemView.findViewById(R.id.date);
            anxietyScore = itemView.findViewById(R.id.anxietyScore);
        }
    }


}


