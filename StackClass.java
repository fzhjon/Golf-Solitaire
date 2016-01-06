//Stack
import java.util.*;
import java.awt.*;
import hsa.Console;
public class StackClass extends DeckClass
{
    //Constructors
    public StackClass ()
    {
	super ();
    }


    public void addCard (CardClass cardToAdd)
    {
	if (cardToAdd != null)
	{
	    if (deck.isEmpty ())
	    {
		cardToAdd.setCentre (iCentreX, iCentreY);
	    }
	    if (!deck.isEmpty ())
	    {
		CardClass top = (CardClass) deck.firstElement ();
		setCentre (top.getCentreX (), top.getCentreY () + cardToAdd.getHeight () * 2 / 3);
		cardToAdd.setCentre (iCentreX, iCentreY);
	    }

	    cardToAdd.setfaceup (true);

	    deck.insertElementAt (cardToAdd, 0);
	}
    }


    public CardClass dealCard ()
    {
	CardClass dummy = null;
	if (!deck.isEmpty ())
	{
	    dummy = (CardClass) (deck.elementAt (0));
	    deck.remove (0);
	    setCentre (iCentreX, iCentreY - dummy.getHeight () * 2 / 3);
	}
	return dummy;
    }


    public void draw (Graphics g, int Pos)
    {
	if (!deck.isEmpty ())
	{
	    CardClass end = (CardClass) deck.elementAt (Pos);
	    end.draw (g);
	    if (Pos != 0)
	    {
		draw (g, Pos - 1);
	    }
	}
    }
}
