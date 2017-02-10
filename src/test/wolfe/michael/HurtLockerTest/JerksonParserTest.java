package wolfe.michael.HurtLockerTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import wolfe.michael.HurtLocker.GroceryItem;
import wolfe.michael.HurtLocker.JerksonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michaelwolfe on 2/9/17.
 */
public class JerksonParserTest {

    String rawData;
    JerksonParser parser;
    GroceryItem milkOne;
    GroceryItem milkTwo;
    GroceryItem breadOne;
    GroceryItem cookiesOne;
    GroceryItem applesOne;
    GroceryItem applesTwo;
    List<GroceryItem> list;
    List<GroceryItem> groceryList;


    @Before
    public void setUp(){
        list = new ArrayList<GroceryItem>();
        rawData = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##\n";
        parser = new JerksonParser(rawData);
        milkOne = new GroceryItem("milk", 3.23);
        list.add(milkOne);
        milkTwo = new GroceryItem("milk", 1.23);
        list.add(milkTwo);
        breadOne = new GroceryItem("Bread", 1.23);
        list.add(breadOne);
        cookiesOne = new GroceryItem("cookies", 2.25);
        list.add(cookiesOne);
        applesOne = new GroceryItem("apples", 0.25);
        list.add(applesOne);
        applesTwo = new GroceryItem("apples", 0.23);
        list.add(applesTwo);
        groceryList = parser.parseInputToGroceryItemsList();
    }

    @Test
    public void parseInputToGroceryItemsListTest(){
        int expected = 28;
        int actual = groceryList.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void splitInputByEntryTest(){
        String[] expected = {"naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##", "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##", "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##", "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##", "naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##", "naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##", "naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##", "naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##", "NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##", "naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##", "naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##", "naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##", "NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##", "naMe:;price:3.23;type:Food;expiration:1/04/2016##", "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##", "naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##", "NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##", "naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##", "naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##", "naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##", "naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##", "naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##", "NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##", "naMe:MilK;priCe:;type:Food;expiration:4/25/2016##", "naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##", "naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##", "NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##", "naMe:;price:3.23;type:Food^expiration:1/04/2016##"};
        String[] actual = parser.splitInputByEntry("##");
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void parseEntryToGroceryItemTest(){
        list.clear();
        rawData = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        parser = new JerksonParser(rawData);
        list = parser.parseInputToGroceryItemsList();
        String expected = "name: milk   price: 3.23";
        String actual = list.get(0).toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parseEntryForGroceryItemNameTest(){
        list.clear();
        rawData = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        parser = new JerksonParser(rawData);
        list = parser.parseInputToGroceryItemsList();
        String expected = "milk";
        String actual = list.get(0).getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parseEntryForGroceryItemPriceTest(){
        list.clear();
        rawData = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        parser = new JerksonParser(rawData);
        list = parser.parseInputToGroceryItemsList();
        Double expected = 3.23;
        Double actual = list.get(0).getPrice();
        Assert.assertEquals(expected, actual, 0.00001);
    }
}
