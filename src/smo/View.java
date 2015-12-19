package smo;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author kilian mock
 * @version 08.11.15
 * die ganze graphische oberfläche 
 */
public class View extends JFrame {
	 private boolean sindwirendlichdafragezeichen = false;
	 private Model m;
	 private Controller c;
	 TreeSet<Integer> set;
	 private JLabel tipAnz;
	 private JLabel ausgabe;
	 private JPanel buttons;
	 private JButton neu = new JButton("neue ziehung");
	 private JButton auswerten = new JButton("auswerten");
	 /**
	  * übernimmt Model + Controller vom Controller
	  * generiert die GUI-Elemente
	  * meldet die ActionListener an
	  * generiert das Fenster
	  * @param m model
	  * @param c controler
	  */
	 public View(Model m, Controller c) {
		 this.m = m;
		 this.c = c;
		 set = new TreeSet<Integer>();
		 JPanel bp = new JPanel();
		 JToggleButton toggleButton = null;
		 tipAnz = new JLabel("");
		 bp.setLayout(new WrapLayout());
		 for(int x=1;x<46;x++)
		 {
			 toggleButton=new JToggleButton(x+"");
			 toggleButton.addActionListener(c);
			 bp.add(toggleButton);
		 }
		 
		 this.add(bp);
		 this.setLayout(new BorderLayout());
		 this.add(bp, BorderLayout.NORTH);
		 
		 
		 
		 JPanel cp = new JPanel();
		 ausgabe = new JLabel();
		 cp.add(tipAnz);
		 cp.add(ausgabe);
		 cp.setLayout(new BoxLayout(cp, BoxLayout.X_AXIS));
		 this.add(cp, BorderLayout.CENTER);
		 
		 
		 buttons = new JPanel();
		 buttons.add(neu);
		 neu.addActionListener(c);
		 buttons.add(auswerten);
		 auswerten.addActionListener(c);
		 this.add(buttons, BorderLayout.SOUTH);
		 
		 
		 
		 this.setTitle("Lottomator2000");
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setSize(1500, 2000);
		 this.pack();
		 this.setVisible(true);
	 }

	 /**
	  * nimmt zahlen entgegen und fügt sie den gewählten hinzu
	  * @param i die zahl die zu den gewählten zahlen hinzugefüt werden soll 
	  */
	 public void addToTip(int i)
	 {
		 if (set.size()<6)
		 {
			 set.add(i);
			 tipAnz.setText("<html> TIP: "+set.toString().replace('[', ' ').replace(']', ' ')+"<br><br>");
		 }else 
			 if (!sindwirendlichdafragezeichen)
			 {
				 m.setTip(set, i);
				 tipAnz.setText("<html> TIP: "+set.toString().replace('[', ' ').replace(']', ' ') + " zusatzzahl: "+i+"<br><br>");
				 sindwirendlichdafragezeichen = true;
			 }
			   else
				 JOptionPane.showMessageDialog(null, "es wurden schon alle auszuwählenden zahlen ausgewählt");
	 }
	 
	 /**
	  * generiert einen string, zur ausgabe, der alle relevanten informationen enthält
	  */
	 public void auswertung ()
	 {
	    ausgabe.setText("");
		String bla = "<html>" + m.toString() + " <br> übereinstimmungen mit tip: "+m.check() + "<br>";
		if (m.checkZusatz(set))
			bla = bla + " es gibt übereinstimmungen mit der zusatzzahl";
		else 
			bla = bla + " es gibt keine übereinstimmungen mit der zusatzzahl";
		
				 
		ausgabe.setText(bla);
	 }
}