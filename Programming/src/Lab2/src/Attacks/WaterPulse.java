package Attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class WaterPulse extends SpecialMove {
    public WaterPulse() {
        super(Type.WATER, 60, 100, 20, 0);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() < 0.1)
            Effect.freeze( p);
    }

    @Override
    public String describe() {
        return "применяет водяной импульс";
    }

}
