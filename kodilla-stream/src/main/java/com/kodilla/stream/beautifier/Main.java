package com.kodilla.stream.beautifier;

public class Main {

    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        //Za pomocą implementacji klasy i stworzenia jej obiektu
        PoemDecorator poemDecorator = new ToUpperCase();
        String result1 = poemBeautifier.beautify("text", poemDecorator);
        System.out.println(result1);

        //Wykorzystanie lambdy
        String result2 = poemBeautifier.beautify("text", s -> s.toUpperCase());
        //Dziala jak linijke wyzej, inny sposob zapisy
        //String result2 = poemBeautifier.beautify("text", String::toUpperCase);
        System.out.println(result2);

    }


}
