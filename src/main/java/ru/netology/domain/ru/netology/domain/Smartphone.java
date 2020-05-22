package ru.netology.domain.ru.netology.domain;

import ru.netology.domain.Product;

public class Smartphone extends Product {
    private String vendor;

    public Smartphone(){
        super();
    }

    public Smartphone(int id, String name, int price, String vendor) {
        super(id, name, price);
        this.vendor = vendor;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
