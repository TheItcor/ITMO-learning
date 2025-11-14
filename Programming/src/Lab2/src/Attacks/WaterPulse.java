package Attacks;

import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class WaterPulse extends SpecialMove {
    public WaterPulse() {
        super(Type.WATER, 60, 100, 20, 20);
    }

    @Override
    public String describe() {
        return "применяет водяной импульс";
    }

}
