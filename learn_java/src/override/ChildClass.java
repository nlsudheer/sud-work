package override;

/**
 * Created by sudheerl on 5/22/14.
 */
public class ChildClass extends BaseClass{
    @Override
    public void doSomething(String str){
        System.out.println("Child impl:"+str);
    }
}
