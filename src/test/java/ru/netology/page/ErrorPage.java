package ru.netology.page;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ErrorPage {
    private SelenideElement error = $(".notification_status_error");

    public ErrorPage() {
        error.shouldBe(visible, Duration.ofSeconds(20));
    }
}
