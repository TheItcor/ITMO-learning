class Pokemon {

    String name;
    int HP, attack, defense, speed;
    String special_attack;
    String special_defense;

    // Покемон по умолчанию
    Pokemon() {
        name = "Default_Name";
        HP = 100;
        attack = 10;
        defense = 10;
        speed = 10;
        special_attack = "Fire";
        special_defense = "Fire";
    }

    // Конструктор для покемонов
    Pokemon(String name, int HP, int attack, int defense, int speed, String special_attack, String special_defense) {
        this.name = name;
        this.HP = HP;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.special_attack = special_defense;
        this.special_defense = special_defense;
    }

    void sayHello() {
        System.out.println("Hello, i am " + this.name);
    };

}


public class Lab2 {

    class PhysicalMove {}

    class SpecialMove {}

    class StatusMove {}

    class Battle {}


    public static void main(String[] args) {
        Pokemon testPokemon = new Pokemon();
        testPokemon.sayHello();

    }
}
