package com.example.retrofittest.data.model;

public class PureAnimal {
    int type;
    double location_lat, location_log;
    boolean gender;
    String _id, nickname, breed, address, color, contacts, additional_info, photo;

    public PureAnimal() {
    }

    public String getRemoteId() {
        return _id;
    }

    public int getPetType() {
        return type;
    }

    public boolean getGender() {
        return gender;
    }

    public String getNickname() {
        return nickname;
    }

    public String getBreed() {
        return breed;
    }

    public String getColor() {
        return color;
    }

    public double getLocationLat() {
        return location_lat;
    }

    public double getLocationLog() {
        return location_log;
    }

    public String getAddress() {
        return address;
    }

    public String getContacts() {
        return contacts;
    }

    public String getInfo() {
        return additional_info;
    }

    public String getPhoto() {
        return photo;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setLocation_lat(double location_lat) {
        this.location_lat = location_lat;
    }

    public void setLocation_log(double location_log) {
        this.location_log = location_log;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setId(String id) {
        this._id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public void setAdditional_info(String additional_info) {
        this.additional_info = additional_info;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}