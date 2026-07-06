package com.example.testbspb.pages;

import com.example.testbspb.basestructure.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends BasePage {
    private final By headerDepositsMenu = By.xpath("//button[@role='group' " +
            "and contains(., 'Вклады')]");
    private final By allDepositsClickLocator = By.xpath("//a[@href='/retail/deposits' " +
            "and text()='Все вклады']");


    public MainPage(WebDriver driver) {
        super(driver);
    }
    @Step("Наведение курсора на пукт меню 'Вклады' и клик по 'Все вклады' ")
    public void hoverOverDepositsMenu(){
        WebElement depositsMenu = wait.until(ExpectedConditions
                .visibilityOfElementLocated(headerDepositsMenu));
        new Actions(driver)
                .moveToElement(depositsMenu)
                .perform();

        WebElement allDeposits = wait.until(ExpectedConditions
                .visibilityOfElementLocated(allDepositsClickLocator));
        allDeposits.click();

        wait.until(ExpectedConditions.urlContains("/retail/deposits"));

    }

}
