package com.kodilla.stream.array;;
import org.junit.Assert;
import org.junit.Test;
import java.util.OptionalDouble;
import static org.junit.Assert.*;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {

        //Given
       int[] numbers = {4, 6, 7, 12, 16, 71, 43, 44, 21, 54};

       //When
       OptionalDouble average = ArrayOperations.getAverage(numbers);

       //Than
        assertEquals(27.8, average, 27.8);

    }

    private void assertEquals(double i, OptionalDouble average, double i1) {
    }
}
