package com.example.apiapplication;

import com.google.gson.annotations.SerializedName;

public class MODEL
{
    @SerializedName("setUpJoke")
    public String setUpJoke;
    @SerializedName("punchLine")
    public String punchLine;


    public MODEL (String setUpJokeText, String punchLineText)
    {
        setUpJoke = setUpJokeText;
        punchLine = punchLineText;
    }
    /** getters */
    public String getSetUpJoke()
    {
        return setUpJoke;
    }

    public String getPunchLine()
    {
        return punchLine;
    }

    /** setters */
    public void setTranslatedText(final String setUpJokeText)
    {
        this.setUpJoke = setUpJokeText;
    }

    public void setPunchLineText(final String punchLineText)
    {
        this.punchLine = punchLineText;
    }
}
