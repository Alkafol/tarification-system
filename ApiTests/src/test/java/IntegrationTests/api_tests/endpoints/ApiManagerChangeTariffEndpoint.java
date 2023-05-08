package IntegrationTests.api_tests.endpoints;

import IntegrationTests.api_tests.dto.managerdto.ManagedAbonentDto;
import IntegrationTests.api_tests.dto.managerdto.ManagerRegisterDto;

import static io.restassured.RestAssured.given;

@Endpoint("/manager/changeTariff")
public class ApiManagerChangeTariffEndpoint extends BaseEndpoint {

    public ManagedAbonentDto changeTariff(ManagerRegisterDto managerCreds, ManagedAbonentDto abonentParams) {

        return given()
                .auth()
                .preemptive()
                .basic(managerCreds.getLogin(), managerCreds.getPassword())
                .body(abonentParams)
                .patch(getEndpoint())
                .then()
                .statusCode(200)
                .extract()
                .as(ManagedAbonentDto.class);
    }
}
