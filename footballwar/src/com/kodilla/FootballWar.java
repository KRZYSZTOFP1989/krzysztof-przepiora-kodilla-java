package com.kodilla;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FootballWar extends Application {

    private Text text1 = new Text("Twoja drużyna:");
    private Text text2 = new Text("Drużyna przeciwnika:");
    private Text text3 = new Text("0");
    private Text text4 = new Text(":");
    private Text text5 = new Text("0");
    private int playerWin = 0;
    private int cpuWin = 0;
    private Button button1 = new Button("Reset");
    private Button button2 = new Button("Zmień zespół");
    private Button button3 = new Button("Zmień poziom");
    private Button button4 = new Button("Zapisz grę");
    private Button button5 = new Button("Wczytaj grę");
    private Button button6 = new Button("Zapisz wynik");
    private Button button7 = new Button("Ranking");
    private Image logomini = new Image("file:images/logos/bvbmini.png");
    private Image logomini2 = new Image("file:images/logos/bayernmini.png");
    private ImageView userTeamMini = new ImageView(logomini);
    private ImageView computerTeamMini = new ImageView(logomini2);
    private Image imageback = new Image("file:images/table.png");
    private Image playerLogo = new Image("file:images/logos/bvb.png");
    private Image cpuLogo = new Image("file:images/logos/bayern.png");
    private Image emptyLogo = new Image("file:images/logos/empty.png");
    private GameField[][] gameBoard = new GameField[3][3];
    private Teams teams = new Teams();
    private Levels levels = new Levels();
    private Team playerTeam = null;
    private Team cpuTeam = null;
    private List<Ranking> rankingRecords;
    private Level actualLevel = null;
    File save = new File("save.game");
    File saveRanking = new File("ranking.list");


    public ImageView getUserTeamMini() {
        return userTeamMini;
    }

    public ImageView getComputerTeamMini() {
        return computerTeamMini;
    }

    public void setPlayerLogo(Image playerLogo) {
        this.playerLogo = playerLogo;
    }

    public void setCpuLogo(Image cpuLogo) {
        this.cpuLogo = cpuLogo;
    }

    public Team getPlayerTeam() {
        return playerTeam;
    }

    public void setPlayerTeam(Team playerTeam) {
        this.playerTeam = playerTeam;
    }

    public Team getCpuTeam() {
        return cpuTeam;
    }

    public void setCpuTeam(Team cpuTeam) {
        this.cpuTeam = cpuTeam;
    }

    public Level getActualLevel() {
        return actualLevel;
    }

    public void setActualLevel(Level actualLevel) {
        this.actualLevel = actualLevel;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        loadRanking();

        text1.setFill(Color.web("#FFF"));
        text1.setFont(new Font("Arial", 24));

        text2.setFill(Color.web("#FFF"));
        text2.setFont(new Font("Arial", 24));

        text3.setFill(Color.web("#FFF"));
        text3.setFont(new Font("Arial", 50));

        text4.setFill(Color.web("#FFF"));
        text4.setFont(new Font("Arial", 50));

        text5.setFill(Color.web("#FFF"));
        text5.setFont(new Font("Arial", 50));

        button1.setOnAction(event -> pointsCounterReset());
        button2.setOnAction(event -> teams.showChooseTeamAlert(this));
        button3.setOnAction(event -> levels.showChooseLevelAlert(this));
        button4.setOnAction(event -> saveGame());
        button5.setOnAction(event -> loadGame());
        button6.setOnAction(event -> saveRanking());
        button7.setOnAction(event -> showRanking());

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        StackPane stackPane = new StackPane();
        stackPane.setBackground(background);

        GridPane gridPaneTeamPlayer = new GridPane();
        stackPane.getChildren().add(gridPaneTeamPlayer);
        gridPaneTeamPlayer.setTranslateX(50);
        gridPaneTeamPlayer.setTranslateY(20);
        gridPaneTeamPlayer.setHgap(10);

        gridPaneTeamPlayer.add(text1, 1, 0);
        gridPaneTeamPlayer.add(userTeamMini, 2, 0);

        GridPane gridPaneScore = new GridPane();
        stackPane.getChildren().add(gridPaneScore);
        gridPaneScore.setTranslateX(600);
        gridPaneScore.setTranslateY(20);
        gridPaneScore.setHgap(10);

        gridPaneScore.add(text3, 1, 0);
        gridPaneScore.add(text4, 2, 0);
        gridPaneScore.add(text5, 3, 0);

        GridPane gridPaneTeamCPU = new GridPane();
        stackPane.getChildren().add(gridPaneTeamCPU);
        gridPaneTeamCPU.setTranslateX(900);
        gridPaneTeamCPU.setTranslateY(20);
        gridPaneTeamCPU.setHgap(10);

        gridPaneTeamCPU.add(text2, 1, 0);
        gridPaneTeamCPU.add(computerTeamMini, 2, 0);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(120);
        gridPane.setVgap(50);
        gridPane.setPadding(new Insets(0, 0, 0, 100));

        gridPane.setTranslateX(120);
        gridPane.setTranslateY(100);

        stackPane.getChildren().add(gridPane);

        GridPane gridPaneMenu = new GridPane();
        stackPane.getChildren().add(gridPaneMenu);
        gridPaneMenu.setTranslateY(830);
        gridPaneMenu.setTranslateX(300);
        gridPaneMenu.setHgap(10);

        gridPaneMenu.add(button1, 1, 0);
        gridPaneMenu.add(button2, 2, 0);
        gridPaneMenu.add(button3, 3, 0);
        gridPaneMenu.add(button4, 4, 0);
        gridPaneMenu.add(button5, 5, 0);
        gridPaneMenu.add(button6, 6, 0);
        gridPaneMenu.add(button7, 7, 0);

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = createGameField(emptyLogo);
                gridPane.add(gameBoard[i][j], i, j, 1, 1);
            }
        }

        teams.showChooseTeamAlert(this);
        levels.showChooseLevelAlert(this);

        Scene scene = new Scene(stackPane, 1300, 867, Color.GREEN);

        primaryStage.setTitle("FootballWar");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void resetField() {
        for (GameField[] gameFields : gameBoard) {
            for (GameField gameField : gameFields) {
                gameField.setImage(emptyLogo);
            }
        }
    }

    private GameField createGameField(Image image) {
        GameField gameField = new GameField(image);
        gameField.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (gameField.getImage().equals(emptyLogo)) {
                    gameField.setImage(playerLogo);
                }
                checkResult(playerLogo, "GRACZ");
                if (actualLevel.getName().equals("Początkujący")) {
                    cpuTurnEasy();
                } else if (actualLevel.getName().equals("Zaawansowany")) {
                    cpuTurnMedium();
                } else if (actualLevel.getName().equals("Trudny")) {
                    cpuTurnHard();
                }
            }
        });
        return gameField;
    }

    private void checkResult(Image image, String name) {

        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i][0].getImage().equals(image) && gameBoard[i][1].getImage().equals(image) && gameBoard[i][2].getImage().equals(image)) {
                win(name, image);
                pointsCounter();
            }

            if (gameBoard[0][i].getImage().equals(image) && gameBoard[1][i].getImage().equals(image) && gameBoard[2][i].getImage().equals(image)) {
                win(name, image);
                pointsCounter();
            }

            if (gameBoard[0][0].getImage().equals(image) && gameBoard[1][1].getImage().equals(image) && gameBoard[2][2].getImage().equals(image)) {
                win(name, image);
                pointsCounter();
            }

            if (gameBoard[0][2].getImage().equals(image) && gameBoard[1][1].getImage().equals(image) && gameBoard[2][0].getImage().equals(image)) {
                win(name, image);
                pointsCounter();
            }

        }

        checkDraw();
    }

    public void pointsCounter() {
        text3.setText(String.valueOf(playerWin));
        text5.setText(String.valueOf(cpuWin));
    }

    public void pointsCounterReset() {
        for (GameField[] gameFields : gameBoard) {
            for (GameField gameField : gameFields) {
                gameField.setImage(emptyLogo);
            }
        }
        text3.setText(String.valueOf(0));
        text5.setText(String.valueOf(0));
        playerWin = 0;
        cpuWin = 0;
    }

    public void checkDraw() {
        boolean shouldDraw = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                if (gameBoard[i][j].getImage().equals(emptyLogo)) {
                    shouldDraw = false;
                }
        }

        if (shouldDraw) {
            draw();
        }
    }

    private void win(String name, Image image) {

        if (image == playerLogo) {
            showAlert("Wygrywa" + " " + name);
            playerWin++;
        }

        if (image == cpuLogo) {
            showAlert("Wygrywa" + " " + name);
            cpuWin++;
        }

    }

    private void cpuTurnEasy() {
        int min = 0;
        int max = 2;
        int range = max - min + 1;
        int see = 0;
        while (see == 0) {
            int i = (int) (Math.random() * range) + min;
            int j = (int) (Math.random() * range) + min;
            if (gameBoard[i][j].getImage().equals(emptyLogo)) {
                gameBoard[i][j].setImage(cpuLogo);
                see = 1;
            }
        }
        checkResult(cpuLogo, "CPU");
    }

    private void cpuTurnMedium() {
        if (gameBoard[0][0].getImage().equals(cpuLogo) && gameBoard[0][1].getImage().equals(cpuLogo)
                && gameBoard[0][2].getImage().equals(emptyLogo)) {
            gameBoard[0][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[0][2].getImage().equals(cpuLogo) && gameBoard[0][1].getImage().equals(cpuLogo)
                && gameBoard[0][0].getImage().equals(emptyLogo)) {
            gameBoard[0][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[1][0].getImage().equals(cpuLogo) && gameBoard[1][1].getImage().equals(cpuLogo)
                && gameBoard[1][2].getImage().equals(emptyLogo)) {
            gameBoard[1][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[1][2].getImage().equals(cpuLogo) && gameBoard[1][1].getImage().equals(cpuLogo)
                && gameBoard[1][0].getImage().equals(emptyLogo)) {
            gameBoard[1][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[2][0].getImage().equals(cpuLogo) && gameBoard[2][1].getImage().equals(cpuLogo)
                && gameBoard[2][2].getImage().equals(emptyLogo)) {
            gameBoard[2][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[2][2].getImage().equals(cpuLogo) && gameBoard[2][1].getImage().equals(cpuLogo)
                && gameBoard[2][0].getImage().equals(emptyLogo)) {
            gameBoard[2][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[2][0].getImage().equals(cpuLogo) && gameBoard[1][1].getImage().equals(cpuLogo)
                && gameBoard[0][2].getImage().equals(emptyLogo)) {
            gameBoard[0][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[0][0].getImage().equals(cpuLogo) && gameBoard[1][1].getImage().equals(cpuLogo)
                && gameBoard[2][2].getImage().equals(emptyLogo)) {
            gameBoard[2][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[2][2].getImage().equals(cpuLogo) && gameBoard[1][1].getImage().equals(cpuLogo)
                && gameBoard[0][0].getImage().equals(emptyLogo)) {
            gameBoard[0][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        }  else if (gameBoard[0][0].getImage().equals(cpuLogo) && gameBoard[1][0].getImage().equals(cpuLogo)
                && gameBoard[2][0].getImage().equals(emptyLogo)) {
            gameBoard[2][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        }  else if (gameBoard[2][0].getImage().equals(cpuLogo) && gameBoard[1][0].getImage().equals(cpuLogo)
                && gameBoard[0][0].getImage().equals(emptyLogo)) {
            gameBoard[0][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        }  else if (gameBoard[0][1].getImage().equals(cpuLogo) && gameBoard[1][1].getImage().equals(cpuLogo)
                && gameBoard[2][1].getImage().equals(emptyLogo)) {
            gameBoard[2][1].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        }  else if (gameBoard[2][1].getImage().equals(cpuLogo) && gameBoard[1][1].getImage().equals(cpuLogo)
                && gameBoard[0][1].getImage().equals(emptyLogo)) {
            gameBoard[0][1].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        }  else if (gameBoard[0][2].getImage().equals(cpuLogo) && gameBoard[1][2].getImage().equals(cpuLogo)
                && gameBoard[2][2].getImage().equals(emptyLogo)) {
            gameBoard[0][1].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        }  else if (gameBoard[2][2].getImage().equals(cpuLogo) && gameBoard[1][2].getImage().equals(cpuLogo)
                && gameBoard[0][2].getImage().equals(emptyLogo)) {
            gameBoard[0][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[2][2].getImage().equals(cpuLogo) && gameBoard[1][1].getImage().equals(cpuLogo)
                && gameBoard[0][0].getImage().equals(emptyLogo)) {
            gameBoard[0][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[0][0].getImage().equals(cpuLogo) && gameBoard[1][1].getImage().equals(cpuLogo)
                && gameBoard[2][2].getImage().equals(emptyLogo)) {
            gameBoard[2][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else {
            cpuTurnEasy();
        }
    }

    private void cpuTurnHard() {
        if (gameBoard[0][0].getImage().equals(cpuLogo) && gameBoard[0][1].getImage().equals(cpuLogo)
                && gameBoard[0][2].getImage().equals(emptyLogo)) {
            gameBoard[0][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[0][2].getImage().equals(cpuLogo) && gameBoard[0][1].getImage().equals(cpuLogo)
                && gameBoard[0][0].getImage().equals(emptyLogo)) {
            gameBoard[0][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[1][0].getImage().equals(cpuLogo) && gameBoard[1][1].getImage().equals(cpuLogo)
                && gameBoard[1][2].getImage().equals(emptyLogo)) {
            gameBoard[1][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[1][2].getImage().equals(cpuLogo) && gameBoard[1][1].getImage().equals(cpuLogo)
                && gameBoard[1][0].getImage().equals(emptyLogo)) {
            gameBoard[1][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[2][0].getImage().equals(cpuLogo) && gameBoard[2][1].getImage().equals(cpuLogo)
                && gameBoard[2][2].getImage().equals(emptyLogo)) {
            gameBoard[2][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[2][2].getImage().equals(cpuLogo) && gameBoard[2][1].getImage().equals(cpuLogo)
                && gameBoard[2][0].getImage().equals(emptyLogo)) {
            gameBoard[2][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[2][0].getImage().equals(cpuLogo) && gameBoard[1][1].getImage().equals(cpuLogo)
                && gameBoard[0][2].getImage().equals(emptyLogo)) {
            gameBoard[0][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[0][0].getImage().equals(cpuLogo) && gameBoard[1][1].getImage().equals(cpuLogo)
                && gameBoard[2][2].getImage().equals(emptyLogo)) {
            gameBoard[2][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[2][2].getImage().equals(cpuLogo) && gameBoard[1][1].getImage().equals(cpuLogo)
                && gameBoard[0][0].getImage().equals(emptyLogo)) {
            gameBoard[0][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        }  else if (gameBoard[0][0].getImage().equals(cpuLogo) && gameBoard[1][0].getImage().equals(cpuLogo)
                && gameBoard[2][0].getImage().equals(emptyLogo)) {
            gameBoard[2][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        }  else if (gameBoard[2][0].getImage().equals(cpuLogo) && gameBoard[1][0].getImage().equals(cpuLogo)
                && gameBoard[0][0].getImage().equals(emptyLogo)) {
            gameBoard[0][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        }  else if (gameBoard[0][1].getImage().equals(cpuLogo) && gameBoard[1][1].getImage().equals(cpuLogo)
                && gameBoard[2][1].getImage().equals(emptyLogo)) {
            gameBoard[2][1].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        }  else if (gameBoard[2][1].getImage().equals(cpuLogo) && gameBoard[1][1].getImage().equals(cpuLogo)
                && gameBoard[0][1].getImage().equals(emptyLogo)) {
            gameBoard[0][1].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        }  else if (gameBoard[0][2].getImage().equals(cpuLogo) && gameBoard[1][2].getImage().equals(cpuLogo)
                && gameBoard[2][2].getImage().equals(emptyLogo)) {
            gameBoard[0][1].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        }  else if (gameBoard[2][2].getImage().equals(cpuLogo) && gameBoard[1][2].getImage().equals(cpuLogo)
                && gameBoard[0][2].getImage().equals(emptyLogo)) {
            gameBoard[0][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[2][2].getImage().equals(cpuLogo) && gameBoard[1][1].getImage().equals(cpuLogo)
                && gameBoard[0][0].getImage().equals(emptyLogo)) {
            gameBoard[0][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[0][0].getImage().equals(cpuLogo) && gameBoard[1][1].getImage().equals(cpuLogo)
                && gameBoard[2][2].getImage().equals(emptyLogo)) {
            gameBoard[2][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[0][0].getImage().equals(playerLogo) && gameBoard[1][1].getImage().equals(playerLogo)
                && gameBoard[2][2].getImage().equals(emptyLogo)) {
            gameBoard[2][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[0][2].getImage().equals(playerLogo) && gameBoard[1][1].getImage().equals(playerLogo)
                && gameBoard[2][0].getImage().equals(emptyLogo)) {
            gameBoard[2][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[0][0].getImage().equals(playerLogo) && gameBoard[2][2].getImage().equals(playerLogo)
                && gameBoard[1][1].getImage().equals(emptyLogo)) {
            gameBoard[1][1].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[0][2].getImage().equals(playerLogo) && gameBoard[2][0].getImage().equals(playerLogo)
                && gameBoard[1][1].getImage().equals(emptyLogo)) {
            gameBoard[1][1].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[2][0].getImage().equals(playerLogo) && gameBoard[1][1].getImage().equals(playerLogo)
                && gameBoard[0][2].getImage().equals(emptyLogo)) {
            gameBoard[0][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[2][2].getImage().equals(playerLogo) && gameBoard[1][1].getImage().equals(playerLogo)
                && gameBoard[0][0].getImage().equals(emptyLogo)) {
            gameBoard[0][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[0][0].getImage().equals(playerLogo) && gameBoard[1][1].getImage().equals(playerLogo)
                && gameBoard[2][2].getImage().equals(emptyLogo)) {
            gameBoard[2][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[0][0].getImage().equals(playerLogo) && gameBoard[1][0].getImage().equals(playerLogo)
                && gameBoard[2][0].getImage().equals(emptyLogo)) {
            gameBoard[2][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[1][0].getImage().equals(playerLogo) && gameBoard[0][0].getImage().equals(playerLogo)
                && gameBoard[2][0].getImage().equals(emptyLogo)) {
            gameBoard[2][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[0][0].getImage().equals(playerLogo) && gameBoard[2][0].getImage().equals(playerLogo)
                && gameBoard[1][0].getImage().equals(emptyLogo)) {
            gameBoard[1][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[1][0].getImage().equals(playerLogo) && gameBoard[2][0].getImage().equals(playerLogo)
                && gameBoard[0][0].getImage().equals(emptyLogo)) {
            gameBoard[0][0].setImage(cpuLogo);
        } else if (gameBoard[0][1].getImage().equals(playerLogo) && gameBoard[1][1].getImage().equals(playerLogo)
                && gameBoard[2][1].getImage().equals(emptyLogo)) {
            gameBoard[2][1].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[0][1].getImage().equals(playerLogo) && gameBoard[2][1].getImage().equals(playerLogo)
                && gameBoard[1][1].getImage().equals(emptyLogo)) {
            gameBoard[1][1].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[1][1].getImage().equals(playerLogo) && gameBoard[2][1].getImage().equals(playerLogo)
                && gameBoard[0][1].getImage().equals(emptyLogo)) {
            gameBoard[0][1].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[0][2].getImage().equals(playerLogo) && gameBoard[1][2].getImage().equals(playerLogo)
                && gameBoard[2][2].getImage().equals(emptyLogo)) {
            gameBoard[2][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[0][2].getImage().equals(playerLogo) && gameBoard[2][2].getImage().equals(playerLogo)
                && gameBoard[1][2].getImage().equals(emptyLogo)) {
            gameBoard[1][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[1][2].getImage().equals(playerLogo) && gameBoard[2][2].getImage().equals(playerLogo)
                && gameBoard[0][2].getImage().equals(emptyLogo)) {
            gameBoard[0][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[0][0].getImage().equals(playerLogo) && gameBoard[0][1].getImage().equals(playerLogo)
                && gameBoard[0][2].getImage().equals(emptyLogo)) {
            gameBoard[0][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[0][0].getImage().equals(playerLogo) && gameBoard[0][2].getImage().equals(playerLogo)
                && gameBoard[0][1].getImage().equals(emptyLogo)) {
            gameBoard[0][1].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[0][1].getImage().equals(playerLogo) && gameBoard[0][2].getImage().equals(playerLogo)
                && gameBoard[0][0].getImage().equals(emptyLogo)) {
            gameBoard[0][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[1][0].getImage().equals(playerLogo) && gameBoard[1][1].getImage().equals(playerLogo)
                && gameBoard[1][2].getImage().equals(emptyLogo)) {
            gameBoard[1][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[1][0].getImage().equals(playerLogo) && gameBoard[1][2].getImage().equals(playerLogo)
                && gameBoard[1][1].getImage().equals(emptyLogo)) {
            gameBoard[1][1].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[1][1].getImage().equals(playerLogo) && gameBoard[1][2].getImage().equals(playerLogo)
                && gameBoard[1][0].getImage().equals(emptyLogo)) {
            gameBoard[1][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[1][2].getImage().equals(playerLogo) && gameBoard[1][1].getImage().equals(playerLogo)
                && gameBoard[1][0].getImage().equals(emptyLogo)) {
            gameBoard[1][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[2][0].getImage().equals(playerLogo) && gameBoard[2][1].getImage().equals(playerLogo)
                && gameBoard[2][2].getImage().equals(emptyLogo)) {
            gameBoard[2][2].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[2][0].getImage().equals(playerLogo) && gameBoard[2][2].getImage().equals(playerLogo)
                && gameBoard[2][1].getImage().equals(emptyLogo)) {
            gameBoard[2][1].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else if (gameBoard[2][1].getImage().equals(playerLogo) && gameBoard[2][2].getImage().equals(playerLogo)
                && gameBoard[2][0].getImage().equals(emptyLogo)) {
            gameBoard[2][0].setImage(cpuLogo);
            checkResult(cpuLogo, "CPU");
        } else {
            cpuTurnMedium();
        }
    }

    private void draw() {
        showAlert("Remis");
    }

    public void saveGame() {
        try {
            int[][] board = new int[3][3];

            for (int i = 0; i < gameBoard.length; i++) {
                for (int j = 0; j < gameBoard[i].length; j++) {
                    if (gameBoard[i][j].getImage().equals(playerLogo)) {
                        board[i][j] = 1;
                    } else if (gameBoard[i][j].getImage().equals(cpuLogo)){
                        board[i][j] = 2;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
            GameState gameState = new GameState(playerWin, cpuWin, playerTeam.getName(),
                    cpuTeam.getName(), board);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(save));
            oos.writeObject(gameState);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadGame() {

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(save));
            Object loadObject = ois.readObject();
            if (loadObject instanceof GameState) {
                GameState gameState = (GameState) loadObject;
                loadGameState(gameState);
            }
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadGameState(GameState gameState) {
        playerWin = gameState.getPlayerWin();
        cpuWin = gameState.getCpuWin();
        pointsCounter();

        Team playerT = teams.getTeamByName(gameState.getPlayerTeam());

        playerTeam = playerT;
        userTeamMini.setImage(playerT.getMiniImage());
        playerLogo = playerT.getImage();

        Team playerC = teams.getTeamByName(gameState.getCpuTeam());

        cpuTeam = playerC;
        computerTeamMini.setImage(playerC.getMiniImage());
        cpuLogo = playerC.getImage();

        int[][] board = gameState.getGameBoard();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    gameBoard[i][j].setImage(emptyLogo);
                } else if (board[i][j] == 1) {
                    gameBoard[i][j].setImage(playerLogo);
                }  else if (board[i][j] == 2) {
                    gameBoard[i][j].setImage(cpuLogo);
                }
            }
        }
    }

    public void saveRanking() {

        try {
            Ranking ranking = new Ranking(playerTeam.getName(), playerWin,
                    cpuTeam.getName(), cpuWin);
            rankingRecords.add(ranking);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveRanking));
            oos.writeObject(rankingRecords);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadRanking() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveRanking));
            Object readList = ois.readObject();
            if (readList instanceof List) {
                rankingRecords = (List) readList;
            } else {
                rankingRecords = new ArrayList<>();
            }
            ois.close();
        } catch (Exception e) {
            rankingRecords = new ArrayList<>();
            e.printStackTrace();
        }
    }

    public void showRanking() {
        System.out.println(rankingRecords);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Historia spotkań:");
        alert.setHeaderText("Wyniki rozegranych spotkań:");
        alert.getDialogPane().setMinWidth(600);

        String results = "";

        for (Ranking ranking : rankingRecords) {
            String recordString = "Gracz " + ranking.getPlayerTeam() + " " + ranking.getPlayerWin() + " : "
                    + ranking.getCpuWin() + " Komputer " + ranking.getCpuTeam();
            results += recordString + "\n";
        }

        alert.setContentText(results);
        alert.showAndWait();
    }

    private void showAlert(String headerText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Koniec gry!!!");
        alert.setHeaderText(headerText);
        alert.setResizable(false);
        alert.setContentText("Kliknij OK, aby zagrać jeszcze raz");

        alert.showAndWait();
        resetField();
    }

}
