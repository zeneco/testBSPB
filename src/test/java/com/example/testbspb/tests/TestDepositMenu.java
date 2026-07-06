package com.example.testbspb.tests;

import com.example.testbspb.basestructure.BaseSettings;
import com.example.testbspb.pages.MainPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

@Epic("Продукты Банка")
@Feature("Главное меню")
@Story("Переход в раздел 'Вклады' ")
public class TestDepositMenu extends BaseSettings {
    @Test
    void hoverOverDepositsMenuAndClick() {
        MainPage mainPage = new MainPage(driver);

        mainPage.hoverOverDepositsMenu();

        Allure.step("Проверка изменения URL", () -> {
            Assertions.assertThat(driver.getCurrentUrl())
                    .as("URL должен изменится и открыть страницу с Вкладами и накопительными счетами")
                    .isNotBlank()
                    .contains("/retail/deposits")
                    .startsWith("https://");
        }
        );

        Allure.step("Проверка Title Page", () -> {
            Assertions.assertThat(driver.getTitle())
                .as("Проверка, что заголовок соответствует названию кнопки-перехода")
                    .contains("Вклады");
        }
        );
    }
}