package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.PurchaseMethodPage;


public class MonthTests extends BaseTest {
    @Test
    void shouldNotBePurchasedWithInvalidMonthNull() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var invalidMonthNull = DataHelper.getInvalidMonthNull();
        formPage.buy(invalidMonthNull);
        formPage.wrongFormat();
    }

    @Test
    void shouldNotBePurchasedWithInvalidMonthThirteen() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var invalidMonthThirteen = DataHelper.getInvalidMonthThirteen();
        formPage.buy(invalidMonthThirteen);
        formPage.wrongFormat();
    }

    @Test
    void shouldNotBePurchasedWithInvalidMonthLetters() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var invalidMonthLetters = DataHelper.getInvalidMonthLetters();
        formPage.buy(invalidMonthLetters);
        formPage.wrongFormat();
    }

    @Test
    void shouldNotBePurchasedWithInvalidMonthOneDigit() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var invalidMonthOneDigit = DataHelper.getInvalidMonthOneDigit();
        formPage.buy(invalidMonthOneDigit);
        formPage.wrongFormat();
    }
}
