package com.example.retrofittest;

import com.example.retrofittest.data.model.PureAnimal;

import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.POST;

public interface MyApi {
        @GET("/pets")
        PureAnimal[] fetchAnimal();

        @POST("/pet")
        PureAnimal addAnimal(@Body PureAnimal animal);
}
