package com.example.myapp2;

import com.google.gson.annotations.SerializedName;

public class SkillsIqList {
    @SerializedName("badgeUrl")
    private String badgeUrl;
    @SerializedName("name")
    private String name;
    @SerializedName("hours")
    private String hours;
    @SerializedName("country")
    private String country;

    public SkillsIqList(String badgeUrl,String name,String hours,String country){
        this.badgeUrl = badgeUrl;
        this.name = name;
        this.country = country;
        this.hours = hours;

    }



    public String getName() {
        return name;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public String getHours() {
        return hours;
    }

    public String getCountry() {
        return country;
    }
}
