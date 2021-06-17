package life;

import java.util.Random;

public class Grid {

    private Cell[][] prev;
    private Cell[][] current;
    private final Random random;
    private final int N;
    private int generations;
    private int numberOfCellsAlive;

    public Grid(int n, long seed){
        if (n <= 0) {
            throw new IllegalArgumentException("n should be greater than 0");
        }
        N = n;
        current = new Cell[n][n];
        random = new Random(seed);
        generations = 0;
    }

    public Grid(int n, long seed, int generations) {
        this(n, seed);
        if (generations < 0) {
            throw new IllegalArgumentException("number of generations can't be negative");
        }
        this.generations = generations;
    }

    public void buildGrid() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                boolean alive = random.nextBoolean();
                current[i][j].setAlive(alive);
                if (alive) {
                    numberOfCellsAlive++;
                }
            }
        }
    }

    public void nextGeneration() {
        System.arraycopy(current, 0, prev, 0, N);
        current = new Cell[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // top left corner
                if (prev[i][j + 1].isAlive()) {
                    prev[i][j].addNeighbor();
                }
            }
        }
    }


    public void displayGrid() {
        for (Cell[] row : current) {
            for (Cell cell : row) {
                System.out.print(cell.isAlive()? "O" : " ");
            }
            System.out.println();
        }
    }

    public int getNumberOfCellsAlive() {
        return numberOfCellsAlive;
    }


}
