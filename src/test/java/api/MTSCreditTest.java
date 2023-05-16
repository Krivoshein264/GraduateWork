package api;

import api.models.*;
import api.steps.MTSCreditSteps;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    public static String errorOrderId = "a68585f1-7096-4603-a622-ecca0cdc6347";
    public static String status = "IN_PROGRESS";  //REFUSED APPROVED
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
    @DisplayName("'POST' Успешная проверка метода подачи заявки на кредит")
    public void successOrderCheck(int tariffId) {
        successAuthenticationUser();
       Order payload = new Order(1, tariffId);
       OrderId response = mtsCreditSteps.getOrder(payload, token);
       mtsCreditSteps.checkOrderId(response);
       orderId = response.getOrderId();
    }
    @Test
    @Description("Проверяем, что при методе подачи заявки на кредит в теле запроса нельзя указать несуществующий номер тарифа")
    @DisplayName("'POST' Негативная проверка метода подачи заявки на кредит выбрав несуществующий тариф")
    public void errorOrderCheck() {
        successAuthenticationUser();
        Order payload = new Order(1, 0);
        ErrorOrder response = mtsCreditSteps.errorPostLoan(payload, token);
        mtsCreditSteps.checkErrorOrder(response, "TARIFF_NOT_FOUND");
    }
    @Test
    @Description("Проверяем, что значение статуса ордера соответствует статусу этого ордера из ответа в методе получения статуса заявки")
    @DisplayName("'GET' Успешная проверка соответствия статуса ордера в методе получения статуса заявки")
    public void successStatusOrderCheck() {
        successAuthenticationUser();
        Response response = mtsCreditSteps.getAllOrderStatuses(orderId, token);
        mtsCreditSteps.checkOrdersId(response, status);
    }
    @Test
    @Description("Проверяем, что выдаст ошибку при попытке запроса статуса несуществующей заявки")
    @DisplayName("'GET' Негативная проверка получения статуса несуществующей заявки")
    public void errorStatusOrderCheck() {
        successAuthenticationUser();
        ErrorOrder response = mtsCreditSteps.errorGetStatus(errorOrderId, token);
        mtsCreditSteps.checkErrorOrder(response, "ORDER_NOT_FOUND");
    }
    @Test
    @Description("Проверяем, что заявка успешно удалится")
    @DisplayName("'DELETE' Успешное удаление существующей заявки")
    public void successDeleteOrder() {
        successAuthenticationUser();
        DeleteOrder payload = new DeleteOrder( 1L, orderId);
        mtsCreditSteps.deleteOrder(payload, token);
    }
    @Test
    @Description("Проверяем, что при удалении несуществующей заявки выдаст ошибку ORDER_NOT_FOUND")
    @DisplayName("'DELETE' Негативное удаление несуществующей заявки")
    public void errorDeleteOrder() {
        successAuthenticationUser();
        DeleteOrder payload = new DeleteOrder(1L, errorOrderId);
        ErrorOrder response = mtsCreditSteps.errorDeleteOrder(payload, token);
        mtsCreditSteps.checkErrorOrder(response, "ORDER_NOT_FOUND");
    }
}
