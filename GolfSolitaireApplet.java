// The "GolfSolitaire" class.
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.imageio.*;
import java.io.*;



public class GolfSolitaireApplet extends Applet implements ActionListener, MouseListener, MouseMotionListener
{
    //Instance Variables
    StackClass[] stacks;
    DeckClass drawpile;
    DiscardPileClass discardpile;
    int score;
    TextField textFieldAction = new TextField (10);
    TextField CardsRemaining = new TextField (25);
    private Image offScreenImage;
    private Graphics offScreenGraphics;
    private int width, height;
    Button buttonReplay = new Button ("Replay");
    FlowLayout lm = new FlowLayout (FlowLayout.LEFT, 200, 15);
    boolean OKtoMove = false;
    CardClass temp;
    int stacknum;
    Panel mainpde = new Panel ();
    Panel pde = new Panel ();
    Panel pde2 = new Panel ();
    Panel pde3 = new Panel ();
    Image img1;

    public void init ()
    {
	setSize (1200, 800);
	width = getSize ().width;
	height = getSize ().height;
	offScreenImage = createImage (width, height);
	offScreenGraphics = offScreenImage.getGraphics ();
	drawpile = new DeckClass ("facedown");
	drawpile.shuffle ();
	drawpile.setCentre (100, 600);
	stacks = new StackClass [7];
	discardpile = new DiscardPileClass ();
	discardpile.setCentre (265, 600);
	score = 0;
	pde.setLayout (new BorderLayout ());
	pde2.setLayout (new BorderLayout ());
	pde3.setLayout (new BorderLayout ());
	try
	{
	    img1 = ImageIO.read (new File ("pokertable.jpg"));
	}
	catch (IOException e)
	{
	}
	for (int i = 0 ; i < 7 ; i++)
	{
	    stacks [i] = new StackClass ();
	    for (int ii = 0 ; ii < 5 ; ii++)
	    {
		stacks [i].setCentre (i * 165 + 100, stacks [i].getCentreY ());
		stacks [i].addCard (drawpile.dealCard (0));
	    }
	}
	discardpile.addCard (drawpile.dealCard (0), true);
	setLayout (lm);
	pde.add ("North", textFieldAction);
	pde2.add ("South", CardsRemaining);
	pde3.add ("West", buttonReplay);
	add (pde);
	add (pde2);
	add (pde3);
	addMouseListener (this);
	addMouseMotionListener (this);
	buttonReplay.addActionListener (this);
    }


    public void mouseClicked (MouseEvent e)
    {
    }


    public void mouseEntered (MouseEvent e)
    {
    }


    public void mouseExited (MouseEvent e)
    {
    }


    public void mousePressed (MouseEvent e)
    {
	if (drawpile.isPointInside (e.getX (), e.getY ()) == true)
	{
	    if (!drawpile.isDeckEmpty ())
	    {
		discardpile.addCard (drawpile.dealCard (0), true);
	    }
	}
	for (int i = 0 ; i < 7 ; i++)
	{
	    if (stacks [i].isPointInside (e.getX (), e.getY ()) == true)
	    {
		if (!stacks [i].isDeckEmpty ())
		{
		    temp = stacks [i].dealCard ();
		    OKtoMove = true;
		    stacknum = i;
		}
	    }
	}
	repaint ();
    }


    public void mouseReleased (MouseEvent e)
    {
	OKtoMove = false;
	if (temp != null)
	{
	    if (discardpile.isPointInside (e.getX (), e.getY ()) == true)
	    {
		if (discardpile.addCard (temp, false))
		{

		}
		else if (!discardpile.addCard (temp, false))
		{
		    if (stacks [stacknum].isDeckEmpty ())
		    {
			stacks [stacknum].setCentre (stacks [stacknum].getCentreX (), stacks [stacknum].getCentreY () + temp.getHeight () * 2 / 3);
		    }
		    stacks [stacknum].addCard (temp);
		}

	    }
	    else if (discardpile.isPointInside (e.getX (), e.getY ()) == false)
	    {
		if (stacks [stacknum].isDeckEmpty ())
		{
		    stacks [stacknum].setCentre (stacks [stacknum].getCentreX (), stacks [stacknum].getCentreY () + temp.getHeight () * 2 / 3);
		}
		stacks [stacknum].addCard (temp);
	    }
	    temp = null;
	    repaint ();
	}

    }


    public void mouseDragged (MouseEvent e)
    {
	if (OKtoMove == true)
	{
	    temp.setCentre (e.getX (), e.getY ());
	    repaint ();
	}

    }


    public void mouseMoved (MouseEvent e)
    {
    }



    public void actionPerformed (ActionEvent e)
    {
	Object objSource = e.getSource ();
	//Draw/Erase
	if (objSource instanceof Button)
	{
	    if (objSource == buttonReplay)
	    {

		drawpile = new DeckClass ("facedown");
		drawpile.shuffle ();
		drawpile.setCentre (100, 600);
		stacks = new StackClass [7];
		discardpile = new DiscardPileClass ();
		discardpile.setCentre (265, 600);
		score = 0;

		for (int i = 0 ; i < 7 ; i++)
		{
		    stacks [i] = new StackClass ();
		    for (int ii = 0 ; ii < 5 ; ii++)
		    {
			stacks [i].setCentre (i * 165 + 100, stacks [i].getCentreY ());
			stacks [i].addCard (drawpile.dealCard (0));
		    }
		    score += stacks [i].getSize ();
		}
		discardpile.addCard (drawpile.dealCard (0), true);

	    }
	}
	repaint ();
    }


    public void update (Graphics g)
    {
	paint (g);
    }


    public void paint (Graphics g)
    {
	offScreenGraphics.clearRect (0, 0, width, height);
	offScreenGraphics.drawImage (img1, 0, 0, this);
	score = 0;
	for (int i = 0 ; i < 7 ; i++)
	{
	    stacks [i].draw (offScreenGraphics, stacks [i].getSize () - 1);
	    score += stacks [i].getSize ();
	}
	textFieldAction.setText ("Score: " + ("" + score));

	CardsRemaining.setText ("Cards Remaining in Draw Pile: " + ("" + drawpile.getSize ()));
	drawpile.draw (offScreenGraphics);
	discardpile.draw (offScreenGraphics);
	if (temp != null)
	{
	    temp.draw (offScreenGraphics);
	}


	g.drawImage (offScreenImage, 0, 0, this);
    }
}


