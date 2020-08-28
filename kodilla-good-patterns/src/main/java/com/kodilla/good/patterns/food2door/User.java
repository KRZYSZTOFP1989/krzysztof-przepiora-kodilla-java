package com.kodilla.good.patterns.food2door;

public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User customer = (User) o;

        return getName().equals(customer.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
