package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        //given
        String log1 = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s";
        String log2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod;";
        String log3 = "Neque aliquam vestibulum morbi blandit cursus risus at ultrices";
        //when
        com.kodilla.patterns.singleton.Logger.getInstance().log(log1);
        com.kodilla.patterns.singleton.Logger.getInstance().log(log2);
        com.kodilla.patterns.singleton.Logger.getInstance().log(log3);
        //then
        Assert.assertEquals(log3, com.kodilla.patterns.singleton.Logger.getInstance().getLastLog());
    }
}
