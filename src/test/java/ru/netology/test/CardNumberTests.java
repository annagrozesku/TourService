package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.PurchaseMethodPage;


public class CardNumberTests extends BaseTest {
    @Test
    void shouldNotBePurchasedWithInvalidCardNumberNull() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var cardNumberNull = DataHelper.getCardNumberNull();
        formPage.buy(cardNumberNull);
        formPage.error();
    }

    @Test
    void shouldNotBePurchasedWithInvalidCardNumberNine() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var cardNumberNine = DataHelper.getCardNumberNine();
        formPage.buy(cardNumberNine);
        formPage.error();
    }

    @Test
    void shouldNotBePurchasedWithInvalidCardNumberLetters() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var cardNumberLetters = DataHelper.getCardNumberLetters();
        formPage.buy(cardNumberLetters);
        formPage.wrongFormat();
    }

    @Test
    void shouldNotBePurchasedWithInvalidCardNumberFifteenDigits() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var cardNumberFifteenDigits = DataHelper.getCardNumberFifteenDigits();
        formPage.buy(cardNumberFifteenDigits);
        formPage.wrongFormat();
    }
}
