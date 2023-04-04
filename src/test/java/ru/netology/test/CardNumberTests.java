package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.Reporting;
import ru.netology.data.DataHelper;
import ru.netology.page.PurchasePage;

import static com.codeborne.selenide.Selenide.open;

public class CardNumberTests extends Reporting {
    @Test
    void shouldNotBePurchasedWithInvalidCardNumber_Null() {
        open("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var cardNumberNull = DataHelper.getCardNumberNull();
        purchasePage.buyInvalidCardNumber(cardNumberNull);
    }

    @Test
    void shouldNotBePurchasedWithInvalidCardNumber_Nine() {
        open("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var cardNumberNine = DataHelper.getCardNumberNine();
        purchasePage.buyInvalidCardNumber(cardNumberNine);
    }

    @Test
    void shouldNotBePurchasedWithInvalidCardNumber_Letters() {
        open("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var cardNumberLetters = DataHelper.getCardNumberLetters();
        purchasePage.invalidCardNumber(cardNumberLetters);
    }

    @Test
    void shouldNotBePurchasedWithInvalidCardNumber_15_Digits() {
        open("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var cardNumber_15_Digits = DataHelper.getCardNumber15();
        purchasePage.invalidCardNumber(cardNumber_15_Digits);
    }
}
