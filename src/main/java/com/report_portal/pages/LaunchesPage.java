package com.report_portal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LaunchesPage extends BasePage {
    public LaunchesPage (WebDriver driver) {
        super(driver);
    }

    public void openDashboard(){
        By dashboardButton=  By.xpath("//a[@href='#default_personal/dashboard']");
        WebElement dashboardEl = wait.until(ExpectedConditions.elementToBeClickable(dashboardButton));
        dashboardEl.click();


        wait.until(ExpectedConditions.urlContains("#default_personal/dashboard"));
        System.out.println("Выполнен переход на страницу дашбордов");


    }

}
