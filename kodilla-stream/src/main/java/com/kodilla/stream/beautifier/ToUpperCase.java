package com.kodilla.stream.beautifier;

public class ToUpperCase implements PoemDecorator {
    @Override
    public String decorate(String text) {
        return text.toUpperCase();
    }
}
