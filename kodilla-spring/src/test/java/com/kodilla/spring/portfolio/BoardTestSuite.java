package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Test
    public void testTaskAdd() {

        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        List<String> toDoList = board.getToDoList().getTasks();
        List<String> inProgressList = board.getInProgressList().getTasks();
        List<String> doneList = board.getDoneList().getTasks();
        toDoList.add("Task to do");
        inProgressList.add("Task in progress");
        doneList.add("Done task");
        //Then
        Assert.assertEquals("Task to do", board.getToDoList().getTasks().get(0));
        Assert.assertEquals("Task in progress", board.getInProgressList().getTasks().get(0));
        Assert.assertEquals("Done task", board.getDoneList().getTasks().get(0));

    }

}
