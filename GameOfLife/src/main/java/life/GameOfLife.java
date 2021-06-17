package life;

import java.util.Scanner;

public class GameOfLife {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final long seed = scanner.nextLong();
        final Grid game = new Grid(n, seed);
        game.buildGrid();
        game.displayGrid();
    }
}
