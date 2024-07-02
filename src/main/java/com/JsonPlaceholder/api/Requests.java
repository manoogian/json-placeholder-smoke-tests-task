package com.JsonPlaceholder.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Requests {

    public Response get(String url){
        return  RestAssured.get(url);
    }
    public String post(String url, String body){
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(body)
                .post(url);
        return  response.getBody().asString();
    }
    public Response put(String url, String body){
        //TODO
        return  RestAssured.put(url, body);
    }
    public Response delete(String url, String body){
        //TODO
        return  RestAssured.delete(url, body);
    }

}
