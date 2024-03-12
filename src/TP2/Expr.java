package TP2;

import java.util.function.Function;

public interface Expr<V> {
	int eval(Function<V, Integer> env);
	
	static <V> Expr<V> Var(V v) {
		return env->env.apply(v);	
	}
	
	default Expr<V> add(Expr<V> e){
		return env -> this.eval(env)+e.eval(env);
		
	}
	
	default Expr<V> mul(Expr<V> e){
		return env -> this.eval(env)*e.eval(env);
		
	}
	
	public static void main(String[] args) {
		
	}
	
	
	
	
	

}
