package override;

/**
 * Created by sudheerl on 5/22/14.
 * http://www.journaldev.com/817/overriding-methods-in-java-always-use-override-annotation
 */
public class BaseClass {
    public void doSomething(String str){
        System.out.println("Base impl:"+str);
    }

    // comment @Override in child class and run test by replacing doSomething(String str) method with below
//    public void doSomething(Object str){
//        System.out.println("Base impl with Object param:"+str);
//    }

//    public void doSomething(String str){
//        System.out.println("Base impl:"+str);
//    }
}
