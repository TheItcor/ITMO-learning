package Characters;

public abstract class Person {
    /* Класс для любого человека */
    protected final String name;
    protected double money;

    public Person(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public abstract void dream();
}
