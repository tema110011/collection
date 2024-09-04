import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        MyArrayList<Integer> myArrayList1 = new MyArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 20; i < 25; i++) {
            list.add(i);
        }
        MyArrayList<Integer> myArrayListCollection = new MyArrayList<>(list);
        for (int i = 0; i < myArrayListCollection.getSize(); i++) {
            System.out.println(myArrayListCollection.get(i));
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < 10; i++){
            myArrayList.add(i);
            myArrayList1.add(i);
        }
        myArrayList.remove(2);
        myArrayList.remove(4);


        myArrayList.addAll(list);
        myArrayList.addAll(myArrayList1);
        myArrayList.sortBubble();
        myArrayList.add(56);
        myArrayList.sortBubble();
        for (int i = 0; i < myArrayList.getSize(); i++){
            System.out.println(myArrayList.get(i));
        }

    }
}