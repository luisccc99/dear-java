public class IntersectionOutput {

    private final int numberOfCars;
    private final int horizontalCars;
    private final int verticalCars;
    private final int optimizations;


    public IntersectionOutput(int totalNumberOfCars, int totalNumberOfHorizontalCars, int totalNumberOfVerticalCars, int optimizations) {
        this.numberOfCars = totalNumberOfCars;
        this.horizontalCars = totalNumberOfHorizontalCars;
        this.verticalCars = totalNumberOfVerticalCars;
        this.optimizations = optimizations;
    }

    public int getVerticalCars() {
        return verticalCars;
    }

    public int getHorizontalCars() {
        return horizontalCars;
    }

    public int getOptimizations() {
        return optimizations;
    }

    public int getTotalNumberOfCars() {
        return numberOfCars;
    }
}
