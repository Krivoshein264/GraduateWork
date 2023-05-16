package api;

import api.models.*;
import api.steps.MTSCreditSteps;
import io.qameta.allure.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static io.restassured.RestAssured.given;

@Epic("Api tests")
@Feature("Reqres service")
@Story("Методы для работы с пользователем")
@Link(name = "Документация сервиса", url = "https://reqres.in/")
@Owner("Долженко Артём")
public class MTSCreditTest {
    static MTSCreditSteps mtsCreditSteps = new MTSCreditSteps();
    public static String token;
    public static String orderId;
    @Test
    @Description("Проверяем, что аутентификация пройдет успешно с данными выданными с документацией проекта. Получение токена")
    @DisplayName("'POST' Успешная аутентификация и получение токена")
    public void successAuthenticationUser() {
        AuthenticateUser payload = new AuthenticateUser("ivanov@mail.ru", "1234");
        Token response = mtsCreditSteps.postAuthenticateUser(payload);
        token = response.getToken();
    }
    @Test
    @Description("Проверяем, что в полученном списке тарифов есть тарифы из ТЗ")
    @DisplayName("'GET' Успешная проверка списка тарифов")
    public void successGetTariffs() {
        Data response = mtsCreditSteps.getTariffs();
        mtsCreditSteps.checkEMail(response);
    }
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3,} )
    @Description("Проверяем, что при методе подачи заявки на кредит в теле ответа есть orderId")
    @DisplayName("'POST' Успешная аутентификация и получение токена")
    public void successOrderCheck(int tariffId) {
        successAuthenticationUser();
       Order payload = new Order(1, tariffId);
       OrderId response = mtsCreditSteps.getOrder(payload, token);
       mtsCreditSteps.checkOrderId(response);
       orderId = response.getOrderId();
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/client-data.csv", numLinesToSkip = 1)
    @Description("Проверяем, что статус ордера из списка соответствует статусу этого ордера из ответа")
    @DisplayName("'GET' Успешная проверка соответствия статуса ордера")
    public void statusAllOrdersCheck(String orderId, String status) {
        successAuthenticationUser();
        Response response = mtsCreditSteps.getAllOrderStatuses(orderId, token);
        mtsCreditSteps.checkOrdersId(response, status);
    }
    @Test
    @Description("Проверяем, что аутентификация пройдет успешно с данными выданными с документацией проекта. Получение токена")
    @DisplayName("'POST' Успешная аутентификация и получение токена")
    public void successDeleteOrder() {
        DeleteOrder payload = new DeleteOrder( 1L, orderId);
        mtsCreditSteps.deleteOrder(payload);
    }

}
