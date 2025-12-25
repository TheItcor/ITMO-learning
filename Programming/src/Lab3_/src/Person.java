import java.util.ArrayList;
import java.util.List;

class Person {
    /*Абстрактный класс для любого человека*/
    String name;
    float money;

    public Person(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public float getMoney() {
        return money;
    }
}


interface Employee {
    /* Работник, не путать с работодателем Employer */

    static void first_work() {
        System.out.println("Работаем...");
    }

    static void another_work() {
        System.out.println("Делаем другую работу...");
    }
}


interface Employer {
    /* Работодатель, не путать с работником Employee */

    List<Person> listEmployees = new ArrayList<>(); // список работников

    static void order() {
        System.out.println("Отдал распоряжение продавать акции");
    }

}


interface Scammers {
    boolean escaped = false;

    static void run() {
        System.out.println("Побег!");
    }

    static boolean isEscaped() {
        return escaped;
    }
}


interface ShareOwner {
    static void waitDay() {
        System.out.println("Ждёт следующего дня...");
    }


    static void dream() {
        System.out.println("Мечтает уже лишь о том, чтоб хотя бы вернуть свои деньги.");
    }


    static void leavePrice(Share share) {
        System.out.println(share.getOwner() + " решил не снижать больше цену.");
    }


    static void reducePrice(Share share, float price) {
        /*Умеьшение цены на н фертингов*/
        float newPrice = share.getCost() - price;
        System.out.println(share.getOwner() + "Уменьшает цену до " + newPrice);
    }

    static void soldShare(Share share) {
        /* Владелец акции продаёт акции за н-ную цену */

        System.out.println(share.getOwner() + " Пытается продать " + share.getName() + " за " + share.getCost() + " Фертингов.");
    }
}

