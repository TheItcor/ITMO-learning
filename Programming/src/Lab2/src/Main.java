import Pokemons.*;
import ru.ifmo.se.pokemon.*;

// ID: 75475
public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        b.addAlly(new Skarmory("Бэбэй", 5));
        b.addAlly(new Whicash("Шнюпи", 5));
        b.addAlly(new Barboach("Дюпи", 5));
        b.addFoe(new Togepi("Ануснимус", 5));
        b.addFoe(new Togetic("Бро", 5));
        b.addFoe(new Togekiss("Линус Торвальдс", 5));
        b.go();
    }
}
