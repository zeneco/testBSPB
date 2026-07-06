package com.example.testbspb.tests;

import com.example.testbspb.basestructure.BaseSettings;
import com.example.testbspb.pages.CardApplicationPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import java.util.List;



public class TestCardApplication extends BaseSettings {

    @Override
    protected String getBaseUrl(){
        return "https://www.bspb.ru/retail/cards/debit/icount";
    }

    @Test
    void testThatExactlyFiveErrorsDisplay(){
         CardApplicationPage cardApplicationPage = new CardApplicationPage(driver);
         List<WebElement> errors = cardApplicationPage.getCountOfErrors();

         Assertions.assertThat(errors)
                 .as("На странице должно отображаться ровно 5 ошибок обязательных полей")
                 .hasSize(3);
    }
}
