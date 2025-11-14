package Attacks;

import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class DoubleTeam extends StatusMove {
    public DoubleTeam() {
        super(Type.NORMAL, 0, 0, 15, 1);
    }

    @Override
    public String describe() {
        return "применяет славянский зажим";
    }

}
