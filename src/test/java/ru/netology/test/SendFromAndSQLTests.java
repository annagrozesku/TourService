package ru.netology.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Reporting;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.PurchasePage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.SQLHelper.cleanDB;


public class SendFromAndSQLTests extends Reporting {
    @BeforeEach
    void setUp() {
        cleanDB();
    }

    @Test
    void infoStatusPaymentCard_1() {
        open("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var cardInfo_1 = DataHelper.getCardInfo_1();
        purchasePage.buyCard_1(cardInfo_1);
        var actualStatusPayment = SQLHelper.getInfoPaymentCard().getStatus();
        var expectedStatusPayment = "APPROVED";
        assertEquals(expectedStatusPayment, actualStatusPayment);
    }

    @Test
    void infoStatusPaymentCard_2() {
        open("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var cardInfo_2 = DataHelper.getCardInfo_2();
        purchasePage.buyCard_2(cardInfo_2);
        var actualStatusPayment = SQLHelper.getInfoPaymentCard().getStatus();
        var expectedStatusPayment = "APPROVED";
        assertEquals(expectedStatusPayment, actualStatusPayment);
    }

    @Test
    void infoStatusCreditPurchaseCard_1() {
        open("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var cardInfo_1 = DataHelper.getCardInfo_1();
        purchasePage.buyOnCreditCard_1(cardInfo_1);
        var actualStatusPayment = SQLHelper.getInfoPurchaseCreditCard().getStatus();
        var expectedStatusPayment = "APPROVED";
        assertEquals(expectedStatusPayment, actualStatusPayment);
    }

    @Test
    void infoStatusCreditPurchaseCard_2() {
        open("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var cardInfo_2 = DataHelper.getCardInfo_2();
        purchasePage.buyOnCreditCard_2(cardInfo_2);
        var actualStatusPayment = SQLHelper.getInfoPurchaseCreditCard().getStatus();
        var expectedStatusPayment = "APPROVED";
        assertEquals(expectedStatusPayment, actualStatusPayment);
    }

    @Test
    void fixingThePaymentMethod() {
        open("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var cardInfo_1 = DataHelper.getCardInfo_1();
        purchasePage.buyCard_1(cardInfo_1);
        var actualStatusPayment = SQLHelper.getInfoPaymentCard().getTransaction_id();
        var expectedStatusPayment = SQLHelper.getFixOrderMethod().getPayment_id();
        assertEquals(expectedStatusPayment, actualStatusPayment);
    }

    @Test
    void fixingThePurchaseCreditMethod() {
        open("http://localhost:8080/");
        var purchasePage = new PurchasePage();
        var cardInfo_1 = DataHelper.getCardInfo_1();
        purchasePage.buyOnCreditCard_1(cardInfo_1);
        var actualStatusPayment = SQLHelper.getInfoPurchaseCreditCard().getBank_id();
        var expectedStatusPayment = SQLHelper.getFixOrderMethod().getCredit_id();
        assertEquals(expectedStatusPayment, actualStatusPayment);
    }
}
