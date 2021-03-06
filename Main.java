import javax.swing.JFrame;

/** Fais le lien entre l'Etat, l'Affichage et le Controle*/
public class Main {
	  public static void main(String [] args) {
		  
		  Etat etat = new Etat(50);
		  Affichage vue = new Affichage(etat);
		  Parcours parcours = new Parcours(vue);
		  parcours.affichePoint();
		  Control control = new Control(etat, vue);
		  etat = new Etat(etat.getHauteur(),vue, parcours);
		  vue = new Affichage(etat);
		  control = new Control(etat,vue);
		  Voler vol = new Voler(etat,vue);
		  Avancer avancer = new Avancer(parcours,vue);
		  
		  
		  JFrame test = new JFrame("Test dessin");
          test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          test.add(vue);
          test.pack();
          test.setVisible(true);
          vol.start();
          avancer.start();
          
		  }
}
