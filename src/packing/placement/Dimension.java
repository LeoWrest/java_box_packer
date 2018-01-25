package packing.placement;

public class Dimension {

    int width;
    int depth;
    int height;

    public Dimension(int width, int depth, int height) {
        this.width = width;
        this.depth = depth;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Dimension{" +
                "width=" + width +
                ", depth=" + depth +
                ", height=" + height +
                '}';
    }

}
