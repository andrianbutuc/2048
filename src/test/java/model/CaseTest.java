package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CaseTest {
    @Test
    void createCase1(){
         new Case(1,0);
    }

    @Test
    void createCase2(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Case(-1,0));

    }
    @Test
    void getValue() {
        Case c = new Case(0,0);
        int result = c.getValue();
        int resultExpected = 0 ;
        assertEquals(result, resultExpected);
    }
    @Test
    void isEmptyTrue() {
        Case c = new Case(0,0);
        boolean result = c.isEmpty();
        assertTrue(result);
    }
    @Test
    void isEmptyFalse() {
        Case c = new Case(0,0);
        c.setValue(2);
        boolean result = c.isEmpty();
        assertFalse(result);

    }
    @Test
    void setValue() {
        Case c = new Case(0,0);
        c.setValue(2);
        int result = c.getValue();
        int resultExpected = 2 ;
        assertEquals(result, resultExpected);
    }

    @Test
    void getLine() {
        Case c = new Case(1,0);
        int result = c.getLine();
        int resultExpected = 1 ;
        assertEquals(result, resultExpected);
    }

    @Test
    void getColumn() {
        Case c = new Case(1,3);
        int result = c.getColumn();
        int resultExpected = 3;
        assertEquals(result, resultExpected);
    }

    @Test
    void mergeTrue() {
        Case c = new Case(1, 3);
        Case c2 = new Case(2, 3);
        c.setValue(4);
        c2.setValue(4);
        boolean result = c.merge(c2);
        assertTrue(result);
    }

    @Test
    void mergeCaseNull() {
        Case c = new Case(1, 3);
        c.setValue(4);
        boolean result = c.merge(null);
        assertFalse(result);
    }

    @Test
    void mergeFalse() {
        Case c = new Case(1, 3);
        Case c2 = new Case(2, 3);
        c.setValue(4);
        c2.setValue(2);
        boolean result = c.merge(c2);
        assertFalse(result);
    }
}