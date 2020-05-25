package ru.netology.ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProduct(Product item){
        repository.save(item);
    }

    public Product[] allProduct() {
        return repository.findAll();
    }

    public void deleteById(int id) {
        repository.removeById(id);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product: repository.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}
