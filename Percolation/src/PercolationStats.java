import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private Percolation percolation;
    private final int n;
    private final int trials;
    private final double[] numberOpenSites;
    private static final double confidence = 1.96;


    public PercolationStats(int n, int trials) {
        validateIndex(n);
        validateIndex(trials);
        this.n = n;
        this.trials = trials;
        numberOpenSites = new double[trials];
        for (int i = 0; i < trials; i++) {
            percolation = new Percolation(n);
            numberOpenSites[i] += (double) fillTillPercolates() / (n * n);
        }
    }

    private int fillTillPercolates() {
        int rndRow;
        int rndcol;
        while (!percolation.percolates()) {
            rndRow = StdRandom.uniform(1, n + 1);
            rndcol = StdRandom.uniform(1, n + 1);
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
        return mean() - ((confidence * stddev()) / Math.sqrt(trials));
    }

    public double confidenceHi() {
        return mean() + ((confidence * stddev()) / Math.sqrt(trials));
    }

    private void validateIndex(int entry) {
        if (entry <= 0) {
            throw new IllegalArgumentException(
                    "entry " + entry + " out of bounds");
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(StdIn.readString());
        int trials = Integer.parseInt(StdIn.readString());
        PercolationStats percolationStats = new PercolationStats(n, trials);
        StdOut.println("mean                    " + "= " + percolationStats.mean());
        StdOut.println("stddev                  " + "= " + percolationStats.stddev());
        StdOut.println("95% confidence interval " + "= " + "[" + percolationStats.confidenceHi() +
                ", [" + percolationStats.confidenceLo() + "]");
    }

}
