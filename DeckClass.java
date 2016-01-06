//DeckClass
import java.util.*;
import java.awt.*;
import hsa.Console;
public class DeckClass extends ShapeClass
{
    protected Vector deck = new Vector (0, 1);
    CardClass cc = new CardClass ();

    public DeckClass ()
    {

    }


    public DeckClass (String deckType)
    {
	if (deckType == "faceup") // std deck
	{
	    for (int i = 0 ; i < 13 ; i++)
	    {
		for (int ii = 1 ; ii < 5 ; ii++)
		{
		    cc = new CardClass ();
		    cc.setsuit (ii);
		    cc.setface ("" + "A23456789TJQK".charAt (i));
		    addCard (cc, 0);
		}
	    }
	    // generate 52 cards (2 nested loops) and add them to the deck
	}
	if (deckType == "facedown") //facedown deck
	{
	    for (int i = 0 ; i < 13 ; i++)
	    {
		for (int ii = 1 ; ii < 5 ; ii++)
		{
		    cc = new CardClass ();
		    cc.setsuit (ii);
		    cc.setface ("" + "A23456789TJQK".charAt (i));
		    cc.setfaceup (false);
		    addCard (cc, 0);
		}
	    }
	    // generate 52 cards (2 nested loops) and add them to the deck
	}
	shuffle ();
    }


    public void addCard (CardClass cardToAdd, int Pos)
    {
	if (cardToAdd != null)
	{


	    if (Pos == 0 && deck.size () == 0)
	    {
		deck.addElement (cardToAdd);
	    }
	    else if (Pos > deck.size ())
	    {
		deck.insertElementAt (cardToAdd, deck.size ());
	    }
	    else
	    {
		deck.insertElementAt (cardToAdd, Pos);
	    }
	}
    }


    public CardClass dealCard (int Pos)
    {
	CardClass dummy = null;
	if (Pos >= 0 && Pos <= deck.size ())
	{
	    if (deck.size () != 0)
	    {
		dummy = (CardClass) (deck.elementAt (Pos));
		deck.remove (Pos);
	    }
	}

	return dummy;
    }


    public void shuffle ()
    {
	if (!deck.isEmpty ())
	{
	    for (int i = 0 ; i < deck.size () ; i++)
	    {
		deck.add ((int) (Math.random () * deck.size ()), deck.remove (i));
	    }
	}
    }


    public boolean isPointInside (int x, int y)
    {
	if (x > iCentreX - iWidth / 2 && x < iCentreX + iWidth / 2 && y > iCentreY - iHeight / 2 && y < iCentreY + iHeight / 2)
	{
	    return true;
	}
	else
	{
	    return false;
	}
    }


    public void draw (Console c)
    {
	if (!deck.isEmpty ())
	{
	    CardClass cc = (CardClass) deck.firstElement ();
	    cc.setcardsize (iHeight);
	    cc.setCentre (iCentreX, iCentreY);
	    cc.draw (c);
	}
	else
	{
	    Color tempColor = getColor ();
	    c.setColor (Color.lightGray);
	    c.fillRect (iCentreX - iWidth / 2, iCentreY - iHeight / 2, iWidth, iHeight);
	    c.setColor (tempColor);
	    c.drawRect (iCentreX - iWidth / 2, iCentreY - iHeight / 2, iWidth, iHeight);
	}
    }


    public void draw (Graphics g)
    {
	if (!deck.isEmpty ())
	{
	    CardClass cc = (CardClass) deck.firstElement ();
	    cc.setcardsize (iHeight);
	    cc.setCentre (iCentreX, iCentreY);
	    cc.draw (g);
	}
	else
	{
	    Color tempColor = getColor ();
	    g.setColor (Color.green);
	    g.fillRect (iCentreX - iWidth / 2, iCentreY - iHeight / 2, iWidth, iHeight);
	    g.setColor (Color.black);
	    g.drawRect (iCentreX - iWidth / 2, iCentreY - iHeight / 2, iWidth, iHeight);
	    g.setColor (tempColor);
	}
    }


    public boolean isDeckEmpty ()
    {
	return deck.isEmpty ();
    }


    public int getSize ()
    {
	return deck.size ();
    }
}


