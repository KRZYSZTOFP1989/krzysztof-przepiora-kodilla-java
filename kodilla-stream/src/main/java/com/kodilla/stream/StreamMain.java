package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.reference.FunctionalCalculator;
import com.kodilla.stream.person.People;

import java.util.Locale;

public class StreamMain {
    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.execute(() -> System.out.println("This is an example text."));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier poembeautifier = new PoemBeautifier();

        String text1 = poembeautifier.beautify("Example text", (text -> text.toUpperCase()));
        System.out.println(text1);

        String text2 = poembeautifier.beautify("Example text", (text -> text.toLowerCase()));
        System.out.println(text2);

        String text3 = poembeautifier.beautify("Example text", (text -> text.replace("E","Ə")));
        System.out.println(text3);

        String text4 = poembeautifier.beautify("Example text", (text -> text.replaceFirst("E", "EEE")));
        System.out.println(text4);

        String text5 = poembeautifier.beautify("Example text", (text -> text.replaceFirst("E", "*E")));
        System.out.println(text5);

        String text6 = poembeautifier.beautify("Example text", (text -> text.replaceFirst("Example", "EXAMPLE")));
        System.out.println(text6);

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

        People.getList().stream()
                .forEach(System.out::println);repr

    }
}
