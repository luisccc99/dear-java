import java.util.Scanner;

public class CoffeeMachine {
    private final int WATER_FOR_ONE_CUP = 200; // ml
    private final int MILK_FOR_ONE_CUP = 50; // ml
    private final int COFFEE_FOR_BEANS_ONE_CUP = 15; // grams
    private int waterInTheCoffeeMachine = 400;
    private int milkInTheCoffeeMachine = 540;
    private int coffeeBeansInTheCoffeeMachine = 120;
    private int disposableCups = 9;

    private double money = 550;

    public void fillMachine() {

    }

    public double takeMoney() {
        return money;
    }

    public void buyCoffee() {

    }

    public void showMachineState() {

    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        machine.showMachineState();
        System.out.println("Write action (buy, fill, take):");
        Scanner scanner = new Scanner(System.in);
        String action = scanner.next();
        switch (action){
            case "buy":
                System.out.println("what do you want?       ");
                break;
            case "fill":
                System.out.println("come on fill me");
            default:
                break;
        }
        System.out.println(action);


    }
}
