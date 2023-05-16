package api.steps;

import api.models.*;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
public class MTSCreditSteps {
    String orderID;
    @Step("Отправить запрос POST Аутентификация пользователя и получение токена")
    public static Token postAuthenticateUser(AuthenticateUser payload) {
        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(payload)
                .post("auth/authenticate")
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract()
                .body().jsonPath().getObject(".", Token.class);
    }
    @Step("Отправить запрос GET для получения списка тарифов")
    public static Data getTariffs() {
        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .get("loan-service/getTariffs")
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract()
                .body().jsonPath().getObject("data", Data.class);
    }
    @Step("Проверка что в списке тарифов есть тарифы из ТЗ")
    public void checkEMail(Data response) {
         Assertions.assertTrue(response.getTariffs().stream().anyMatch(x -> x.getType().equalsIgnoreCase("CONSUMER")));
         Assertions.assertTrue(response.getTariffs().stream().anyMatch(x -> x.getType().equalsIgnoreCase("MORTGAGE")));
         Assertions.assertTrue(response.getTariffs().stream().anyMatch(x -> x.getType().equalsIgnoreCase("SALE")));
    }
    @Step("Отправить запрос POST для получения orderId")
    public static OrderId getOrder(Order payload, String token) {
        return given()
                .header("Authorization", "Bearer " + token)
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(payload)
                .post("loan-service/order")
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract()
                .body().jsonPath().getObject("data", OrderId.class);
    }
    @Step("Отправить запрос POST для получения ошибки что тариф не существует")
    public static ErrorOrder errorPostLoan(Order payload, String token) {
        return given()
                .header("Authorization", "Bearer " + token)
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(payload)
                .post("loan-service/order")
                .then()
                .spec(SpecHelper.getResponseSpec(400))
                .extract()
                .body().jsonPath().getObject("error", ErrorOrder.class);
    }
    @Step("Проверка что в ответе действительно есть orderId")
    public void checkOrderId(OrderId response) {
            orderID = response.getOrderId();
        System.out.println(orderID);
    }
    @Step("Отправить запрос GET для получения статуса ордера")
    public static Response getAllOrderStatuses(String orderId, String token) {
        return given()
                .header("Authorization", "Bearer " + token)
                .spec(SpecHelper.getRequestSpec())
                .when()
                .get("loan-service/getStatusOrder?orderId=" + orderId)
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract()
                .response();
    }
    @Step("Отправить запрос GET на несуществующую заявки")
    public static ErrorOrder errorGetStatus(String orderId, String token) {
        return given()
                .header("Authorization", "Bearer " + token)
                .spec(SpecHelper.getRequestSpec())
                .when()
                .get("loan-service/getStatusOrder?orderId=" + orderId)
                .then()
                .spec(SpecHelper.getResponseSpec(400))
                .extract()
                .body().jsonPath().getObject("error", ErrorOrder.class);
    }
    @Step("Проверка что значение статуса соответствует статусу в ответе")
    public void checkOrdersId(Response response, String status) {
        Assertions.assertTrue(response.path("data", "orderStatus").toString().contains(status));
    }
    @Step("Отправить запрос DELETE на удаление")
    public static Response deleteOrder(DeleteOrder payload, String token) {
        return given()
                .header("Authorization", "Bearer " + token)
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(payload)
                .delete("loan-service/deleteOrder")
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract()
                .response();
    }
    @Step("Отправить запрос DELETE на удаление несуществующей заявки")
    public static ErrorOrder errorDeleteOrder(DeleteOrder payload, String token) {
        return given()
                .header("Authorization", "Bearer " + token)
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(payload)
                .delete("loan-service/deleteOrder")
                .then()
                .spec(SpecHelper.getResponseSpec(400))
                .extract()
                .body().jsonPath().getObject("error", ErrorOrder.class);
    }
    @Step("Проверка что в ответе код ошибки совпадает с ожидаемым")
    public void checkErrorOrder(ErrorOrder response, String error) {
        Assertions.assertEquals(error, response.getCode());
    }
}