package ru.netology.test;

import org.junit.jupiter.api.Test;

import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.FormPage;
import ru.netology.page.PurchaseMethodPage;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SendFromAndSQLTests extends BaseTest {
    @Test
    void infoStatusPaymentCardOne() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var cardInfoOne = DataHelper.getCardInfoOne();
        formPage.buy(cardInfoOne);
        formPage.success();
        var actualStatusPayment = SQLHelper.getInfoPaymentCard().getStatus();
        var expectedStatusPayment = "APPROVED";
        assertEquals(expectedStatusPayment, actualStatusPayment);
    }

    @Test
    void infoStatusPaymentCardTwo() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var cardInfoTwo = DataHelper.getCardInfoTwo();
        formPage.buy(cardInfoTwo);
        formPage.success();
        var actualStatusPayment = SQLHelper.getInfoPaymentCard().getStatus();
        var expectedStatusPayment = "APPROVED";
        assertEquals(expectedStatusPayment, actualStatusPayment);
    }

    @Test
    void infoStatusCreditPurchaseCardOne() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buyOnCredit();
        var cardInfoOne = DataHelper.getCardInfoOne();
        formPage.buy(cardInfoOne);
        formPage.success();
        var actualStatusPayment = SQLHelper.getInfoPurchaseCreditCard().getStatus();
        var expectedStatusPayment = "APPROVED";
        assertEquals(expectedStatusPayment, actualStatusPayment);
    }

    @Test
    void infoStatusCreditPurchaseCardTwo() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buyOnCredit();
        var cardInfoTwo = DataHelper.getCardInfoTwo();
        formPage.buy(cardInfoTwo);
        formPage.success();
        var actualStatusPayment = SQLHelper.getInfoPurchaseCreditCard().getStatus();
        var expectedStatusPayment = "APPROVED";
        assertEquals(expectedStatusPayment, actualStatusPayment);
    }

    @Test
    void fixingThePaymentMethod() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buy();
        var cardInfoOne = DataHelper.getCardInfoOne();
        formPage.buy(cardInfoOne);
        formPage.success();
        var actualFixPayment = SQLHelper.getInfoPaymentCard().getTransaction_id();
        var expectedFixPayment = SQLHelper.getFixOrderMethod().getPayment_id();
        assertEquals(expectedFixPayment, actualFixPayment);
    }

    @Test
    void fixingThePurchaseCreditMethod() {
        var purchaseMethodPage = new PurchaseMethodPage();
        var formPage = purchaseMethodPage.buyOnCredit();
        var cardInfoOne = DataHelper.getCardInfoOne();
       formPage.buy(cardInfoOne);
        formPage.success();
        var actualFixPayment = SQLHelper.getInfoPurchaseCreditCard().getBank_id();
        var expectedFixPayment = SQLHelper.getFixOrderMethod().getCredit_id();
        assertEquals(expectedFixPayment, actualFixPayment);
    }
}
