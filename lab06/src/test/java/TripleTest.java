import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TripleTest {

    Triple <Integer, String, Integer> t1 = new Triple<>(5, "a", 21);
    Triple <Integer, String, Integer> t2 = new Triple<>(5, "a", 21);
    Triple <Integer, String, Integer> t3 = new Triple<>(5, "b", 22);
    Triple <Integer, String, Double> t4 = new Triple<>(5, "b", 22.0);



    @Test
    void getFirst() {
        Assertions.assertEquals(5, t1.getFirst());
    }

    @Test
    void getFirstNull() {
        Triple <Integer, String, Integer> t1 = new Triple<>(null, "a", 21);
        assertNull(t1.getFirst());
    }

    @Test
    void getSecond() {
        Assertions.assertEquals("a", t1.getSecond());
    }

    @Test
    void getThird() {
        Assertions.assertEquals(21, t1.getThird());
    }

    @Test
    void testToString() {
        Assertions.assertEquals("Triple<5, a, 21>", t1.toString());
    }

    @Test
    void getFirstType() {
        Assertions.assertEquals("java.lang.Integer", t4.getFirstType());
    }

    @Test
    void getSecondType() {
        Assertions.assertEquals("java.lang.String", t4.getSecondType());
    }

    @Test
    void getThirdType() {
        Assertions.assertEquals("java.lang.Double", t4.getThirdType());
    }

    @Test
    void min() {
        Triple<Integer, String, Integer> t_test = new Triple<>( 5, "a",  21);
        Assertions.assertEquals(t_test, t1.min(t1, t3));
    }


    @Test
    void max() {
        Triple<Integer, String, Integer> t_test = new Triple<>( 5, "b",  22);
        Assertions.assertEquals(t_test, t1.max(t1, t3));
    }

    @Test
    void shouldReturnTrueWhenisHomogeneous() {
        Triple <Integer, Integer, Integer> tripleHomogeneous = new Triple<>(5, 21, 22);
        assertTrue(tripleHomogeneous.isHomogeneous());
    }

    @Test
    void shouldReturnFalseWhenisNotHomogeneous() {
        Triple <Integer, String, Integer> tripleNotHomogeneous = new Triple<>(5, "21", 22);
        assertFalse(tripleNotHomogeneous.isHomogeneous());
    }

    @Test
    void shouldReturnTrueWhenEquals() {
        assertEquals(t1, t2);
    }
    @Test
    void shouldReturnFalseWhenNotEquals() {
        assertNotEquals(t1, t3);
    }
}