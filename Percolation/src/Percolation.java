import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int TOP_SITE = 0;
    private final int BOTTOM_SITE = 1;

    private final boolean[][] site;
    private int openSites = 0;
    private final int N;
    private final WeightedQuickUnionUF system;

    //i = y, j = x
    public Percolation(int n) {
        N = n + 1;
        site = new boolean[N][N];
        int size = N * N;
        system = new WeightedQuickUnionUF(size);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                site[i][j] = false;
                //connecting bottom and top site with bottom and top rows
                if (i == 1 || i == N - 1) {
                    system.union(xyTo1D(j, 1), TOP_SITE);
                    system.union(xyTo1D(j, N - 1), BOTTOM_SITE);
                }
            }
        }

    }

    public void open(int row, int col) {
        validateIndex(row);
        validateIndex(col);
        if (!isOpen(row, col)) {
            site[row][col] = true;
            openSites++;
        }
        checkNeighbors(row, col);

    }

    private void checkNeighbors(int row, int col) {
        int upY = row - 1;
        int downY = row + 1;
        int backX = col - 1;
        int frontX = col + 1;

        if (row == 1 && col == 1) {
            connect(downY, col, row, col);
            connect(row, frontX, row, col);
        } else if (row == N - 1 && col == N - 1) {
            connect(upY, col, row, col);
            connect(row, backX, row, col);
        } else if (row == 1 && col == N - 1) {
            connect(row, backX, row, col);
            connect(downY, col, row, col);
        } else if (row == N - 1 && col == 1) {
            connect(upY, col, row, col);
            connect(row, frontX, row, col);
        } else if (row == 1) {
            connect(row, backX, row, col);
            connect(row, frontX, row, col);
            connect(downY, col, row, col);
        } else if (row == N - 1) {
            connect(row, backX, row, col);
            connect(row, frontX, row, col);
            connect(upY, col, row, col);
        } else if (col == 1) {
            connect(upY, col, row, col);
            connect(downY, col, row, col);
            connect(row, frontX, row, col);
        } else if (col == N - 1) { //col == N
            connect(upY, col, row, col);
            connect(downY, col, row, col);
            connect(row, backX, row, col);
        } else {
            connect(upY, col, row, col);
            connect(downY, col, row, col);
            connect(row, frontX, row, col);
            connect(row, backX, row, col);
        }

    }

    private void connect(int row, int col, int p, int q) {
        if (isOpen(row, col)) {
            system.union(xyTo1D(col, row), xyTo1D(q, p));
        }
    }

    public boolean isOpen(int row, int col) {
        validateIndex(row);
        validateIndex(col);
        return site[row][col];
    }

    public boolean isFull(int row, int col) {
        validateIndex(row);
        validateIndex(col);
        int element = xyTo1D(col, row);
        if (isOpen(row, col)) {
            return connected(element, TOP_SITE);
        }
        return false;
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        return connected(TOP_SITE, BOTTOM_SITE);
    }

    public boolean connected(int p, int q) {
        return system.find(p) == system.find(q);
    }

    private void validateIndex(int entry) {
        if (entry <= 0 || entry > N - 1) {
            throw new IllegalArgumentException(
                    "entry " + entry + " out of bounds");
        }
    }

    private int xyTo1D(int x, int y) {
        int i = x + N * y;
        return i;
    }

//    public void printSystem() {
//        for (int i = 1; i < N; i++) {
//            for (int j = 1; j < N; j++) {
//                if (!site[i][j]) {
//                    System.out.print("[ ]");
//                } else {
//                    System.out.print("[*]");
//                }
//            }
//            System.out.println("");
//        }
//    }

    public static void main(String[] args) {
//        int N = StdIn.readInt();
//        Percolation system = new Percolation(N);
//        system.printSystem();
//        system.open(1, 1);
//        system.open(1, 4);
//        system.open(2, 4);
//        system.open(2, 2);
//        system.open(3, 3);
//        system.open(3, 4);
//        system.open(4, 4);
//
//        System.out.println();
//        System.out.println(system.isFull(4, 4));
//        System.out.println();
//        system.printSystem();
//        System.out.println("Percolates: " + system.percolates());
//        System.out.println("number of open sites: " + system.openSites);
//
    }
}
