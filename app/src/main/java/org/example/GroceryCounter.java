package org.example;

public class GroceryCounter {
    private int value;            
    private int maxValue;        
    private int overflowCount;   

    public GroceryCounter() {
        this(0, 9999);
    }

    public GroceryCounter(int startValue) {
        this(startValue, 9999);
    }

    public GroceryCounter(int startValue, int maxValue) {
        if (maxValue < 0) {
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
        if (startValue < 0 || startValue > maxValue) {
            throw new IllegalArgumentException("startValue must be in [0, maxValue]");
        }
        this.value = startValue;
        this.maxValue = maxValue;
        this.overflowCount = 0;
    }

    public void tens() { applyIncrement(1000); }  
    public void ones() { applyIncrement(100); } 
    public void tenths() { applyIncrement(10); }  
    public void hundreths() { applyIncrement(1); }    

    public void increment(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be >= 0");
        }
        applyIncrement(amount);
    }

    private void applyIncrement(int amount) {
        int modulus = maxValue + 1; 
        long sum = (long) value + (long) amount; 
        long wraps = sum / modulus;
        if (wraps > 0) {
            overflowCount += (int) wraps;
        }
        value = (int) (sum % modulus);
    }

    public void decrementTens() { applyDecrement(1000); }
    public void decrementOnes() { applyDecrement(100); }
    public void decrementTenths() { applyDecrement(10); }
    public void decrementHundreths() { applyDecrement(1); }

    private void applyDecrement(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be >= 0");
        }
        int modulus = maxValue + 1;
        int a = amount % modulus;     
        value -= a;
        if (value < 0) value += modulus;
    }

    public String total() {
        int dollars = value / 100;
        int cents = value % 100;
        return String.format("$%d.%02d", dollars, cents);
    }

    public int overflows() {
        return overflowCount;
    }

    public void clear() {
        value = 0;
        overflowCount = 0;
    }

    public int rawValue() { return value; }
    public int getMaxValue() { return maxValue; }
}
