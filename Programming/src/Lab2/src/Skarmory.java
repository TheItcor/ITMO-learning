import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Skarmory extends Pokemon {
    public Skarmory(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC);
        setStats(50, 50 ,50, 50, 50, 50);
        this.addMove(new Peck());
    }
}
