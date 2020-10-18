package com.kodilla.patterns2.decorator.pizza;


import java.math.BigDecimal;

public class MargheritaPizzaOrder implements PizzaOrder {

    public BigDecimal getCost() {
        return new BigDecimal(15);
    }

    public String getDescription() {
        return "dough, tomato sauce, cheese";
    }
}
