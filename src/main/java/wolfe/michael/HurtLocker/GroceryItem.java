package wolfe.michael.HurtLocker;

import java.util.List;

/**
 * Created by michaelwolfe on 2/9/17.
 */
public class GroceryItem {

    private String name;
    private double price;

    public GroceryItem(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    @Override
    public String toString(){
        return "name: " + name + "\t" + "price: " + price;
    }

}
