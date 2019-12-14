package com.example.myapplication.model;

public class ItemModel {
    String first_name;
    String middle_name;
    String last_name;
    String profile_image;
    String city;
    String Country;
    String message;
    String success;
    String data;
    String from;
    String to;
    String from_time;
    String to_time;
    String cost;
    String value;
    String currency;
    String currency_symbol;
    String trip_duration_in_mins;
    String trips;

    public ItemModel(String from, String to, String from_time, String to_time) {
        this.from = from;
        this.to = to;
        this.from_time = from_time;
        this.to_time = to_time;
    }

    public ItemModel(String first_name, String middle_name, String last_name, String profile_image, String city, String country, String message, String success, String data, String from, String to, String from_time, String to_time, String cost, String value, String currency, String currency_symbol, String trip_duration_in_mins) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.profile_image = profile_image;
        this.city = city;
        this.Country = country;
        this.message = message;
        this.success = success;
        this.data = data;
        this.from = from;
        this.to = to;
        this.from_time = from_time;
        this.to_time = to_time;
        this.cost = cost;
        this.value = value;
        this.currency = currency;
        this.currency_symbol = currency_symbol;
        this.trip_duration_in_mins = trip_duration_in_mins;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom_time() {
        return from_time;
    }

    public void setFrom_time(String from_time) {
        this.from_time = from_time;
    }

    public String getTo_time() {
        return to_time;
    }

    public void setTo_time(String to_time) {
        this.to_time = to_time;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency_symbol() {
        return currency_symbol;
    }

    public void setCurrency_symbol(String currency_symbol) {
        this.currency_symbol = currency_symbol;
    }

    public String getTrip_duration_in_mins() {
        return trip_duration_in_mins;
    }

    public void setTrip_duration_in_mins(String trip_duration_in_mins) {
        this.trip_duration_in_mins = trip_duration_in_mins;
    }
}
