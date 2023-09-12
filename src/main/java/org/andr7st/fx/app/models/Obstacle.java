package org.andr7st.fx.app.models;

import javafx.scene.image.Image;

import java.util.Objects;

public class Obstacle extends Alien {

    Image image;

    public Obstacle(ObstacleVariant obstacleVariant) {
        switch (obstacleVariant) {

            case A -> this.image = new Image(Objects.requireNonNull(this.getClass().getResource("/path/obstacle/Variant1.gif")).toString());
            case B -> this.image = new Image(Objects.requireNonNull(this.getClass().getResource("/path/obstacle/Variant2.png")).toString());
            case C -> this.image = new Image(Objects.requireNonNull(this.getClass().getResource("/path/obstacle/Variant3.png")).toString());
            case D -> this.image = new Image(Objects.requireNonNull(this.getClass().getResource("/path/obstacle/Variant4.png")).toString());
            case E -> this.image = new Image(Objects.requireNonNull(this.getClass().getResource("/path/obstacle/Variant5.gif")).toString());
            case F -> this.image = new Image(Objects.requireNonNull(this.getClass().getResource("/path/obstacle/Variant6.gif")).toString());
            case G -> this.image = new Image(Objects.requireNonNull(this.getClass().getResource("/path/obstacle/Variant7.png")).toString());
        }
    }

    public Image getImage() {
        return image;
    }
}
