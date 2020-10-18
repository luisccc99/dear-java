import FamilyAlgorithms.FlyWithWings;
import FamilyAlgorithms.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("Mallard duck displaying");
    }
}
