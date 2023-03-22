package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class CardInfo {
        private String cardNumber;
        private String month;
        private String owner;
        private String codeVerification;
    }

    @Value
    public static class CardInfoInvalidMonth {
        private String cardNumber;
        private String invalidMonth;
        private String owner;
        private String codeVerification;
    }

    @Value
    public static class CardInfoInvalidYear {
        private String cardNumber;
        private String month;
        private String invalidYear;
        private String owner;
        private String codeVerification;
    }

    @Value
    public static class CardInfoInvalidOwner {
        private String cardNumber;
        private String month;
        private String invalidOwner;
        private String codeVerification;

    }

    @Value
    public static class CardInfoInvalidCodeVerification {
        private String cardNumber;
        private String month;
        private String owner;
        private String invalidCodeVerification;
    }
    @Value
    public static class PaymentStatus {
        private String status;
    }

    @Value
    public static class PaymentCreditStatus {
        private String creditStatus;
    }

    @Value
    public static class FixingPurchaseOrderMethod {
        private String orderMethod;
    }
    @Value
    public static class FixingPurchaseMethod {
        private String payment_id;
    }

    @Value
    public static class FixingPurchaseCreditMethod {
        private String credit_id;
    }

    public static String generateMonth() {
        String[] month = new String[]{
                "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        Faker faker = new Faker();
        return month[faker.number().numberBetween(0, month.length - 1)];
    }

    public static String generateYear(int years) {
        return LocalDate.now().plusYears(years).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String generateOwner(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String owner = faker.name().firstName() + " " + faker.name().lastName();
        return owner;
    }

    public static String generateCodeVerification() {
        String[] codeVerification = new String[]{
                "156", "124", "956", "735", "901", "455", "308", "777", "464", "900", "128", "759", "840", "100", "534", "706", "651", "996", "789", "890"};
        Faker faker = new Faker();
        return codeVerification[faker.number().numberBetween(0, codeVerification.length - 1)];
    }

    public static CardInfo getCardInfo_1() {
        return new CardInfo("4444 4444 4444 4441", generateMonth(), generateOwner("en"), generateCodeVerification());
    }

    public static CardInfo getCardInfo_2() {
        return new CardInfo("4444 4444 4444 4442", generateMonth(), generateOwner("en"), generateCodeVerification());
    }

    public static CardInfo getCardNumberNull() {
        return new CardInfo("0000 0000 0000 0000", generateMonth(), generateOwner("en"), generateCodeVerification());
    }

    public static CardInfo getCardNumberNine() {
        return new CardInfo("9999 9999 9999 9999", generateMonth(), generateOwner("en"), generateCodeVerification());
    }

    public static CardInfo getCardNumberLetters() {
        return new CardInfo("абв", generateMonth(), generateOwner("en"), generateCodeVerification());
    }

    public static CardInfo getCardNumber15() {
        return new CardInfo("1111 1111 1111 111", generateMonth(), generateOwner("en"), generateCodeVerification());
    }

    public static CardInfoInvalidMonth getInvalidMonth_00() {
        return new CardInfoInvalidMonth("4444 4444 4444 4441", "00", generateOwner("en"), generateCodeVerification());
    }

    public static CardInfoInvalidMonth getInvalidMonth_13() {
        return new CardInfoInvalidMonth("4444 4444 4444 4441", "13", generateOwner("en"), generateCodeVerification());
    }

    public static CardInfoInvalidMonth getInvalidMonthLetters() {
        return new CardInfoInvalidMonth("4444 4444 4444 4441", "абв", generateOwner("en"), generateCodeVerification());
    }

    public static CardInfoInvalidMonth getInvalidMonthOneDigit() {
        return new CardInfoInvalidMonth("4444 4444 4444 4441", "1", generateOwner("en"), generateCodeVerification());
    }

    public static CardInfoInvalidYear getInvalidYear_00() {
        return new CardInfoInvalidYear("4444 4444 4444 4441", generateMonth(), "00", generateOwner("en"), generateCodeVerification());
    }

    public static CardInfoInvalidYear getInvalidYearLetters() {
        return new CardInfoInvalidYear("4444 4444 4444 4441", generateMonth(), "абв", generateOwner("en"), generateCodeVerification());
    }


    public static CardInfoInvalidYear getInvalidYearOneDigit() {
        return new CardInfoInvalidYear("4444 4444 4444 4441", generateMonth(), "1", generateOwner("en"), generateCodeVerification());
    }

    public static String generateInvalidOwnerCyrillic(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String invalidOwner = faker.name().firstName() + " " + faker.name().lastName();
        return invalidOwner;
    }

    public static CardInfoInvalidOwner getInvalidOwnerCyrillic() {
        return new CardInfoInvalidOwner("4444 4444 4444 4441", generateMonth(), generateInvalidOwnerCyrillic("ru"), generateCodeVerification());
    }

    public static CardInfoInvalidOwner getInvalidOwnerSymbols() {
        return new CardInfoInvalidOwner("4444 4444 4444 4441", generateMonth(), "!@#$%^&*()+", generateCodeVerification());
    }

    public static CardInfoInvalidOwner getInvalidOwnerNumbers() {
        return new CardInfoInvalidOwner("4444 4444 4444 4441", generateMonth(), "1234", generateCodeVerification());
    }

    public static CardInfoInvalidOwner getInvalidOwnerSpace() {
        return new CardInfoInvalidOwner("4444 4444 4444 4441", generateMonth(), " ", generateCodeVerification());
    }

    public static CardInfoInvalidOwner getInvalidOwnerSpaces() {
        return new CardInfoInvalidOwner("4444 4444 4444 4441", generateMonth(), "     ", generateCodeVerification());
    }

    public static CardInfoInvalidCodeVerification getInvalidCodeVerificationNull() {
        return new CardInfoInvalidCodeVerification("4444 4444 4444 4441", generateMonth(), generateOwner("en"), "000");
    }

    public static CardInfoInvalidCodeVerification getInvalidCodeVerificationLetters() {
        return new CardInfoInvalidCodeVerification("4444 4444 4444 4441", generateMonth(), generateOwner("en"), "абв");
    }

    public static CardInfoInvalidCodeVerification getInvalidCodeVerificationOneDigit() {
        return new CardInfoInvalidCodeVerification("4444 4444 4444 4441", generateMonth(), generateOwner("en"), "1");
    }

    public static CardInfoInvalidCodeVerification getInvalidCodeVerificationFourDigits() {
        return new CardInfoInvalidCodeVerification("4444 4444 4444 4441", generateMonth(), generateOwner("en"), "1234");
    }
}
