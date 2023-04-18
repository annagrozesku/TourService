package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.PurchaseMethodPage;


public class VerificationCodeTests extends BaseTest {
    @Test
    void shouldNotBePurchasedWithInvalidCodeVerificationNull() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var invalidCodeVerificationNull = DataHelper.getInvalidCodeVerificationNull();
        formPage.buy(invalidCodeVerificationNull);
        formPage.wrongFormat();
    }

    @Test
    void shouldNotBePurchasedWithInvalidCodeVerificationLetters() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var invalidCodeVerificationLetters = DataHelper.getInvalidCodeVerificationLetters();
        formPage.buy(invalidCodeVerificationLetters);
        formPage.wrongFormat();
    }

    @Test
    void shouldNotBePurchasedWithInvalidCodeVerificationOneDigit() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var invalidCodeVerificationOneDigit = DataHelper.getInvalidCodeVerificationOneDigit();
        formPage.buy(invalidCodeVerificationOneDigit);
        formPage.wrongFormat();
    }
}
