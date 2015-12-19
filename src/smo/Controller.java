package smo;


/**
 * @author kilian mock
 * @version 08,11.15
 * stellt controler dh.action listener für das lotto programm dar
 */
import java.awt.event.*;

import javax.swing.JToggleButton;
import javax.swing.plaf.basic.BasicBorders.ToggleButtonBorder;
public class Controller implements ActionListener {
	 // Attribute: Model und View
	 private Model m;
	 private View v;

	 /**
	  * Kontruktor: erzeugt Model und View
	  */
	 public Controller() {
		 this.m = new Model();
		 this.v = new View(this.m, this);
	 }

	 /**
	  * @param e der event der den aufruf bewirkt hat
	  * 
	  * überprüft von was er aufgerufen wurde und ruft demensprechend die richtigen methoden auf
	  */
	 public void actionPerformed(ActionEvent e) {
		 if (e.getActionCommand() == "neue ziehung")
		 {
			 m.ziehen();
			 v.auswertung();
			 System.out.println("los");
			 return;
		 }
		 if (e.getActionCommand() == "auswerten")
		 {
			 v.auswertung();
			 return;
		 }
		 JToggleButton a = (JToggleButton) e.getSource();
		 v.addToTip(Integer.parseInt(a.getText()));
	 }
	}
