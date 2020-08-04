package com.kodilla.good.patterns.challenges;

public class InformationServiceEmail implements InformationService {

    @Override
    public void inform(User user) {
        System.out.println(user + " " + "Your order customized");
    }

}
