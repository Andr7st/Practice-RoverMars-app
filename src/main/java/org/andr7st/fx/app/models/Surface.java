package org.andr7st.fx.app.models;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Objects;


/**
 * Pinta el campo una sola vez por sesión
 * */
public class Surface {

    Pane pane;

    public Surface(Pane pane, SurfaceDimension surfaceDimension, ImageView[][] imageViews) {

        this.pane = pane;

        int sizeX = 36;
        int sizeY = 36;

        GridPane gridPane = new GridPane();

        for (int axisX = 0; axisX < surfaceDimension.getWidthX(); axisX++) {
            for (int axisY = 0; axisY < surfaceDimension.getHeightY(); axisY++) {

                Pane p = new Pane();
                p.setPrefWidth(sizeX);
                p.setPrefHeight(sizeY);
                // Crear un borde visible
                Rectangle border = new Rectangle(sizeX, sizeY);
                border.setStrokeWidth(0.1); // Grosor del borde
                border.setStroke(Color.rgb(255,255,255));
                border.setFill(null);
                ImageView imageView = new ImageView();
                imageViews[axisX][axisY] = imageView;
                imageView.setFitWidth(sizeX);
                imageView.setFitHeight(sizeY);
                p.getChildren().add(border);
                p.getChildren().add(imageView);
                gridPane.add(p, axisX, axisY);
            }
        }

        ImageView fondo = new ImageView();

        fondo.setFitWidth(sizeX * surfaceDimension.getWidthX() );
        fondo.setFitHeight(sizeY * surfaceDimension.getHeightY());

        Image imageBackground = new Image(
                Objects.requireNonNull(this.getClass()
                        .getResource("/path/background.png")).toString());

        fondo.setImage(imageBackground);
        this.pane.getChildren().add(fondo);
        this.pane.getChildren().add(gridPane);
    }

    public Pane getPane() {
        return pane;
    }
}
