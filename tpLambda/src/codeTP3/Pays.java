package codeTP3;

import java.util.List;

public interface Pays {
	List<Ville> getVilles();
	String getContinent();
	Ville getCapitale();
	int getPopulation();
	boolean add(Ville v);
}
