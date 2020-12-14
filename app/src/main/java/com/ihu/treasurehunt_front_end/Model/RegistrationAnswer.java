package com.ihu.treasurehunt_front_end.Model;

import com.google.gson.annotations.SerializedName;


public class RegistrationAnswer
{
    @SerializedName("answer")
    String answer;

    public RegistrationAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
