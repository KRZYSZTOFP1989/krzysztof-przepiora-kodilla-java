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

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

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
    private Button button5 = new Button("Ranking");
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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
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

        button1.setOnAction(event -> resetField());
        button2.setOnAction(event -> teams.showChooseTeamAlert(this));
        button3.setOnAction(event -> levels.showChooseLevelAlert());
        button4.setOnAction(event -> Paths.get("file:images/logos/output.txt"));
        button5.setOnAction(event -> System.out.println("Test"));

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
        gridPaneMenu.setTranslateX(400);
        gridPaneMenu.setHgap(10);

        gridPaneMenu.add(button1, 1, 0);
        gridPaneMenu.add(button2, 2, 0);
        gridPaneMenu.add(button3, 3, 0);
        gridPaneMenu.add(button4, 4, 0);
        gridPaneMenu.add(button5, 5, 0);

        Path path = Paths.get("file:images/logos/output.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(path))
        {
            writer.write("Zapisuje wynik");
        } catch (IOException e) {
            System.out.println("wystąpił błąd: " + e);
        }

        Path file = Paths.get("file:images/logos/output.txt");

        try (Stream<String> stream = Files.lines(file)) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("wystąpił błąd: " + e);
        }

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = createGameField(emptyLogo);
                gridPane.add(gameBoard[i][j], i, j, 1, 1);
            }
        }

        teams.showChooseTeamAlert(this);
        levels.showChooseLevelAlert();

        Scene scene = new Scene(stackPane, 1300, 867, Color.GREEN);

        primaryStage.setTitle("FootballWar");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private GameField createGameField(Image image) {
        GameField gameField =  new GameField(image);
        gameField.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (gameField.getImage().equals(emptyLogo)) {
                    gameField.setImage(playerLogo);
                }
                checkResult(playerLogo, "GRACZ");
                cpuTurn();
            }
        });
        return gameField;
    }


    private void resetField() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j].setImage(emptyLogo);
                text3.setText(String.valueOf(0));
                text5.setText(String.valueOf(0));
            }
        }
    }

    public void pointsCounter() {

        text3.setText(String.valueOf(playerWin));
        text5.setText(String.valueOf(cpuWin));

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

    private void cpuTurn() {
        int min = 0;
        int max = 2;
        int range = max - min + 1;
        int see = 0;
        while (see == 0) {
            int i = (int)(Math.random() * range) + min;
            int j = (int)(Math.random() * range) + min;
            if (gameBoard[i][j].getImage().equals(emptyLogo)) {
                gameBoard[i][j].setImage(cpuLogo);
                see = 1;
            }
        }
        checkResult(cpuLogo, "CPU");
    }

    private void win(String name, Image image) {

        if(image == playerLogo) {
            showAlert("Wygrywa" + " " + name);
            playerWin++;
        }

        if(image == cpuLogo) {
            showAlert("Wygrywa" + " " + name);
            cpuWin++;
        }
    }

    private void draw() {
        showAlert("Remis");
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
