package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.PurchasePage;

import static com.codeborne.selenide.Selenide.open;

public class A_SendFormTests {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
    @Test
    void shouldBePurchasedWithAnApprovedCard() {
        open ("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var cardInfoApproved = DataHelper.getCardInfo_1();
        purchasePage.buyCard_1(cardInfoApproved);
    }

    @Test
    void shouldNotBePurchasedWithAnDeclinedCard() {
        open ("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var cardInfoDeclined = DataHelper.getCardInfo_2();
        purchasePage.buyCard_2(cardInfoDeclined);
    }

    @Test
    void shouldBePurchasedOnCreditWithAnApprovedCard() {
        open ("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var cardInfoApproved = DataHelper.getCardInfo_1();
        purchasePage.buyOnCreditCard_1(cardInfoApproved);
    }

    @Test
    void shouldNotBePurchasedOnCreditWithAnDeclinedCard() {
        open ("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var cardInfoDeclined = DataHelper.getCardInfo_2();
        purchasePage.buyOnCreditCard_2(cardInfoDeclined);
    }
}
