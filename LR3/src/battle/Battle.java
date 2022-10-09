package battle;

import droids.Droid;
import save.SaveUtil;

import java.util.List;
import java.util.Random;

public class Battle {
    private List<Droid> teammates;
    private List<Droid> enemies;
    private Random random = new Random();

    public Battle(List<Droid> teammates, List<Droid> enemies) {
        this.teammates = teammates;
        this.enemies = enemies;
    }

    public void startBattle() {
        boolean turn = random.nextBoolean();
        while(!teammates.isEmpty() && !enemies.isEmpty()) {
            if(turn) {
                teammates.get(random.nextInt(teammates.size())).uniqueAbility(teammates, enemies);
            } else {
                enemies.get(random.nextInt(enemies.size())).uniqueAbility(enemies, teammates);
            }
            turn = !turn;
            this.showHP();
            SaveUtil.printBattle("\n-------------------------------------------------------------------------------");
        }
        if (teammates.isEmpty()) {
            SaveUtil.printBattle("\nПеремогла команда Пітьми!\n");
        } else {
            SaveUtil.printBattle("\nПеремогла команда Сяйва!\n");
        }
        SaveUtil.closeBattle();
    }

    private void showHP() {
        SaveUtil.printBattle("Команда Сяйва: ");
        for (Droid droid : teammates) {
            String res = String.format("%.6f", droid.getHealth());
            SaveUtil.printBattle(droid.getName() + " - Здоров'я: " + res);
        }
        SaveUtil.printBattle("Команда Пітьми: ");
        for (Droid droid : enemies) {
            String res = String.format("%.6f", droid.getHealth());
            SaveUtil.printBattle(droid.getName() + " - Здоров'я: " + res);
        }
    }
}