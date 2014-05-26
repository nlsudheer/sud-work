package abstractDemo;

/**
 * Created by sudheerl on 5/22/14.
 */
public abstract class Person {

    private String name;
    private String gender;

    public Person(String nm, String gen){
        this.name=nm;
        this.gender=gen;
    }

    //abstract method
    public abstract void work();

    @Override
    public String toString(){
        return "Name="+this.name+"::Gender="+this.gender;
    }

}
