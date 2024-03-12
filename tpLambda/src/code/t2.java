package code;

public interface t2<Integer> {
	public int f2(t1 f);
	
	public static void main(String[] args) {
		class Cl2 implements t2{

			@Override
			public int f2(t1 f) {
				return f.f1(f.f1(0));	
				}	
		}
		t1 add = x -> x+2;
		Cl2 elem2 = new Cl2();
		System.out.println(elem2.f2(add));
	}

}
