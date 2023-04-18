package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.PurchaseMethodPage;


public class YearTests extends BaseTest {
    @Test
    void shouldNotBePurchasedWithInvalidYear_00() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var invalidYearNull = DataHelper.getInvalidYearNull();
        formPage.buy(invalidYearNull);
        formPage.wrongFormat();
    }

    @Test
    void shouldNotBePurchasedWithInvalidYearLetters() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var invalidYearLetters = DataHelper.getInvalidYearLetters();
        formPage.buy(invalidYearLetters);
        formPage.wrongFormat();
    }

    @Test
    void shouldNotBePurchasedWithInvalidYearOneDigit() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var invalidYearOneDigit = DataHelper.getInvalidYearOneDigit();
        formPage.buy(invalidYearOneDigit);
        formPage.wrongFormat();
    }
}
