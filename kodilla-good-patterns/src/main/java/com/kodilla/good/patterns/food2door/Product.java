package com.kodilla.good.patterns.food2door;

public class Product {

    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "product name=" + name + "," + " quantity:";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return getName().equals(product.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
