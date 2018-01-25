package packing.placement;

public class Position extends Dimension {

    public Position(int width, int depth, int height) {
        super(width, depth, height);
    }

    @Override
    public String toString() {
        return "Position{" +
                "width=" + width +
                ", depth=" + depth +
                ", height=" + height +
                '}';
    }



}
