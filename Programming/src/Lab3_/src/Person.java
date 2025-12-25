import java.util.ArrayList;
import java.util.List;

class Person {
    /*класс для любого человека*/
    String name;
    double money = 0;

    public Person(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }
}


interface Employee {
    /* Работник, не путать с работодателем Employer */

    default void first_work() {};
    default void another_work() {};
}


interface Employer {
    /* Работодатель, не путать с работником Employee */

    List<Person> listEmployees = new ArrayList<>(); // список работников

    void order();

}


interface Scammers {
    boolean escaped = false;

    void run();

    boolean isEscaped();
}


interface ShareOwner {
    void waitDay();

    void dream();

    void leavePrice(Share share);

    void reducePrice(Share share, double price);

    void soldShare(Share share);
}

