package com.scheduler.qa;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssured {
    @Test
    public void GetLogin() {
        RequestSpecification httpRequest = io.restassured.RestAssured.given();

        Response response = httpRequest.given().header("Content-Type", "application/json").given()
                .header("Authorization", "dGVzdGVyXzJAZ20uY29tOjEyMzQ1NjdYeA==").
                        request().get("https://java-3-ilcarro-team-b.herokuapp.com/user/login");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);

        int statusCode = response.getStatusCode();
        System.out.println("Actual Status Code is : " + statusCode);

        Assert.assertEquals(statusCode, 200,
                "BUG : Status code is coming as different");
        JsonElement parsed = new JsonParser().parse(responseBody);
        String first_name = parsed.getAsJsonObject().get("first_name").toString();
        String own_cars = parsed.getAsJsonObject().get("own_cars").toString();
        System.out.println(first_name + " " + own_cars);
    }

    @Test(enabled = false)
    public void testPostRequest(){
        RequestSpecification httpRequest = io.restassured.RestAssured.given();

            Response response = httpRequest.given().header("Content-Type", "application/json").given()
                    .header("Authorization", "YWhoaEBnbWFpbC5jb206UXdlcnR5MQ==").
                            request().body("\"email\": \" ahhh@gmail.com \", \"password\": \" + Qwerty1 + \" }").when().post("https://java-3-ilcarro-team-b.herokuapp.com/registration");


            String responseBody = response.getBody().asString();
            System.out.println("Response Body is =>  " + responseBody);

            int statusCode = response.getStatusCode();
            System.out.println("Actual Status Code is : " + statusCode);

            Assert.assertEquals(statusCode, 200,
                    "BUG : Status code is coming as different");
            JsonElement parsed = new JsonParser().parse(responseBody);
            String first_name = parsed.getAsJsonObject().get("first_name").toString();
            String own_cars = parsed.getAsJsonObject().get("own_cars").toString();
            System.out.println(first_name + " " + own_cars);
        }
    }

