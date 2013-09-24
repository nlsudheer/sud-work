package testng;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * https://groups.google.com/forum/#!topic/testng-users/Wsd-S2IsPbQ
 * http://stackoverflow.com/questions/8596632/retrieve-test-name-on-testng
 * <p/>
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 24/9/13
 * Time: 11:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class GetTestNgTestData {

    @Test
    public void f(ITestContext ctx) {
        String name = ctx.getCurrentXmlTest().getName();
        System.out.println("method name: " + name);

        System.out.println("getClasses name: " + ctx.getCurrentXmlTest().getClasses());
        System.out.println("getMetaGroups name: " + ctx.getCurrentXmlTest().getMetaGroups());
        System.out.println("getTestParameters name: " + ctx.getCurrentXmlTest().getTestParameters());
        System.out.println("getXmlClasses name: " + ctx.getCurrentXmlTest().getXmlClasses());
//
//        System.out.println("method name: " + name);
//        System.out.println("method name: " + ctx.getCurrentXmlTest().getName());
    }

    @Test
    public void handleTestMethodName(Method method) {
        String testName = method.getName();
        System.out.println("@Test testName : " + testName);
//        method.
    }

    // returns name of it's previous method name
    @BeforeMethod
    public void handleTestMethodNameBeforeTest(Method method) {
        String testName = method.getName();
        System.out.println("@BeforeMethod testName : " + testName);
//        method.
    }
}
