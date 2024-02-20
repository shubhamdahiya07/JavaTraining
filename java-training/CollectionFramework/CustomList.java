package CollectionFramework;

import java.util.Iterator;

public class CustomList<T> implements Iterable<T> {
  private T[] list;
  private int size;
  private int capacity;

  CustomList(int capacity) {
    this.capacity = capacity;
    list = (T[]) new Object[capacity];
    size = 0;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public T get(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();
    return list[index];
  }

  public boolean add(T item) {
    // increase capacity if full
    if (size == capacity)
      resize(false);

    list[size++] = item;
    return true;
  }

  public void remove(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();
    for (int i = index; i < size - 1; i++) {
      list[i] = list[i + 1];
    }
    size--;
    // shrink capacity if 1/4th full
    if (size == capacity / 4)
      resize(true);
  }

  private void resize(boolean shrink) {
    int newCapacity = shrink ? capacity / 2 : capacity * 2;
    T[] newList = (T[]) new Object[newCapacity];
    for (int i = 0; i < size; i++) {
      newList[i] = list[i];
    }
    list = newList;
    capacity = newCapacity;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");

    for (int i = 0; i < size; i++) {
      sb.append(list[i]);
      if (i != size - 1)
        sb.append(", ");
    }

    sb.append("]");
    return sb.toString();
  }

  @Override
  public Iterator<T> iterator() {
    return new CustomIterator();
  }

  // Implements iterator in private inner class
  private class CustomIterator implements Iterator<T> {
    private int index;

    CustomIterator() {
      index = 0;
    }

    @Override
    public boolean hasNext() {
      return index < size;
    }

    @Override
    public T next() {
      return list[index++];
    }
  }

}
