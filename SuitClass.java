//SuitClass
import java.awt.*;
import hsa.Console;

public abstract class SuitClass extends ShapeClass
{
    //Constructors
    public SuitClass ()
    {
	super ();
    }


    public SuitClass (int w, int h, int x, int y)
    {
	super (w, h, x, y);
    }


    //Action Methods
    public void setsize (int s)
    {
	super.setHeight (s);
	super.setWidth (s * 4 / 5);
    }
}
