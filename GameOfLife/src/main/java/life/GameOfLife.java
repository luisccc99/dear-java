package life;

import java.util.Random;

public class GameOfLife {

    private final boolean[][] grid;
    private final Random random;
    private final int N;
    private int numberOfCellsAlive;

    public GameOfLife(int n, long seed){
        if (n <= 0) {
            throw new IllegalArgumentException("n should be greater than 0");
        }
        N = n;
        grid = new boolean[n][n];
        random = new Random(seed);
    }

    public void buildGrid() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                boolean alive = random.nextBoolean();
                grid[i][j] = alive;
                if (alive) numberOfCellsAlive++;
            }
        }
    }

    public void displayGrid() {
        for (boolean[] row : grid) {
            for (boolean elem : row) {
                System.out.print(elem? "O" : " ");
            }
            System.out.println();
        }
    }

    public int getNumberOfCellsAlive() {
        return numberOfCellsAlive;
    }

}
