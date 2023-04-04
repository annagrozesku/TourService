package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static ru.netology.data.DataHelper.*;

public class PurchasePage {
    private SelenideElement buyButton = $$("button").find(exactText("Купить"));
    private SelenideElement buyOnCreditButton = $$("button").find(exactText("Купить в кредит"));
    private SelenideElement cardNumber = $("[placeholder = '0000 0000 0000 0000']");
    private SelenideElement monthCard = $("[placeholder = '08']");
    private SelenideElement yearCard = $("[placeholder = '22']");
    private SelenideElement ownerCard = $("div:nth-child(3) input");
    private SelenideElement code = $("[placeholder = '999']");
    private SelenideElement continueButton = $$("button").find(exactText("Продолжить"));

    public SuccessPage buyCard_1(DataHelper.CardInfo info_1) {
        buyButton.click();
        cardNumber.setValue(info_1.getCardNumber());
        monthCard.setValue(info_1.getMonth());
        yearCard.setValue(info_1.getYear());
        ownerCard.setValue(info_1.getOwner());
        code.setValue(info_1.getCodeVerification());
        continueButton.click();
        return new SuccessPage();
    }

    public SuccessPage buyCard_2(DataHelper.CardInfo info_2) {
        buyButton.click();
        cardNumber.setValue(info_2.getCardNumber());
        monthCard.setValue(info_2.getMonth());
        yearCard.setValue(info_2.getYear());
        ownerCard.setValue(info_2.getOwner());
        code.setValue(info_2.getCodeVerification());
        continueButton.click();
        return new SuccessPage();
    }

    public SuccessPage buyOnCreditCard_1(DataHelper.CardInfo info_1) {
        buyOnCreditButton.click();
        cardNumber.setValue(info_1.getCardNumber());
        monthCard.setValue(info_1.getMonth());
        yearCard.setValue(info_1.getYear());
        ownerCard.setValue(info_1.getOwner());
        code.setValue(info_1.getCodeVerification());
        continueButton.click();
        return new SuccessPage();
    }

    public SuccessPage buyOnCreditCard_2(DataHelper.CardInfo info_2) {
        buyOnCreditButton.click();
        cardNumber.setValue(info_2.getCardNumber());
        monthCard.setValue(info_2.getMonth());
        yearCard.setValue(info_2.getYear());
        ownerCard.setValue(info_2.getOwner());
        code.setValue(info_2.getCodeVerification());
        continueButton.click();
        return new SuccessPage();
    }

    public ErrorPage buyInvalidCardNumber(DataHelper.CardInfo infoInvalidCardNumber) {
        buyButton.click();
        cardNumber.setValue(infoInvalidCardNumber.getCardNumber());
        monthCard.setValue(infoInvalidCardNumber.getMonth());
        yearCard.setValue(infoInvalidCardNumber.getYear());
        ownerCard.setValue(infoInvalidCardNumber.getOwner());
        code.setValue(infoInvalidCardNumber.getCodeVerification());
        continueButton.click();
        return new ErrorPage();
    }

    public WrongFormatPage invalidCardNumber(DataHelper.CardInfo infoInvalidCardNumber) {
        buyButton.click();
        cardNumber.setValue(infoInvalidCardNumber.getCardNumber());
        monthCard.setValue(infoInvalidCardNumber.getMonth());
        yearCard.setValue(infoInvalidCardNumber.getYear());
        ownerCard.setValue(infoInvalidCardNumber.getOwner());
        code.setValue(infoInvalidCardNumber.getCodeVerification());
        continueButton.click();
        return new WrongFormatPage();
    }

    public WrongFormatPage invalidMonth(DataHelper.CardInfo infoInvalidMonth) {
        buyButton.click();
        cardNumber.setValue(infoInvalidMonth.getCardNumber());
        monthCard.setValue(infoInvalidMonth.getMonth());
        yearCard.setValue(infoInvalidMonth.getYear());
        ownerCard.setValue(infoInvalidMonth.getOwner());
        code.setValue(infoInvalidMonth.getCodeVerification());
        continueButton.click();
        return new WrongFormatPage();
    }

    public WrongFormatPage invalidYear(DataHelper.CardInfo infoInvalidYear) {
        buyButton.click();
        cardNumber.setValue(infoInvalidYear.getCardNumber());
        monthCard.setValue(infoInvalidYear.getMonth());
        yearCard.setValue(infoInvalidYear.getYear());
        ownerCard.setValue(infoInvalidYear.getOwner());
        code.setValue(infoInvalidYear.getCodeVerification());
        continueButton.click();
        return new WrongFormatPage();
    }

    public WrongFormatPage invalidOwner(DataHelper.CardInfo infoInvalidOwner) {
        buyButton.click();
        cardNumber.setValue(infoInvalidOwner.getCardNumber());
        monthCard.setValue(infoInvalidOwner.getMonth());
        yearCard.setValue(infoInvalidOwner.getYear());
        ownerCard.setValue(infoInvalidOwner.getOwner());
        code.setValue(infoInvalidOwner.getCodeVerification());
        continueButton.click();
        return new WrongFormatPage();
    }

    public WrongFormatPage invalidCodeVerification(DataHelper.CardInfo infoInvalidCodeVerification) {
        buyButton.click();
        cardNumber.setValue(infoInvalidCodeVerification.getCardNumber());
        monthCard.setValue(infoInvalidCodeVerification.getMonth());
        yearCard.setValue(infoInvalidCodeVerification.getYear());
        ownerCard.setValue(infoInvalidCodeVerification.getOwner());
        code.setValue(infoInvalidCodeVerification.getCodeVerification());
        continueButton.click();
        return new WrongFormatPage();
    }
}
