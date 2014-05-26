package override;

/**
 * Created by sudheerl on 5/22/14.
 *http://www.journaldev.com/817/overriding-methods-in-java-always-use-override-annotation
 It’s clear that using Override annotation will make sure any Superclass changes in method signature
 will result in a warning and you will have to do necessary changes to make sure the classes work as expected.
 */
public class OverrideTest {
    public static void main(String[] args) {
        BaseClass bc = new ChildClass();
        bc.doSomething("override");
    }
}
