package droids;

import save.SaveUtil;

import java.util.List;
import java.util.Random;

public abstract class Droid {
    protected String name;
    protected double health;
    protected double damage;
    protected double evasion;
    protected int evadChance;

    public abstract void uniqueAbility(List<Droid> teammates, List<Droid> enemies);
    protected Random random = new Random();

    public String getName() {
        return name;
    }
    public double getHealth() {
        return health;
    }
    public double getDamage() {
        return damage;
    }
    public double getEvasion() {
        return evasion;
    }

    public void attack(List<Droid> enemies) {
        Droid enemy = enemies.get(random.nextInt(enemies.size()));
        if (random.nextInt(100) <= enemy.evadChance) {
            double actualDamage = this.damage - (this.damage * (enemy.evasion / 100));
            enemy.health -= actualDamage;
            SaveUtil.printBattle("\nДроїд " + this.name + " має нанести " + this.damage + " шкоди дроїду " + enemy.name);
            SaveUtil.printBattle("Дроїд " + enemy.name + " на " + enemy.evasion + "% блокує шкоду");
            SaveUtil.printBattle("Дроїд " + this.name + " наносить " + actualDamage + " шкоди дроїду " + enemy.name + "\n");
        } else {
            enemy.health -= this.damage;
            SaveUtil.printBattle("\nДроїд " + this.name + " наносить " + this.damage + " шкоди дроїду " + enemy.name + "\n");
        }
        if(enemy.health <= 0) {
            enemies.remove(enemy);
            SaveUtil.printBattle("Дроїд " + enemy.name + " загинув\n");
        }
    }

    @Override
    public String toString() {
        return "Droid{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", random=" + random +
                '}';
    }
}