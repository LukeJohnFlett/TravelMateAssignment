package com.example.travelmateassignment.ui.dashboard;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.travelmateassignment.R;

@Entity(tableName = "post_table")
public class Post {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String country;
    private String name;
    private String decription;
    private int priority;


    public Post(String country, String name, String decription, int priority) {
        this.id = id;
        this.country = country;
        this.name = name;
        this.decription = decription;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
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
