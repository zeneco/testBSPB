package com.example.testbspb.tests;

import com.example.testbspb.basestructure.BaseSettings;
import com.example.testbspb.pages.CardApplicationPage;
import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import java.util.List;


@Epic("Продукты Банка")
@Feature("Оформление карты Ясчитаю")
@Story("Поптыка продолжить без заполнения данных")
public class TestCardApplication extends BaseSettings {

    @Override
    protected String getBaseUrl(){
        return "https://www.bspb.ru/retail/cards/debit/icount";
    }

    @Test
    void testThatExactlyFiveErrorsDisplay(){
         CardApplicationPage cardApplicationPage = new CardApplicationPage(driver);
         List<WebElement> errors = cardApplicationPage.getCountOfErrors();
         Allure.step("Проверка обратки пустого ввода при заполнении завяки на оформление карты", () -> {
             Assertions.assertThat(errors)
                     .as("На странице должно отображаться ровно 5 ошибок обязательных полей")
                     .hasSize(5);
         }
         );
    }
}
