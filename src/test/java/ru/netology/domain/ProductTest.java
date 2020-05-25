package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product = new Product(1,"Война и мир",1000);

    @Test
    void shouldMatchByNameIfExists() {
        String textToFind = "Война и мир";
        product.matches(textToFind);
        assertTrue(product.matches(textToFind));
    }

    @Test
    void shouldMatchByNameIfNotExists() {
        String textToFind = "Отцы и дети";
        product.matches(textToFind);
        assertFalse(product.matches(textToFind));
    }

}