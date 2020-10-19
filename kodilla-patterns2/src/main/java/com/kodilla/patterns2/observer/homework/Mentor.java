package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {

    private final String username;
    private int updateCount;

    public Mentor (String username) {
        this.username = username;
    }

    public void update(Student student) {
        System.out.println(username + ": New task from student: " + student.getName() + " from group: " + student.getGroup() + "\n" +
                "  (total: " + student.getMessages().size() + " messages from " + student.getName() + ")");
        updateCount++;
    }

    public String getUsername() {
        return username;
    }

    public int getUpdateCount() {
        return updateCount;
    }

}
