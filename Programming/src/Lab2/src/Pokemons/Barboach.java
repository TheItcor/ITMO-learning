package Pokemons;

import Attacks.IceBeam;
import Attacks.Rest;
import Attacks.WaterPulse;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Barboach extends Pokemon {
    public Barboach(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC);
        setStats(300, 90 ,120, 50, 100, 50);
        this.addMove(new WaterPulse());
        this.addMove(new Rest());
        this.addMove(new IceBeam());
    }
}

