package kg.geeks.game.logic;
import kg.geeks.game.players.*;
import java.util.Random;
public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss(1200, 50, "Steve");
        Warrior warrior = new Warrior(300, 10, "Ben");
        Warrior warrior2 = new Warrior(290, 15, "Jim");
        Medic doc = new Medic(260, 5, 15, "John");
        Magic magic = new Magic(280, 20, "lisa");
        Berserk berserk = new Berserk(260, 10, "Mark");
        Medic assistant = new Medic(300, 5, 5, "Karl");
        Witcher witcher = new Witcher(350, 0, "Cj");
        Thor thor = new Thor(320, 30, "Raider");
        Hero[] heroes = {warrior, warrior2, doc, magic, berserk, assistant, witcher, thor};
        printStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0 && hero.getAbility() != boss.getDefence()) {
                hero.attack(boss);
                hero.applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " -------------------");
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
}