package com.report_portal.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DashboardApiNegativeTest {
    String apiKey = "createDashboardTest_T0yZuQdTRoujPGDxs85qHY7ZI0h6DInE41rYogkz_Jz6MizYwFttdWtPdzREGnm0";

    @Test
    public void createDashboardWithoutName() {
        RestAssured.baseURI = "https://demo.reportportal.io/api/v1";
        String dashboardName= "";
        String dashboarddescription= "Создание дашборда без имени";

        String body = "{\"name\":\""+dashboardName+ "\", \"description\":\"" +dashboarddescription+"\"}";

        var response = given()
                .header("Authorization", "bearer " + apiKey)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/default_personal/dashboard");


        int statusCode = response.getStatusCode();
        System.out.println("Статус-код ответа: " + statusCode);
        System.out.println("Тело ответа: " + response.getBody().asString());

        if (statusCode == 400 || statusCode == 422) {
            System.out.println("Тест пройден, сервер вернул ошибку, потому что имя обязательно");
        } else {
            System.out.println("Тест провален, ожидался статус 400 или 422, но был " + statusCode);
        }
    }
}