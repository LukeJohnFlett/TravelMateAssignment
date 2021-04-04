package com.example.travelmateassignment.ui.dashboard;

public class Post {


    private String country;
    private String name;
    private String decription;


    public Post(String country, String name, String decription) {
        this.country = country;
        this.name = name;
        this.decription = decription;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }



    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getDecription() {
        return decription;
    }

}
