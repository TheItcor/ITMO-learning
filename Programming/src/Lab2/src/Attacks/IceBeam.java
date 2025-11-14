package Attacks;


import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class IceBeam extends SpecialMove {
    public IceBeam() {
        super(Type.ICE, 90, 100, 10, 30);
    }

    @Override
    public String describe() {
        return "применяет ледяной шторм";
    }

}

