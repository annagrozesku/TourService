package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.PurchasePage;

import static com.codeborne.selenide.Selenide.open;

public class MonthTests {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
    @Test
    void shouldNotBePurchasedWithInvalidMonth_00() {
        open ("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var invalidMonth_00 = DataHelper.getInvalidMonth_00();
        purchasePage.invalidMonth(invalidMonth_00);
    }

    @Test
    void shouldNotBePurchasedWithInvalidMonth_13() {
        open ("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var invalidMonth_13 = DataHelper.getInvalidMonth_13();
        purchasePage.invalidMonth(invalidMonth_13);
    }

    @Test
    void shouldNotBePurchasedWithInvalidMonth_Letters() {
        open ("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var invalidMonth_Letters = DataHelper.getInvalidMonthLetters();
        purchasePage.invalidMonth(invalidMonth_Letters);
    }

    @Test
    void shouldNotBePurchasedWithInvalidMonth_1_Digit() {
        open ("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var invalidMonth_1_Digit = DataHelper.getInvalidMonthOneDigit();
        purchasePage.invalidMonth(invalidMonth_1_Digit);
    }
}
