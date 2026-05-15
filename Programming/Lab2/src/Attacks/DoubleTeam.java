package Attacks;

import ru.ifmo.se.pokemon.*;

public class DoubleTeam extends StatusMove {
    public DoubleTeam() {
        super(Type.NORMAL, 0, 15);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.DEFENSE, 6);
        p.setMod(Stat.ATTACK, 6);
        p.setMod(Stat.ACCURACY, 6);
        p.setMod(Stat.EVASION, 1);
    }

    @Override
    public String describe() {
        return "применяет Двойной Призыв";
    }

}
