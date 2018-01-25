package packing;

public class Rectangle {


    String name;
    int width;
    int depth;
    int height;

    public Rectangle(String name, int width, int depth, int height) {
        this.name = name;
        this.width = width;
        this.depth = depth;
        this.height = height;
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

}
