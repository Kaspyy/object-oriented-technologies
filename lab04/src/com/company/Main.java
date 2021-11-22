package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Tuple<Integer, String, Double> tuple1 = new Tuple<>(1, "jeden", 1.0);
        Tuple<Integer, String, Double> tuple2 = new Tuple<>(1, "jeden", 1.0);
        Tuple<Integer, String, Double> tuple3 = new Tuple<>(4, "cztery", 4.0);
        Tuple<Integer, String, Double> tuple4 = new Tuple<>(3, "trzy", 3.0);
        Tuple<Integer, String, Double> tuple5 = new Tuple<>(5, "pięć", 5.0);

        System.out.println("tuple1 " + tuple1);
        System.out.println("tuple2 " + tuple2);
        System.out.println("tuple3 " + tuple3);
        System.out.println("tuple4 " + tuple4);
        System.out.println("tuple5 " + tuple5);

        System.out.println("\ntuple1.equals(tuple2) " + tuple1.equals(tuple2));
        System.out.println("tuple1.equals(tuple3) " + tuple1.equals(tuple3));

        List<Tuple<Integer, String, Double>> list = new ArrayList<>();
        list.add(tuple1);
        list.add(tuple2);
        list.add(tuple3);
        list.add(tuple4);
        list.add(tuple5);

        System.out.println("\nPrzed sortowaniem");
        for (var i: list) {
            System.out.println(i);
        }

        System.out.println("\nPo sortowaniu");
        Collections.sort(list);
        for (var i: list) {
            System.out.println(i);
        }

    }
}