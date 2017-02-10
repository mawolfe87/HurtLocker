package wolfe.michael.HurtLockerTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import wolfe.michael.HurtLocker.GroceryItem;

/**
 * Created by michaelwolfe on 2/9/17.
 */
public class GroceryItemTest {

    GroceryItem itemOne;
    GroceryItem itemTwo;
    GroceryItem itemThree;

    @Before
    public void setUp(){
        itemOne = new GroceryItem("milk", 3.29);
        itemTwo = new GroceryItem("cookies", 2.99);
        itemThree = new GroceryItem("apples", 0.99);
    }

    @Test
    public void getNameTest(){
        String expected = "milk";
        String actual = itemOne.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest(){
        Double expected = 2.99;
        Double actual = itemTwo.getPrice();
        Assert.assertEquals(expected, actual);
    }
}
