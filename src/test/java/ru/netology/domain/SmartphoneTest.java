package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone smartphone = new Smartphone(5, "Mi", 10000, "Xiaomi");

    @Test
    void shouldMatchByNameIfExists() {
        String textToFind = "Mi";
        smartphone.matches(textToFind);
        assertTrue(smartphone.matches(textToFind));
    }

    @Test
    void shouldMatchByNameIfNotExists() {
        String textToFind = "Galaxy";
        smartphone.matches(textToFind);
        assertFalse(smartphone.matches(textToFind));
    }

    @Test
    void shouldMatchByVendorIfExists() {
        String textToFind = "Xiaomi";
        smartphone.matches(textToFind);
        assertTrue(smartphone.matches(textToFind));
    }

    @Test
    void shouldMatchByProducerIfNotExists() {
        String textToFind = "Samsung";
        smartphone.matches(textToFind);
        assertFalse(smartphone.matches(textToFind));
    }
}