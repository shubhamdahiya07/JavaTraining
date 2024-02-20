package CollectionFramework;

public class CustomListTest {
  public static void main(String[] args) {
    CustomList<Integer> list = new CustomList<>(10);
    list.add(1);
    list.add(2);
    list.add(3);
    list.get(0);
    list.remove(0);
    list.remove(0);
    list.remove(0);
    list.add(1);
    list.add(2);
    list.remove(3);

    for (Integer item : list) {
      System.out.println(item);
    }
  }
}
