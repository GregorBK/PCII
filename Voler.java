
public class Voler extends Thread {
	
	public Etat etat;
	
	/**
	 * Constructeur
	 * @param e
	 */
	public Voler(Etat e)
	{
		this.etat = e;
	}
	
	/**
	 * Appelle la fonction moveDown à intervalle régulier infiniment
	 */
	public void run()
	{
		while(true)
		{
			this.etat.moveDown();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}
