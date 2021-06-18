package life;

public class Cell {
    private byte neighbors;
    private boolean alive;
    public static final int NEIGHBORS = 8;

    public Cell(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public byte getNeighbors() {
        return neighbors;
    }

    public void addNeighbor() {
        neighbors++;
    }

    public void removeNeighbor() {
        neighbors--;
    }
}
