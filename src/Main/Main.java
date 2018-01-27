package Main;

import packing.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

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

    }

}
