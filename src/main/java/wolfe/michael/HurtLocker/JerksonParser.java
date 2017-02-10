package wolfe.michael.HurtLocker;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by michaelwolfe on 2/9/17.
 */
public class JerksonParser {

    private String stringToParse;
    public List<GroceryItem> groceryItems;
    private Matcher matcher;

    public JerksonParser(String input){
        this.stringToParse = input;
        groceryItems = new ArrayList<GroceryItem>();
    }

    public String[] splitInputByEntry(String delimeter){
        return stringToParse.split(delimeter);
    }

    public String parseEntryForGroceryItemName(String entry) throws InvalidJerksonException{
        Pattern pattern = Pattern.compile("\\b[aAbBcCmM]\\w+");
        matcher = pattern.matcher(entry);

        String name = null;

        if(matcher.find()){
            name = matcher.group();
            name = name.toLowerCase();
        }

        if(name != null){
            Pattern pattern2 = Pattern.compile("\\b[cC]..[kK][iI][eE][sS]");
            matcher = pattern2.matcher(name);

            if(matcher.find()){
                name = "cookies";
            }
            return name;
        }
        else{
            throw new InvalidJerksonException();
        }

    }

    public Double parseEntryForGroceryItemPrice(String entry) throws InvalidJerksonException{
        Pattern pattern = Pattern.compile("\\b\\d+\\.\\d+");
        matcher = pattern.matcher(entry);

        String stringPrice = null;
        Double price = null;

        if(matcher.find()){
            stringPrice = matcher.group();
            price = Double.parseDouble(stringPrice);
        }

        if(price != null){
            return price;
        } else {
            throw new InvalidJerksonException();
        }
    }

    public List<GroceryItem> parseInputToGroceryItemsList(){
        String[] inputEntries = splitInputByEntry("##");
        GroceryItem temp = null;

        for(int i = 0; i < inputEntries.length; i++){
            try{
                temp = parseEntryToGroceryItem(inputEntries[i]);
            } catch (InvalidJerksonException e){

            }

            if(temp != null){
                groceryItems.add(temp);
            }
        }
        return groceryItems;
    }

    public GroceryItem parseEntryToGroceryItem(String entry) throws InvalidJerksonException{
        String name = parseEntryForGroceryItemName(entry);
        Double price = parseEntryForGroceryItemPrice(entry);
        return new GroceryItem(name, price);
    }
}
