package Pokemons;

import Attacks.IceBeam;
import Attacks.Rest;
import Attacks.RockSlide;
import Attacks.WaterPulse;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Whiscash extends Pokemon {
    public Whiscash(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC);
        setStats(110, 78 ,73, 76, 71, 60);
        this.addMove(new Rest());
        this.addMove(new WaterPulse());
        this.addMove(new IceBeam());
        this.addMove(new RockSlide());
    }
}
