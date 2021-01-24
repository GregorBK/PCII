/**
 * Définit l’ensemble des données qui caractérisent l’état de l'interface*/
public class Etat {
	
	/**Définie l'hauteur de l'objet*/
	private static int hauteur;
	private static Affichage vue;
	public Parcours parcours;
	
	 /** Saut de l'objet */
    public static final int SAUT = -20;
    /** Chute de l'objet*/
    public static final int CHUTE = 5; 
	
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
		Etat.vue.revalidate();
		Etat.vue.repaint();
		
	}
}
