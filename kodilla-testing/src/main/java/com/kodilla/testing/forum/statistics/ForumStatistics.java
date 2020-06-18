package com.kodilla.testing.forum.statistics;

public class ForumStatistics {

    private int usersQuantity;
    private int postsQuantity;
    private int commentsQuantity;
    private double averagePostsQuantity;
    private double averageCommentsQuantity;
    private double averageQuantity;

    public ForumStatistics(int usersQuantity, int postsQuantity, int commentsQuantity, double averagePostsQuantity, double averageCommentsQuantity, double averageQuantity) {
        this.usersQuantity = usersQuantity;
        this.postsQuantity = postsQuantity;
        this.commentsQuantity = commentsQuantity;
        this.averagePostsQuantity = averagePostsQuantity;
        this.averageCommentsQuantity = averageCommentsQuantity;
        this.averageQuantity = averageQuantity;
    }

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

    public double getAverageQuantity() {
        return averageQuantity;
    }

    public int calculateAdvStatistics (Statistics statistics) {


    }

    public int showStatistics() {

    }

}
