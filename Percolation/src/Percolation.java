import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    int topSite = 0;
    int bottomSite = 1;

    private boolean[][] site;
    private int openSites = 0;
    private int N;
    private WeightedQuickUnionUF system;

    //i = x, j = y
    public Percolation(int n) {
        N = n + 1;
        site = new boolean[N][N];
        int size = N * N;
        system = new WeightedQuickUnionUF(size);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                site[i][j] = false;
                //connecting bottom and top site with bottom and top rows
                if (j == 1 || j == N - 1) {
                    system.union(xyTo1D(i, 1), topSite);
                    system.union(xyTo1D(i, N - 1), bottomSite);
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

    }

    public void checkNeighbors(int row, int col) {
        int upY = row - 1;
        int downY = row + 1;
        int backX = col - 1;
        int frontX = col + 1;

        if (isOpen(upY, col)) {
            system.union(xyTo1D(col, row), xyTo1D(col, upY));
        } else if (isOpen(downY, col)) {
            system.union(xyTo1D(col, row), xyTo1D(col, downY));
        } else if (isOpen(row, frontX)) {
            system.union(xyTo1D(col, row), xyTo1D(frontX, row));
        } else if (isOpen(row, backX)) {
            system.union(xyTo1D(col, row), xyTo1D(backX, row));
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
        if (entry <= 0 || entry > N) {
            throw new IllegalArgumentException(
                    "entry " + entry + " out of bounds");
        }
    }

    private int xyTo1D(int x, int y) {
        int i = x + N * y;
        return i;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        Percolation system = new Percolation(N);
        system.open(1, 2);
        system.open(2, 3);
        system.open(2, 1);
        system.open(3, 2);
        System.out.println(system.connected(6, 14));
        system.open(2, 2);
        system.checkNeighbors(2,2);
        System.out.println(system.connected(10, 14));

        //TODO: corner and edge cases

    }
}
