import java.awt.Point;

/**
 * Définit l’ensemble des données qui caractérisent l’état de l'interface*/
public class Etat {
	
	/**Définie l'hauteur de l'objet*/
	private static int hauteur;
	private static Affichage vue;
	public Parcours parcours;
	
	 /** Saut de l'objet */
    public static final int SAUT = -30;
    /** Chute de l'objet*/
    public static final int CHUTE = 2; 
	
	/**
	 * Constructeurs*/
	public Etat(int h)
	{
		Etat.hauteur = h;
	}
	
	public Etat(int h, Affichage a, Parcours p)
	{
		Etat.hauteur = h;
		Etat.vue = a;
		this.parcours = p;
	}
	
	/**
	 * Renvoie la hauteur de l'objet*/
	public int getHauteur()
	{
		return Etat.hauteur;
		
	}
	
	/**
	 * Augmente la hauteur de l'objet*/
	public void jump()
	{
		if((hauteur + SAUT) < Affichage.HAUT && (hauteur + SAUT) >= 0)
		{
			hauteur = hauteur + SAUT;
		}
	}
	
	/**
	 * Fais tomber l'objet petit à petit
	 */
	public void moveDown()
	{
		if( (hauteur+Affichage.ELHAUT + CHUTE) < Affichage.HAUT )
			hauteur = hauteur + CHUTE;
	}
	
	/**
	 * Teste si l'ellipse est touche la ligne brisée
	 * @return
	 */
	public boolean testPerdu()
	{
		Point p1 = null;
		Point p2 = null;
		boolean ok = true;
		int xcentre = this.vue.XCENTRE;
		int i = 0;
		while(ok)
		{
			if(this.parcours.points.get(i).x <= xcentre && this.parcours.points.get(i+1).x >= xcentre)
			{
				p1 = this.parcours.points.get(i);
				p2 = this.parcours.points.get(i+1);
				ok = false;
			}else
				{
					i++;
				}
			
		}	
		
		
		float pente = (p2.y - p1.y) / ((float)p2.x - (float)p1.x);
        float y = p1.y - pente *(p1.x - xcentre);

        if(y > (hauteur+this.vue.ELHAUT) ) return false;
        
        return true;
	}
	
}
