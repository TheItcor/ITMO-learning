package Attacks;

import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class Swagger extends StatusMove {
    public Swagger() {
        super(Type.NORMAL, 0, 85, 15, 100);
    }

    @Override
    public String describe() {
        return "применяет свагу";
    }

}
