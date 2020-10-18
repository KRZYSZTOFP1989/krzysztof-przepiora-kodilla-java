package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void testShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.makeTask(TaskFactory.FIRST_VARIABLE);
        shopping.executeTask();
        //Then
        Assert.assertEquals(shopping.getTaskName(), "go to the grocery store");
        Assert.assertTrue(shopping.isTaskExecuted());
    }

    @Test
    public void testPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task painting = factory.makeTask(TaskFactory.SECOND_VARIABLE);
        painting.executeTask();
        //Then
        Assert.assertEquals(painting.getTaskName(), "painting walls");
        Assert.assertTrue(painting.isTaskExecuted());
    }

    @Test
    public void testDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task driving = factory.makeTask(TaskFactory.THIRD_VARIABLE);
        driving.executeTask();
        //Then
        Assert.assertEquals(driving.getTaskName(), "go to the station");
        Assert.assertTrue(driving.isTaskExecuted());
    }

}
