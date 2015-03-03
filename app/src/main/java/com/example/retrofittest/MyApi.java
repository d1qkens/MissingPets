package com.example.retrofittest;

import com.example.retrofittest.data.model.PureAnimal;

import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface MyApi {
    @GET("/pets")
    public PureAnimal[] fetchAnimal();

    @POST("/pet")
    public PureAnimal addAnimal(@Body PureAnimal animal);

    @DELETE("/pet/{id}")
    public String deleteAnimal(@Path("id") String id);
}

