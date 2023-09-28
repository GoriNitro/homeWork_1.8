package kg.geeks.game.players;

public class Witcher extends Hero {
    public Witcher(int health, int damage, String name) {
        super(health, damage, SuperAbility.REVIVE, name);

    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if(hero.getHealth() <= 0 && this != hero){
                hero.setHealth(hero.getHealth() + this.getHealth());
                this.setHealth(0);            }
        }
    }
}