package com.kodilla;

import javafx.scene.image.Image;

import java.io.Serializable;

public class Team implements Serializable {

    private String name;
    private Image image;
    private Image miniImage;

    public Team(Image image, Image miniImage) {
        this.image = image;
        this.miniImage = miniImage;
    }

    public Team(String name, Image image, Image miniImage) {
        this.name = name;
        this.image = image;
        this.miniImage = miniImage;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    public Image getMiniImage() {
        return miniImage;
    }

    @Override
    public String toString() {
        return name;
    }
}
