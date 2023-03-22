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
        String year = generateYear(5);
        yearCard.setValue(year);
        ownerCard.setValue(info_1.getOwner());
        code.setValue(info_1.getCodeVerification());
        continueButton.click();
        return new SuccessPage();
    }

    public SuccessPage buyCard_2(DataHelper.CardInfo info_2) {
        buyButton.click();
        cardNumber.setValue(info_2.getCardNumber());
        monthCard.setValue(info_2.getMonth());
        String year = generateYear(4);
        yearCard.setValue(year);
        ownerCard.setValue(info_2.getOwner());
        code.setValue(info_2.getCodeVerification());
        continueButton.click();
        return new SuccessPage();
    }

    public SuccessPage buyOnCreditCard_1(DataHelper.CardInfo info_1) {
        buyOnCreditButton.click();
        cardNumber.setValue(info_1.getCardNumber());
        monthCard.setValue(info_1.getMonth());
        String year = generateYear(3);
        yearCard.setValue(year);
        ownerCard.setValue(info_1.getOwner());
        code.setValue(info_1.getCodeVerification());
        continueButton.click();
        return new SuccessPage();
    }

    public SuccessPage buyOnCreditCard_2(DataHelper.CardInfo info_2) {
        buyOnCreditButton.click();
        cardNumber.setValue(info_2.getCardNumber());
        monthCard.setValue(info_2.getMonth());
        String year = generateYear(2);
        yearCard.setValue(year);
        ownerCard.setValue(info_2.getOwner());
        code.setValue(info_2.getCodeVerification());
        continueButton.click();
        return new SuccessPage();
    }

    public ErrorPage buyInvalidCardNumber(DataHelper.CardInfo infoInvalidCardNumber) {
        buyButton.click();
        cardNumber.setValue(infoInvalidCardNumber.getCardNumber());
        monthCard.setValue(infoInvalidCardNumber.getMonth());
        String year = generateYear(1);
        yearCard.setValue(year);
        ownerCard.setValue(infoInvalidCardNumber.getOwner());
        code.setValue(infoInvalidCardNumber.getCodeVerification());
        continueButton.click();
        return new ErrorPage();
    }

    public WrongFormatPage invalidCardNumber(DataHelper.CardInfo infoInvalidCardNumber) {
        buyButton.click();
        cardNumber.setValue(infoInvalidCardNumber.getCardNumber());
        monthCard.setValue(infoInvalidCardNumber.getMonth());
        String year = generateYear(0);
        yearCard.setValue(year);
        ownerCard.setValue(infoInvalidCardNumber.getOwner());
        code.setValue(infoInvalidCardNumber.getCodeVerification());
        continueButton.click();
        return new WrongFormatPage();
    }

    public WrongFormatPage invalidMonth(DataHelper.CardInfoInvalidMonth infoInvalidMonth) {
        buyButton.click();
        cardNumber.setValue(infoInvalidMonth.getCardNumber());
        monthCard.setValue(infoInvalidMonth.getInvalidMonth());
        String year = generateYear(0);
        yearCard.setValue(year);
        ownerCard.setValue(infoInvalidMonth.getOwner());
        code.setValue(infoInvalidMonth.getCodeVerification());
        continueButton.click();
        return new WrongFormatPage();
    }

    public WrongFormatPage invalidYear(DataHelper.CardInfoInvalidYear infoInvalidYear) {
        buyButton.click();
        cardNumber.setValue(infoInvalidYear.getCardNumber());
        monthCard.setValue(infoInvalidYear.getMonth());
        yearCard.setValue(infoInvalidYear.getInvalidYear());
        ownerCard.setValue(infoInvalidYear.getOwner());
        code.setValue(infoInvalidYear.getCodeVerification());
        continueButton.click();
        return new WrongFormatPage();
    }

    public WrongFormatPage invalidOwner(DataHelper.CardInfoInvalidOwner infoInvalidOwner) {
        buyButton.click();
        cardNumber.setValue(infoInvalidOwner.getCardNumber());
        monthCard.setValue(infoInvalidOwner.getMonth());
        String year = generateYear(0);
        yearCard.setValue(year);
        ownerCard.setValue(infoInvalidOwner.getInvalidOwner());
        code.setValue(infoInvalidOwner.getCodeVerification());
        continueButton.click();
        return new WrongFormatPage();
    }

    public WrongFormatPage invalidCodeVerification(DataHelper.CardInfoInvalidCodeVerification infoInvalidCodeVerification) {
        buyButton.click();
        cardNumber.setValue(infoInvalidCodeVerification.getCardNumber());
        monthCard.setValue(infoInvalidCodeVerification.getMonth());
        String year = generateYear(0);
        yearCard.setValue(year);
        ownerCard.setValue(infoInvalidCodeVerification.getOwner());
        code.setValue(infoInvalidCodeVerification.getInvalidCodeVerification());
        continueButton.click();
        return new WrongFormatPage();
    }
}
