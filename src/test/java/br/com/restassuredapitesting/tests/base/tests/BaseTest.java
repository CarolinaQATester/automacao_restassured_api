package br.com.restassuredapitesting.tests.base.tests;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class BaseTest {

    @BeforeClass
    public static void steup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI = "https://treinamento-api.herokuapp.com/";
    }
    
}
