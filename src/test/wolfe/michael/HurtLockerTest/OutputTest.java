package wolfe.michael.HurtLockerTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import wolfe.michael.HurtLocker.GroceryItem;
import wolfe.michael.HurtLocker.Output;

import java.util.List;

/**
 * Created by michaelwolfe on 2/9/17.
 */
public class OutputTest {

    Output output;
    GroceryItem milkOne;
    GroceryItem milkTwo;
    GroceryItem breadOne;
    GroceryItem cookiesOne;
    GroceryItem applesOne;
    GroceryItem applesTwo;
    List<GroceryItem> list;

    @Before
    public void setUp(){
        output = new Output();
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
    }

    @Test
    public void displayMilkOutputTest(){
        String expected = "name:    Milk\tseen: 2 times\n"
                       +  "=============\t=============\n"
                       +  "Price:   3.23\tseen: 1 times\n"
                       +  "-------------\t-------------\n"
                       +  "Price:   1.23\tseen: 1 times\n"
                       +  "\n";
        String actual = output.displayMilkOutput();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void displayBreadOutputTest(){
        String expected = "name:   Bread\tseen: 1 times\n"
                       +  "=============\t=============\n"
                       +  "Price:   1.23\tseen: 1 times\n"
                       +  "-------------\t-------------\n"
                       +  "\n";
        String actual = output.displayBreadOutput();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void displayCookiesOutputTest(){
        String expected = "name: Cookies\tseen: 1 times\n"
                       +  "=============\t=============\n"
                       +  "Price:   2.25\tseen: 1 times\n"
                       +  "-------------\t-------------\n"
                       +  "\n";
        String actual = output.displayCookiesOutput();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void displayApplesOutputTest(){
        String expected = "name:  Apples\tseen: 2 times\n"
                       +  "=============\t=============\n"
                       +  "Price:   0.25\tseen: 1 times\n"
                       +  "-------------\t-------------\n"
                       +  "Price:   0.23\tseen: 1 times\n"
                       +  "\n";
        String actual = output.displayApplesOutput();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void displayErrorOutputTest(){
        String expected = "Errors         seen: 1 times";
        String actual = output.displayErrorOutput();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void displayOutputTest(){
        String expected = "name:    Milk\tseen: 1 times\n"
                       +  "=============\t=============\n"
                       +  "Price:   3.29\tseen: 1 times\n"
                       +  "-------------\t-------------\n"
                       +  "Price:   1.29\tseen: 1 times\n"
                       +  "\n"
                       +  "name:   Bread\tseen: 1 times\n"
                       +  "=============\t=============\n"
                       +  "Price:   1.23\tseen: 1 times\n"
                       +  "-------------\t-------------\n"
                       +  "\n"
                       +  "name: Cookies\tseen: 1 times\n"
                       +  "=============\t=============\n"
                       +  "Price:   1.23\tseen: 1 times\n"
                       +  "-------------\t-------------\n"
                       +  "\n"
                       +  "name:  Apples\tseen: 1 times\n"
                       +  "=============\t=============\n"
                       +  "Price:   3.29\tseen: 1 times\n"
                       +  "-------------\t-------------\n"
                       +  "Price:   1.29\tseen: 1 times\n"
                       +  "\n"
                       +  "Errors         seen: 1 times";
        String actual = output.displayOutput(list);
        Assert.assertEquals(expected, actual);
    }
}
