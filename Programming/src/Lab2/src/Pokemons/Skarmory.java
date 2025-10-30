package Pokemons;

import Attacks.Confide;
import Attacks.DoubleTeam;
import Attacks.Facade;
import Attacks.Peck;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Skarmory extends Pokemon {
    public Skarmory(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC);
        setStats(200, 90 ,50, 150, 50, 520);
        this.addMove(new Peck());
        this.addMove(new DoubleTeam());
        this.addMove(new Confide());
        this.addMove(new Facade());
    }
}
