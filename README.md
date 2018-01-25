# java_box_packer

First fit heuristic algorithm for 3D bin-packing.

Java implementation of [box_packer](https://github.com/mushishi78/box_packer)

Weight functionality has not been ported across (yet...)

### Usage

You will find the below snippet in the main class of the codebase as well:

``` java 
Rectangle container = new Rectangle("Container",60,38,3);
Rectangle box1 = new Rectangle("Box1", 60,38,1);
Rectangle box2 = new Rectangle("Box2", 30,19,1);
Rectangle box3 = new Rectangle("Box3", 30,19,1);
Rectangle box4 = new Rectangle("Box4", 30,19,1);
Rectangle box5 = new Rectangle("Box5", 30,19,1);
Rectangle box6 = new Rectangle("Box6", 30,20,1);
Rectangle box7 = new Rectangle("Box7", 20,10,1);



List<Rectangle> boxList = new ArrayList<>(Arrays.asList(box1, box2, box3, box4, box5, box6, box7));

Logic logic = new Logic();
logic.doLogic(container, boxList);

```