import java.util.Random;

public class Intersection {

    private final TrafficLight[] trafficLights;
    private final Random random = new Random();

    public Intersection() {
        trafficLights = new TrafficLight[4];
        for (int i = 0; i < trafficLights.length; i++) {
            if (i % 2 == 0) {
                trafficLights[i] = new TrafficLight(TrafficLight.TrafficOrientation.HORIZONTAL);
            } else {
                trafficLights[i] = new TrafficLight(TrafficLight.TrafficOrientation.VERTICAL);
            }
        }
    }

    public void setTrafficLights(TrafficLight.TrafficOrientation o, TrafficLight.Lights l) {
        for (TrafficLight t : trafficLights) {
            if (t.getOrientation() == o) {
                t.setLight(l);
            }
        }
    }

    public void enqueueCar() {
        for (TrafficLight t : trafficLights) {
            int cars = getRandomNumberInRange(0, 2);
            t.enqueueCar(cars);
        }
    }

    public void dequeueCar() {
        for (TrafficLight t : trafficLights) {
            if (t.getLight() == TrafficLight.Lights.GREEN) {
                t.dequeueCar();
            }
        }
    }

    public TrafficLight.TrafficOrientation priority() {
        return getHorizontalWorkload() > getVerticalWorkload() ?
                TrafficLight.TrafficOrientation.HORIZONTAL : TrafficLight.TrafficOrientation.VERTICAL;
    }

    private int getRandomNumberInRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    public int getVerticalWorkload() {
        return getWorkload(TrafficLight.TrafficOrientation.VERTICAL);
    }

    public int getHorizontalWorkload() {
        return getWorkload(TrafficLight.TrafficOrientation.HORIZONTAL);
    }

    public int getTotalNumberOfCars() {
        int total = 0;
        for (TrafficLight t: trafficLights) {
            total += t.getTotalNumberOfCars();
        }
        return total;
    }

    public int getTotalNumberOfCarsOn(TrafficLight.TrafficOrientation o) {
        int total = 0;
        for (TrafficLight t : trafficLights) {
            if (t.getOrientation() == o) {
                total += t.getTotalNumberOfCars();
            }
        }
        return total;
    }

    private int getWorkload(TrafficLight.TrafficOrientation o) {
        int work = 0;
        for (TrafficLight t : trafficLights) {
            if (t.getOrientation() == o) {
                work += t.getNumberOfCars();
            }
        }
        return work;
    }

}