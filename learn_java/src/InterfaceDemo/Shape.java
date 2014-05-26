package InterfaceDemo;

/**
 * Created by sudheerl on 5/22/14.
 */
public interface Shape {

    //implicitly public, static and final
    public String LABLE="Shape";

    //interface methods are implicitly abstract and public
    void draw();

    double getArea();
}