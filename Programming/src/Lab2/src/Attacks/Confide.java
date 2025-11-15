package Attacks;

import ru.ifmo.se.pokemon.*;

public class Confide extends StatusMove {
    public Confide() {
        super(Type.NORMAL, 0, 20);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.DEFENSE, 10);
    }

    @Override
    protected boolean checkAccuracy(Pokemon att, Pokemon deff) { return true;}


    @Override
    public String describe() {
        return "применяет призыв";
    }

}
