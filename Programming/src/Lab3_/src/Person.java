public abstract class Person {
    /* Класс для любого человека */
    protected String name;
    protected double money = 0;

    public Person(String name, double money) {
        this.name = name;
        this.money = money;
    }
}
