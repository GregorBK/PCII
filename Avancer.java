
public class Avancer extends Thread{
	
	public Parcours parcours;
	
	public Avancer(Parcours p)
	{
		this.parcours = p;
	}
	
	public void run()
	{
		while(true)
		{
			this.parcours.majPosition();;
		}
		
	}
}
