package smo;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
/**
 * 
 * @author kilian mock	
 * @version 08.11.15
 * 
 * beinhaltet die gesammte logik zb. wird �berpr�ft und/oder hinzugef�gt
 *
 */
public class Model {

	private TreeSet<Integer>  lottozahlen = new TreeSet<Integer>();
	private int zusatzzahl;
	private TreeSet<Integer> tip = null;
	private int tipzus = 0;
	 /**
	  * legt bei aufruf die zahlen fest 
	  */
	 
	public Model() {
		 ziehen();
		 
		 
	 }
	 /**
	  * zieht per zufall 7 zahlen und speichert sie als lottozahlen und zusatzzahl ab
	  */
	 public void ziehen() 
	 {
		 lottozahlen = new TreeSet<Integer>();
		 Set<Integer>  m�gliche = new TreeSet<Integer>();
		 for (int i = 1;i<=45;i++)
		 {
			 m�gliche.add(i);
		 }
		 
		 Iterator<Integer> it;
		 
		 for(int i = 0; i < 6 ; i++)
		 {
			 it = m�gliche.iterator();
			 int pick = ThreadLocalRandom.current().nextInt(0, m�gliche.size());
			 for (int j = 0 ; j <  pick-1; j++)
			 {
				 it.next();
			 }
			 lottozahlen.add(it.next());
			 it.remove();
		 }
		 it = m�gliche.iterator();
		 int pick = ThreadLocalRandom.current().nextInt(0, m�gliche.size());
		 for (int j = 0 ; j <  pick-1; j++)
		 {
			 it.next();
		 }
		 zusatzzahl = it.next(); 
		 
	 }
	/**
	 *  
	 * @param t ein treeset it den getippten zahlen
	 * @param zu die zusatzzahl
	 * schribt die ausgew�hlten zahlen in atribute
	 */
	public void setTip(TreeSet<Integer> t, int zu)
	{
		tipzus = zu;
		tip =t;
	}
	/**
	 * returnt die zusatzzahl
	 * @return die zusatzzahl
	 */
	public int getZusatzzahl()
	{
		return zusatzzahl;
	}
	/**
	 * returnt die zusatzzahl des tips
	 * @return die zusatzzahl des tips
	 */
	public int getTipZusatzzahl()
	{
		return tipzus;
	}
	/**
	 * checkt wie viele der zahlen mit einander �bereinstimmen
	 * @return timmenden zahlendie anzahl der �bereinstimmenden zahlen
	 */
	public int check()
	{
		if (tip == null)
			return -1;
		int �bst = 0;
		Iterator<Integer> tit = tip.iterator();
		Iterator<Integer> zit = lottozahlen.iterator();
		for(int i = 0;i<6;i++)
			if(tip.contains(zit.next()))
				�bst++;
		return �bst;
	}
	/**
	 * �berpr�ft ob die zusatzzahl in den lottozahlen vorkommt
	 * @param t lottozahlen
	 * @return true wenn es eine �bereistimmung gibt
	 */
	public boolean checkZusatz(TreeSet<Integer> t)
	{
		return t.contains(zusatzzahl);
	}
	/**
	 * wandelt die lottozahlen von einem set in ein array um
	 * @return das fertig umgewandelte array
	 */
	public int[] toArray()
	{
		//lottozahlen.toArray(); ist vermutlich einfacher.
		int [] array = new int[lottozahlen.size()];
		Iterator<Integer> it = lottozahlen.iterator();
		for (int i = 0; i<lottozahlen.size();i++)
			array[i] = it.next();
		return array;
	}
	/**
	 * wandelt di lottozalen in einen string um
	 * @return der string der 
	 */
	public String toString()
	{
		String a ="";
		Iterator<Integer> it = lottozahlen.iterator();
		for (int i = 0; i<lottozahlen.size();i++)
			a=a+ it.next()+",";
		return "Lottozahlen: "+a+" Zusatzzahl: "+zusatzzahl;
	}
	
}
