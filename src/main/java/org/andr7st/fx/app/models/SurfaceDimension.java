package org.andr7st.fx.app.models;

public class SurfaceDimension {

    int total;

    int widthX;

    int heightY;

    public SurfaceDimension(int widthX, int heightY) {

        if(widthX >= 18 ) { widthX = 18; }

        if (heightY >= 12) { heightY = 12; }

        this.widthX = widthX;

        this.heightY = heightY;
        
        total = widthX * heightY;
    }

    public int getTotal() {
        return total;
    }

    public int getWidthX() {
        return widthX;
    }

    public int getHeightY() {
        return heightY;
    }
}
