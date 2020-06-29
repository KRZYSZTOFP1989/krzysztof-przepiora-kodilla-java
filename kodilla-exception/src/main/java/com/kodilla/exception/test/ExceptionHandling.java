package com.kodilla.exception.test;

public class ExceptionHandling  {

    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();
        String result = "Done!";

        try {
            result = secondChallenge.probablyIWillThrowException(1.0, 8.0);

        } catch (Exception e) {

            System.out.print("Oh no! Something went wrong!" + e);

        } finally {

            System.out.print(result);
        }

    }
}
