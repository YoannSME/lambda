package code;

import java.util.function.Function;

public interface t3<A> {
	public <A> A fn3(Function<A,A> f,A elem);
	
	public static void main(String[] args) {
		class Cl3 implements t3{

			@Override
			public Object fn3(Function f, Object elem) {
				return f.apply(f.apply(elem));
			}

			
		}
		
		Function<String,String> f3 = s -> s.concat("x");
		Cl3 elem3 = new Cl3();
		System.out.println(elem3.fn3(f3, "a"));
		
	}
	
	

}
