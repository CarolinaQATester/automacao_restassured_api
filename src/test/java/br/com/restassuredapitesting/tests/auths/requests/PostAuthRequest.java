package br.com.restassuredapitesting.tests.auths.requests;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

@Feature("Buscar um token")
public class PostAuthRequest {

    @Step("Buscar um token")
    public Response token() {
        JSONObject payload = new JSONObject();
        payload.put("username", "admin");
        payload.put("password", "password123");
        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(payload.toString())
                .post("auth");
    }
    @Step("Retornar o token")
    public String getToken(){
        return "token=" + this.token()
                    .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .path("token");
    }
}
