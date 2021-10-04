package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.requests.DeleteBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.GetRequestBooking;
import br.com.restassuredapitesting.tests.booking.requests.PutBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;

public class DeleteBookingTest extends BaseTest {

    GetRequestBooking getRequestBooking = new GetRequestBooking();

    DeleteBookingRequest deleteBookingRequest = new DeleteBookingRequest();
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Excluir um reserva com sucesso")
    @Description("Devo excluir um reserva com sucesso")
    public void verificarSeExluiuUmaReservaComSucesso() throws Exception{
        int primeiroId = getRequestBooking.allBookings().then().statusCode(200).extract().path("[3].bookingid");
        System.out.println(primeiroId);

        deleteBookingRequest.deleteBooking(primeiroId,Utils.verificaPayload("Carolina", "Mesquita",112, true, "Braekfast"))
                .then()
                .log().all()
                .statusCode(200)
                .body(isEmptyString());


    }
}
