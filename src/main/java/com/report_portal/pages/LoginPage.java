package com.report_portal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private final By inputUsername= By.name("login");
    private final By inputPassword= By.name("password");
    private final By loginButton = By.xpath("//button[text()='Login']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void login (String username, String password){
        open("https://demo.reportportal.io/ui/#login");
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(inputUsername));
        usernameField.clear();
        usernameField.sendKeys(username);
        System.out.println("Введен логин");
        WebElement passwordField = driver.findElement(inputPassword);
        passwordField.clear();
        passwordField.sendKeys(password);
        System.out.println("Введен пароль");
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        submitButton.click();
        System.out.println("Кнопка входа нажата");
        wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("#login")));
        System.out.println("Переход со страницы входа, пользователь вошел в систему");
    }

}
