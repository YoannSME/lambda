package code;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface comp2 {
	static <A> A comp2(Function<A,A> f1,Function<A,A> f2,BiFunction<A,A,A> g,A x) {
		return g.apply(f1.apply(x), f2.apply(x));
	}
	
	public static void main(String[] args) {
		
		Function<Integer,Integer> f1 = x -> x+1;
		Function<Integer,Integer> f2 = x -> x*1;
		
		System.out.println(Integer.max(f1.apply(2), f2.apply(2)));

		
		
	}

}
