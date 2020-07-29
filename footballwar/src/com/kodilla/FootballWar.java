package com.kodilla;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;

public class FootballWar extends Application {

    private Text text1 = new Text("Twoja drużyna:");
    private Text text2 = new Text("Drużyna przeciwnika:");
    private Image logomini = new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\bvbmini.png");
    private Image logomini2 = new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\bayernmini.png");
    private ImageView userTeamMini = new ImageView(logomini);
    private ImageView computerTeamMini = new ImageView(logomini2);
    private Image imageback = new Image("file:C:\\Users\\Monika\\Desktop\\resources\\table.png");
    private Image playerLogo = new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\bvb.png");
    private Image cpuLogo = new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\bayern.png");
    private Image emptyLogo = new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\empty.png");
    private GameField[][] gameBoard = new GameField[3][3];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        text1.setFill(Color.web("#FFF"));
        text1.setFont(new Font("Arial", 24));

        text2.setFill(Color.web("#FFF"));
        text2.setFont(new Font("Arial", 24));

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        StackPane stackPane = new StackPane();
        stackPane.setBackground(background);

        GridPane gridPaneTeam = new GridPane();
        stackPane.getChildren().add(gridPaneTeam);
        gridPaneTeam.setTranslateX(400);
        gridPaneTeam.setHgap(10);

        gridPaneTeam.add(text1, 0, 0);
        gridPaneTeam.add(userTeamMini, 1, 0);
        gridPaneTeam.add(text2, 2, 0);
        gridPaneTeam.add(computerTeamMini, 3, 0);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(120);
        gridPane.setVgap(50);
        gridPane.setPadding(new Insets(0, 0, 0, 100));

        gridPane.setTranslateX(120);
        gridPane.setTranslateY(100);

        stackPane.getChildren().add(gridPane);

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = createGameField(emptyLogo);
                gridPane.add(gameBoard[i][j], i, j, 1, 1);
            }
        }

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
                //Sprawdzenie czy gracz wygral
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
            }
        }
    }

    private void checkResult(Image image, String name) {
        for (int i = 0; i < gameBoard.length; i++) {
            //Poziomo
            if (gameBoard[i][0].getImage().equals(image) && gameBoard[i][1].getImage().equals(image) && gameBoard[i][2].getImage().equals(image)) {
                win(name);
            }

            //Pionowo
            if (gameBoard[0][i].getImage().equals(image) && gameBoard[1][i].getImage().equals(image) && gameBoard[2][i].getImage().equals(image)) {
                win(name);
            }

            //Przekatna \
            if (gameBoard[0][0].getImage().equals(image) && gameBoard[1][1].getImage().equals(image) && gameBoard[2][2].getImage().equals(image)) {
                win(name);
            }

            //Przekatna /
            if (gameBoard[0][2].getImage().equals(image) && gameBoard[1][1].getImage().equals(image) && gameBoard[2][0].getImage().equals(image)) {
                win(name);
            }

        }

        //sprawdz remis
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

        // Sprawdzenie czy komputer wygral
        checkResult(cpuLogo, "CPU");
    }

    private void win(String name) {
        showAlert("Wygrywa" + " " + name);
    }

    private void draw() {
        showAlert("Remis");
    }

    private void showAlert(String headerText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Koniec gry!!!");
        alert.setHeaderText(headerText);
        alert.setResizable(false);
        alert.setContentText("Kliknij OK, aby zagrać jeszcze raz.");

        alert.showAndWait();
        resetField();
    }

}
