package codetp2;

import java.util.function.Function;

interface HasSucc<N extends HasSucc<N>> {
	N Succ(); 
	<T> T cases(T x, Function<N,T> f); 
	
	public default boolean isSucc() {
		return cases(true,p->false);
	}
	
	public default N pred() {
		if(this.Succ()!=null) {
			return this.Succ();
		}
		return this.Succ();
	}

}

