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
    public void testIfPostQuantityBiggerThanZero {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> postList = new ArrayList<>();
        when(statisticsMock.postsCount()).thenReturn(postList);
        //When
        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatistics.getPostsQuantity());
    }

}
