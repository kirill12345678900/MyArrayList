package org.example;

import java.util.Collection;
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


        MyArrayList<Integer> myArrayList2 = new MyArrayList<>();

        myArrayList2.add(1);
        myArrayList2.add(2);
        myArrayList2.add(3);
        myArrayList2.add(4);
        myArrayList2.add(5);

        MyArrayList<Integer> myArrayList3 = new MyArrayList<>();

        myArrayList3.add(6);
        myArrayList3.add(7);
        myArrayList3.add(8);
        myArrayList3.add(9);
        myArrayList3.add(10);
        myArrayList3.add(6);
        myArrayList3.add(7);
        myArrayList3.add(8);
        myArrayList3.add(9);
        myArrayList3.add(10);
        myArrayList3.add(6);
        myArrayList3.add(7);
        myArrayList3.add(8);
        myArrayList3.add(9);
        myArrayList3.add(10);

        myArrayList2.addAll(myArrayList3);

        System.out.println(myArrayList2);



    }
}