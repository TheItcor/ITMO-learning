package Attacks;

import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove {
    public Swagger() {
        super(Type.NORMAL, 0, 85, 15, 1);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (p.getCondition() != Status.PARALYZE) {
            Effect.confuse(p);
        } else {
            if (Math.random() < 0.5) Effect.flinch(p);
            else Effect.poison(p);
        }
    }


    @Override
    public String describe() {
        return "применяет сваггер";
    }

}
