package packing;

import packing.placement.Dimension;
import packing.placement.Position;

import java.util.ArrayList;
import java.util.List;

public class Placement {

    Dimension dimensions;
    Position positions;

    public Placement(Dimension dimensions, Position positions) {
        this.dimensions = dimensions;
        this.positions = positions;
    }

    public Dimension getDimensions() {
        return dimensions;
    }

    public Position getPositions() {
        return positions;
    }

    @Override
    public String toString() {
        return "Placement{" +
                "dimensions=" + dimensions +
                ", positions=" + positions +
                '}';
    }
}
