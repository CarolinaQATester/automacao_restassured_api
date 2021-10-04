package br.com.restassuredapitesting.tests.booking.requests;

import br.com.restassuredapitesting.tests.auths.requests.PostAuthRequest;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class PutBookingRequest {


    PostAuthRequest postAuthRequest = new PostAuthRequest();

    @Step("Altera uma reserva com token")
        public Response alterarUmaReservaComToken(int id, JSONObject payload){
            return given()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .header("Cookie", postAuthRequest.getToken())
                    .when()
                    .body(payload.toString())
                    .put("booking/" + id);
        }

}
