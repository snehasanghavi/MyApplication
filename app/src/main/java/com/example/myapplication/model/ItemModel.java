package com.example.myapplication.model;

import org.json.JSONObject;

public class ItemModel {
    String value;
    String currency;
    String currency_symbol;
    String trips;
    String from;
    String to;
    String from_time;
    String to_time;
    JSONObject cost;
    String trip_duration_in_mins;

    public ItemModel() {
    }

    public ItemModel(String from, String from_time, String to, String to_time, JSONObject cost,String value,String currency_symbol,String trip_duration_in_mins) {
        this.from=from;
        this.from_time = from_time;
        this.to = to;
        this.to_time = to_time;
        this.cost=cost;
        this.value=value;
        this.currency_symbol=currency_symbol;
        this.trip_duration_in_mins=trip_duration_in_mins;

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

    public String getTrips() {
        return trips;
    }

    public void setTrips(String trips) {
        this.trips = trips;
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

    public JSONObject getCost() {
        return cost;
    }

    public void setCost(JSONObject cost) {
        this.cost = cost;
    }

    public String getTrip_duration_in_mins() {
        return trip_duration_in_mins;
    }

    public void setTrip_duration_in_mins(String trip_duration_in_mins) {
        this.trip_duration_in_mins = trip_duration_in_mins;
    }
}
