import ru.ifmo.se.pokemon.*;

// ID: 75475
public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        b.addAlly(new Skarmory("Бэбэй", 5));
        b.addFoe(new Barboach("Бубсич", 5));
        b.go();
    }
}
