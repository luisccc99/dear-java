import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private static final int TOP_SITE = 0;
    private static final int BOTTOM_SITE = 1;

    private final boolean[][] site;
    private int openSites = 0;
    private final int num;
    private final WeightedQuickUnionUF system;

    // i = y, j = x
    public Percolation(int n) {
        num = n + 1;
        site = new boolean[num][num];
        int size = num * num;
        system = new WeightedQuickUnionUF(size);
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                site[i][j] = false;
                // connecting bottom and top site with bottom and top rows
                if (i == 1 || i == num - 1) {
                    system.union(xyTo1D(j, 1), TOP_SITE);
                    system.union(xyTo1D(j, num - 1), BOTTOM_SITE);
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
        } else if (row == num - 1 && col == num - 1) {
            connect(upY, col, row, col);
            connect(row, backX, row, col);
        } else if (row == 1 && col == num - 1) {
            connect(row, backX, row, col);
            connect(downY, col, row, col);
        } else if (row == num - 1 && col == 1) {
            connect(upY, col, row, col);
            connect(row, frontX, row, col);
        } else if (row == 1) {
            connect(row, backX, row, col);
            connect(row, frontX, row, col);
            connect(downY, col, row, col);
        } else if (row == num - 1) {
            connect(row, backX, row, col);
            connect(row, frontX, row, col);
            connect(upY, col, row, col);
        } else if (col == 1) {
            connect(upY, col, row, col);
            connect(downY, col, row, col);
            connect(row, frontX, row, col);
        } else if (col == num - 1) {
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

    private boolean connected(int p, int q) {
        return system.find(p) == system.find(q);
    }

    private void validateIndex(int entry) {
        if (entry <= 0 || entry > num - 1) {
            throw new IllegalArgumentException(
                    "entry " + entry + " out of bounds");
        }
    }

    private int xyTo1D(int x, int y) {
        return x + num  * y;
    }
}
