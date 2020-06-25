package com.kodilla.stream.array;;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {

        //Given
       int[] numbers = {4, 6, 7, 12, 16, 71, 43, 44, 21, 54};

       //When
       double average = ArrayOperations.getAverage(numbers);

       //Than
        assertEquals(27.8, average, 27.8);

    }

}
