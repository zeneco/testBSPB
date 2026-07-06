package com.example.testbspb.pages;

import com.example.testbspb.basestructure.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CardApplicationPage extends BasePage {

    private final By formDebitLocator = By.xpath("//p[contains(normalize-space(), 'Обязательное')]");
    private final By continueButtonLocator = By.xpath("//button[normalize-space()='Продолжить']");
    public CardApplicationPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getCountOfErrors(){
        WebElement continueButton = wait.until(ExpectedConditions
                .visibilityOfElementLocated(continueButtonLocator));
        new Actions(driver).moveToElement(continueButton)
                .click()
                .perform();

        List<WebElement> errors = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(formDebitLocator));
        return errors;

    }

}