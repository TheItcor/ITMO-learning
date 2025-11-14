package Attacks;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class Peck extends PhysicalMove {
    public Peck() {
        super(Type.FLYING, 35, 100, 35, 100);
    }

    @Override
    public String describe() {
        return "применяет клевание";
    }

}
