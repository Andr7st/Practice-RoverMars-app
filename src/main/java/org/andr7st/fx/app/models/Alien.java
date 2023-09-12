package org.andr7st.fx.app.models;

/**
 * El alien debe conocer el tamaño de la superficie de Marte (Surface)
 * y se le agregan las coordenadas en donde se encuentra.
 * */
public class Alien {

    protected Coordinate coordinate;

    protected SurfaceDimension surfaceDimension;

    public Alien(SurfaceDimension surfaceDimension, Coordinate coordinate) {
        this.surfaceDimension = surfaceDimension;
        this.coordinate = coordinate;
    }

    public Alien() {
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

}