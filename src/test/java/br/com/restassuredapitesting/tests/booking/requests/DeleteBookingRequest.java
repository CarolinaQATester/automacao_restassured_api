package br.com.restassuredapitesting.tests.booking.requests;

import br.com.restassuredapitesting.tests.auths.requests.PostAuthRequest;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class DeleteBookingRequest {

    @Step("Excluir um reserva com sucesso")
    public Response deleteBooking(int id, JSONObject payload){
        return given()
                .header("Content-Type", "application/json")
                .queryParam("bookingid", 11)
                .when()
                .body(payload.toString())
                .delete("booking/" + id);
    }
}
