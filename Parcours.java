import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Parcours {
	
	public ArrayList<Point> points;
	public Affichage vue;
	public int position;
	public final int pas = 30;
	
	public Parcours(Affichage a)
	{
		this.vue = a;
		this.points = new ArrayList<Point>();
		
		int x0 = Affichage.XCENTRE;
		int y0 = Affichage.ETAT.getHauteur();
		Random rand = new Random();
		int temp2;
		this.points.add(new Point(x0+(Affichage.ELLARG/2),y0+(Affichage.ELHAUT/2)));
		for(int i = 0; i < 8; i++)
		{
			rand = new Random();
			temp2 = 40 - rand.nextInt(80);
			while(y0+temp2 > 500)
			{
				temp2 = 40 - rand.nextInt(80);
			}
			this.points.add(new Point(x0+50,(y0)+temp2));
			y0 = (y0-20)+temp2;	
			x0 = x0+50;
			
		}
		this.points.add(new Point(this.vue.LARG,(y0)+40-rand.nextInt(40)));
	}
	
	public void affichePoint()
	{
		for(int i = 0; i < this.points.size(); i++)
		{
			System.out.print(this.points.get(i));
		}
		System.out.println();
	}
	
	public ArrayList<Point> getParcours()
	{
		return this.points;
	}
	
	public int getPosition()
	{
		return this.position;
	}
	
	public void majPosition()
	{
		this.position = this.position + this.pas;
	}
	
	public void setPosition(int p)
	{
		this.position = p;
	}
}
