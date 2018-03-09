package com.asif047.pocketmoney.Model;


public class Pocket {

    private long id;
    private String type;
    private String date;
    private String description;
    private double amount;
    private String month;
    private String category;

    public Pocket() {
    }

    public Pocket(String type, String date, String description, double amount, String month, String category) {
        this.type = type;
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.month = month;
        this.category = category;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
