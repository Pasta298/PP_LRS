import battle.Battle;
import droids.*;
import save.SaveUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        List<Droid> teammates = new ArrayList<>();
        List<Droid> enemies = new ArrayList<>();
        Battle battle = new Battle(teammates, enemies);
        while (true) {
            System.out.println("Введіть \"1\", щоб додати дроїда до команди Сяйва");
            System.out.println("Введіть \"2\", щоб додати дроїда до команди Пітьми");
            System.out.println("Введіть \"3\", щоб почати бій");
            System.out.println("Введіть \"4\", щоб повторити останній бій");
            System.out.println("Введіть \"5\", щоб вивести на екран дроїдів з команди Сяйва");
            System.out.println("Введіть \"6\", щоб вивести на екран дроїдів з команди Пітьми");
            System.out.println("Введіть \"7\", щоб вилучити дроїда з команди Сяйва");
            System.out.println("Введіть \"8\", щоб вилучити дроїда з команди Пітьми");
            System.out.println("Введіть \"9\", щоб вийти з програми");
            switch (in.nextInt()) {
                case(1):
                    adding(teammates);
                    break;
                case(2):
                    adding(enemies);
                    break;
                case(3):
                    battle.startBattle();
                    break;
                case(4):
                    SaveUtil.importBattle();
                    break;
                case(5):
                    print(teammates);
                    break;
                case(6):
                    print(enemies);
                    break;
                case(7):
                    delete(teammates);
                    break;
                case(8):
                    delete(enemies);
                    break;
                case(9):
                    return;
                default:
                    System.out.println("Такої опції не існує!\n");
                    break;
            }
        }
    }
    private static void adding(List<Droid> droids) {
        in.nextLine();
        System.out.println("Введіть назву дроїда: ");
        String name = in.nextLine();
        System.out.println("Введіть \"а\" щоб створити клас асасіна");
        System.out.println("Введіть \"б\" щоб створити клас фантома");
        System.out.println("Введіть \"в\" щоб створити клас хілера");
        System.out.println("Введіть \"г\" щоб створити клас жнеця");
        System.out.println("Введіть \"д\" щоб створити клас трікстера");
        String classNumber = in.nextLine();
        switch(classNumber) {
            case("а"):
                droids.add(new Assassin(name));
                System.out.println("Обраний клас - асасін\n");
                break;
            case("б"):
                droids.add(new Phantom(name));
                System.out.println("Обраний клас - фантом\n");
                break;
            case("в"):
                droids.add(new Healer(name));
                System.out.println("Обраний клас - хілер\n");
                break;
            case("г"):
                droids.add(new Reaper(name));
                System.out.println("Обраний клас - жнець\n");
                break;
            case("д"):
                droids.add(new Trickster(name));
                System.out.println("Обраний клас - трікстер\n");
                break;
            default:
                System.out.println("Не існує данного класу!\n");
                break;
        }
    }
    private static void print(List<Droid> droids) {
        System.out.println("Список дроїдів: ");
        for (Droid droid: droids) {
            System.out.printf(droid.getName() + " ");
        }
        System.out.println();
    }
    private static void delete(List<Droid> droids) {
        in.nextLine();
        System.out.println("Введіть назву дроїда: ");
        String name = in.nextLine();
        droids.remove(name);
        System.out.println("Дроїда " + name + " вилучено\n");
    }
}