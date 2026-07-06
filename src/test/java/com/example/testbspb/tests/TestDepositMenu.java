package com.example.testbspb.tests;

import com.example.testbspb.basestructure.BaseSettings;
import com.example.testbspb.pages.MainPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestDepositMenu extends BaseSettings {
    @Test
    void hoverOverDepositsMenuAndClick() {
        MainPage mainPage = new MainPage(driver);

        mainPage.hoverOverHeaderDepositsMenu();

        assertThat(driver.getCurrentUrl())
                .as("URL должен изменится и открыть страницу с Вкладами и накопительными счетами")
                .isNotBlank()
                .contains("/retail/deposits")
                .startsWith("https://");
        assertThat(driver.getTitle())
                .as("Проверка, что заголовок соответствует названию кнопки-перехода")
                .contains("Вклады");

    }

}