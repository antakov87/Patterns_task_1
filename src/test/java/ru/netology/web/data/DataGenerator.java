package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public  static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String[] city = new String[]{
            "Уфа", "Белгород", "Волгоград", "Димитровград", "Кострома",
            "Москва", "Санкт-Петербург", "Тюмень", "Ульяновск", "Тамбов",
            "Ярославль", "Пенза", "Екатеринбург", "Казань", "Оренбург"
    };

    public static String generateCity() {
        Random generator = new Random();
        int randomIndex = generator.nextInt(15);
        return city[randomIndex];
    }

    public static String generateName() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().fullName().replaceAll("ё", "е");
    }

    public static String generatePhone() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.phoneNumber().phoneNumber();
    }

    public static RegistrationInfo getUser() {
        RegistrationInfo user = new RegistrationInfo(generateCity(), generateName(), generatePhone());
        return user;
    }

    @Value
    public static class RegistrationInfo {
        String login;
        String password;
        String status;

    }
}