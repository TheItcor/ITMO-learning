package Attacks;

import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class SweetKiss extends StatusMove {
    public SweetKiss() {
        super(Type.FAIRY, 0, 75, 10, 0);
    }

    @Override
    public String describe() {
        return "применяет сладкий поцелуй";
    }

}
