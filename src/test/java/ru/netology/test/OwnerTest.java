package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.Reporting;
import ru.netology.data.DataHelper;
import ru.netology.page.PurchasePage;

import static com.codeborne.selenide.Selenide.open;

public class OwnerTest extends Reporting {
    @Test
    void shouldNotBePurchasedWithInvalidOwner_Cyrillic() {
        open("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var invalidOwnerCyrillic = DataHelper.getInvalidOwnerCyrillic();
        purchasePage.invalidOwner(invalidOwnerCyrillic);
    }

    @Test
    void shouldNotBePurchasedWithInvalidOwner_Symbols() {
        open("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var invalidOwnerSymbols = DataHelper.getInvalidOwnerSymbols();
        purchasePage.invalidOwner(invalidOwnerSymbols);
    }

    @Test
    void shouldNotBePurchasedWithInvalidOwner_Numbers() {
        open("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var invalidOwnerNumbers = DataHelper.getInvalidOwnerNumbers();
        purchasePage.invalidOwner(invalidOwnerNumbers);
    }

    @Test
    void shouldNotBePurchasedWithInvalidOwner_Space() {
        open("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var invalidOwnerSpace = DataHelper.getInvalidOwnerSpace();
        purchasePage.invalidOwner(invalidOwnerSpace);
    }

    @Test
    void shouldNotBePurchasedWithInvalidOwner_Spaces() {
        open("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var invalidOwnerSpaces = DataHelper.getInvalidOwnerSpaces();
        purchasePage.invalidOwner(invalidOwnerSpaces);
    }
}
