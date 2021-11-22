package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Tuple <T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>> implements Comparable<Tuple<T1, T2, T3>>, Comparator<Tuple<T1, T2, T3>> {
    private T1 first;
    private T2 second;
    private T3 third;

    public Tuple(T1 first, T2 second, T3 third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public T3 getThird() {
        return third;
    }

    @Override
    public String toString() {
        return String.format("Tuple<%s, %s, %s>", first, second, third);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple<?, ?, ?> tuple = (Tuple<?, ?, ?>) o;
        return Objects.equals(first, tuple.first) && Objects.equals(second, tuple.second) && Objects.equals(third, tuple.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    @Override
    public int compareTo(Tuple<T1, T2, T3> o) {
        if (this.getFirst().compareTo(o.getFirst()) < 0) {
            return -1;
        }

        if (this.getFirst().compareTo(o.getFirst()) > 0) {
            return 1;
        }

        if (this.getSecond().compareTo(o.getSecond()) < 0) {
            return -1;
        }

        if (this.getSecond().compareTo(o.getSecond()) > 0) {
            return 1;
        }

        if (this.getThird().compareTo(o.getThird()) == 0) {
            return 0;
        }

        return 0;
    }

    @Override
    public int compare(Tuple<T1, T2, T3> o1, Tuple<T1, T2, T3> o2) {
        return Collections.reverseOrder().compare(o1, o2);
    }
}
