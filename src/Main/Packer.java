package Main;

import packing.Container;
import packing.Placement;
import packing.Rectangle;
import packing.Space;
import packing.placement.Dimension;
import packing.placement.Position;

import java.util.*;

public class Packer {



    public void pack(Rectangle containerSpecification, List<Rectangle> boxList) throws Exception {
        List<Container> containerList = new ArrayList<>();
        // for every product in the list
        for (Rectangle box : boxList) {
            // throw exception if box weight is more than the container
            if (box.getWeight() > containerSpecification.getWeight()) {
                throw new Exception("Box is too heavy for container");
            }
            // Need a bool so we can break out nested loops once it's been packed
            boolean itemHasBeenPacked = false;
            // for each container check for space
            for (Container container : containerList) {
                // skip to next container if current box is too heavy for this box
                if ((container.getCurrentWeight() + box.getWeight()) > containerSpecification.getWeight()) {
                    continue;
                }
                // cant remove spaces while looping over them
                // place holders variables for outside
                Space spaceToRemove = null;
                Placement newPlacement = null;
                // reverse through list so we use the most recent spaces in list
                for (int i = container.getSpaces().size()-1; i >= 0; i--) {
                    // try to place the product
                    newPlacement = place(box, container.getSpaces().get(i));
                    // if product isn't placed skip to next space
                    if (newPlacement == null) {
                        continue;
                    }
                    // add the placement to the current container
                    container.addPlacement(newPlacement);
                    // add weight to the container
                    container.addWeight(box.getWeight());
                    // space to be removed and broken up
                    spaceToRemove = container.getSpaces().get(i);
                    itemHasBeenPacked = true;
                    break;
                }
                if (itemHasBeenPacked) {
                    // remove space
                    container.getSpaces().remove(spaceToRemove);
                    // break up the remaining space
                    container.getSpaces().addAll(breakUpSpace(spaceToRemove, newPlacement));
                    // if the item has been placed break to next item
                    break;
                }
            }
            if (itemHasBeenPacked) {
                // if the item has been placed break to next item
                continue;
            }

            // If there is no container or current container is full then add new container
            Container container = new Container();
            // generate dimension size of the pod
            Dimension dimension = new Dimension(containerSpecification.getWidth(), containerSpecification.getDepth(), containerSpecification.getHeight());
            // start the position back at 0,0,0
            Position position = new Position(0,0,0);
            // store these in a space
            Space space = new Space(dimension, position);
            // try place the current product in the space
            Placement placement = place(box, space);

            if (placement == null) {
                throw new Exception("TOO BIG");
            }

            container.addPlacement(placement);
            container.addWeight(box.getWeight());
            container.getSpaces().addAll(breakUpSpace(space, placement));

            containerList.add(container);

        }

        System.out.println("Amount of containers: " + containerList.size());
        System.out.println("Amount of items packed in container 1: " + containerList.get(0).getPlacements().size());
        System.out.println("Placement data: " + containerList.get(0).getPlacements().toString());
    }

    private Placement place(Rectangle box, Space space) {
        List<Integer> boxDimensions = new ArrayList<>(Arrays.asList(box.getWidth(), box.getDepth(), box.getHeight()));
        boxDimensions.sort(Comparator.reverseOrder());
        // todo - sort by largest
        int width = boxDimensions.get(0);
        int depth = boxDimensions.get(1);
        int height = boxDimensions.get(2);
        // find all size permutations of the object (includes 3d)
        List<Dimension> permutationList = new ArrayList<>();
        permutationList.add(new Dimension(width, depth, height));
        permutationList.add(new Dimension(width, height, depth));
        permutationList.add(new Dimension(height, width, depth));
        permutationList.add(new Dimension(height, depth, width));
        permutationList.add(new Dimension(depth, width, height));
        permutationList.add(new Dimension(depth, height, width));

        for (Dimension permutation : permutationList) {
            if (permutation.getWidth()  <= space.getDimension().getWidth() &&
                permutation.getDepth()  <= space.getDimension().getDepth() &&
                permutation.getHeight() <= space.getDimension().getHeight()) {

                Dimension dimension = new Dimension(permutation.getWidth(), permutation.getDepth(), permutation.getHeight());
                Position position = new Position(space.getPosition().getWidth(), space.getPosition().getDepth(), space.getPosition().getHeight());

                return new Placement(dimension, position);


            }
        }
        return null;
    }

    public List<Space> breakUpSpace(Space space, Placement placement) {
        // ........................  ........................  .............
        // .                      .  .                      .  .           .
        // .                      .  .                      .  .           .
        // .    A                 .  .          A           .  .           .
        // .                      .  .                      .  .           .
        // .                B     .  .                      .  .    B      .
        // ............           .  ........................  .           .
        // .          .           .                            .           .
        // .          .           .                            .           .
        // ........................                            .............
        // Z is area above the placement


        // Generate space b
        // generate the size of space b
        Dimension dimensionB = new Dimension(
            (space.getDimension().getWidth() - placement.getDimensions().getWidth()),
            space.getDimension().getDepth(),
            space.getDimension().getHeight()
        );
        // generate the position of space b (bottom left)
        Position positionB = new Position(
            (space.getPosition().getWidth() + placement.getDimensions().getWidth()),
            space.getPosition().getDepth(),
            space.getPosition().getHeight()
        );
        Space spaceB = new Space(dimensionB, positionB);

        // Generate space A
        // generate the size of space A
        Dimension dimensionA = new Dimension(
            placement.getDimensions().getWidth(),
            (space.getDimension().getDepth() - placement.getDimensions().getDepth()),
            space.getDimension().getHeight()
        );
        // generate the location of space A (bottom left)
        Position positionA = new Position(
            space.getPosition().getWidth(),
            (space.getPosition().getDepth() + placement.getDimensions().getDepth()),
            space.getPosition().getHeight()
        );
        Space spaceA = new Space(dimensionA, positionA);

        // generate space z ( area above the placement)
        Dimension dimensionZ = new Dimension(
            placement.getDimensions().getWidth(),
            placement.getDimensions().getDepth(),
            (space.getDimension().getHeight() - placement.getDimensions().getHeight())
        );
        Position positionZ = new Position(
            space.getPosition().getWidth(),
            space.getPosition().getDepth(),
            (space.getPosition().getHeight() + placement.getDimensions().getHeight())
        );
        Space spaceZ = new Space(dimensionZ, positionZ);

        // return the generated spaces
        return new ArrayList<>(Arrays.asList(spaceB, spaceA, spaceZ));
    }



}

