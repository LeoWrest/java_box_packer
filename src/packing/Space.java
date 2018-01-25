package packing;

import packing.placement.Dimension;
import packing.placement.Position;

public class Space {

    Dimension dimension;
    Position position;

    public Space(Dimension dimension, Position position) {
        this.dimension = dimension;
        this.position = position;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public Position getPosition() {
        return position;
    }

}
