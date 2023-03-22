package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.PurchasePage;

import static com.codeborne.selenide.Selenide.open;

public class VerificationCodeTests {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
    @Test
    void shouldNotBePurchasedWithInvalidCodeVerification_Null() {
        open ("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var invalidCodeVerification_Null = DataHelper.getInvalidCodeVerificationNull();
        purchasePage.invalidCodeVerification(invalidCodeVerification_Null);
    }

    @Test
    void shouldNotBePurchasedWithInvalidCodeVerification_Letters() {
        open ("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var invalidCodeVerification_Letters = DataHelper.getInvalidCodeVerificationLetters();
        purchasePage.invalidCodeVerification(invalidCodeVerification_Letters);
    }

    @Test
    void shouldNotBePurchasedWithInvalidCodeVerification_1_Digit() {
        open ("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var invalidCodeVerification_1_Digit = DataHelper.getInvalidCodeVerificationOneDigit();
        purchasePage.invalidCodeVerification(invalidCodeVerification_1_Digit);
    }

    @Test
    void shouldNotBePurchasedWithInvalidCodeVerification_4_Digits() {
        open ("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var invalidCodeVerification_4_Digits = DataHelper.getInvalidCodeVerificationFourDigits();
        purchasePage.invalidCodeVerification(invalidCodeVerification_4_Digits);
    }
}
