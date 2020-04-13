import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    int topSite = 0;
    int bottomSite = 1;

    private boolean[][] site;
    private int openSites = 0;
    private int N;
    private WeightedQuickUnionUF system;

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
                    system.union(xyTo1D(j, 1), topSite);
                    system.union(xyTo1D(j, N - 1), bottomSite);
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

    public void checkNeighbors(int row, int col) {
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
            return connected(element, topSite);
        }
        return false;
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        return connected(topSite, bottomSite);
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
        int i = x + N  * y;
        return i;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        Percolation system = new Percolation(N);
        system.open(1, 1);
        system.open(2, 1);
        system.open(3, 1);
        system.open(4, 1);
        system.open(5, 1);
        System.out.println();
        System.out.println(system.xyTo1D(1, 1));
        System.out.println(system.xyTo1D(1, 2));
        System.out.println(system.xyTo1D(1, 3));
        System.out.println(system.xyTo1D(1, 4));
        System.out.println(system.xyTo1D(1, 5));
        System.out.println();
        System.out.println(system.connected(7, 31));
        System.out.println();
        System.out.println("Percolates: " + system.percolates());
        System.out.println("number of open sites: " + system.openSites);

    }
}
