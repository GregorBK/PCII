import java.awt.Component;
import javax.swing.JFrame;

/** ... */
public class Fenetre {
	
	/** ... */
	public Fenetre(String NomFenetre, Component composant) 
	{
		JFrame fenetre = new JFrame(NomFenetre);
		fenetre.add(composant);
	}
	
}
