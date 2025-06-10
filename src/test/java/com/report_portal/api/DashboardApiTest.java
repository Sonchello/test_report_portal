package com.report_portal.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
public class DashboardApiTest {

    String apiKey= "createDashboardTest_T0yZuQdTRoujPGDxs85qHY7ZI0h6DInE41rYogkz_Jz6MizYwFttdWtPdzREGnm0";
    @Test
    public void createDashboardTest(){


        RestAssured.baseURI= "https://demo.reportportal.io/api/v1";

        String dashboardName= "NewTestDashboard";
        String dashboarddescription= "Создание нового дашборда";

        String body = "{\"name\":\""+dashboardName+ "\", \"description\":\"" +dashboarddescription+"\"}";
        Response response= given().header("Authorization", "bearer " + apiKey).contentType(ContentType.JSON).body(body)
                .when().post("/default_personal/dashboard");

        if (response.getStatusCode() == 409) {
            System.out.println("Дашборд с таким именем уже существует");
        }

        System.out.println("Проверка создания дашборда");
        isDashboardCreated(dashboardName);
    }

    private void isDashboardCreated(String dashboardName) {
        // Получаем все дашборды (массив content)
        var dashboards = given()
                .header("Authorization", "bearer " + apiKey)
                .when()
                .get("/default_personal/dashboard")
                .then()
                .extract()
                .jsonPath()
                .getList("content.name", String.class); // Получаем список имён

        if (dashboards != null && dashboards.contains(dashboardName)) {
            System.out.println("Дашборд " + dashboardName + " найден в списке");
        } else {
            System.out.println("Дашборд " + dashboardName + " не найден в списке");
        }
    }
}


