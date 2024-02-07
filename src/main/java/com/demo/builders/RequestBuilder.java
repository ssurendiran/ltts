package com.demo.builders;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

public static RequestSpecification buildRequest(){
    return RestAssured.given().baseUri("https://reqres.in");
}

}
