package com.kodilla;
import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;

public class Teams {

    private List<Team> teams;

    public Teams() {
        teams = new ArrayList<>();

        Team borussia = new Team("BVB",
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\bvb.png"),
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\bvbmini.png"));
        teams.add(borussia);

        Team bayern = new Team("Bayern",
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\bayern.png"),
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\bayernmini.png"));
        teams.add(bayern);
    }

    public List<Team> getTeams() {
        return teams;
    }

}
