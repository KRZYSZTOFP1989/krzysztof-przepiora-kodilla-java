package com.kodilla.testing.forum.statistics;

public class ForumStatistics {

    private int usersQuantity;
    private int postsQuantity;
    private int commentsQuantity;
    private double averagePostsQuantity;
    private double averageCommentsQuantity;
    private double averageQuantityCommentsPerPosts;

    public int getUsersQuantity() {
        return usersQuantity;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    public int getCommentsQuantity() {
        return commentsQuantity;
    }

    public double getAveragePostsQuantity() {
        return averagePostsQuantity;
    }

    public double getAverageCommentsQuantity() {
        return averageCommentsQuantity;
    }

    public double getAverageQuantityCommentsPerPosts() {
        return averageQuantityCommentsPerPosts;
    }

    public double calculatedAveragePostsQuantity() {
        if(postsQuantity > 0) {
            return (double)postsQuantity / usersQuantity;
        } else {
            return 0;
        }
    }

    public double calculatedAverageCommentsQuantity() {
        if(commentsQuantity > 0) {
            return (double)commentsQuantity / usersQuantity;
        } else {
            return 0;
        }
    }

    public double calculatedAverageQuantityCommentsPerPosts() {
        if(commentsQuantity > 0) {
            return (double)commentsQuantity / postsQuantity;
        } else {
            return 0;
        }
    }

    public void calculateAdvStatistics (Statistics statistics) {
        usersQuantity = statistics.usersNames().size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();
        averagePostsQuantity = calculatedAveragePostsQuantity();
        averageCommentsQuantity = calculatedAverageCommentsQuantity();
        averageQuantityCommentsPerPosts = calculatedAverageQuantityCommentsPerPosts();
    }

    public void showStatistics() {
        System.out.println("Users Quantity:" + usersQuantity);
        System.out.println("Posts Quantity:" + postsQuantity);
        System.out.println("Comments Quantity:" + commentsQuantity);
        System.out.println("Average Posts Quantity:" + averagePostsQuantity);
        System.out.println("Average Comments Quantity:" + averageCommentsQuantity);
        System.out.println("Average Quantity Comments Per Posts:" + averageQuantityCommentsPerPosts);
    }

}
