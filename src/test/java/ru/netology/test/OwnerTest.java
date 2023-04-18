package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.PurchaseMethodPage;


public class OwnerTest extends BaseTest {
    @Test
    void shouldNotBePurchasedWithInvalidOwnerCyrillic() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var invalidOwnerCyrillic = DataHelper.getInvalidOwnerCyrillic();
        formPage.buy(invalidOwnerCyrillic);
        formPage.wrongFormat();
    }

    @Test
    void shouldNotBePurchasedWithInvalidOwnerSymbols() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var invalidOwnerSymbols = DataHelper.getInvalidOwnerSymbols();
        formPage.buy(invalidOwnerSymbols);
        formPage.wrongFormat();
    }

    @Test
    void shouldNotBePurchasedWithInvalidOwnerNumbers() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var invalidOwnerNumbers = DataHelper.getInvalidOwnerNumbers();
        formPage.buy(invalidOwnerNumbers);
        formPage.wrongFormat();
    }

    @Test
    void shouldNotBePurchasedWithInvalidOwnerSpace() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var invalidOwnerSpace = DataHelper.getInvalidOwnerSpace();
        formPage.buy(invalidOwnerSpace);
        formPage.wrongFormat();
    }

    @Test
    void shouldNotBePurchasedWithInvalidOwnerSpaces() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var invalidOwnerSpaces = DataHelper.getInvalidOwnerSpaces();
        formPage.buy(invalidOwnerSpaces);
        formPage.wrongFormat();
    }
}
