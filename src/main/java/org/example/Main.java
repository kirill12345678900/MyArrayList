package org.example;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList1 = new MyArrayList<>();

        myArrayList1.add("a");
        myArrayList1.add("c");
        myArrayList1.add("arr");
        myArrayList1.add("t");
        myArrayList1.add("wq");


        myArrayList1.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o2.length(), o1.length());
            }
        });

        System.out.println(myArrayList1);
    }
}