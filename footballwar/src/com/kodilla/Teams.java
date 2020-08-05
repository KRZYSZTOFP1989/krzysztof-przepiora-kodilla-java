package com.kodilla;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Teams {

    private List<Team> teams;

    public Teams() {

        teams = new ArrayList<>();

        Team borussia = new Team("Borussia Dortmund",
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\bvb.png"),
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\bvbmini.png"));
        teams.add(borussia);

        Team bayern = new Team("Bayern Monachium",
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\bayern.png"),
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\bayernmini.png"));
        teams.add(bayern);

        Team bayer = new Team("Bayer Leverkusen",
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\bayer.png"),
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\bayermini.png"));
        teams.add(bayer);

        Team werder = new Team("Werder Brema",
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\werder.png"),
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\werdermini.png"));
        teams.add(werder);

        Team schalke = new Team("Schalke 04",
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\schalke.png"),
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\schalkemini.png"));
        teams.add(schalke);

        Team stuttgart = new Team("VfB Stuttgart",
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\stuttgart.png"),
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\stuttgartmini.png"));
        teams.add(stuttgart);

        Team wolfsburg = new Team("VfL Wolfsburg",
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\wolfsburg.png"),
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\wolfsburgmini.png"));
        teams.add(wolfsburg);

        Team hertha = new Team("Hertha Berlin",
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\hertha.png"),
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\herthamini.png"));
        teams.add(hertha);

        Team union = new Team("Union Berlin",
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\union.png"),
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\unionmini.png"));
        teams.add(union);

        Team hoffenhem = new Team("TSG Hoffenheim",
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\hoffenhem.png"),
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\hoffenhemmini.png"));
        teams.add(hoffenhem);

        Team lipsk = new Team("RB Lipsk",
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\lipsk.png"),
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\lipskmini.png"));
        teams.add(lipsk);

        Team gladbach = new Team("Borussia M'gladbach",
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\gladbach.png"),
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\gladbachmini.png"));
        teams.add(gladbach);

        Team mainz = new Team("FSV Mainz",
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\mainz.png"),
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\mainzmini.png"));
        teams.add(mainz);

        Team freiburg = new Team("SC Freiburg",
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\freiburg.png"),
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\freiburgmini.png"));
        teams.add(freiburg);

        Team eintracht = new Team("Eintracht Frankfurt",
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\eintracht.png"),
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\eintrachtmini.png"));
        teams.add(eintracht);

        Team arminia = new Team("Arminia Bielefeld",
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\arminia.png"),
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\arminiamini.png"));
        teams.add(arminia);

        Team augsburg = new Team("FC Augsburg",
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\augsburg.png"),
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\augsburgmini.png"));
        teams.add(augsburg);

        Team koln = new Team("FC Köln",
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\koln.png"),
                new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\kolnmini.png"));
        teams.add(koln);
    }

    public void showChooseTeamAlert() {
        ChoiceDialog<Team> yourTeam = new ChoiceDialog<>(teams.get(0), teams);
        yourTeam.setTitle("Witaj w grze FootballWar!");
        yourTeam.setHeaderText("Wybierz swoją drużynę");
        yourTeam.setContentText("Dostępne zespoły:");

        Optional<Team> userTeam = yourTeam.showAndWait();
        if (userTeam.isPresent()){

        }

        ChoiceDialog<Team> computerTeam = new ChoiceDialog<>(teams.get(0), teams);
        computerTeam.setTitle("Witaj w grze FootballWar!");
        computerTeam.setHeaderText("Wybierz drużynę przeciwnika");
        computerTeam.setContentText("Dostępne zespoły:");

        Optional<Team> cpuTeam = computerTeam.showAndWait();
        if (cpuTeam.isPresent()){

        }
    }

}
