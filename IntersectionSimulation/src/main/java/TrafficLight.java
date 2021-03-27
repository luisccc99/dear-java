public class TrafficLight {

    private int cars;
    private int totalNumberOfCars = 0;
    private final TrafficOrientation orientation;
    private Lights light;

    public TrafficLight(TrafficOrientation o) {
        this.orientation = o;
        cars = 0;
    }

    public void enqueueCar(int n) {
        totalNumberOfCars += n;
        cars += n;
    }

    public void dequeueCar() {
        if (cars > 0) {
            cars--;
        }
    }

    public int getNumberOfCars() {
        return this.cars;
    }

    public int getTotalNumberOfCars() {
        return this.totalNumberOfCars;
    }

    public void setLight(Lights light) {
        this.light = light;
    }

    public Lights getLight() {
        return this.light;
    }

    public TrafficOrientation getOrientation() {
        return this.orientation;
    }

    public enum TrafficTime { NORMAL, SHORT }
    public enum Lights { GREEN, RED }
    public enum TrafficOrientation { HORIZONTAL, VERTICAL }
}
