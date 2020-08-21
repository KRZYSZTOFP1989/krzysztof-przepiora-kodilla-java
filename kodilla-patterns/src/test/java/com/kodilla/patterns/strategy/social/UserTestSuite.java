package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {

        //Given
        User giuseppe = new Millenials("Giuseppe Reyna");
        User francesco = new YGeneration("Francesco Totti");
        User michael = new ZGeneration("Michael Ballack");

        //When
        String giuseppeSharePost = giuseppe.sharePost();
        System.out.println("Giuseppe share post on: " + giuseppeSharePost);
        String francescoSharePost = francesco.sharePost();
        System.out.println("Francesco share post on: " + francescoSharePost);
        String michaelSharePost = michael.sharePost();
        System.out.println("Michael share post on: " + michaelSharePost);

        //Then
        Assert.assertEquals("Facebook", giuseppeSharePost);
        Assert.assertEquals("Twitter", francescoSharePost);
        Assert.assertEquals("Snapchat", michaelSharePost);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User giuseppe = new Millenials("Giuseppe Reyna");

        //When
        String giuseppeSharePost = giuseppe.sharePost();
        System.out.println("Giuseppe share post on: " + giuseppeSharePost);
        giuseppe.setMediumStrategy(new TwitterPublisher());
        giuseppeSharePost = giuseppe.sharePost();
        System.out.println("Giuseppe share post on: " + giuseppeSharePost);

        //Then
        Assert.assertEquals("Twitter", giuseppeSharePost);
    }
}
