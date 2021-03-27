import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightTest {
    private final TrafficLight horizontalTrafficLight =
            new TrafficLight(TrafficLight.TrafficOrientation.HORIZONTAL);

    @DisplayName("Size of cars should be 1")
    @Test
    void testEnqueue5Cars() {
        horizontalTrafficLight.enqueueCar(5);
        assertEquals(5, horizontalTrafficLight.getNumberOfCars());
    }

    @DisplayName("Orientation should be horizontal")
    @Test
    void testOrientationOfTrafficLight() {
        assertEquals(TrafficLight.TrafficOrientation.HORIZONTAL, horizontalTrafficLight.getOrientation());
    }
}
