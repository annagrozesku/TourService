package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.Reporting;
import ru.netology.data.DataHelper;
import ru.netology.page.PurchasePage;

import static com.codeborne.selenide.Selenide.open;

public class YearTests extends Reporting {
    @Test
    void shouldNotBePurchasedWithInvalidYear_00() {
        open("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var invalidYear_00 = DataHelper.getInvalidYear_00();
        purchasePage.invalidYear(invalidYear_00);
    }

    @Test
    void shouldNotBePurchasedWithInvalidYear_Letters() {
        open("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var invalidYear_Letters = DataHelper.getInvalidYearLetters();
        purchasePage.invalidYear(invalidYear_Letters);
    }

    @Test
    void shouldNotBePurchasedWithInvalidYear_1_Digit() {
        open("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var invalidYear_1_Digit = DataHelper.getInvalidYearOneDigit();
        purchasePage.invalidYear(invalidYear_1_Digit);
    }
}
