package testng;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 20/9/13
 * Time: 6:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestNGTest1 {
    private Collection collection;
    ArrayList<String> array = new ArrayList<String>();

    @BeforeClass
    public void oneTimeSetUp() {
        // one-time initialization code
        System.out.println("TestNGTest1: @BeforeClass - oneTimeSetUp");
    }

    @AfterClass
    public void oneTimeTearDown() {
        // one-time cleanup code
        System.out.println("TestNGTest1: @AfterClass - oneTimeTearDown");
    }

    @BeforeMethod
    public void setUp() {
        collection = new ArrayList();
        System.out.println("TestNGTest1: @BeforeMethod - setUp");
    }

    @AfterMethod
    public void tearDown() {
        collection.clear();
        System.out.println("TestNGTest1: @AfterMethod - tearDown");
    }

    @Test
    public void testEmptyCollection() {
        Assert.assertEquals(collection.isEmpty(), true);
        System.out.println("TestNGTest1: @Test - testEmptyCollection");
    }

    @Test
    public void testOneItemCollection() {
        collection.add("itemA");
        Assert.assertEquals(collection.size(), 1);
        System.out.println("TestNGTest1: @Test - testOneItemCollection");
    }

    @Test(groups = "method1")
    public void testGroup1() {
        array.add("item1");
        Assert.assertEquals(array.isEmpty(), false);
        System.out.println("TestNGTest1: @Test - testGroup1 groups = method1");
    }

    @Test(groups = "method2")
    public void testGroup2() {
        array.add("item2");
        Assert.assertEquals(array.isEmpty(), false);
        System.out.println("TestNGTest1: @Test - testGroup2 groups = method2");
    }

    @Test(groups = "method1")
    public void testGroup3() {
        array.add("item3");
        Assert.assertEquals(array.isEmpty(), false);
        System.out.println("TestNGTest1: @Test - testGroup3 groups = method1");
    }

    @Test(groups = "method2")
    public void testGroup4() {
        array.add("item4");
        Assert.assertEquals(array.isEmpty(), false);
        System.out.println("TestNGTest1: @Test - testGroup4 groups = method2");
    }
}
