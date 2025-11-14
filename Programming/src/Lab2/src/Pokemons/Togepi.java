package Pokemons;

import Attacks.ShadowBall;
import Attacks.Swagger;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Togepi extends Pokemon {
    public Togepi(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC);
        setStats(35, 20 ,65, 40, 65, 20);
        this.addMove(new ShadowBall());
        this.addMove(new Swagger());
    }
}
