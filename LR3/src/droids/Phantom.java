package droids;

import save.SaveUtil;

import java.util.List;

public class Phantom extends Droid{
    private final int normAtkChance = 85;

    public Phantom(String name) {
        super.name = name;
        super.health = 100;
        super.damage = 15;
        super.evasion = 100;
        super.evadChance = 35;
    }
    @Override
    public void uniqueAbility(List<Droid> teammates, List<Droid> enemies) {
        Droid enemy = enemies.get(random.nextInt(enemies.size()));
        if (super.random.nextInt(100) <= this.normAtkChance){
            this.attack(enemies);
        } else {
            double lowDamage = this.damage - super.random.nextInt(1,5);
            if (super.random.nextInt(100) <= enemy.evadChance) {
                double actualDamage = lowDamage - (lowDamage * (enemy.evasion / 100));
                enemy.health -= actualDamage;
                SaveUtil.printBattle("\nДроїд " + this.name + " має нанести " + lowDamage + " послабленої шкоди дроїду " + enemy.name);
                SaveUtil.printBattle("Дроїд " + enemy.name + " на " + enemy.evasion + "% блокує шкоду");
                SaveUtil.printBattle("Дроїд " + this.name + " наносить " + actualDamage + " послабленої шкоди дроїду " + enemy.name + "\n");
            } else {
                enemy.health -= lowDamage;
                SaveUtil.printBattle("\nДроїд " + this.name + " наносить " + lowDamage + " послабленої шкоди дроїду " + enemy.name + "\n");
            }
            if(enemy.health <= 0) {
                enemies.remove(enemy);
                SaveUtil.printBattle("Дроїд " + enemy.name + " загинув\n");
            }
        }
    }
}