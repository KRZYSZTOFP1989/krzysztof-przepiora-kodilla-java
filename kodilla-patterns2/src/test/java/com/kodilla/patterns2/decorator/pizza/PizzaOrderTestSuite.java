package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost() {

        //Given
        PizzaOrder pizzaOrder = new MargheritaPizzaOrder();

        //When
        BigDecimal calculateCost = pizzaOrder.getCost();

        //Than
        assertEquals(new BigDecimal(15), calculateCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {

        //Given
        PizzaOrder pizzaOrder = new MargheritaPizzaOrder();

        //When
        String description = pizzaOrder.getDescription();

        //Than
        assertEquals("dough, tomato sauce, cheese", description);
    }

    @Test
    public void testPepperoniPizzaOrderGetCost() {

        //Given
        PizzaOrder pizzaOrder = new MargheritaPizzaOrder();
        pizzaOrder = new PepperoniPizzaOrderDecorator(pizzaOrder);

        //When
        BigDecimal calculateCost = pizzaOrder.getCost();

        //Than
        assertEquals(new BigDecimal(20), calculateCost);

    }

    @Test
    public void testPepperoniPizzaOrderGetDescription() {

        //Given
        PizzaOrder pizzaOrder = new MargheritaPizzaOrder();
        pizzaOrder = new PepperoniPizzaOrderDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Than
        assertEquals("dough, tomato sauce, cheese + pepperoni", description);

    }

    @Test
    public void testHawaiiPizzaOrderGetCost() {

        //Given
        PizzaOrder pizzaOrder = new MargheritaPizzaOrder();
        pizzaOrder = new HawaiiPizzaOrderDecoration(pizzaOrder);

        //When
        BigDecimal calculateCost = pizzaOrder.getCost();

        //Than
        assertEquals(new BigDecimal(23), calculateCost);

    }

    @Test
    public void testHawaiiPizzaOrderGetDescription() {

        //Given
        PizzaOrder pizzaOrder = new MargheritaPizzaOrder();
        pizzaOrder = new HawaiiPizzaOrderDecoration(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Than
        assertEquals("dough, tomato sauce, cheese + pineapple, ham", description);

    }

    @Test
    public void testSupremePizzaOrderGetCost() {

        //Given
        PizzaOrder pizzaOrder = new MargheritaPizzaOrder();
        pizzaOrder = new SupremePizzaOrderDecorator(pizzaOrder);

        //When
        BigDecimal calculateCost = pizzaOrder.getCost();

        //Than
        assertEquals(new BigDecimal(25), calculateCost);

    }

    @Test
    public void testSupremePizzaOrderGetDescription() {

        //Given
        PizzaOrder pizzaOrder = new MargheritaPizzaOrder();
        pizzaOrder = new SupremePizzaOrderDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Than
        assertEquals("dough, tomato sauce, cheese + pepperoni sausage, onion, beef", description);

    }

    @Test
    public void testSupremePizzaWithDoubleCheeseGetCost() {

        //Given
        PizzaOrder pizzaOrder = new MargheritaPizzaOrder();
        pizzaOrder = new SupremePizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new DoubleCheeseDecorator(pizzaOrder);

        //When
        BigDecimal calculateCost = pizzaOrder.getCost();

        //Than
        assertEquals(new BigDecimal(30), calculateCost);

    }

    @Test
    public void testSupremePizzaWithDoubleCheeseGetDescription() {

        //Given
        PizzaOrder pizzaOrder = new MargheritaPizzaOrder();
        pizzaOrder = new SupremePizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new DoubleCheeseDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Than
        assertEquals("dough, tomato sauce, cheese + pepperoni sausage, onion, beef + extra cheese", description);

    }

    @Test
    public void testHawaiiPizzaWithCheeseEdgesGetCost() {

        //Given
        PizzaOrder pizzaOrder = new MargheritaPizzaOrder();
        pizzaOrder = new HawaiiPizzaOrderDecoration(pizzaOrder);
        pizzaOrder = new CheeseEdgesDecorator(pizzaOrder);

        //When
        BigDecimal getCost = pizzaOrder.getCost();

        //Than
        assertEquals(new BigDecimal(28), getCost);

    }

    @Test
    public void testHawaiiPizzaWithCheeseEdgesGetDescription() {

        //Given
        PizzaOrder pizzaOrder = new MargheritaPizzaOrder();
        pizzaOrder = new HawaiiPizzaOrderDecoration(pizzaOrder);
        pizzaOrder = new CheeseEdgesDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Than
        assertEquals("dough, tomato sauce, cheese + pineapple, ham + cheese edges", description);

    }

}
