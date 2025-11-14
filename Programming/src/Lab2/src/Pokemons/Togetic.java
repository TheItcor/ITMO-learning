package Pokemons;

import Attacks.ShadowBall;
import Attacks.Swagger;
import Attacks.SweetKiss;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Togetic extends Pokemon {
    public Togetic(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC);
        setStats(55, 40 ,85, 80, 105, 40);
        this.addMove(new ShadowBall());
        this.addMove(new Swagger());
        this.addMove(new SweetKiss());
    }
}
