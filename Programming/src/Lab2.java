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
    }




    static class Messages {
        static class Messages_en {}

        static class Messages_ru {}
    }
}

class Battle{
    static void startBattle(Pokemon firstPokemon, Pokemon secondPokemon){
        while (firstPokemon.HP <= 0 || secondPokemon.HP <= 0) {
            // WIP
        }

        if (firstPokemon.HP > secondPokemon.HP ) {
            System.out.println(firstPokemon.name + "победил!");
        } else {
            System.out.println(secondPokemon.name + "победил!");
        }
    }
}

//  Класс для всех атак
class Move {
    class DamageMove {}

    class PhysicalMove {}

    class SpecialMove {}

    class StatusMove {}
}

// Эффект на покемона
class Effect {}


public class Lab2 {
    public static void main(String[] args) {
        Pokemon testPokemon1 = new Pokemon();
        Pokemon testPokemon2 = new Pokemon();
        testPokemon1.sayHello();

        //Pokemon.Battle.startBattle(testPokemon1, testPokemon2);
    }
}
