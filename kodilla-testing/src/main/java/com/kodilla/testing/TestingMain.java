package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();

        int result1 = calculator.add(5,4);
        int result2 = calculator.subtract(5,4);

        if (result1 == 9){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        if (result2 == 1){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

    }
}