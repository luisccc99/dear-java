package life;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameOfLifeTest {

    public static final int SEED = 100;

    @Test
    void initialize10AliveCellsWithSeedOf4() {
        GameOfLife life = new GameOfLife(4, 4);
        life.buildGrid();
        assertEquals(10, life.getNumberOfCellsAlive());
    }

    @Test
    void throwExceptionIfNIsLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GameOfLife(-1, SEED);
        });
    }

    @Test
    void throwExceptionIfNIsZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GameOfLife(0, SEED);
        });
    }

}
