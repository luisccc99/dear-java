public class BruteCollinearPoints {

    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        for (int i = 0; i < points.length; i++) {
            if (isNull(points[i]))
                throw new IllegalArgumentException();

        }
    }

    public int numberOfSegments() {

        return 0;
    }

    public LineSegment[] segments() {

        return null;
    }

    private boolean areCollinear(Point[] points) {
        Point p = points[0];
        Point q = points[1];
        Point r = points[2];
        Point s = points[3];
        return p.slopeTo(q) == p.slopeTo(r)
                && p.slopeTo(q) == p.slopeTo(s);
    }

    private boolean isNull(Point p) {
        return p == null;
    }
}
