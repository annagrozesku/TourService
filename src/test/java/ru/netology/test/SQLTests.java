package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.PurchasePage;


import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class SQLTests {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
//    @AfterAll
//    static void teardown() {
//        cleanDB();
//    }


    @Test
    void infoStatusPaymentCard_1() {
        var actualStatusPayment = SQLHelper.getPaymentStatusCard_1().getStatus();
        var expectedStatusPayment = "APPROVED";
       assertEquals (expectedStatusPayment, actualStatusPayment);
    }

    @Test
    void infoStatusPaymentCard_2() {
        var actualStatusPayment = SQLHelper.getPaymentStatusCard_2().getStatus();
        var expectedStatusPayment = "DECLINED";
        assertEquals (expectedStatusPayment, actualStatusPayment);
    }

    @Test
    void infoCreditPurchaseStatusCard_1() {
        var actualStatusPayment = SQLHelper.getPaymentCreditStatusCard_1().getCreditStatus();
        var expectedStatusPayment = "APPROVED";
        assertEquals (expectedStatusPayment, actualStatusPayment);
    }

    @Test
    void infoCreditPurchaseStatusCard_2() {
        var actualStatusPayment = SQLHelper.getPaymentCreditStatusCard_2().getCreditStatus();
        var expectedStatusPayment = "DECLINED";
        assertEquals (expectedStatusPayment, actualStatusPayment);
    }

    @Test
    void fixingThePurchaseMethod() {
        var actualStatusPayment = SQLHelper.getFixOrderMethod().getOrderMethod();
        var expectedStatusPayment = SQLHelper.getFixMethodPayment().getPayment_id();
        assertEquals (expectedStatusPayment, actualStatusPayment);
    }

    @Test
    void fixingThePurchaseCreditMethod() {
        var actualStatusPayment = SQLHelper.getFixOrderMethodCredit().getOrderMethod();
        var expectedStatusPayment = SQLHelper.getFixMethodPaymentCredit().getCredit_id();
        assertEquals (expectedStatusPayment, actualStatusPayment);
    }
}
