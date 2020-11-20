package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {

        //Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Test author", "Test title", 1999, "JASDSDKSDKS"));
        bookSet.add(new Book("Test author 2", "Test title 2", 2000, "TTTGSFSDFD"));
        bookSet.add(new Book("Test author 3", "Test title 3", 1989, "TEEERERERER"));
        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int publicationYearMedian = medianAdapter.publicationYearMedian(bookSet);

        //Then
        Assert.assertEquals(1999, publicationYearMedian);

    }
}
