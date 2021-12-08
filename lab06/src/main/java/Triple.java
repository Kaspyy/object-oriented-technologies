import java.util.Objects;
import java.util.Comparator;

public class Triple <V1 extends Comparable<V1>, V2 extends Comparable<V2>, V3 extends Comparable<V3>> implements Comparable<Triple<V1, V2, V3>>, Comparator<Triple <V1, V2, V3>>{
    private V1 first;
    private V2 second;
    private V3 third;

    public Triple(V1 first, V2 second, V3 third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public V1 getFirst() {
        return first;
    }

    public V2 getSecond() {
        return second;
    }

    public V3 getThird() {
        return third;
    }

    public void setFirst(V1 first) {
        this.first = first;
    }

    public void setSecond(V2 second) {
        this.second = second;
    }

    public void setThird(V3 third) {
        this.third = third;
    }

    @Override
    public String toString() {
        return String.format("Triple<%s, %s, %s>", first, second, third);
    }

    public String getFirstType () {
        return first.getClass().getTypeName();
    }

    public String getSecondType () {
        return second.getClass().getTypeName();
    }

    public String getThirdType () {
        return third.getClass().getTypeName();
    }

    public boolean isHomogeneous() {
        if (getFirstType().equals(getSecondType()) && getSecondType().equals(getThirdType())) {
            return true;
        }
            return false;
    }

    public Triple<V1,V2,V3> min(Triple<V1,V2,V3> t1, Triple<V1,V2,V3> t2) {
        Triple<V1, V2,V3> t3 = new Triple<>( null, null,  null);
        if(t1.getFirst().compareTo(t2. getFirst()) <= 0)
            t3.setFirst(t1.getFirst());
        else
            t3.setFirst(t2.getFirst());
        if(t1.getSecond ().compareTo(t2.getSecond()) <= 0)
            t3.setSecond (t1.getSecond ());
        else
            t3. setSecond (t2.getSecond());
        if(t1.getThird().compareTo(t2.getThird()) <= 0)
            t3.setThird(t1.getThird());
        else
            t3.setThird(t2.getThird());
        return t3;
    }

    public Triple<V1,V2,V3> max(Triple<V1,V2,V3> t1, Triple<V1,V2,V3> t2) {
        Triple<V1, V2,V3> t3 = new Triple<>( null, null,  null);
        if(t1.getFirst().compareTo(t2. getFirst()) >= 0)
            t3.setFirst(t1.getFirst());
        else
            t3.setFirst(t2.getFirst());
        if(t1.getSecond ().compareTo(t2.getSecond()) >= 0)
            t3.setSecond (t1.getSecond ());
        else
            t3. setSecond (t2.getSecond());
        if(t1.getThird().compareTo(t2.getThird()) >= 0)
            t3.setThird(t1.getThird());
        else
            t3.setThird(t2.getThird());
        return t3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
        return Objects.equals(first, triple.first) && Objects.equals(second, triple.second) && Objects.equals(third, triple.third);
    }

    @Override
    public int compare(Triple<V1, V2, V3> o1, Triple<V1, V2, V3> o2) {
        return 0;
    }


    @Override
    public int compareTo(Triple<V1, V2, V3> o) {
        return 0;
    }
}
