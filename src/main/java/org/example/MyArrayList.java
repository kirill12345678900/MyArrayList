package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class MyArrayList<T> {

    private T[] list;

    public T[] getList() {
        return list;
    }

    private int size;
    private final int DEFAULT_CAPACITY = 10;


    public MyArrayList(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException();
        } else {
            list = (T[]) new Object[capacity];
            size = 0;
        }
    }

    public MyArrayList() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    private void ensureLength(int addElement) {
        int requiredLength = size + addElement;
        if (requiredLength > list.length) {
            int newLength = requiredLength * 2;
            T[] newList = (T[]) new Object[newLength];
            for (int i = 0; i < size; ++i)
                newList[i] = list[i];
            list = newList;
        }
    }

    public boolean add(T item) {
        ensureLength(1);
        list[size++] = item;
        return false;
    }

    public void add(int index, T item) {
        ensureLength(1);
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }

    public void delete(int index) {
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        size--;
    }

    public void deleteAll() {
        for (int i = 0; i < size; ++i) {
            list[i] = null;
        }
        size = 0;
    }

    public T get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        return list[index];
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[" + list[0]);

        for (int i = 1; i < size; i++) {
            result.append(", ").append(list[i]);
        }
        result.append("]");
        return result.toString();
    }


    public void sort(Comparator<T> c) {
        bubbleSortArrayList(list,c);
    }

    public <T> void bubbleSortArrayList(T[] list, Comparator<? super T> c) {
        T temp;
        int size = list.length;
        boolean flag = true;

        while (flag) {
            flag = false;
            for (int i = 0; i < size - 1; i++) {
                for (int j = 0; j < size - i - 1; j++) {
                    if (list[j] != null && list[j + 1] != null) {
                        if (c.compare(list[j + 1], list[j]) > 0) {
                            temp = list[j];
                            list[j] = list[j + 1];
                            list[j + 1] = temp;
                            flag = true;
                        }
                    }
                }
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void addAll(MyArrayList<? extends T> c) {
        T[] a = c.getList();
        int numNew = c.getSize();
        ensureLength(size + numNew);
        System.arraycopy(a, 0, list, size, numNew);
        size += numNew;
    }

}
