
public class Voler extends Thread {
	
	public Etat etat;
	public Affichage vue;
	public boolean ok = true;
	
	/**
	 * Constructeur
	 * @param e
	 */
	public Voler(Etat e, Affichage a)
	{
		this.etat = e;
		this.vue = a;
	}
	
	/**
	 * Appelle la fonction moveDown à intervalle régulier infiniment
	 */
	public void run()
	{
		while(ok)
		{
			this.etat.moveDown();
			ok = !this.etat.testPerdu();
			vue.revalidate();
			vue.repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
