
import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private double money;
    private final Scanner scanner = new Scanner(System.in);

    public CoffeeMachine() {
        water = 400;
        milk = 540;
        coffeeBeans = 120;
        disposableCups = 9;
        money = 550;
    }

    public void fillMachine() {
        System.out.println("Write how many ml of water do you want to add:");
        int waterToAdd = scanner.nextInt();
        water += waterToAdd;
        System.out.println("Write how many ml of milk do you want to add:");
        int milkToAdd = scanner.nextInt();
        milk += milkToAdd;
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int coffeeBeansToAdd = scanner.nextInt();
        coffeeBeans += coffeeBeansToAdd;
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int disposableCupsToAdd = scanner.nextInt();
        disposableCups += disposableCupsToAdd;
    }

    public double takeMoney() {
        double moneyToGave = money;
        System.out.println("I gave you $" + moneyToGave);
        money = 0;
        return moneyToGave;
    }

    public void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int variety = scanner.nextInt();
        if (variety == 1) {
            makeEspresso();
        } else if (variety == 2) {
            makeLatte();
        } else {
            makeCappuccino();
        }
        disposableCups--;
    }

    private void makeEspresso() {
        water -= 250;
        coffeeBeans -= 16;
        money += 4;
    }

    private void makeLatte() {
        water -= 350;
        milk -= 75;
        coffeeBeans -= 20;
        money += 7;
    }

    private void makeCappuccino() {
        water += 200;
        milk -= 100;
        coffeeBeans -= 12;
        money += 6;
    }

    public void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            if (action.equals("exit")) break;
            switch (action) {
                case "buy":
                    machine.buyCoffee();
                    break;
                case "fill":
                    machine.fillMachine();
                    break;
                case "take":
                    machine.takeMoney();
                    break;
                case "remaining":
                    machine.remaining();
                    break;
                default:
                    break;
            }
        }

    }
}
