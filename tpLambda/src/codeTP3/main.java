package codeTP3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.PrimitiveIterator.OfDouble;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class main {
	
	static int cptChiffres(int x) {
		int  s = 0;
		while(x>0) {
			s+=1;
			x = x/10;
		}
		return s;
	
	}
	
	static Ville capitaleMAXppl(Stream<Pays> P) {
		Optional<Ville> v = P.flatMap(p -> p.getVilles().stream())
		.max(Comparator.comparingInt(Ville::getPopulation));
		
		return v.orElse(null) ;
	}
	
	static List<Pays> triCPc(Stream<Pays> P){
		List<Pays> lst = new ArrayList<>();
		lst = P.sorted(Comparator.comparing(Pays::getContinent).thenComparing(Pays::getPopulation)).collect(Collectors.toList());
		
		return lst;
	}
	
	static List<Pays> triCPd(Stream<Pays> P){
		List<Pays> lst = new ArrayList<>();
		lst = P.sorted(Comparator.comparing(Pays::getContinent).reversed().thenComparing(Comparator.comparing(Pays::getPopulation).reversed())).collect(Collectors.toList());
		
		return lst;
	}
	
	public static void main(String[] args) {
		
		Function<Integer,Integer> fact = n -> 
		IntStream.range(1, n+1)
		.reduce(1,(x,y)->x*y);
	
		System.out.println(fact.apply(6));
		
		List<Integer> lst =
		Stream.iterate(1,x->x+1)
		.map(fact)
		.limit(10)
		.toList();
		
		System.out.println(lst);
		
		Stream.iterate(1,x->x+1)
		.map(fact)
		.limit(10)
		.forEach(x -> System.out.print(x+" "));
		
		System.out.println(" ");
		

		Stream.iterate(1,x->x+1)
		.map(fact)
		.limit(4)
		.forEach(x -> {if(cptChiffres(x)%2==0) {System.out.println(x);}});
		
		class Pair{
			int entier;
			int factorielle;
			
			public Pair(int entier) {
				this.entier = entier;
				this.factorielle = fact.apply(entier);
			}
			
			public int getFactorielle() {
				return factorielle;
			}
		}
		
		Stream.iterate(0,x->x+1)
		.limit(10)
		.forEach(x -> {
		System.out.print(new Pair(x).getFactorielle()+" ");
		});
		
		List<Produit> prods = new ArrayList<>();
		for(int i = 0;i<150;i++) {
			prods.add(new Produits(i));
		}
		
		int sum = prods.stream()
				.mapToInt(x -> x.getPrix())
				.sum();
		
		System.out.println("\n"+sum);
		
		int sumReuce = prods.stream()
				.mapToInt(x->x.getPrix())
				.reduce(0,(x,y) -> x+y);
				
		System.out.println("\n"+sumReuce);
		
		
		
		Ville vl1 = new Vill(null,10000,"ville1");
		Ville vl2 = new Vill(null,20000,"ville2");
		Ville vl3 = new Vill(null,30000,"ville3");
		Ville vl4 = new Vill(null,40000,"ville4");
		
		Pays p1 = new Pay("Cont1", vl1,100000);
		Pays p2 = new Pay("Cont2",vl2,200000);
		Pays p3 = new Pay("Cont3", vl3, 300000);
		Pays p4 = new Pay("Cont4",vl4,400000);
		
		vl1.setPays(p1);
		vl2.setPays(p2);
		vl3.setPays(p3);
		vl4.setPays(p4);
		
		Collections.addAll(p1.getVilles(),vl1,vl2,vl3,vl4);
		Collections.addAll(p2.getVilles(), vl2,vl3,vl4);
		Collections.addAll(p3.getVilles(),vl3,vl4);
		Collections.addAll(p4.getVilles(),vl4);
		
		
		List<Pays> lstPays = new ArrayList<>();
		Collections.addAll(lstPays, p1,p2,p3,p4);
		List<Ville> lstVille = new ArrayList<>();
		Collections.addAll(lstVille, vl1,vl2,vl3,vl4);
		
		System.out.println(capitaleMAXppl(lstPays.stream()));
		
		List<Pays> tri = triCPc(lstPays.stream());
		for(Pays p:tri) {
			System.out.println(p.getContinent()+p.getPopulation());
		}
		System.out.println("");
		List<Pays> tri2 = triCPd(lstPays.stream());
		for(Pays p:tri2) {
			System.out.println(p.getContinent()+p.getPopulation());
		}
		
		
		
		
		
	}

}
