import java.util.Scanner;

public class IntersectionSimulation {

    public final static TrafficLight.TrafficOrientation HORIZONTAL = TrafficLight.TrafficOrientation.HORIZONTAL;
    public final static TrafficLight.TrafficOrientation VERTICAL = TrafficLight.TrafficOrientation.VERTICAL;
    public final static TrafficLight.TrafficTime NORMAL = TrafficLight.TrafficTime.NORMAL;
    public static final int MIN_TIME = 15;
    public static final int NORMAL_TIME = 25;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
		System.out.println("Luis Carlos Cruz Castillo");
		System.out.println("David Galieli Garcia Hinostroza");
        System.out.println("Ingresa el número de pasos a simular (minimo 25)");
        int totalTime = scanner.nextInt();
        while (totalTime <= 0) {
            System.out.println("Ingresa números positivos y enteros.");
            totalTime = scanner.nextInt();
        }
        final IntersectionOutput result = startSimulation(totalTime, new Intersection());
        int totalCars = result.getTotalNumberOfCars();
        if (totalCars > 0) {
            System.out.printf("En total pasaron %d carros.\n", totalCars);
            System.out.printf("%.5f%s de los carros pasaron horizontalmente.\n", (result.getHorizontalCars() * 1.0 / totalCars) * 100, "%");
            System.out.printf("%.5f%s de los carros pasaron verticalmente.\n", (result.getVerticalCars() * 1.0 / totalCars * 100), "%");
            System.out.printf("Se realizaron %d optimizaciones\n", result.getOptimizations());
        } else {
            System.out.println("Insuficientes pasos para la simulación!");
        }

    }

    private static IntersectionOutput startSimulation(int totalTime, Intersection intersection) {
        TrafficLight.TrafficOrientation priority;
        TrafficLight.TrafficTime trafficTime;
        int time;
        TrafficLight.TrafficOrientation orientation = null;
        int optimizations = 0;
        for (int i = 0; i < totalTime; i++) {
            trafficTime = NORMAL;
            priority = intersection.priority();
            if (i == 0) {
                setTrafficLights(intersection, priority);
                orientation = priority;
            } else {
                // orientation was horizontal
                if (orientation == HORIZONTAL) {
                    if (priority != VERTICAL) { // there are more cars on horizontal
                        trafficTime = TrafficLight.TrafficTime.SHORT;
                        optimizations++;
                    }
                    orientation = VERTICAL;
                } else {
                    // orientation was vertical
                    if (priority != HORIZONTAL) { // there are more cars on vertical
                        trafficTime = TrafficLight.TrafficTime.SHORT;
                        optimizations++;
                    }
                    orientation = HORIZONTAL;
                }
                setTrafficLights(intersection, orientation);
            }
            time = trafficTime == NORMAL ? NORMAL_TIME : MIN_TIME;
            if ((time - 1 + i) > totalTime) {
                time = (time - 1 + i) - totalTime;
                // normal=25, short-15, 90 + 25, 100, 15, 115, 100
                // 10
            }
            for (int j = 0; j < time; j++) {
                intersection.enqueueCar();
                intersection.dequeueCar();
            }
            i += time - 1;
        }

        int totalCars = intersection.getTotalNumberOfCars();
        int horizontalCars = intersection.getTotalNumberOfCarsOn(HORIZONTAL);
        int verticalCars = intersection.getTotalNumberOfCarsOn(VERTICAL);
        return new IntersectionOutput(totalCars, horizontalCars, verticalCars, optimizations);
    }

    private static void setTrafficLights(Intersection intersection, TrafficLight.TrafficOrientation orientation) {
        if (orientation == HORIZONTAL) {
            setLights(intersection, orientation, TrafficLight.Lights.GREEN);
            setLights(intersection, VERTICAL, TrafficLight.Lights.RED);
        } else {
            // vertical to green and horizontal to red
            setLights(intersection, orientation, TrafficLight.Lights.GREEN);
            setLights(intersection, HORIZONTAL, TrafficLight.Lights.RED);
        }
    }

    private static void setLights(Intersection i, TrafficLight.TrafficOrientation o, TrafficLight.Lights l) {
        i.setTrafficLights(o, l);
    }
}

