package Attacks;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade() {
        super(Type.NORMAL, 70, 100);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        if (p.getCondition() != Status.NORMAL) p.setMod(Stat.ATTACK, 70);
    }


    @Override
    public String describe() {
        return "применяет фасад";
    }

}
