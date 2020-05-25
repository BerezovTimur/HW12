package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book = new Book(1, "Война и мир", 1000, "Толстой");

    @Test
    void shouldMatchByNameIfExists() {
        String textToFind = "Война и мир";
        book.matches(textToFind);
        assertTrue(book.matches(textToFind));
    }

    @Test
    void shouldMatchByAuthorIfExists() {
        String textToFind = "Толстой";
        book.matches(textToFind);
        assertTrue(book.matches(textToFind));
    }

    @Test
    void shouldMatchByNameIfNotExists() {
        String textToFind = "Отцы и дети";
        book.matches(textToFind);
        assertFalse(book.matches(textToFind));
    }

    @Test
    void shouldMatchByAuthorIfNotExists() {
        String textToFind = "Тургенев";
        book.matches(textToFind);
        assertFalse(book.matches(textToFind));
    }


}