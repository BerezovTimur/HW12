package ru.netology.ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    private Book first = new Book(1,"Война и мир",1000,"Толстой");
    private Book second = new Book(2,"Отцы и дети",1000,"Тургенев");
    private Book third = new Book(3, "Преступление и наказание", 1000, "Достоевский");
    private Book fourth = new Book(4,"Galaxy",1000,"Noname");
    private Smartphone xiaomi = new Smartphone(5,"Mi",10000,"Xiaomi");
    private Smartphone samsung = new Smartphone(6,"Galaxy",20000,"Samsung");

    @BeforeEach
    void setup() {
        manager = new ProductManager(repository);
        manager.addProduct(first);
        manager.addProduct(second);
        manager.addProduct(third);
        manager.addProduct(xiaomi);
        manager.addProduct(samsung);
    }

    @Test
    void shouldFindBookByNameIfExists() {
        String textToFind = "Война и мир";
        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindBookByNameIfNotExists() {
        String textToFind = "Ревизор";
        manager.searchBy(textToFind);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindBookByAuthorIfExists() {
        manager.addProduct(fourth);
        String textToFind = "Noname";
        manager.searchBy(textToFind);
        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindBookByAuthorIfNotExists() {
        String textToFind = "Гоголь";
        manager.searchBy(textToFind);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSmartphoneByModelIfExists() {
        String textToFind = "Xiaomi";
        manager.searchBy(textToFind);
        Product[] expected = new Product[]{xiaomi};
        Product[] actual = manager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSmartphoneByVendorIfExists() {
        String textToFind = "Samsung";
        manager.searchBy(textToFind);
        Product[] expected = new Product[]{samsung};
        Product[] actual = manager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindSmartphoneByNameIfNotExists() {
        String textToFind = "Realme";
        manager.searchBy(textToFind);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindSmartphoneByVendorIfNotExists() {
        String textToFind = "Vertex";
        manager.searchBy(textToFind);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }
}