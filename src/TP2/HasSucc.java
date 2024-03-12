package TP2;

import java.util.function.Function;

interface HasSucc<N extends HasSucc<N>> {
	N Succ();
	
	 <T> T cases(T x, Function<N, T> f);
	 
	 public default <T> boolean isSucc() {
		 T x -> this.cases(x, this.equals(x));

}
}
