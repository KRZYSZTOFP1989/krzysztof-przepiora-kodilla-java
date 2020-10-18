package com.kodilla.patterns.challenges;

public class InformationServiceEmail implements InformationService {

    @Override
    public void inform(User user) {
        System.out.println(user + " " + "Your order customized");
    }

}
