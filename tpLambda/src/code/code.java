package code;

import java.util.function.Function;

public class code {
	

	
	public static void main(String[] args) {
	
	Function<Integer,Integer> mul2 = x -> x+2;
	int k = mul2.apply(5);
	System.out.println(k);
	Function<Integer,Integer> div2 = x -> x*2;
	
	int z = div2.andThen(mul2).apply(3);
	System.out.println(z);
	
	
	
	}

}
