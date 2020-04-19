import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        int waterForOneCup = 200; // ml
        int milkForOneCup = 50; // ml
        int coffeeBeansForOneCup = 15; // grams
        String response = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int cupsOfCoffee = scanner.nextInt();

        int totalCupsOfCoffee = 0;

        int neededWater = water / waterForOneCup;
        int neededMilk = milk / milkForOneCup;
        int neededCoffeeBeans = coffeeBeans / coffeeBeansForOneCup;

        if (neededWater <= neededMilk && neededWater <= neededCoffeeBeans) {
            totalCupsOfCoffee += neededWater;
        } else if (neededMilk <= neededWater && neededMilk <= neededCoffeeBeans) {
            totalCupsOfCoffee += neededMilk;
        } else {
            totalCupsOfCoffee += neededCoffeeBeans;
        }

        boolean enoughWater = water >= cupsOfCoffee * waterForOneCup;
        boolean enoughMilk = milk >= cupsOfCoffee * milkForOneCup;
        boolean enoughCoffeeBeans = coffeeBeans >= cupsOfCoffee * coffeeBeansForOneCup;

        if (enoughWater && enoughMilk && enoughCoffeeBeans) {
            if (totalCupsOfCoffee == cupsOfCoffee){
                response = "Yes, I can make that amount of coffee";
            } else {
                totalCupsOfCoffee -= cupsOfCoffee;
                response = "Yes, I can make that amount of coffee (and even "
                        + totalCupsOfCoffee + " more than that)";
            }
        }
        else {
            response = "No, I can make only " + totalCupsOfCoffee +" cup(s) of coffee";
        }

        System.out.println(response);


        // System.out.println("For " + cupsOfCoffee + " cups of coffee you will need:");
        // System.out.println(water * cupsOfCoffee + " ml of water");
        // System.out.println(milk * cupsOfCoffee + " ml  of milk");
        // System.out.println(coffeeBeans * cupsOfCoffee + " g of coffee beans");

        // System.out.println("Starting to make a coffee");
        // System.out.println("Grinding coffee beans");
        // System.out.println("Boiling water");
        // System.out.println("Mixing boiled water with crushed coffee beans");
        // System.out.println("Pouring coffee into the cup");
        // System.out.println("Pouring some milk into the cup");
        // System.out.println("Coffee is ready!");
    }
}
