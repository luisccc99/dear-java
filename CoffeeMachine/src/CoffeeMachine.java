import java.util.Scanner;

abstract class Coffee implements inCoffeeMachine {
    int mlOfWaterNeeded;
    int coffeeBeansNeeded;
    int cost;

    @Override
    public boolean canMakeCoffeeInMachine(CoffeeMachine machine) {
        return machine.enoughWaterFor(this)
                && machine.enoughCoffeeBeansFor(this)
                && machine.enoughDisposableCups();
    }

    @Override
    public String notSufficientInMachine(CoffeeMachine machine) {
        String element = "";
        if (!machine.enoughWaterFor(this))
            element = "water";
        else if (!machine.enoughCoffeeBeansFor(this))
            element = "coffee beans";
        else if (!machine.enoughDisposableCups())
            element = "disposable cups";
        return element;
    }
}

abstract class CoffeeWithMilk extends Coffee {
    int mlOfMilkNeeded;

    @Override
    public boolean canMakeCoffeeInMachine(CoffeeMachine machine) {
        return super.canMakeCoffeeInMachine(machine)
                && machine.enoughMilkFor(this);
    }

    @Override
    public String notSufficientInMachine(CoffeeMachine machine) {
        String element = super.notSufficientInMachine(machine);
        if (element.equals("")) {
            if (!machine.enoughMilkFor(this))
                element = "milk";
        }
        return element;
    }
}

interface inCoffeeMachine {

    void makeCoffeeInMachine(CoffeeMachine machine);

    boolean canMakeCoffeeInMachine(CoffeeMachine machine);

    String notSufficientInMachine(CoffeeMachine machine);
}

class Espresso extends Coffee {

    public Espresso() {
        mlOfWaterNeeded = 250;
        coffeeBeansNeeded = 16;
        cost = 4;
    }

    @Override
    public void makeCoffeeInMachine(CoffeeMachine machine) {
        machine.water -= 250;
        machine.coffeeBeans -= 16;
        machine.money += 4;
    }

    @Override
    public String toString() {
        return "Espresso";
    }
}

class Latte extends CoffeeWithMilk {

    public Latte() {
        mlOfWaterNeeded = 350;
        mlOfMilkNeeded = 75;
        coffeeBeansNeeded = 20;
        cost = 7;
    }

    @Override
    public void makeCoffeeInMachine(CoffeeMachine machine) {
        machine.water -= 350;
        machine.milk -= 75;
        machine.coffeeBeans -= 20;
        machine.money += 7;
    }

    @Override
    public String toString() {
        return "Latte";
    }
}

class Cappuccino extends CoffeeWithMilk {

    public Cappuccino() {
        mlOfWaterNeeded = 200;
        mlOfMilkNeeded = 100;
        coffeeBeansNeeded = 12;
        cost = 6;
    }

    @Override
    public void makeCoffeeInMachine(CoffeeMachine machine) {
        machine.water -= 200;
        machine.milk -= 100;
        machine.coffeeBeans -= 12;
        machine.money += 6;
    }

    @Override
    public String toString() {
        return "Cappuccino";
    }
}

public class CoffeeMachine {
    protected int water;
    protected int milk;
    protected int coffeeBeans;
    protected int disposableCups;
    protected int money;

    public CoffeeMachine() {
        water = 400;
        milk = 540;
        coffeeBeans = 120;
        disposableCups = 9;
        money = 550;
    }

    public void fillMachine() {
        Scanner scanner = new Scanner(System.in);
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

    public void takeMoney() {
        int moneyToGave = money;
        System.out.println("I gave you $" + moneyToGave);
        money = 0;
    }

    public void buyCoffee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu :");
        String variety = scanner.next();
        switch (variety) {
            case "1":
                makeCoffeeIfPossibleOrShowWarning(new Espresso());
                break;
            case "2":
                makeCoffeeIfPossibleOrShowWarning(new Latte());
                break;
            case "3":
                makeCoffeeIfPossibleOrShowWarning(new Cappuccino());
                break;
        }
    }

    private void makeCoffeeIfPossibleOrShowWarning(Coffee coffee) {
        if (coffee.canMakeCoffeeInMachine(this)) {
            System.out.println("I have enough resources, making you a coffee!");
            coffee.makeCoffeeInMachine(this);
            disposableCups--;
        } else {
            System.out.println("Sorry, not enough " + coffee.notSufficientInMachine(this) + "!");
        }
    }

    protected boolean enoughWaterFor(Coffee coffee) {
        return water >= coffee.mlOfWaterNeeded;
    }

    protected boolean enoughCoffeeBeansFor(Coffee coffee) {
        return coffeeBeans >= coffee.coffeeBeansNeeded;
    }

    protected boolean enoughMilkFor(CoffeeWithMilk coffee) {
        return milk >= coffee.mlOfMilkNeeded;
    }

    protected boolean enoughDisposableCups() {
        return disposableCups > 0;
    }

    public void showRemaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
        System.out.println();
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            if (action.equals("exit"))
                break;
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
                    machine.showRemaining();
                    break;
                default:
                    break;
            }
        }

    }
}