import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Parcours {
	
	public ArrayList<Point> points;
	public Affichage vue;
	public int position;
	public final int pas = -1;
	
	/**
	 * Constructeur de Parcours
	 * @param a
	 */
	public Parcours(Affichage a)
	{
		this.vue = a;
		this.points = new ArrayList<Point>();
		
		int x0 = 0;
		int y0 = 450;
		Random rand = new Random();
		int temp2;
		int temp1;
		this.points.add(new Point(x0+(Affichage.ELLARG/2),y0+(Affichage.ELHAUT/2)));
		this.position = 0;
		
		while(x0<this.vue.LARG)
		{
			rand = new Random();
			temp1 = rand.nextInt(100);
			temp2 = 100 - rand.nextInt(200);
			while(y0+temp2 > 500)
			{
				temp2 = 100 - rand.nextInt(200);
			}
			this.points.add(new Point(x0 + temp1,(y0)+temp2));
			y0 = y0+temp2;	
			x0 = x0+temp1;	
		}
	}
	
	/**
	 * Affiche les points du parcours
	 */
	public void affichePoint()
	{
		for(int i = 0; i < this.points.size(); i++)
		{
			System.out.print(this.points.get(i));
		}
		System.out.println();
	}
	
	/**
	 * Renvoie la liste des points mise à jour
	 * permettant d'afficher une ligne brisé continue
	 * @return
	 */
	public ArrayList<Point> getParcours()
	{
		ArrayList<Point> temp = new ArrayList<Point>();
		for(int i = 0; i < this.points.size(); i++)
		{
			if(!(this.points.get(i).x < 0 && this.points.get(i+1).x < 0))
			{
				temp.add(this.points.get(i));
			}
		}
		if(this.points.get(this.points.size()-1).x < Affichage.LARG)
		{
			int x = this.points.get(this.points.size()-1).x;
			int y = this.points.get(this.points.size()-1).y;
			Random rand = new Random();
			temp.add(new Point(x + rand.nextInt(50)+50, y + rand.nextInt(100)-50));
		}
		return temp;
	}
	
	/**
	 * Renvoie la position de l'ellipse
	 * @return
	 */
	public int getPosition()
	{
		return this.position;
	}
	
	/**
	 * Mets à jour la position des points pour faire avancer le parcours
	 * et mets à jour la valeur de position
	 */
	public void majPosition()
	{
		this.points = getParcours();
		for(int i = 0; i < this.points.size(); i++)
		{
			this.points.get(i).x = this.points.get(i).x + this.pas;
		}
		this.position = this.position - this.pas;
	}
	
	/**
	 * Permet de changer la valeur de position
	 * @param p
	 */
	public void setPosition(int p)
	{
		this.position = p;
	}
	
}
