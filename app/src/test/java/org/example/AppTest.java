package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void defaultCounterStartsAtZero() {
        GroceryCounter c = new GroceryCounter();
        assertEquals("$0.00", c.total());
        assertEquals(0, c.overflows());
        assertEquals(0, c.rawValue());
    }

    @Test
    void eachButtonOnce() {
        GroceryCounter c = new GroceryCounter();
        c.tens();     
        assertEquals("$10.00", c.total());
        c.clear();

        c.ones();     
        assertEquals("$1.00", c.total());
        c.clear();

        c.tenths();   
        assertEquals("$0.10", c.total());
        c.clear();

        c.hundreths(); 
        assertEquals("$0.01", c.total());
    }

    @Test
    void mixedButtonsMatchSpec() {
        GroceryCounter c = new GroceryCounter();
        c.tens();
        c.tens();
        c.hundreths();
        assertEquals("$20.01", c.total());
        assertEquals(0, c.overflows());
    }

    @Test
    void loopsFromSpec() {
        GroceryCounter c = new GroceryCounter();
        c.tens(); c.tens(); c.hundreths(); 

        for (int i = 0; i < 35; i++) c.ones(); 
        assertEquals("$55.01", c.total());
        assertEquals(0, c.overflows());

        for (int i = 0; i < 100; i++) c.ones(); 
        assertEquals("$55.01", c.total());
        assertEquals(1, c.overflows());
    }

    @Test
    void overflowFromMaxBoundary() {
        GroceryCounter c = new GroceryCounter(9999);
        c.hundreths(); 
        assertEquals("$0.00", c.total());
        assertEquals(1, c.overflows());
    }

    @Test
    void multipleWrapsCounted() {
        GroceryCounter c = new GroceryCounter();
        for (int i = 0; i < 250; i++) c.ones();
        assertEquals(2, c.overflows());
        assertEquals("$50.00", c.total()); 
    }

    @Test
    void clearResetsAll() {
        GroceryCounter c = new GroceryCounter();
        for (int i = 0; i < 100; i++) c.ones();
        assertEquals(1, c.overflows());
        c.clear();
        assertEquals("$0.00", c.total());
        assertEquals(0, c.overflows());
    }

    @Test
    void customStartAndMax() {
        GroceryCounter c = new GroceryCounter(50, 200); 
        assertEquals("$0.50", c.total());

        for (int i = 0; i < 201; i++) c.hundreths();
        assertEquals("$0.50", c.total());
        assertEquals(1, c.overflows());
    }

    @Test
    void invalidConstructorArgsThrow() {
        assertThrows(IllegalArgumentException.class, () -> new GroceryCounter(-1));
        assertThrows(IllegalArgumentException.class, () -> new GroceryCounter(0, -5));
        assertThrows(IllegalArgumentException.class, () -> new GroceryCounter(10, 5));
    }
}
