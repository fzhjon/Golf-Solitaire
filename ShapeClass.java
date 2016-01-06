//ShapeClass
import java.awt.*;
import hsa.Console;

public abstract class ShapeClass
{
    static Console c;
    protected int iWidth;
    protected int iHeight;
    protected int iCentreX;
    protected int iCentreY;
    protected boolean isFilled;

    protected Color cColor;

    //Constructors
    public ShapeClass ()
    {
	iWidth = 80;
	iHeight = 100;
	iCentreX = 100;
	iCentreY = 100;
	isFilled = true;
    }


    public ShapeClass (int w, int h, int x, int y)
    {
	iWidth = w;
	iHeight = h;
	iCentreX = x;
	iCentreY = y;
	isFilled = true;

    }


    //Communicator Methods
    public void setWidth (int iNewWidth)
    {
	iWidth = iNewWidth;
    }


    public void setHeight (int iNewHeight)
    {
	iHeight = iNewHeight;
    }


    public void setCentre (int iNewCentreX, int iNewCentreY)
    {
	iCentreX = iNewCentreX;
	iCentreY = iNewCentreY;
    }


    public void setColor (Color cNewColor)
    {

	cColor = cNewColor;
    }


    public void setFilled (boolean f)
    {
	isFilled = f;
    }


    public int getWidth ()
    {
	return iWidth;
    }


    public int getHeight ()
    {
	return iHeight;
    }


    public int getCentreX ()
    {
	return iCentreX;
    }


    public int getCentreY ()
    {
	return iCentreY;
    }



    public Color getColor ()
    {
	return cColor;
    }


    public boolean getFilled ()
    {
	return isFilled;
    }


    //Action Methods
    public void delay (int iDelayTime)
    {
	long lFinalTime = System.currentTimeMillis () + iDelayTime;
	do
	{
	}

	while (lFinalTime >= System.currentTimeMillis ());
    }


    public abstract void draw (Console c);

    public void erase (Console c)
    {
	Color tempColor = getColor ();
	setColor (Color.white);
	draw (c);
	setColor (tempColor);
    }


    public abstract void draw (Graphics g);

    public void erase (Graphics g)
    {
	Color tempColor = getColor ();
	setColor (Color.white);
	draw (g);
	setColor (tempColor);
    }
}
