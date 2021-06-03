package life;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final long seed = scanner.nextLong();
        final GameOfLife game = new GameOfLife(n, seed);
        game.buildGrid();
        game.displayGrid();
    }

}
