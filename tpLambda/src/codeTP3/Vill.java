package codeTP3;

public class Vill implements Ville {
	Pays pays;
	int population;
	String nom;
	
	
	public Vill(Pays pays,int population, String nom) {
		this.pays = pays;
		this.population = population;
		this.nom = nom;
	}
	
	
	public void setPays(Pays pays) {
		this.pays = pays;
	}


	public void setPopulation(int population) {
		this.population = population;
	}


	public Pays getPays() {
		// TODO Auto-generated method stub
		return pays;
	}

	public int getPopulation() {
		// TODO Auto-generated method stub
		return population;
	}
	
	public String toString() {
		return "Ville présente dans le pays: "+pays+" avec une population de : "+population;
	}

}
