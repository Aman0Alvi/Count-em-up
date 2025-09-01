package org.example;

public class App {
    public String getGreeting() {
        return "GroceryCounter demo starting…";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        GroceryCounter counter = new GroceryCounter(); 
        counter.tens();
        counter.tens();
        counter.hundreths();
        System.out.println(counter.total());       
        System.out.println(counter.overflows());   

        for (int i = 0; i < 35; i++) counter.ones();
        System.out.println(counter.total());      
        System.out.println(counter.overflows());   

        for (int i = 0; i < 100; i++) counter.ones();
        System.out.println(counter.total());     
        System.out.println(counter.overflows()); 

        counter.clear();
        System.out.println(counter.total());     
        System.out.println(counter.overflows());   

        GroceryCounter custom = new GroceryCounter(50, 200); 
        custom.increment(201); 
        System.out.println(custom.total());        
        System.out.println(custom.overflows());    

        custom.decrementHundreths();            
        System.out.println(custom.total());     
        System.out.println(custom.overflows());   
    }
}
