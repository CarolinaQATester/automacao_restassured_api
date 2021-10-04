package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.suites.Contract;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.requests.GetRequestBooking;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;


@Feature("Reservas")
public class GetBookingTest extends BaseTest {

    GetRequestBooking getRequestBooking = new GetRequestBooking();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({Acceptance.class})
    @DisplayName("Verificar se API está online")
    @Description("Devo verificar se API está online")
    public void verificarSeApiEstaOnline(){
        getRequestBooking.apiDisponivel().then()
                .log().all()
                .statusCode(201);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar Id das reservas")
    @Description("Devo buscar uma lista de reserva por id")
    public void verificarIdDasReservas()throws Exception{
        getRequestBooking.allBookings()
                .then()
                .log().all()
                .statusCode(200)
                .time(lessThan(2L), TimeUnit.SECONDS)
                .body("size()", greaterThan(0));
    }
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category(Contract.class)
    @DisplayName("Garantir o contrato de retorno da lista de reserva")
    @Description("Devo garantir o contrato de retorno da lista de reserva")
    public void garantirContratoListaReserva(){
        getRequestBooking.allBookings().then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body(matchesJsonSchema(new File(Utils.getContractsBasePath("booking", "bookings"))));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category(Contract.class)
    @DisplayName("Garantir o contrato do retorno de uma reserva específica")
    @Description("Devo garantir o contrato do retorno de uma reserva específica")
    public void garantirContratoDoRetornoDeUmaReservaEspecifica() {
        int primeiroId = getRequestBooking.allBookings().then().statusCode(200).extract().path("[3].bookingid");
        System.out.println(primeiroId);

        getRequestBooking.findByIdBookings(primeiroId, Utils.verificaPayload("Carolina", "Mesquita",112, true, "Braekfast"))
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .body(matchesJsonSchema(new File(Utils.getContractsBasePath("booking", "bookingsEspecifico"))));
    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar IDs de reservas utilizando o filtro firstname")
    @Description("Devo listar IDs de reservas utilizando o filtro firstname")
    public void verificarFirtnameDasReservas()throws Exception{
        int primeiroId = getRequestBooking.allBookings().then().statusCode(200).extract().path("[2].bookingid");
        System.out.println(primeiroId);

        getRequestBooking.findByFistname(primeiroId, Utils.verificaPayload("Susan", "Ericsson",100, true, "Braekfast"))
                .then()
                .log().all()
                .statusCode(200)
                .time(lessThan(2L), TimeUnit.SECONDS)
                .body("size()", greaterThan(0));
    }

}
