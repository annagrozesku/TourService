package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FormPage {

    private SelenideElement cardNumber = $("[placeholder = '0000 0000 0000 0000']");
    private SelenideElement monthCard = $("[placeholder = '08']");
    private SelenideElement yearCard = $("[placeholder = '22']");
    private SelenideElement ownerCard = $("div:nth-child(3) input");
    private SelenideElement code = $("[placeholder = '999']");
    private SelenideElement continueButton = $$("button").find(exactText("Продолжить"));
    private SelenideElement success = $(".notification_visible");
    private SelenideElement wrongFormat = $(".input__sub");
    private SelenideElement error = $(".notification_status_error");

    public FormPage success() {
        success.shouldBe(visible, Duration.ofSeconds(20));
        return this;
    }

    public FormPage wrongFormat() {
        wrongFormat.shouldBe(visible, Duration.ofSeconds(20));
        return this;
    }

    public FormPage error() {
        error.shouldBe(visible, Duration.ofSeconds(20));
        return this;
    }

    public FormPage buy(DataHelper.CardInfo info) {
        cardNumber.setValue(info.getCardNumber());
        monthCard.setValue(info.getMonth());
        yearCard.setValue(info.getYear());
        ownerCard.setValue(info.getOwner());
        code.setValue(info.getCodeVerification());
        continueButton.click();
        return this;
    }
}
