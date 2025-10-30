import Attacks.ShadowBall;
import Attacks.Swagger;
import Attacks.SweetKiss;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Togetic extends Pokemon {
    public Togetic(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC);
        setStats(150, 350 ,100, 50, 50, 50);
        this.addMove(new ShadowBall());
        this.addMove(new Swagger());
        this.addMove(new SweetKiss());
    }
}
