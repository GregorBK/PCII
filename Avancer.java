import javax.swing.JOptionPane;

public class Avancer extends Thread{
	
	public Parcours parcours;
	public Affichage vue;
	public boolean ok = true;
	
	/**
	 * Contructeur d'Avancer
	 * @param p
	 * @param a
	 */
	public Avancer(Parcours p, Affichage a)
	{
		this.parcours = p;
		this.vue = a;
	}
	
	/**
	 * Thread permettant de déplacer le parcours à intervalle régulier
	 * et affiche le score après la défaite du joueur
	 */
	public void run()
	{
		while(ok)
		{
			this.parcours.majPosition();
			this.vue.revalidate();
			this.vue.repaint();
			ok = !Affichage.ETAT.testPerdu();
			
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		JOptionPane d = new JOptionPane();
		JOptionPane.showMessageDialog(d, "Vous avez perdu\n Votre score est de " + this.parcours.getPosition(),
				" Oh Noon... ", JOptionPane.INFORMATION_MESSAGE, null);
	}
}
