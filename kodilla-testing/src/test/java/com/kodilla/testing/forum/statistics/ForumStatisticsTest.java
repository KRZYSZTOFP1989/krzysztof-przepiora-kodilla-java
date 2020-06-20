package com.kodilla.testing.forum.statistics.mock;

import com.kodilla.testing.forum.statistics.ForumStatistics;
import com.kodilla.testing.forum.statistics.Statistics;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTest {

    @Test
    public void testIfPostQuantityIsEqualToZero() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(usersList);
        //When
        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatistics.getPostsQuantity());
        assertEquals(0, forumStatistics.getAveragePostsQuantity(),(0));
        assertEquals(0, forumStatistics.getAverageCommentsQuantity(),(0));
        assertEquals(0, forumStatistics.getAverageQuantityCommentsPerPosts(),(0));
    }

    @Test
    public void testIfPostQuantityIsEqualToThousand() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();
        for(int i = 0; i < 1200; i++){
            usersList.add("User");
        }
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(1200);
        when(statisticsMock.usersNames()).thenReturn(usersList);
        //When
        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(1000, forumStatistics.getPostsQuantity());
        assertEquals(0.83, forumStatistics.getAveragePostsQuantity(),(0.83));
        assertEquals(1, forumStatistics.getAverageCommentsQuantity(),(1));
        assertEquals(1, forumStatistics.getAverageQuantityCommentsPerPosts(),(1));
    }

    @Test
    public void testIfCommentsQuantityIsEqualToZero() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();
        for(int i = 0; i < 90; i++) {
            usersList.add("User");
        }
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(usersList);
        //When
        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatistics.getCommentsQuantity());
        assertEquals(11.1, forumStatistics.getAveragePostsQuantity(),(11.1));
        assertEquals(0, forumStatistics.getAverageCommentsQuantity(),(0));
        assertEquals(0, forumStatistics.getAverageQuantityCommentsPerPosts(),(0));
    }

    @Test
    public void testIfCommentsQuantityIsSmallerThanPostsQuantity() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
            List<String> usersList = new ArrayList<>();
            for(int i = 0; i < 5; i++) {
                usersList.add("User");
            }
        when(statisticsMock.commentsCount()).thenReturn(5);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.usersNames()).thenReturn(usersList);
        //When
        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(5, forumStatistics.getCommentsQuantity());
        assertEquals(10, forumStatistics.getPostsQuantity());
        assertEquals(2, forumStatistics.getAveragePostsQuantity(),(2));
        assertEquals(1, forumStatistics.getAverageCommentsQuantity(),(1));
        assertEquals(0.5, forumStatistics.getAverageQuantityCommentsPerPosts(),(0.5));
    }

    @Test
    public void testIfPostsQuantityIsSmallerThanCommentsQuantity() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            usersList.add("User");
        }
        when(statisticsMock.commentsCount()).thenReturn(10);
        when(statisticsMock.postsCount()).thenReturn(5);
        when(statisticsMock.usersNames()).thenReturn(usersList);
        //When
        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(10, forumStatistics.getCommentsQuantity());
        assertEquals(5, forumStatistics.getPostsQuantity());
        assertEquals(1, forumStatistics.getAveragePostsQuantity(),(1));
        assertEquals(2, forumStatistics.getAverageCommentsQuantity(),(2));
        assertEquals(2, forumStatistics.getAverageQuantityCommentsPerPosts(),(2));
    }

    @Test
    public void testIfUsersQuantityIsEqualToZero() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(usersList);
        //When
        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatistics.getUsersQuantity());
        assertEquals(0, forumStatistics.getAveragePostsQuantity(),(0));
        assertEquals(0, forumStatistics.getAverageCommentsQuantity(),(0));
        assertEquals(0, forumStatistics.getAverageQuantityCommentsPerPosts(),(0));
    }

    @Test
    public void testIfUsersQuantityIsEqualToHundred() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();
                for(int i = 0; i < 100; i++) {
                    usersList.add("User");
                }
        when(statisticsMock.commentsCount()).thenReturn(30);
        when(statisticsMock.postsCount()).thenReturn(20);
        when(statisticsMock.usersNames()).thenReturn(usersList);
        //When
        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(100, forumStatistics.getUsersQuantity());
        assertEquals(0.2, forumStatistics.getAveragePostsQuantity(),(0.2));
        assertEquals(0.3, forumStatistics.getAverageCommentsQuantity(),(0.3));
        assertEquals(1.5, forumStatistics.getAverageQuantityCommentsPerPosts(),(1.5));
    }
}