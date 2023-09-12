package org.andr7st.fx.app.models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Rover extends Alien {

    public Direction direction;

    public Image image;

    private final ImageView[][] imageViews;

    private static boolean isHinderedFront = false;
    private static boolean isHinderedBack = false;

    public static boolean isIsHinderedFront() {
        return isHinderedFront;
    }

    public Rover(SurfaceDimension surfaceDimension, Coordinate coordinate, Direction direction, ImageView[][] imageViews ) {
        super(surfaceDimension, coordinate);
       // this.direction = direction;
        this.imageViews = imageViews;
        setDirection(direction);

        checkObstacles();
    }


    // Evaluar obstaculos
    private void checkObstacles() {


        isHinderedFront = false;
        isHinderedBack = false;

        int rX = this.getCoordinate().getX();
        int rY = this.getCoordinate().getY();
        //
        int dX = this.surfaceDimension.getWidthX();
        int dY = this.surfaceDimension.getHeightY();

        int posXUpdate;
        int posYUpdate;


        switch (direction) {
            case NORTH -> {

                if (rY == 0) { posYUpdate = dY - 1;
                } else { posYUpdate = rY - 1; }
                Image frontImage = imageViews[rX][posYUpdate].getImage();
                if (frontImage != null) { isHinderedFront = true; }


                if( rY == (dY - 1) ) { posYUpdate = 0;
                } else { posYUpdate = rY + 1; }
                Image backImage = imageViews[rX][posYUpdate].getImage();
                if (backImage != null) { isHinderedBack = true; }

            }

            case SOUTH -> {

                if( rY == (dY - 1) ) { posYUpdate = 0;
                } else { posYUpdate = rY + 1; }
                Image frontImage = imageViews[rX][posYUpdate].getImage();
                if (frontImage != null) { isHinderedFront = true; }

                if (rY == 0) { posYUpdate = dY - 1;
                } else { posYUpdate = rY - 1; }
                Image backImage = imageViews[rX][posYUpdate].getImage();
                if (backImage != null) { isHinderedBack = true; }

            }

            case EAST -> {

                if( rX == (dX - 1) ) { posXUpdate = 0;
                } else {posXUpdate = rX + 1; }
                Image frontImage = imageViews[posXUpdate][rY].getImage();
                if (frontImage != null) { isHinderedFront = true; }

                if (rX == 0) { posXUpdate = dX - 1;
                } else {posXUpdate = rX - 1;}
                Image backImage = imageViews[posXUpdate][rY].getImage();
                if (backImage != null) { isHinderedBack = true; }
            }

            case WEST -> {
                if (rX == 0) { posXUpdate = dX - 1;
                } else {posXUpdate = rX - 1;}
                Image frontImage = imageViews[posXUpdate][rY].getImage();
                if (frontImage != null) { isHinderedFront = true; }

                if( rX == (dX - 1) ) { posXUpdate = 0;
                } else {posXUpdate = rX + 1; }
                Image backImage = imageViews[posXUpdate][rY].getImage();
                if (backImage != null) { isHinderedBack = true; }
            }
        }
    }

    public void setDirection(Direction direction) {
        switch (direction) {

            case NORTH -> this.image = new Image(Objects.requireNonNull(this.getClass().getResource("/org/andr7st/fx/app/assets/rover/NORTH.png")).toString()) ;
            case SOUTH -> this.image = new Image(Objects.requireNonNull(this.getClass().getResource("/org/andr7st/fx/app/assets/rover/SOUTH.png")).toString()) ;
            case WEST ->  this.image = new Image(Objects.requireNonNull(this.getClass().getResource("/org/andr7st/fx/app/assets/rover/WEST.png")).toString()) ;
            case EAST ->  this.image = new Image(Objects.requireNonNull(this.getClass().getResource("/org/andr7st/fx/app/assets/rover/EAST.png")).toString()) ;

        }

        this.direction = direction;
    }

    public Image getImage() {
        return image;
    }

    public Direction getDirection() {
        return direction;
    }

    /**
     * Girar a la derecha o izquierda
     * */
    public void girar(boolean sentido) {

        // cada vez que gira desabilitar obstaculo
        isHinderedFront = false;
        isHinderedBack = false;

        // chequear de nuevo si hay obstaculo
        checkObstacles();


        if(getDirection().equals(Direction.NORTH)) {
            if (sentido) {
                this.setDirection(Direction.EAST);
            } else {
                this.setDirection(Direction.WEST);
            }
        } else if(this.getDirection().equals(Direction.EAST)) {
            if (sentido) {
                this.setDirection(Direction.SOUTH);
            } else {
                this.setDirection(Direction.NORTH);
            }
        } else if(this.getDirection().equals(Direction.SOUTH)) {
            if (sentido) {
                this.setDirection(Direction.WEST);
            } else {
                this.setDirection(Direction.EAST);
            }
        } else { // if:: rover.getDirection().equals(Direction.WEST)
            if (sentido) {
                this.setDirection(Direction.NORTH);
            } else {
                this.setDirection(Direction.SOUTH);
            }
        }
    }


    public void irAdelante() {
        checkObstacles();

        switch (direction) {
            case NORTH -> goToNorth();
            case SOUTH -> goToSouth();
            case WEST ->  goToWest();
            case EAST ->  goToEast();
        }
    }

    public void irAtras() {

        switch (direction) {
            case NORTH -> goToSouth();
            case SOUTH -> goToNorth();
            case WEST ->  goToEast();
            case EAST ->  goToWest();
        }
    }

    void goToNorth() {
        if(!isHinderedFront) {
            int rY = this.getCoordinate().getY();
            int dY = this.surfaceDimension.getHeightY();
            int posYUpdate;
            if (rY == 0) {
                posYUpdate = dY - 1;
            } else {
                posYUpdate = rY - 1;
            }
            this.setCoordinate(new Coordinate(this.getCoordinate().getX(), posYUpdate ));
        }
    }

    void goToSouth() {
        if(!isHinderedFront) {
            int rY = this.getCoordinate().getY();
            int dY = this.surfaceDimension.getHeightY();
            int posYUpdate;
            if ( rY < (dY -1) ) {
                posYUpdate = rY+1;
            } else {
                posYUpdate = 0;
            }
            this.setCoordinate(new Coordinate(this.getCoordinate().getX(), posYUpdate ));
        }
    }

    void goToWest() {
        if(!isHinderedFront) {
            int rX = this.getCoordinate().getX();
            int rY = this.getCoordinate().getY();
            //
            int dX = this.surfaceDimension.getWidthX();
            int posXUpdate;
            if (rX == 0) {
                posXUpdate = dX - 1;
            } else {
                posXUpdate = rX - 1;
            }
            this.setCoordinate(new Coordinate(posXUpdate, rY ));
        }
    }

    void goToEast() {
        if(!isHinderedFront) {
            int rX = this.getCoordinate().getX();
            int rY = this.getCoordinate().getY();
            //
            int dX = this.surfaceDimension.getWidthX();
            /// Ir al este East
            int posXUpdate;
            if ( rX < (dX -1) ) {
                posXUpdate = rX+1;
            } else {
                posXUpdate = 0;
            }
            this.setCoordinate(new Coordinate(posXUpdate, rY ));

        }

    }
}



