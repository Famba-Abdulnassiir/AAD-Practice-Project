package com.example.myapp2;

import com.google.gson.annotations.SerializedName;

public class LeaderList {
    @SerializedName("badgeUrl")
    private String badgeUrl;
    @SerializedName("name")
    private String name;
    @SerializedName("hours")
    private String score;
    @SerializedName("country")
    private String country;

    public LeaderList(String badgeUrl,String name,String score,String country){
        this.badgeUrl = badgeUrl;
        this.name = name;
        this.country = country;
        this.score = score;

    }



    public String getName() {
        return name;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public String getScore() {
        return score;
    }

    public String getCountry() {
        return country;
    }
}


