package com.kodilla.testing.shape;

import org.junit.*;

import static org.junit.Assert.*;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;
    private Object Square;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure() {

        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Square();

        //When
        shapeCollector.addFigure(shape);

        //Then
        assertEquals(1, shapeCollector.getShapeCollection().size());

    }

    @Test
    public void testRemoveFigure() {

        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Square();
        shapeCollector.addFigure(shape);

        //When
        boolean result = shapeCollector.removeFigure(shape);

        //Then
        Assert.assertTrue(result);
        assertEquals(1, shapeCollector.getShapeCollection().size());

    }

    @Test
    public void testGetFigure() {

        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Square();
        shapeCollector.addFigure(shape);

        //When
        Shape retrievedShape;
        retrievedShape = shapeCollector.getFigure();

        //Then
        assertEquals(shapeCollector, retrievedShape);

    }

    @Test
    public void testShowFigures() {

    }
}
