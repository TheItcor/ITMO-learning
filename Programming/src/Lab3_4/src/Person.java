public abstract class Person {
    /* Класс для любого человека */
    protected final String name;
    protected double money = 0;

    public Person(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public abstract void dream();
}
