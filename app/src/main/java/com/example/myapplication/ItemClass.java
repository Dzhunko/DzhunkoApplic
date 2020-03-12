package com.example.myapplication;

import android.content.ClipData;

import java.io.Serializable;

public class ItemClass implements Serializable {
    public String category;
    public String date;
    public String time;
    public int price;
    public String currency;

    public ItemClass(String category, String date, String time, int price, String currency) {
        this.category = category;
        this.currency = currency;
        this.date = date;
        this.price = price;
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category= category;
    }



    public String getDate() {
        return date;
    }

    public void setDate(String category) {
        this.date= date;
    }



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time= time;
    }



    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency= currency;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
