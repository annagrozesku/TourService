package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.PurchasePage;

import static com.codeborne.selenide.Selenide.open;

public class InvalidYearTests {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
    @Test
    void shouldNotBePurchasedWithInvalidYear_00() {
        open ("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var invalidYear_00 = DataHelper.getInvalidYear_00();
        purchasePage.invalidYear(invalidYear_00);
    }

    @Test
    void shouldNotBePurchasedWithInvalidYear_Letters() {
        open ("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var invalidYear_Letters = DataHelper.getInvalidYearLetters();
        purchasePage.invalidYear(invalidYear_Letters);
    }

    @Test
    void shouldNotBePurchasedWithInvalidYear_1_Digit() {
        open ("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var invalidYear_1_Digit = DataHelper.getInvalidYearOneDigit();
        purchasePage.invalidYear(invalidYear_1_Digit);
    }
}
