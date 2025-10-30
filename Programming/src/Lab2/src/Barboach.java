import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Barboach extends Pokemon {
    public Barboach(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC);
        setStats(50, 50 ,50, 50, 50, 50);
        this.addMove(new WaterPulse());
    }
}

