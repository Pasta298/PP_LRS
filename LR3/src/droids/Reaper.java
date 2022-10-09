package droids;

import save.SaveUtil;

import java.util.List;

public class Reaper extends Droid {

    public final int killChance = 5;
    public Reaper(String name) {
        super.name = name;
        super.health = 100;
        super.damage = 25;
        super.evasion = 15;
        super.evadChance = 15;
    }
    @Override
    public void uniqueAbility(List<Droid> teammates, List<Droid> enemies) {
        Droid enemy = enemies.get(random.nextInt(enemies.size()));
        if (super.random.nextInt(100) <= this.killChance) {
            enemies.remove(enemy);
            SaveUtil.printBattle("\nДроїд " + this.name + " викорустовує здібність класу жнець: \"КОСА СМЕРТІ\", від якої помирає дроїд " + enemy.name + "\n");
            SaveUtil.printBattle("Дроїд " + enemy.name + " загинув\n");
        } else {
            this.attack(enemies);
        }
    }
}