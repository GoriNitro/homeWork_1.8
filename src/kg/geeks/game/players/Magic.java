
package kg.geeks.game.players;

public class Magic extends Hero {
    private int increaseDamage;

    public Magic(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
        this.increaseDamage = increaseDamage;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getAbility() != SuperAbility.REVIVE) {
                hero.setDamage(hero.getDamage() + this.increaseDamage);
            }
        }
    }
}