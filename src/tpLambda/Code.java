package tpLambda;

import java.util.function.BiFunction;
import java.util.function.Function;

import java.util.*;

public class Code {
	
	public static Function<Integer,Integer> f1 = x -> x+1;
	
	public static Function<Integer,Integer> print = x -> {
		System.out.println(f1.apply(x));
		return x;
		
	};
	
	interface t1<Integer>{
		public int t1(int i);
	}
	
	interface t2<Integer>{
		public int t2(int a,int b);	
	}
	
	interface t3<T>{
		public T t3(Function<T,T>f,T elem);
	}
	
	public static Function<Function<Integer, Integer>, Integer> f2 = (f) -> f.apply(f.apply(0));
	
	static t3 fn = (f,x) -> f.apply(f.apply(x));
	
	@FunctionalInterface
	public interface Power<T> extends Function<T, T> {
	    // Définition de power
	    static <T> Power<T> power(int n, Power<T> f) {
	       if(n==0) {
	            return identity();
	    }
	       else {
	    	   return t -> f.apply(Power.power(n - 1, f).apply(t));
	       }
	    }
	    
	    static <T> Power<T> identity() {
	        return t -> t;
	    }

	   
	    default Power<T> andThen(Power<T> after) {
	        return t -> after.apply(this.apply(t)); 
	    }
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("***PARTIE 1***\n");
		//1.1
		t1 fn = x -> x+1;
		int x = f1.apply(5);
		if(x!=6) {
			System.exit(1);
		}
		print.apply(5);
			
		//1.2//
		System.out.println("f2: "+f2.apply(f1));
		
		//1.3//
		//System.out.println("f3: "+f3((^),'x'),'a');
		
		System.out.println("***PARTIE 2***\n");
		//1.1//
		System.out.println(f1.apply(6));
		//1.2//
		Function<Integer,Integer> g = elem -> elem*2;
		Function<Integer,Integer> f = elem2 -> elem2+1;
		Function<Integer,Integer> h = f.andThen(g);
		
		System.out.println(h.apply(3));
		
		//1.3//
//		public static <T, R> Function<T, R> comp2(Function<T, R> f1, Function<T, R> f2, BiFunction<R, R, R> g) {
//	        return x -> g.apply(f1.apply(x), f2.apply(x));
//	    }
	
	}

}
