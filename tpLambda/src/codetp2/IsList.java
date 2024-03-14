package codetp2;

import java.util.function.BiFunction;

public interface IsList<E, L extends IsList<E,L>> {
	L add(E x);
	<T> T cases(T z,BiFunction<E,L,T> f);
	
	default boolean isEmpty() {
		return this.cases(true,(elem,lst)->false);
	}

}
