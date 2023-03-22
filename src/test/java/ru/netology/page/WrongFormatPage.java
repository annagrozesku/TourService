package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class WrongFormatPage {
    private SelenideElement wrongFormat = $(".input__sub");

    public WrongFormatPage() {
        wrongFormat.shouldBe(visible);
    }
}
