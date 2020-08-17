package com.kodilla.spring.forum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ForumUserTestSuite {

    @Test
    public void testGetUsername() {

        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.forum");
        ForumUser forumuser = context.getBean(ForumUser.class);
        //When
        String username = forumuser.getUserName();
        //Then
        Assert.assertEquals("John Smith", username);

    }
}
