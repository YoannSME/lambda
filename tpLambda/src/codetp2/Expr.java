package codetp2;

import java.util.function.Function;

public interface Expr<V> {
	
	int eval(Function<V,Integer> env);
	
	public static <V> Expr<V> Var(V v) {
		 return env -> env.apply(v);
	}
	
	default Expr<V> add(Expr<V> e){
		return env -> e.eval(env)+this.eval(env);
	}
	
	default Expr<V> mul(Expr<V> e){
		return env -> e.eval(env)*this.eval(env);
	}
	
	
	
	public static void main(String[] args) {
        // Création des variables x et y
        Expr<String> x = Expr.Var("x");
        Expr<String> y = Expr.Var("y");

        // Création de l'expression x*x + y
        Expr<String> expression = x.mul(x).add(y);
        System.out.println(expression);

}
}
