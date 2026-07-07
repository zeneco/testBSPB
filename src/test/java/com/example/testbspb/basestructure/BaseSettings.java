package com.example.testbspb.basestructure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public abstract class BaseSettings {
    protected WebDriver driver;

    protected String getBaseUrl(){
        return "https://www.bspb.ru/";
    }

    @BeforeEach
    public void setUp() {
        var options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(getBaseUrl());

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}