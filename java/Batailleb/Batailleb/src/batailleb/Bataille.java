package batailleb;

import java.util.*;

public class Bataille {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		List<Carte> paquet = new ArrayList<Carte>();
		for(Integer j = 1; j < 5; j++){
			for(Integer k = 2; k < 14; k++) {
				Carte c = new Carte(k, j);
				paquet.add(c);
		}}
		
		Playeur p1 = new Playeur();
		Playeur p2 = new Playeur();
		
		Collections.shuffle(paquet);
		
		for(Carte c : paquet) {
			if(i % 2 == 0) {
				p1.addCarte(c);
			}else {
				p2.addCarte(c);
			}
			i++;
		}
		
		while(p1.getCartes().size() > 0 && p2.getCartes().size() > 0) {
			Carte carte1 = p1.getFirstCarte();
			Carte carte2 = p2.getFirstCarte();
			System.out.println(carte1.toName() + " VS " + carte2.toName());
			if(carte1.getValeur() > carte2.getValeur()) {
				System.out.println("playeur 1 win ");
				p1.addCarte(carte2);
				p1.addCarte(carte1);
			}else if(carte1.getValeur() < carte2.getValeur()) {
				System.out.println("playeur 2 win ");
				p2.addCarte(carte1);
				p2.addCarte(carte2);
				
			}else {
				System.out.println("equals ");
				p1.addCarte(carte1);
				p2.addCarte(carte2);
			}
			System.out.println(p1.getCartes().size() + " " + p2.getCartes().size());
		}
		
		
		if(p1.getCartes().size() > 0) {
			System.out.println("playeur 1 win");
		}else {
			System.out.println("playeur 2 win");
		}
		
	}

}
