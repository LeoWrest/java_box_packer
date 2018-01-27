package packing;

public class Rectangle {


    String name;
    int width;
    int depth;
    int height;
    int weight;

    public Rectangle(String name, int width, int depth, int height, int weight) {
        this.name = name;
        this.width = width;
        this.depth = depth;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
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

    public int getWeight() {
        return weight;
    }

}
