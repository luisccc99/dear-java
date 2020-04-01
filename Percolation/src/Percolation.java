import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int xBottomSite = 0;
    private int xTopSite = 0;
    private int yBottomSite = 0;
    private int yTopSite = 0;

    private boolean[][] site;
    private int size;
    private int openSites = 0;
    private int N;
    private WeightedQuickUnionUF system;


    public Percolation(int n) {
        this.N = n + 1;
        yTopSite = n;
        site = new boolean[N][N];
        size = N * N;
        system = new WeightedQuickUnionUF(size);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                site[i][j] = false;
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
        //TODO: implement checking for adjacent open sites
    }

    public boolean isOpen(int row, int col) {
        validateIndex(row);
        validateIndex(col);
        return site[row][col];
    }

    public boolean isFull(int row, int col) {
        validateIndex(row);
        validateIndex(col);
        //TODO: finish this section
        return false;
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        int topSite = xyTo1D(xTopSite, yTopSite);
        int bottomSite = xyTo1D(xBottomSite, yBottomSite);
        if (system.find(topSite) == system.find(bottomSite)) {
            return true;
        }
        return false;
    }

    private void validateIndex(int entry) {
        if (entry <= 0 || entry > N) {
            throw new IllegalArgumentException(
                    "index" + entry + " out of bounds");
        }
    }

    private int xyTo1D(int x, int y) {
        int i = x + N * y;
        return i;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        Percolation system = new Percolation(N);
        system.open(2, 2);
        system.open(1, 1);
        System.out.println(system.numberOfOpenSites());
    }
}
