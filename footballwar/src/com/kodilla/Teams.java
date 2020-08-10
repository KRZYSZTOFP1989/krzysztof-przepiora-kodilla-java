package com.kodilla;
import com.sun.deploy.cache.BaseLocalApplicationProperties;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.Image;

import java.util.*;

public class Teams {

    private List<Team> teams;

    public Teams() {

        teams = new ArrayList<>();

        Team borussia = new Team("Borussia Dortmund",
                new Image("file:images/logos/bvb.png"),
                new Image("file:images/logos/bvbmini.png"));
        teams.add(borussia);

        Team bayern = new Team("Bayern Monachium",
                new Image("file:images/logos/bayern.png"),
                new Image("file:images/logos/bayernmini.png"));
        teams.add(bayern);

        Team bayer = new Team("Bayer Leverkusen",
                new Image("file:images/logos/bayer.png"),
                new Image("file:images/logos/bayermini.png"));
        teams.add(bayer);

        Team werder = new Team("Werder Brema",
                new Image("file:images/logos/werder.png"),
                new Image("file:images/logos/werdermini.png"));
        teams.add(werder);

        Team schalke = new Team("Schalke 04",
                new Image("file:images/logos/schalke.png"),
                new Image("file:images/logos/schalkemini.png"));
        teams.add(schalke);

        Team stuttgart = new Team("VfB Stuttgart",
                new Image("file:images/logos/stuttgart.png"),
                new Image("file:images/logos/stuttgartmini.png"));
        teams.add(stuttgart);

        Team wolfsburg = new Team("VfL Wolfsburg",
                new Image("file:images/logos/wolfsburg.png"),
                new Image("file:images/logos/wolfsburgmini.png"));
        teams.add(wolfsburg);

        Team hertha = new Team("Hertha Berlin",
                new Image("file:images/logos/hertha.png"),
                new Image("file:images/logos/herthamini.png"));
        teams.add(hertha);

        Team union = new Team("Union Berlin",
                new Image("file:images/logos/union.png"),
                new Image("file:images/logos/unionmini.png"));
        teams.add(union);

        Team hoffenhem = new Team("TSG Hoffenheim",
                new Image("file:images/logos/hoffenheim.png"),
                new Image("file:images/logos/hoffenheimmini.png"));
        teams.add(hoffenhem);

        Team lipsk = new Team("RB Lipsk",
                new Image("file:images/logos/lipsk.png"),
                new Image("file:images/logos/lipskmini.png"));
        teams.add(lipsk);

        Team gladbach = new Team("Borussia M'gladbach",
                new Image("file:images/logos/mgladbach.png"),
                new Image("file:images/logos/mgladbachmini.png"));
        teams.add(gladbach);

        Team mainz = new Team("FSV Mainz",
                new Image("file:images/logos/mainz.png"),
                new Image("file:images/logos/mainzmini.png"));
        teams.add(mainz);

        Team freiburg = new Team("SC Freiburg",
                new Image("file:images/logos/freiburg.png"),
                new Image("file:images/logos/freiburgmini.png"));
        teams.add(freiburg);

        Team eintracht = new Team("Eintracht Frankfurt",
                new Image("file:images/logos/eintracht.png"),
                new Image("file:images/logos/eintrachtmini.png"));
        teams.add(eintracht);

        Team arminia = new Team("Arminia Bielefeld",
                new Image("file:images/logos/arminia.png"),
                new Image("file:images/logos/arminiamini.png"));
        teams.add(arminia);

        Team augsburg = new Team("FC Augsburg",
                new Image("file:images/logos/augburg.png"),
                new Image("file:images/logos/augsburgmini.png"));
        teams.add(augsburg);

        Team koln = new Team("FC Köln",
                new Image("file:images/logos/koln.png"),
                new Image("file:images/logos/kolnmini.png"));
        teams.add(koln);
    }

    public void showChooseTeamAlert(FootballWar footballWar) {
        ChoiceDialog<Team> yourTeam = new ChoiceDialog<>(teams.get(0), teams);
        yourTeam.setTitle("Witaj w grze FootballWar!");
        yourTeam.setHeaderText("Wybierz swoją drużynę");
        yourTeam.setContentText("Dostępne zespoły:");

        Optional<Team> userTeam = yourTeam.showAndWait();
        if (userTeam.isPresent()){
            Team team = userTeam.get();
            //ustawia wybrany mini obrazek w ImageView
            footballWar.getUserTeamMini().setImage(team.getMiniImage());
            footballWar.setPlayerLogo(team.getImage());
            footballWar.setPlayerTeam(team);
            if (userTeam.isPresent())
                teams.remove(userTeam.get());
        }

        ChoiceDialog<Team> computerTeam = new ChoiceDialog<>(teams.get(0), teams);
        computerTeam.setTitle("Witaj w grze FootballWar!");
        computerTeam.setHeaderText("Wybierz drużynę przeciwnika");
        computerTeam.setContentText("Dostępne zespoły:");

        Optional<Team> cpuTeam = computerTeam.showAndWait();
        if (cpuTeam.isPresent()){
            Team team = cpuTeam.get();
            //ustawia wybrany mini obrazek w ImageView
            footballWar.getComputerTeamMini().setImage(team.getMiniImage());
            footballWar.setCpuLogo(team.getImage());
            footballWar.setCpuTeam(team);
            if (cpuTeam.isPresent())
                teams.add(userTeam.get());
        }
    }
}
