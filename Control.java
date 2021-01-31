import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Effectue les changements dans Etat et informe l'Affichage du changement*/
public class Control implements MouseListener{
	
	public Etat etat;
	public Affichage vue;
	
	/**
	 * Constructeur*/
	public Control(Etat e, Affichage v)
	{
		this.etat = e;
		this.vue = v;
		v.addMouseListener(this);
	}
	
	/** 
	 * Appel la fonction de saut d'Etat et mettre à jour l'affichage
	 * lorsqu'un clique de la souris est détecté*/
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(!Affichage.ETAT.testPerdu())
		{
			etat.jump();
			vue.repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
