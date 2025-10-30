package Attacks;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class SweetKiss extends PhysicalMove {
    public SweetKiss() {
        super(Type.PSYCHIC, 90, 1.0, 0, 3);
    }

    @Override
    public String describe() {
        return "применяет сладкий поцелуй";
    }

}
