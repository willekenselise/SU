package batailleb;

import java.util.*;

public class Playeur {
	
	private List<Carte> cartes;
    private Integer points;
	public Playeur(List<Carte> cartes, Integer points) {
		
		this.cartes = cartes;
		this.points = points;
	}
	public Playeur() {
		this.cartes = new ArrayList<Carte>();
		this.points = 0;
	}
	public List<Carte> getCartes() {
		return cartes;
	}
	public Integer getPoints() {
		return points;
	}
	
	public void addCarte(Carte c) {
		this.cartes.add(c);
	}
	
	public void removeCarte(Carte c) {
		this.cartes.remove(c);
	}
	
	public Carte getFirstCarte() {
		Carte c = this.cartes.get(0);
		this.cartes.remove(c);
		return c;
	}
    
     
}
