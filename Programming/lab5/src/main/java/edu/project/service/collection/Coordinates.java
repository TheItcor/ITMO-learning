package edu.project.service.collection;

public class Coordinates {

    private Integer x = 0;      //Поле не может быть null
    private Float y = 0.0F;     //Значение поля должно быть больше -215, Поле не может быть null

    public Coordinates(Integer x, Float y) {
        if (y <= -215) throw new IllegalArgumentException("[ERR]: y > -215");

        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "x: " + x + " y: " + y;
    }
}
