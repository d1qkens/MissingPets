package com.example.retrofittest.data.model;

public class PureAnimal {
    int id;
    String pet, gender, nickname, breed, color, location, contacts, info;

    PureAnimal(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getPet() {
        return pet;
    }

    public String getGender() {
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

    public String getLocation() {
        return location;
    }

    public String getContacts() {
        return contacts;
    }

    public String getInfo() {
        return info;
    }


}
