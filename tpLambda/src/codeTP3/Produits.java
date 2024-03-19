package codeTP3;

public class Produits implements Produit{
	int prix;
	
	public Produits(int prix) {
		this.prix = prix;
	}

	@Override
	public int getPrix() {
		// TODO Auto-generated method stub
		return prix;
	}

}
