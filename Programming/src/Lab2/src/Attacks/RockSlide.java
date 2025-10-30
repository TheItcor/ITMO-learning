package Attacks;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class RockSlide extends PhysicalMove {
    public RockSlide() {
        super(Type.PSYCHIC, 90, 1.0, 0, 3);
    }

    @Override
    public String describe() {
        return "применяет оползень";
    }

}
