package com.report_portal.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BrowserManager {
    private static final Properties properties = new Properties();
    private static WebDriver driver;

    static {
        try {
            properties.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = properties.getProperty("browser", "chrome").toLowerCase();

            switch (browser) {
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--disable-notifications");
                    edgeOptions.addArguments("--disable-features=PasswordManager");
                    edgeOptions.addArguments("--disable-popup-blocking");
                    edgeOptions.addArguments("--disable-infobars");
                    edgeOptions.addArguments("--disable-sync");
                    edgeOptions.addArguments("--no-default-browser-check");
                    edgeOptions.addArguments("--no-first-run");
                    edgeOptions.addArguments("--disable-blink-features=AutomationControlled");
                    edgeOptions.addArguments("--remote-allow-origins=*");
                    edgeOptions.addArguments("--inprivate");
                    driver = new EdgeDriver(edgeOptions);
                    break;

                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-notifications");
                    options.addArguments("--disable-features=PasswordManager");
                    options.addArguments("--disable-popup-blocking");
                    options.addArguments("--disable-infobars");
                    options.addArguments("--disable-sync");
                    options.addArguments("--no-default-browser-check");
                    options.addArguments("--no-first-run");
                    options.addArguments("--disable-blink-features=AutomationControlled");
                    options.addArguments("--remote-allow-origins=*");
                    options.addArguments("--incognito");

                    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                    options.setExperimentalOption("useAutomationExtension", false);

                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("credentials_enable_service", false);
                    prefs.put("profile.password_manager_enabled", false);
                    prefs.put("profile.default_content_settings.popups", 0);
                    options.setExperimentalOption("prefs", prefs);

                    driver = new ChromeDriver(options);
                    break;
            }

            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}