package code;

public interface t1<Integer> {
	public int f1(int x);
	
	
	public static void main(String[] args) {
		
		class Cl1 implements t1{
			public int f1(int x) {
				return x+1;
			}
			
		}
		
		Cl1 elem1 = new Cl1();
		
		System.out.println(elem1.f1(3));
		
		
		
	}

}
