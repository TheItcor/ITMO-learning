import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class Peck extends PhysicalMove {
    public Peck() {
        super(Type.PSYCHIC, 100, 1.0, 0, 3);
    }

    @Override
    public String describe() {
        return "применяет клевание";
    }

}
