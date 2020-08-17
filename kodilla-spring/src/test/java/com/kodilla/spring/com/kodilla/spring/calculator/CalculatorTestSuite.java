package com.kodilla.spring.com.kodilla.spring.calculator;
import com.kodilla.spring.calculator.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorTestSuite {

    @Test
    public void testCalculations() {

        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double add = calculator.add(3,6);
        double sub = calculator.sub(9, 6);
        double mul = calculator.mul(6, 2);
        double div = calculator.div(6, 6);
        //Then
        Assert.assertEquals(9, add, 0.1);
        Assert.assertEquals(3, sub, 0.1);
        Assert.assertEquals(12, mul, 0.1);
        Assert.assertEquals(1, div, 0.1);
    }
}
