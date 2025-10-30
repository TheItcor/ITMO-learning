package Pokemons;

import Attacks.IceBeam;
import Attacks.Rest;
import Attacks.RockSlide;
import Attacks.WaterPulse;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Whicash extends Pokemon {
    public Whicash(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC);
        setStats(50, 150 ,100, 50, 50, 50);
        this.addMove(new Rest());
        this.addMove(new WaterPulse());
        this.addMove(new IceBeam());
        this.addMove(new RockSlide());
    }
}
