package com.report_portal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    private final By addWidgetButton = By.xpath("//button[.//span[text()='Add new widget']]");
    private By widgetType( String widgetTypeName) {
        return By.xpath("//div[normalize-space()='" + widgetTypeName + "']");
    }
    private final By nextStepButton = By.xpath("//button[.//span[text()='Next step']]");
    private final By viewOption = By.xpath("//span[text()='Pie view']");
    private final By launchNameInput = By.xpath("//input[@placeholder='Enter launch name']");
    private final By saveWidgetButton = By.xpath("//button[text()='Add']");

    public By isWidgetAdd(String widgetName) {
        return By.xpath("//div[contains(@class,'widgetHeader__widget-name-block') and starts-with(text(),'" + widgetName + "')]");
    }

    public DashboardPage(WebDriver driver) {
        super(driver);

    }

    public void isDashboardPage() {
        System.out.println("Проверка что открыта страница конкретного дашборда");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addWidgetButton));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addWidgetButton));
    }

    public void addWidget (String widgetTypeName, String launchName, String viewType) {
        System.out.println("Начало добавления виджета");
        System.out.println("Поиск кнопки Add new widget ");
        WebElement addWidgetBtn= wait.until(ExpectedConditions.elementToBeClickable(addWidgetButton));
        addWidgetBtn.click();
        System.out.println("Кнопка Add new widget нажата");

        System.out.println("Поиск типа виджета");
        WebElement widgetTypeClick= wait.until(ExpectedConditions.elementToBeClickable(widgetType(widgetTypeName)));
        widgetTypeClick.click();
        System.out.println("Тип виджета "+ widgetTypeName + " кликнут" );

        WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(nextStepButton));
        nextBtn.click();
        System.out.println("Кнопка Next step кликнута");

        if (widgetTypeName.equals("Passing rate per launch")) {
            WebElement nameInput= wait.until(ExpectedConditions.visibilityOfElementLocated(launchNameInput));
            nameInput.clear();
            nameInput.sendKeys(launchName);
            System.out.println(("Введено имя запуска"));


            By viewTypeLocator = By.xpath("//span[@class='toggleButton__item-label--mfxvu' and text()='" + viewType + "']");
            WebElement viewTypeElement = wait.until(ExpectedConditions.elementToBeClickable(viewTypeLocator));
            viewTypeElement.click();
            System.out.println(("Выбран тип отображения "+ viewType));

        }

        nextBtn.click();

        WebElement saveBtn=  wait.until(ExpectedConditions.elementToBeClickable(saveWidgetButton));
        saveBtn.click();
    }
}



