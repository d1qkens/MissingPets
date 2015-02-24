package com.example.retrofittest;

import com.example.retrofittest.data.model.PureAnimal;

import retrofit.http.GET;

public interface MyApi {

        @GET("/s/fxn9dw95q3fpv9u/doggies.json?dl=1")
        PureAnimal[] fetchAnimal();


}
