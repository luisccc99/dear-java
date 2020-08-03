import java.util.Arrays;

public class BruteCollinearPoints {
    private final LineSegment[] segments;
    private int numberOfSegments;

    public BruteCollinearPoints(Point[] points) {
        if (isThisNull(points)) throw new IllegalArgumentException();
        if (areNullElementsIn(points)) throw new IllegalArgumentException();
        Arrays.sort(points);
        if (containsRepeatedPoints(points)) throw new IllegalArgumentException();

        int N = points.length;
        segments = new LineSegment[N / 4];

        for (int i = 0; i < N - 3; i++) {
            for (int j = i + 1; j < N - 2; j++) {
                for (int k = j + 1; k < N - 1; k++) {
                    for (int m = k + 1; m < N; m++) {
                        Point p = points[i];
                        Point q = points[j];
                        Point r = points[k];
                        Point s = points[m];
                        double first = slopeBetweenThesePoints(p, q);
                        double second = slopeBetweenThesePoints(r, s);
                        if (areTheseSlopesEqual(first, second)) {
                            addLineSegment(new LineSegment(p, s));
                        }
                    }
                }
            }
        }
    }

    private boolean isThisNull(Point[] points) {
        return points == null;
    }

    private boolean containsRepeatedPoints(Point[] points) {
        for (int i = 1; i < points.length; i++) {
            if (areThesePointsEqual(points[i], points[i - 1]))
                return true;
        }
        return false;
    }

    private boolean areThesePointsEqual(Point p, Point q) {
        return p.compareTo(q) == 0;
    }

    private boolean areNullElementsIn(Point[] points) {
        for (Point point : points) {
            if (isPointNull(point))
                return true;
        }
        return false;
    }

    private boolean isPointNull(Point p) {
        return p == null;
    }

    private double slopeBetweenThesePoints(Point p, Point q) {
        return p.slopeTo(q);
    }

    private boolean areTheseSlopesEqual(double s1, double s2) {
        return s1 == s2;
    }

    private void addLineSegment(LineSegment segment) {
        segments[numberOfSegments++] = segment;
    }

    public int numberOfSegments() {
        return numberOfSegments;
    }

    public LineSegment[] segments() {
        return segments;
    }


}
