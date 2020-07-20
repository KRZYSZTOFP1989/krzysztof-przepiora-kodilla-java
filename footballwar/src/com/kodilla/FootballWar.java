package com.kodilla;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class FootballWar extends Application {

    private Text text1 = new Text("Twoja drużyna:");
    private Text text2 = new Text("Drużyna przeciwnika:");
    private Image logomini = new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\bayermini.png");
    private Image logomini2 = new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\werdermini.png");
    private ImageView userTeamMini = new ImageView(logomini);
    private ImageView computerTeamMini = new ImageView(logomini2);
    private Button button1 = new Button("Rozpocznij grę");
    private Image imageback = new Image("file:C:\\Users\\Monika\\Desktop\\resources\\table.png");
    private Image playerLogo = new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\bvb.png");
    private Image cpuLogo = new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\bayern.png");
    private Image emptyLogo = new Image("file:C:\\Users\\Monika\\Desktop\\resources\\logos\\schalke.png");

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

        GameField gameField = createGameField(emptyLogo);
        GameField gameField2 = createGameField(emptyLogo);
        GameField gameField3 = createGameField(emptyLogo);
        GameField gameField4 = createGameField(emptyLogo);
        GameField gameField5 = createGameField(emptyLogo);
        GameField gameField6 = createGameField(emptyLogo);
        GameField gameField7 = createGameField(emptyLogo);
        GameField gameField8 = createGameField(emptyLogo);
        GameField gameField9 = createGameField(emptyLogo);

        gridPane.add(gameField, 0, 0, 1, 1);
        gridPane.add(gameField2, 1, 0, 1, 1);
        gridPane.add(gameField3, 2, 0, 1, 1);
        gridPane.add(gameField4, 0, 1, 1, 1);
        gridPane.add(gameField5, 1, 1, 1, 1);
        gridPane.add(gameField6, 2, 1, 1, 1);
        gridPane.add(gameField7, 0, 2, 1, 1);
        gridPane.add(gameField8, 1, 2, 1, 1);
        gridPane.add(gameField9, 2, 2, 1, 1);

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
                    System.out.println("clicked!");
                }
            }
        });

        return gameField;
    }

    private void checkResult() {

    }

    private void cpuTurn() {

    }

}