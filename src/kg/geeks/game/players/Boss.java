package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

import java.util.Arrays;

public class Boss extends GameEntity {
    private SuperAbility defence;

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public void chooseDefence() {
        SuperAbility[] abilities = SuperAbility.values();
        int randomIndex = RPG_Game.random.nextInt(abilities.length); // 0,1,2,3
        this.defence = abilities[randomIndex];
    }

    public void attack(Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if (heroes[i] instanceof Berserk &&
                        this.defence != SuperAbility.BLOCK_DAMAGE_AND_REVERT) {
                    ((Berserk) heroes[i]).setBlockedDamage(this.getDamage() / 5);
                    heroes[i].setHealth(heroes[i].getHealth() -
                            (this.getDamage() - ((Berserk) heroes[i]).getBlockedDamage()));
                } else {
                    heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
                }
            }
        }
    }


    private boolean stunned = false;

    public boolean isStunned() {
        return stunned;
    }

    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }


    public SuperAbility getDefence() {
        return defence;
    }

    @Override
    public String toString() {
        return super.toString() + " DEFENCE: " + this.defence;
    }
}