package com.report_portal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllDashboardsPage extends BasePage {
    public AllDashboardsPage (WebDriver driver){
        super(driver);

    }
    private final By addDashboardButton= By.xpath("//button[.//span[text()='Add New Dashboard']]");

    private By dashboardByName(String dashboardName){
        return By.xpath("//a[contains(@class, 'dashboardTable__name') and normalize-space(text())='" + dashboardName + "']");

    }

    public void isDashboardsPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addDashboardButton));
        System.out.println("Открыта страница dashboards");
    }

    public void clickOnDashboard(String dashboardName){
        System.out.println("Поиск " + dashboardName + " и клик на него");
        By locator = dashboardByName(dashboardName);
        WebElement dashboardElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        dashboardElement.click();
        System.out.println("Выполнен клик на "+ dashboardName);


    }
}
