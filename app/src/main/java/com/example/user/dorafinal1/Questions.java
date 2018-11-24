package com.example.user.dorafinal1;

import java.io.Serializable;

public class Questions{

    public String mQuestions[] = {
            "Question one: I feel restless, agitated, frantic, or tense.",
            "Question two: I am very anxious, worried or scared about a lot of things in my life.",
            "Question three: I have trouble sleeping. I cannot fall or stay asleep, or do not feel well-rested when I wake up.",
            "Question four: How passionate are you towards your study or job?",
            "Question five: I found it difficult to work up the initiative to do things.",
            "Question six: I choose to do something because of the thing itself, rather than the extrinsic benefits associated with it.",
            "Question seven: I tended to over-react to situation.",
            "Question eight: I was intolerant of anything that kept me from getting on with what I was doing. ",
            "Question nine: It is very easy for me to get emotional (sad or angry)."
    };

    private String mChoices[][] = {
            {"Never", "Sometimes","Often","Almost Always"},
            {"Never", "Sometimes","Often","Almost Always"},
            {"Never", "Sometimes","Often","Almost Always"},
            {"Not Passionate", "Somewhat Passionate","Passionate","Very Passionate"},
            {"Never", "Sometimes","Often","Almost Always"},
            {"Never", "Sometimes","Often","Almost Always"},
            {"Never", "Sometimes","Often","Almost Always"},
            {"Never", "Sometimes","Often","Almost Always"},
            {"Never", "Sometimes","Often","Almost Always"}
    };

    private String mThreePointAnswer[] = {
            "Almost Always", //Anxiety: more score = more anxious
            "Almost Always",
            "Almost Always",
            "Very Passionate", //Motivation: more score = more motivated
            "Never",
            "Almost Always",
            "Never", //Emotional/Neuroticism:  more score = more stable
            "Never",
            "Never",
    };

    private String mTwoPointAnswer[] = {
            "Often", //Anxiety
            "Often",
            "Often",
            "Passionate", //Motivation
            "Sometimes",
            "Often",
            "Sometimes", //Emotional
            "Sometimes",
            "Sometimes",
    };

    private String mOnePointAnswer[] = {
            "Sometimes",//Anxiety
            "Sometimes",
            "Sometimes",
            "Somewhat Passionate",//Motivation
            "Often",
            "Sometimes",
            "Often",//Emotional
            "Often",
            "Often",
    };

    private String mZeroPointAnswer[] = {
            "Never",//Anxiety
            "Never",
            "Never",
            "Not Passionate",//Motivation
            "Almost Always",
            "Never",
            "Almost Always",//Emotional
            "Almost Always",
            "Almost Always",
    };

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a){
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a){
        String choice = mChoices[a][2];
        return choice;
    }
    public String getChoice4(int a){
        String choice = mChoices[a][3];
        return choice;
    }

    public String getThreePointAnswer(int a){
        String answer = mThreePointAnswer[a];
        return answer;
    }

    public String getTwoPointAnswer(int a){
        String answer = mTwoPointAnswer[a];
        return answer;
    }

    public String getOnePointAnswer(int a){
        String answer = mOnePointAnswer[a];
        return answer;
    }

    public String getZeroPointAnswer(int a){
        String answer = mZeroPointAnswer[a];
        return answer;
    }






}
