package codeTP3;

import java.util.ArrayList;
import java.util.List;

public class Pay implements Pays{
	List<Ville> lst = new ArrayList<>();
	String continent;
	Ville capitale;
	int population;
	
	
	public Pay(String continent, Ville capitale, int population) {
		this.continent = continent;
		this.capitale = capitale;
		this.population = population;
	}
	

	public boolean add(Ville v) {
		return lst.add(v);
	}
	public List<Ville> getVille() {
		return lst;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public void setCapitale(Ville capitale) {
		this.capitale = capitale;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public List<Ville> getVilles() {
		// TODO Auto-generated method stub
		return lst;
	}

	@Override
	public String getContinent() {
		// TODO Auto-generated method stub
		return continent;
	}

	@Override
	public Ville getCapitale() {
		// TODO Auto-generated method stub
		return capitale;
	}

	@Override
	public int getPopulation() {
		// TODO Auto-generated method stub
		return population;
	}
	

}
