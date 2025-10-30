import Attacks.ShadowBall;
import Attacks.Swagger;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Togepi extends Pokemon {
    public Togepi(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC);
        setStats(250, 100 ,100, 150, 50, 50);
        this.addMove(new ShadowBall());
        this.addMove(new Swagger());
    }
}
