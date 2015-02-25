package com.example.retrofittest.data.model;

public class PureAnimal {
    int pet_type_id;
    double location_lat, location_lon;
    boolean gender;
    String id, nickname, breed, address, color, contacts, additional_info, photo;

    PureAnimal(String id) {
        this.id = id;
    }

    public String getId() {
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


}
