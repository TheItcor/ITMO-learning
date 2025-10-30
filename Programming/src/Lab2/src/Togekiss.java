import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Togekiss extends Pokemon {
    public Togekiss(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC);
        setStats(50, 150 ,100, 50, 50, 50);
        this.addMove(new PhysicalMove());
    }
}
