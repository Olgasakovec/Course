import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main (String []args){

        List<HeavyBox> heavyBoxes = new ArrayList<>();

        HeavyBox box1 = new HeavyBox(20);
        HeavyBox box2 = new HeavyBox(30);
        HeavyBox box3 = new HeavyBox(15);
        HeavyBox box4 = new HeavyBox(5);

        heavyBoxes.add(box1);
        heavyBoxes.add(box2);
        heavyBoxes.add(box3);
        heavyBoxes.add(box4);

        for (HeavyBox box : heavyBoxes) {
            System.out.println(box);
        }

        box1.setWeight(10);
        box2.setWeight(box1.getWeight());

        int deleteIndex = heavyBoxes.size() - 2;
        heavyBoxes.remove(deleteIndex);

        HeavyBox[] heavyBoxesArray1 = heavyBoxes.toArray (new HeavyBox[0]);
        System.out.println("\nМассив ящиков номер 1");
        for (HeavyBox heavyBox : heavyBoxesArray1) {
            System.out.println(heavyBox.getWeight());
        }

        HeavyBox[] heavyBoxesArray2 = new HeavyBox[heavyBoxes.size()];
        for (int i = 0; i < heavyBoxes.size(); i++) {
            heavyBoxesArray2[i] = heavyBoxes.get(i);
        }

        System.out.println(("\nМассив ящиков номер 2"));
        for (HeavyBox heavyBox : heavyBoxesArray2) {
            System.out.println(heavyBox.getWeight());
        }

        int prevWeight = -1;
        Iterator<HeavyBox> iterator = heavyBoxes.iterator();
        while (iterator.hasNext()) {
            HeavyBox heavyBox = iterator.next();
            if (prevWeight == -1) {
                prevWeight = heavyBox.getWeight();
            }
            else {
                if (heavyBox.getWeight()!= prevWeight) {
                    iterator.remove();
                }
            }
        }
    }
}