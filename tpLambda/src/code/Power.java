package code;

import java.util.function.Function;

public interface Power extends Function<Integer,Integer> {
	
	static<T> Function<T,T> identity(){
		return f->f;
	}
	
	
	static<T> T andThen(Function<T,T> f,Function<T,T> g,T x) {
		return g.apply(f.apply(x));
	}
	
	public static <T> Function<T,T> power(Function<T,T> f,int n) {
		if(n==0) {
			return Function.identity();
		}
		else {
			return f.andThen(power(f,n-1));
			
		}
	}

	

	

}
