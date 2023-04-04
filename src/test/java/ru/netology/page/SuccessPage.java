package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SuccessPage {
    private SelenideElement success = $(".notification_visible");

    public SuccessPage() {
        success.shouldBe(visible, Duration.ofSeconds(20));
    }
}
