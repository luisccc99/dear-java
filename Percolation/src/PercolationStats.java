import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    Percolation percolation;
    int N;
    int T;
    double[] numberOpenSites;


    public PercolationStats(int n, int trials) {
        validateIndex(n);
        validateIndex(trials);
        this.N = n;
        this.T = trials;
        numberOpenSites = new double[trials];
        for (int i = 0; i < trials; i++) {
            percolation = new Percolation(n);
            numberOpenSites[i] += (double) fillTillPercolates() / (n * n);
        }
        formattedOutput();
    }

    private int fillTillPercolates() {
        int rndRow;
        int rndcol;
        while (!percolation.percolates()) {
            rndRow = StdRandom.uniform(1, N + 1);
            rndcol = StdRandom.uniform(1, N + 1);
            percolation.open(rndRow, rndcol);
        }
        return percolation.numberOfOpenSites();
    }

    public double mean() {
        return StdStats.mean(numberOpenSites);
    }

    public double stddev() {
        return StdStats.stddev(numberOpenSites);
    }

    public double confidenceLo() {
        return mean() - ((1.96 * stddev()) / Math.sqrt((double) T));
    }

    public double confidenceH() {
        return mean() + ((1.96 * stddev()) / Math.sqrt((double) T));
    }

    private void validateIndex(int entry) {
        if (entry <= 0) {
            throw new IllegalArgumentException(
                    "entry " + entry + " out of bounds");
        }
    }

    private void formattedOutput() {
        StdOut.println("mean                    " + "= " + mean());
        StdOut.println("stddev                  " + "= " + stddev());
        StdOut.println("95% confidence interval " + "= " + "[" + confidenceLo() +
                ", [" + confidenceH() + "]");
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int trials = StdIn.readInt();
        PercolationStats percolationStats = new PercolationStats(n, trials);
    }

}
