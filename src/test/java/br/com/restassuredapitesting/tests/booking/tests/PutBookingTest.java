package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.tests.auths.requests.PostAuthRequest;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.requests.GetRequestBooking;
import br.com.restassuredapitesting.tests.booking.requests.PutBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

@Feature("Reservas")
public class PutBookingTest extends BaseTest {

    GetRequestBooking getRequestBooking = new GetRequestBooking();

    PutBookingRequest putBookingRequest = new PutBookingRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Alterar uma reserva utilizando token")
    @Description("Devo alterar uma reserva utilizando token")
    public void verificarAlterarUmaReservaUtilizandoToken() throws Exception{
        int primeiroId = getRequestBooking.allBookings().then().statusCode(200).extract().path("[3].bookingid");
        System.out.println(primeiroId);

        putBookingRequest.alterarUmaReservaComToken(primeiroId, Utils.verificaPayload("Carolina", "Mesquita",112, true, "Braekfast"))
                .then()
                .log().all()
                .statusCode(200). time(lessThan(2L), TimeUnit.SECONDS)
                .body("size()", greaterThan(0));


    }
}
