package CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // adding 10 numbers in the list
        for (int i = 1; i <= 10; i++)
            list.add(i);

        // print the list
        System.out.println("Original list: " + list.toString());

        // deleting a value at a given index
        list.remove(0);

        System.out.println(list.toString());

        // getting a value at a given index
        System.out.println("Value at index 3: " + list.get(3));

        // adding two lists into one
        List<Integer> anotherList = new ArrayList<>();
        anotherList.add(10);
        anotherList.add(25);
        anotherList.add(-15);
        anotherList.add(0);

        list.addAll(anotherList);

        System.out.println("After adding two lists: " + list.toString());

        // Sorting the lists
        Collections.sort(list);
        System.out.println("Sorted list: " + list);
    }
}
