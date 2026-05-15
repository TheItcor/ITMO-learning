package Attacks;


import ru.ifmo.se.pokemon.*;

public class IceBeam extends SpecialMove {
    public IceBeam() {
        super(Type.ICE, 90, 100, 10, 0);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() < 0.1)
            Effect.freeze(p);
    }


    @Override
    public String describe() {
        return "применяет ледяной шторм";
    }

}

