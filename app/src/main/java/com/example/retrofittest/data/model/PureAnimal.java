package com.example.retrofittest.data.model;

public class PureAnimal {
    int pet_type_id;
    double location_lat, location_lon;
    boolean gender;
    String id, nickname, breed, address, color, contacts, additional_info, photo;

    public PureAnimal() {

    }

    public String getRemoteId() {
        return id;
    }

    public int getPetTypeId() {
        return pet_type_id;
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

    public double getLocationLon() {
        return location_lon;
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


    public void setPet_type_id(int pet_type_id) {
        this.pet_type_id = pet_type_id;
    }

    public void setLocation_lat(double location_lat) {
        this.location_lat = location_lat;
    }

    public void setLocation_lon(double location_lon) {
        this.location_lon = location_lon;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setId(String id) {
        this.id = id;
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
