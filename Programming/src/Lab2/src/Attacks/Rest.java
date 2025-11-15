package Attacks;


import ru.ifmo.se.pokemon.*;


public class Rest extends StatusMove {
    public Rest() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.addEffect((new Effect()).condition(Status.SLEEP).turns(2));
        p.setMod(Stat.HP, (int)(p.getHP() - p.getStat(Stat.HP)));
    }

    @Override
    protected boolean checkAccuracy(Pokemon att, Pokemon deff) { return true;}


    @Override
    public String describe() {
        return "применяет отдых";
    }

}
