package fr.unilm.iut.rover;


public record Coordinate(int x, int y) {

    public Coordinate add(Coordinate vector) {
        return new Coordinate(this.x + vector.x(), this.y + vector.y());
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}