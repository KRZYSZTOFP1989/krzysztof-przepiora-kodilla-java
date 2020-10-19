package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentHomeworkTestSuite {

    @Test
    public void testUpdate() {

        //Given
        Student kodillajavastudents = new KodillaJava("Andrew Tyson", "Kodilla Java Student");
        Student kodillajavastudents1 = new KodillaJava("Grażyna Nowak", "Kodilla Java Student");
        Student kodillajavascriptstudents = new KodillaJavaScript("Alexandre Pato", "Kodilla Java Script Student");
        Student kodillajavascriptstudents1 = new KodillaJavaScript("Pedro Gonzalez", "Kodilla Java Script Student");

        Mentor janAndrzejewski = new Mentor("Jan Andrzejewski");
        Mentor andrzejJanczewski = new Mentor("Andrzej Janczewski");

        kodillajavastudents.registerObserver(janAndrzejewski);
        kodillajavascriptstudents1.registerObserver(janAndrzejewski);
        kodillajavastudents1.registerObserver(andrzejJanczewski);
        kodillajavascriptstudents.registerObserver(andrzejJanczewski);

        //When
        kodillajavastudents.sendTask("Task 17.2 the observator pattern");
        kodillajavastudents.sendTask("Task 17.3 the facade pattern");
        kodillajavastudents.sendTask("Task 13.3 hibernate framework");
        kodillajavastudents1.sendTask("Task 17.4 Spring AOP");
        kodillajavascriptstudents.sendTask("Task 12.9 Java Script and CSS");
        kodillajavascriptstudents1.sendTask("Task 12.2 Java Script and CSS");
        kodillajavascriptstudents1.sendTask("Task 19.2 Java Script client-side");

        //Then
        assertEquals(5, janAndrzejewski.getUpdateCount());
        assertEquals(2, andrzejJanczewski.getUpdateCount());
    }
}
