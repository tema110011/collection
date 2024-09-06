import java.util.*;

public class MyArrayList<T> {
    private int size;
    private int capacity;
    private Object[] elements;
    private boolean sorted = false;
    private static final int DEFAULT_CAPACITY = 10;
    private static boolean flag = false;


    public MyArrayList() {
        size = 0;
        capacity = DEFAULT_CAPACITY;
        elements = (T[]) new Object[capacity];
    }

    public MyArrayList(Collection <? extends T> collection){
        if (!collection.isEmpty()){
            size = 0;
            capacity = collection.size() + collection.size()/2;
            elements = new Object[capacity];
            addAll(collection);
        }

    }

    public int getSize() {
        return size;
    }

    /**
     * вставка в конец
     */
    public void add(T element) {
        if (size == capacity) {
            grow();
        }
        elements[size] = element;
        size++;
        flag = false;
    }

    private void grow() {
        capacity = capacity + (capacity / 2);
        Object[] elementsCopy = Arrays.copyOf(elements, capacity);
        elements = elementsCopy;
    }

    /**
     * получение элемента по индексу
     */
    public T get(int index) {
        if (index >= 0 && index < size)return (T) elements[index];
        return null;
    }

    /**
     * удаление по индексу
     */
    public void remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < elements.length - 1; i++) {
                elements[i] = elements[i + 1];
                elements[i + 1] = null;
            }
            size--;
        }
    }

    /**
     * добавляет в конец все элементы переданной коллекции
     */
    public void addAll(Collection collection) {
        for (Object o : collection) {
            add((T) o);
        }
    }

    private T[] getElements() {
        return (T[]) elements;
    }

    /**
     * добавляет в конец все элементы переданной коллекции
     */
    public void addAll(MyArrayList collection) {
        T[] buffer = (T[]) collection.getElements();
        for (int i = 0; i < buffer.length; i++) {
            add(buffer[i]);
        }
    }

    public void sortBubble(){
        bubbleSort(elements, size);
    }

    /**
     * - сортировка пузырьком с флагом
     */
    private static <T extends Comparable<? super T>> void bubbleSort(Object[] collection, int sizeCollection) {
        if (flag == false) {
            for (int i = 0; i < sizeCollection - 1; i++) {
                flag = true;
                for (int j = 0; j < sizeCollection - 1 - i; j++) {
                    if (((Comparable<T>) collection[j]).compareTo((T) collection[j + 1]) > 0) {
                        Object temp = collection[j];
                        collection[j] = collection[j + 1];
                        collection[j + 1] = temp;
                    }
                }
            }
        }
    }

    /**
     * - статичная сортировка пузырьком переданной внутрь коллекции
     */
    public static <T extends Comparable<? super T>> List<T> staticBubbleSort(List<T> list) {
        Object[] myArray = list.toArray(new Object[0]);
        bubbleSort(myArray, myArray.length);

        ArrayList<T> newMyList = new ArrayList<T>();
        for (Object obj : myArray)
            newMyList.add((T) obj);

        return newMyList;

    }
}
