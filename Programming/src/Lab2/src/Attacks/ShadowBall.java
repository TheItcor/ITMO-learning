package Attacks;

import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class ShadowBall extends SpecialMove {
    public ShadowBall() {
        super(Type.GHOST, 80, 100, 15, 20);
    }

    @Override
    public String describe() {
        return "применяет теневой шар";
    }

}
