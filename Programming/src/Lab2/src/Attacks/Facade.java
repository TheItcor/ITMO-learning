package Attacks;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class Facade extends PhysicalMove {
    public Facade() {
        super(Type.PSYCHIC, 100, 1.0, 0, 3);
    }

    @Override
    public String describe() {
        return "применяет клевание";
    }

}
