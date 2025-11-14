package Attacks;


import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class Rest extends StatusMove {
    public Rest() {
        super(Type.PSYCHIC, 0, 0, 5, 100);
    }

    @Override
    public String describe() {
        return "применяет отдых";
    }

}
