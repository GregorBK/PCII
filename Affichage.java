import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JButton;

/** ... */
public class Affichage extends JPanel {

        /* Constantes */
		/** Largeur de la fenêtre*/
        public static final int LARG = 500;
        /** Hauteur de la fenêtre*/
        public static final int HAUT = 500;
        
        /** Abscisse du centre de l'objet */
        public static final int XCENTRE = 80;
        /** Largeur de l'objet */
        public static final int ELLARG = 40;
        /** Hauteur de l'objet */
        public static final int ELHAUT = 40;
        
        /**
         * Instance d'un Etat lié à l'affichage
         */
        public static Etat ETAT;
        
        /** Constructeur */
        public Affichage(Etat e) {
        	Affichage.ETAT = e;
            setPreferredSize(new Dimension(LARG, HAUT));
        }
        
        /**
         *Dessine la ligne*/
        public void line(Graphics g)
        {
        	if(ETAT.parcours != null) {
	        	boolean temp = true;
	        	int i = 0;
	        	while(temp)
	        	{
	        		g.drawLine(ETAT.parcours.points.get(i).x, ETAT.parcours.points.get(i).y,
	        				ETAT.parcours.points.get(i+1).x, ETAT.parcours.points.get(i+1).y);
	        		if(i < ETAT.parcours.points.size()-2) i = i+1;
	        		else temp = false;
	        	}
        	}
        }
        
        /**
         *Dessine l'ellipse*/
        public void oval(Graphics g)
        {
        	g.drawOval(XCENTRE, ETAT.getHauteur(), ELLARG, ELHAUT);
        }
        
        /**
         *Dessine les objets*/
        public void paint(Graphics g)
        {
        	g.clearRect(0,500,0,500);
        	super.paint(g);
        	oval(g);
        	line(g);
        }

		
        /**
         * Mets à jour l'affichage*/
		public void update(Graphics g) {
			paint(g);
			}

}	