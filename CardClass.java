//CardClass
import hsa.Console;
import java.awt.*;

class CardClass extends ShapeClass
{
    static Console c;
    protected boolean faceup;
    protected String face;
    protected int suit;
    //1=diamond, 2=club, 3=heart, 4=spade
    protected int faceheight;
    protected int suitheight;
    protected SuitClass card;
    //Constructors
    public CardClass ()
    {
	super ();
	setColor (Color.black);
	faceup = true;
	face = "A";
	suit = 1;
	setcardsize (getHeight ());
	card = new DiamondClass (getWidth (), getHeight (), getCentreX (), getCentreY ());
    }


    public CardClass (int w, int h, int x, int y, boolean fu, String f, int s)
    {
	super (w, h, x, y);
	setColor (Color.black);
	faceup = fu;
	face = "A";
	suit = 1;
	setface (f);
	setsuit (s);
	setcardsize (getHeight ());
	if (suit == 1)
	{
	    card = new DiamondClass (getWidth (), getHeight (), getCentreX (), getCentreY ());
	}
	else if (suit == 2)
	{
	    card = new ClubClass (getWidth (), getHeight (), getCentreX (), getCentreY ());
	}
	else if (suit == 3)
	{
	    card = new HeartClass (getWidth (), getHeight (), getCentreX (), getCentreY ());
	}
	else if (suit == 4)
	{
	    card = new SpadeClass (getWidth (), getHeight (), getCentreX (), getCentreY ());
	}
    }


    //Communicators
    private void setcarddimensions ()
    {
	faceheight = getHeight () / 5;
	suitheight = getHeight () / 4;
    }


    public void setcardsize (int s)
    {
	setHeight (s);
	setWidth (s * 4 / 5);
	setcarddimensions ();
    }


    public void setfaceup (boolean b)
    {
	faceup = b;
    }


    public void setface (String s)
    {
	String a = "A23456789TJQK";
	if (a.indexOf (s) >= 0)
	{
	    face = s;
	}

    }


    public void setsuit (int s)
    {
	if (s >= 1 && s <= 4)
	{
	    suit = s;
	    if (suit == 1)
	    {
		card = new DiamondClass (getWidth (), getHeight (), getCentreX (), getCentreY ());
	    }
	    else if (suit == 2)
	    {
		card = new ClubClass (getWidth (), getHeight (), getCentreX (), getCentreY ());
	    }
	    else if (suit == 3)
	    {
		card = new HeartClass (getWidth (), getHeight (), getCentreX (), getCentreY ());
	    }
	    else if (suit == 4)
	    {
		card = new SpadeClass (getWidth (), getHeight (), getCentreX (), getCentreY ());
	    }
	}
    }


    public void setCentre (int x, int y)
    {
	super.setCentre (x, y);
	card.setCentre (x, y);
    }


    public boolean getfaceup ()
    {
	return faceup;
    }


    public String getface ()
    {
	return face;
    }


    public int getsuit ()
    {
	return suit;
    }


    public int getfaceheight ()
    {
	return faceheight;
    }


    public int getsuitheight ()
    {
	return suitheight;
    }


    //Action Methods
    public void draw (Console c)
    {
	Color tempColor = getColor ();
	c.setColor (Color.lightGray);
	c.fillRect (iCentreX - iWidth / 2, iCentreY - iHeight / 2, iWidth, iHeight);
	c.setColor (tempColor);

	card.setsize (suitheight);
	card.draw (c);
	Font f1 = new Font ("Calibri", Font.PLAIN, faceheight);
	c.setFont (f1);
	c.drawString (face, iCentreX - iWidth / 2 + iWidth / 16, iCentreY - iHeight / 2 + faceheight);
	tempColor = getColor ();
	c.setColor (Color.black);

	if (faceup)
	{
	    c.drawRect (iCentreX - iWidth / 2, iCentreY - iHeight / 2, iWidth, iHeight);
	}
	else if (!faceup)
	{
	    tempColor = getColor ();
	    c.setColor (Color.lightGray);
	    c.fillRect (iCentreX - iWidth / 2, iCentreY - iHeight / 2, iWidth, iHeight);
	    c.setColor (tempColor);
	}

	c.setColor (tempColor);
    }


    public void draw (Graphics g)
    {
	Color tempColor = getColor ();
	g.setColor (Color.lightGray);
	g.fillRect (iCentreX - iWidth / 2, iCentreY - iHeight / 2, iWidth, iHeight);
	g.setColor (tempColor);
	if (faceup)
	{
	    card.setsize (suitheight);
	    card.draw (g);
	    Font f1 = new Font ("Calibri", Font.PLAIN, faceheight);
	    g.setFont (f1);
	    g.drawString (face, iCentreX - iWidth / 2 + iWidth / 16, iCentreY - iHeight / 2 + faceheight);
	}
	tempColor = getColor ();
	g.setColor (Color.black);
	g.drawRect (iCentreX - iWidth / 2, iCentreY - iHeight / 2, iWidth, iHeight);
	g.setColor (tempColor);
    }
}
