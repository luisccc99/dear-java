package LombokVBoilerplate;


public class App {

    public static void main(String[] args) {
        Dog boilerplate = new Dog("Creed", "Poodle", 32, "Brownish");
        System.out.println(boilerplate);
        DogLombok lombok = new DogLombok("Kevin", "Pug", 23, "Black");
        System.out.println(lombok);
    }
}
