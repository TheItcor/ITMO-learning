package Attacks;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class Facade extends PhysicalMove {
    public Facade() {
        super(Type.NORMAL, 70, 100, 20, 1);
    }

    @Override
    public String describe() {
        return "применяет лицевую атаку";
    }

}
