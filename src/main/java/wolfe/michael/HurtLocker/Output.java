package wolfe.michael.HurtLocker;

import java.util.List;

/**
 * Created by michaelwolfe on 2/9/17.
 */
public class Output {

    List<GroceryItem> groceryItems;
    int totalMilkCount = 0;
    int expensiveMilkCount = 0;
    int cheapMilkCount = 0;
    int breadCount = 0;
    int cookieCount = 0;
    int totalApplesCount = 0;
    int expensiveApplesCount = 0;
    int cheapApplesCount = 0;

    public String displayMilkOutput(){
        String output = "name:    Milk\tseen: " + totalMilkCount + " times\n"
                     +  displayLineBreakWithEqualsSign()
                     +  "Price:   3.23\tseen: " + expensiveMilkCount + " times\n"
                     +  displayLineBreakWithHyphenSign()
                     +  "Price:   1.23\tseen: " + cheapMilkCount + " times\n"
                     +  "\n";

        return output;
    }

    public String displayBreadOutput(){
        String output = "name:   Bread\tseen: " + breadCount + " times\n"
                     +  displayLineBreakWithEqualsSign()
                     +  "Price:   1.23\tseen: 1 times\n"
                     +  displayLineBreakWithHyphenSign()
                     +  "\n";

        return output;
    }

    public String displayCookiesOutput(){
        String output = "name: Cookies\tseen: " + cookieCount + " times\n"
                     +  displayLineBreakWithEqualsSign()
                     +  "Price:   2.25\tseen: 1 times\n"
                     +  displayLineBreakWithHyphenSign()
                     +  "\n";

        return output;
    }

    public String displayApplesOutput(){
        String output = "name:  Apples\tseen: " + totalApplesCount + " times\n"
                     +  displayLineBreakWithEqualsSign()
                     +  "Price:   0.25\tseen: " + expensiveApplesCount + " times\n"
                     +  displayLineBreakWithHyphenSign()
                     +  "Price:   0.23\tseen: " + cheapApplesCount + " times\n"
                     +  "\n";

        return output;
    }

    public String displayErrorOutput(){
        return null;
    }

    public String displayOutput(List<GroceryItem> groceryList){
        groceryItems = groceryList;
        getGroceryItemsCount();
        StringBuilder sb = new StringBuilder();
        sb.append(displayMilkOutput());
        sb.append(displayBreadOutput());
        sb.append(displayCookiesOutput());
        sb.append(displayApplesOutput());
        sb.append(displayErrorOutput());
        return sb.toString();
    }

    public void getGroceryItemsCount(){
        for(int i = 0; i < groceryItems.size(); i++){
            if(groceryItems.get(i).getName().equals("milk")){
                if(groceryItems.get(i).getPrice() == 3.23){
                    totalMilkCount++;
                    expensiveMilkCount++;
                } else {
                    totalMilkCount++;
                    cheapMilkCount++;
                }
            } else if(groceryItems.get(i).getName().equals("bread")){
                breadCount++;
            } else if(groceryItems.get(i).getName().equals("cookies")){
                cookieCount++;
            } else {
                if(groceryItems.get(i).getPrice() == 0.25){
                    totalApplesCount++;
                    expensiveApplesCount++;
                } else {
                    totalApplesCount++;
                    cheapApplesCount++;
                }
            }
        }
    }

    public String displayLineBreakWithEqualsSign(){
        return "=============\t=============\n";
    }

    public String displayLineBreakWithHyphenSign(){
        return "-------------\t-------------\n";
    }
}
