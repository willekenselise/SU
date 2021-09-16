package batailleb;

public class Carte {
	private Integer valeur;
	private Integer couleur;
	

	public Carte() {
		
	}


	public Carte(Integer valeur, int couleur) {
		this.valeur = valeur;
		this.couleur = couleur;
	}



	public Integer getValeur() {
		return valeur;
	}


	public Integer getCouleur() {
		return couleur;
	}
	
	public String toName() {
		String str = new String();
		switch (this.valeur) {
		case 11:
			str += "vallet";
			break;
		case 12:
			str += "dame";
			break;
		case 13: 
			str += "roi";
			break;
		case 14: 
			str += "as";
			break;	
		default:
			str += this.valeur.toString();
			break;
    	}
    	
    	
    	switch (this.couleur) {
    		case 1:
    			str += " de coeur";
    			break;
    		case 2:
    			str += " de pique";
    			break;
    		case 3: 
    			str += " de carreau";
    			break;
    		case 4: 
    			str += " de trefle";
    			break;		
    	}
		
    	return str;
	}

	
}

