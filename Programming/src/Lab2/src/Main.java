import Pokemons.*;
import ru.ifmo.se.pokemon.*;

// ID: 75475
public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        b.addAlly(new Skarmory("Аристотель", 5));
        b.addAlly(new Whiscash("Сократ", 5));
        b.addAlly(new Barboach("Платон", 5));
        b.addFoe(new Togepi("Сенека", 5));
        b.addFoe(new Togetic("Пифагор", 5));
        b.addFoe(new Togekiss("Эпикур", 5));
        b.go();
    }
}
