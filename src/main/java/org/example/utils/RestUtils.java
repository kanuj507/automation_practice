package org.example.utils;

import java.util.Map;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;


public class RestUtils {

    public static Response getByUrl(String url) {
        Response response = given().when().log().all().get(url);
        response.then().log().ifError();
        return response;
    }

    public static Response postByUrl(String url) {
        Response response = RestAssured.post(url);
        return response;
    }

    public static Response deleteByUrl(String url) {
        Response response = given().delete(url);
        return response;
    }

    public static Response postByUrl(String url, Map<String,Object> body, JSONObject jsonObject) {

        Response response =
                given()
                .contentType(ContentType.JSON)
                .and()
                .body(jsonObject.toString())
                .when()
                .post(url);
        System.out.println(response.getBody().print());
        return response;
    }

    public static Response putByUrl(String url, Map<String, Object> body) {
        Response response = given()
                .body(body)
                .put(url);
        return response;
    }
}

