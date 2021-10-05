package br.com.restassuredapitesting.tests.booking.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class GetRequestBooking {

    @Step("Verificar se api está online")
    public Response apiDisponivel(){
        return given()
                .when()
                .get("ping");
    }
    @Step("Listar todas as reservas")
    public Response allBookings(){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("booking");

    }
    @Step("Buscar uma reservas por especifico")
    public Response findByIdBookings(int id, JSONObject payload){
        return given()
                .header("Accept", "application/json")
                .param("firstname","Carolina")
                .when()
                .body(payload.toString())
                .get("booking/" + id );

    }
    @Step("Lista Ids de reservas utilizando o filtro fisrtname")
    public Response findByFistname(int id, JSONObject payload){
        return given()
                .header("Accept", "application/json")
                .param("firstname","Susan")
                .when()
                .body(payload.toString())
                .get("booking/" + id );
    }


}
