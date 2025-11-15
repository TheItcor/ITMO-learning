package Attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class SweetKiss extends StatusMove {
    public SweetKiss() {
        super(Type.FAIRY, 0, 75, 10, 0);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() < 0.4)
            Effect.confuse(p);
    }



    @Override
    public String describe() {
        return "применяет сладкий поцелуй";
    }

}
