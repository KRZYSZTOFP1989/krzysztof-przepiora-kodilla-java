package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {

        //Given
        Library library = new Library("LibraryBooks");
        Book book1 = new Book("Pan Tadeusz", "Adam Mickiewicz", LocalDate.of(1989, 8,12));
        Book book2 = new Book("Konrad Wallenrod", "Adam Mickiewicz", LocalDate.of(1889, 4,15));
        Book book3 = new Book("Liryki lozańskie", "Adam Mickiewicz", LocalDate.of(1964, 3,2));
        Book book4 = new Book("Konfederaci barscy", "Adam Mickiewicz", LocalDate.of(1289, 12,12));
        Book book5 = new Book("Jakub Jasiński albo dwie Polski", "Adam Mickiewicz", LocalDate.of(1389, 6,6));

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);
        library.getBooks().add(book5);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println(library);
        System.out.println(clonedLibrary);

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When

        //Then
        Assert.assertEquals(5, library.getBooks().size());
        Assert.assertEquals(5, clonedLibrary.getBooks().size());
        Assert.assertEquals(5, deepClonedLibrary.getBooks().size());
    }
}
