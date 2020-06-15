package com.kodilla.testing.collection;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {

    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {

        OddNumbersExterminator exterminator = new OddNumbersExterminator();

        List<Integer> emptyList = new ArrayList<>();

        List<Integer> resultList = exterminator.exterminate(emptyList);
        System.out.println("Testing empty list");

        Assert.assertEquals(emptyList, resultList);

        }

    @Test
    public void testOddNumbersExterminatorNormalList() {

        OddNumbersExterminator exterminator = new OddNumbersExterminator();

        List<Integer> normalList = new ArrayList<>();

        normalList.add(3);
        normalList.add(4);
        normalList.add(1);
        normalList.add(2);
        normalList.add(5);
        normalList.add(6);
        normalList.add(7);
        normalList.add(8);
        normalList.add(9);
        normalList.add(10);
        normalList.add(11);
        normalList.add(12);
        normalList.add(14);
        normalList.add(13);
        normalList.add(15);

        List<Integer>evenNumbersList = new ArrayList<>();
        evenNumbersList.add(4);
        evenNumbersList.add(2);
        evenNumbersList.add(6);
        evenNumbersList.add(8);
        evenNumbersList.add(10);
        evenNumbersList.add(12);
        evenNumbersList.add(14);

        List<Integer> resultList = exterminator.exterminate(normalList);
        System.out.println("Testing normal list");

        Assert.assertEquals(evenNumbersList, resultList);

    }

}