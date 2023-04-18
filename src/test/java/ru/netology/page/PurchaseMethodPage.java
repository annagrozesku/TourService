package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$;

public class PurchaseMethodPage {
    private SelenideElement buyButton = $$("button").find(exactText("Купить"));
    private SelenideElement buyOnCreditButton = $$("button").find(exactText("Купить в кредит"));

    public FormPage buy() {
        buyButton.click();
        return new FormPage();
    }

    public FormPage buyOnCredit() {
        buyOnCreditButton.click();
        return new FormPage();
    }
}
