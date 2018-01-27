# java_box_packer

First fit heuristic algorithm for 3D bin-packing.

Java implementation of [box_packer](https://github.com/mushishi78/box_packer)


### Usage

You will find the below snippet in the main class of the codebase as well:

``` java 
Rectangle container = new Rectangle("Container",60,38,3, 50);
Rectangle box1 = new Rectangle("Box1", 60,38,1, 30);
Rectangle box2 = new Rectangle("Box2", 30,19,1, 20);
Rectangle box3 = new Rectangle("Box3", 30,19,1, 20);
Rectangle box4 = new Rectangle("Box4", 30,19,1, 10);
Rectangle box5 = new Rectangle("Box5", 30,19,1, 10);
Rectangle box6 = new Rectangle("Box6", 30,20,1, 5);
Rectangle box7 = new Rectangle("Box7", 20,10,1, 5);

List<Rectangle> boxList = new ArrayList<>(Arrays.asList(box1, box2, box3, box4, box5, box6, box7));

Packer packer = new Packer();
packer.pack(container, boxList);

```

#Output: 
```
Amount of containers: 2
Amount of items packed in container 1: 2
Placement data: [Placement{dimensions=Dimension{width=60, depth=38, height=1}, positions=Position{width=0, depth=0, height=0}}, Placement{dimensions=Dimension{width=30, depth=19, height=1}, positions=Position{width=0, depth=0, height=1}}]
```