package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigMacTestSuite {

    @Test
    public void testBigMacNew() {
        //Given
        BigMac bigmac = new BigMac.BigMacBuilder()
                .bun("with sezam")
                .burgers(3)
                .sauce("standard")
                .ingredient("onion")
                .ingredient("lettuce")
                .ingredient("bacon")
                .ingredient("mushrooms")
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        Assert.assertEquals(4, howManyIngredients);
    }
}
