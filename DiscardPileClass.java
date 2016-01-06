//DiscardPile
import java.util.*;
import java.awt.*;
import hsa.Console;
public class DiscardPileClass extends DeckClass
{

    //Constructors
    public DiscardPileClass ()
    {
	super ();
    }


    public boolean addCard (CardClass cardToAdd, boolean isCardFromDrawPile)
    {
	if (isCardFromDrawPile)
	{
	    if (cardToAdd != null)
	    {
		cardToAdd.setCentre (iCentreX, iCentreY);
		cardToAdd.setfaceup (true);
		deck.insertElementAt (cardToAdd, 0);
		return true;
	    }
	}
	else if (!isCardFromDrawPile)
	{
	    if (cardToAdd != null)
	    {
		CardClass top = (CardClass) deck.elementAt (0);
		String s = "A23456789TJQK";
		int topindex = s.indexOf (top.getface ());
		String faceadd = cardToAdd.getface ();
		int addindex = s.indexOf (faceadd);
		if (topindex == 12)
		{
		    return false;
		}
		else if (topindex - addindex == 1 || addindex - topindex == 1)
		{
		    cardToAdd.setCentre (iCentreX, iCentreY);
		    cardToAdd.setfaceup (true);
		    deck.insertElementAt (cardToAdd, 0);
		    return true;
		}
	    }
	}
	return false;
    }
}
