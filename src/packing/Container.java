package packing;

import java.util.ArrayList;
import java.util.List;

public class Container {

    List<Placement> placements = new ArrayList<>();
    List<Space> spaces = new ArrayList<>();
    Integer currentWeight = 0;

    public List<Placement> getPlacements() {
        return placements;
    }

    public List<Space> getSpaces() {
        return spaces;
    }

    public void addPlacement(Placement placement) {
        placements.add(placement);
    }

    public Integer getCurrentWeight() {
        return currentWeight;
    }

    public void addWeight(Integer newWeight) {
        this.currentWeight += newWeight;
    }

}
