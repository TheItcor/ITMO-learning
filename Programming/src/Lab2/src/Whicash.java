import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Whicash extends Pokemon {
    public Whicash(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC);
        setStats(50, 150 ,100, 50, 50, 50);
        this.addMove(new PhysicalMove());
    }
}
