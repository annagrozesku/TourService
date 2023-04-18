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
        private String year;
        private String owner;
        private String codeVerification;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor

    public static class InfoPaymentDB {
        private String status;
        private String transaction_id;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor

    public static class InfoCreditPurchaseDB {
        private String bank_id;
        private String status;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor

    public static class FixingPurchaseOrderMethod {
        private String credit_id;
        private String payment_id;
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
        Faker faker = new Faker();
        String codeVerification = faker.number().digits(3);
        return codeVerification;
    }

    public static String generateInvalidOwnerCyrillic(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String invalidOwner = faker.name().firstName() + " " + faker.name().lastName();
        return invalidOwner;
    }

    public static CardInfo getCardInfoOne() {
        return new CardInfo("4444 4444 4444 4441", generateMonth(), generateYear(5), generateOwner("en"), generateCodeVerification());
    }

    public static CardInfo getCardInfoTwo() {
        return new CardInfo("4444 4444 4444 4442", generateMonth(), generateYear(4), generateOwner("en"), generateCodeVerification());
    }

    public static CardInfo getCardNumberNull() {
        return new CardInfo("0000 0000 0000 0000", generateMonth(), generateYear(3), generateOwner("en"), generateCodeVerification());
    }

    public static CardInfo getCardNumberNine() {
        return new CardInfo("9999 9999 9999 9999", generateMonth(), generateYear(2), generateOwner("en"), generateCodeVerification());
    }

    public static CardInfo getCardNumberLetters() {
        return new CardInfo("абв", generateMonth(), generateYear(1), generateOwner("en"), generateCodeVerification());
    }

    public static CardInfo getCardNumberFifteenDigits() {
        return new CardInfo("1111 1111 1111 111", generateMonth(), generateYear(5), generateOwner("en"), generateCodeVerification());
    }

    public static CardInfo getInvalidMonthNull() {
        return new CardInfo("4444 4444 4444 4441", "00", generateYear(5), generateOwner("en"), generateCodeVerification());
    }

    public static CardInfo getInvalidMonthThirteen() {
        return new CardInfo("4444 4444 4444 4441", "13", generateYear(5), generateOwner("en"), generateCodeVerification());
    }

    public static CardInfo getInvalidMonthLetters() {
        return new CardInfo("4444 4444 4444 4441", "абв", generateYear(5), generateOwner("en"), generateCodeVerification());
    }

    public static CardInfo getInvalidMonthOneDigit() {
        return new CardInfo("4444 4444 4444 4441", "1", generateYear(5), generateOwner("en"), generateCodeVerification());
    }

    public static CardInfo getInvalidYearNull() {
        return new CardInfo("4444 4444 4444 4441", generateMonth(), "00", generateOwner("en"), generateCodeVerification());
    }

    public static CardInfo getInvalidYearLetters() {
        return new CardInfo("4444 4444 4444 4441", generateMonth(), "абв", generateOwner("en"), generateCodeVerification());
    }

    public static CardInfo getInvalidYearOneDigit() {
        return new CardInfo("4444 4444 4444 4441", generateMonth(), "1", generateOwner("en"), generateCodeVerification());
    }

    public static CardInfo getInvalidOwnerCyrillic() {
        return new CardInfo("4444 4444 4444 4441", generateMonth(), generateYear(5), generateInvalidOwnerCyrillic("ru"), generateCodeVerification());
    }

    public static CardInfo getInvalidOwnerSymbols() {
        return new CardInfo("4444 4444 4444 4441", generateMonth(), generateYear(5), "!@#$%^&*()+", generateCodeVerification());
    }

    public static CardInfo getInvalidOwnerNumbers() {
        return new CardInfo("4444 4444 4444 4441", generateMonth(), generateYear(5), "1234", generateCodeVerification());
    }

    public static CardInfo getInvalidOwnerSpace() {
        return new CardInfo("4444 4444 4444 4441", generateMonth(), generateYear(5), " ", generateCodeVerification());
    }

    public static CardInfo getInvalidOwnerSpaces() {
        return new CardInfo("4444 4444 4444 4441", generateMonth(), generateYear(5), "     ", generateCodeVerification());
    }

    public static CardInfo getInvalidCodeVerificationNull() {
        return new CardInfo("4444 4444 4444 4441", generateMonth(), generateYear(5), generateOwner("en"), "000");
    }

    public static CardInfo getInvalidCodeVerificationLetters() {
        return new CardInfo("4444 4444 4444 4441", generateMonth(), generateYear(5), generateOwner("en"), "абв");
    }

    public static CardInfo getInvalidCodeVerificationOneDigit() {
        return new CardInfo("4444 4444 4444 4441", generateMonth(), generateYear(5), generateOwner("en"), "1");
    }
}