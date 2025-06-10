package com.report_portal.ui;

import com.report_portal.framework.BrowserManager;
import com.report_portal.pages.AllDashboardsPage;
import com.report_portal.pages.DashboardPage;
import com.report_portal.pages.LaunchesPage;
import com.report_portal.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WidgetTest {
    private WebDriver driver ;
    private LoginPage loginPage;
    private AllDashboardsPage allDashboardsPage;
    private LaunchesPage launchesPage;
    private DashboardPage dashboardPage;


    @BeforeEach
    public void setup () {
        System.out.println("Запуск браузера");
        driver= BrowserManager.getDriver();
        loginPage= new LoginPage(driver);
        System.out.println("Браузер готов");
    }


    @Test
    public void createWidgetTest(){
        System.out.println("Начало теста");

        loginPage.login("default", "1q2w3e");

        System.out.println("Осуществление перехода на страницу дашбордов");
        launchesPage = new LaunchesPage(driver);
        launchesPage.openDashboard();

        allDashboardsPage = new AllDashboardsPage(driver);
        allDashboardsPage.isDashboardsPage();

        String clickDashboard = "testDashboard";
        allDashboardsPage.clickOnDashboard(clickDashboard);

        dashboardPage = new DashboardPage(driver);
        dashboardPage.isDashboardPage();
        System.out.println("Да, открыта страница дашборда " + clickDashboard);
        dashboardPage.addWidget("Passing rate per launch", "MyNewWidgetLaunch", "Pie view");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardPage.isWidgetAdd("MyNewWidgetLaunch")));
        System.out.println("Виджет добавлен");

        System.out.println("Конец теста");
    }
    @AfterEach
    public void close(){

        BrowserManager.quitDriver();
        System.out.println("Браузер закрыт");

    }
}