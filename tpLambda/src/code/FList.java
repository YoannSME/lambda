package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;
import java.util.function.Predicate;

public class FList<T> {
	private List<T> list;
	public FList(List<T> l) {
		this.list = l;
	}
	
	public List<T> map(List<T> lst, Function<T,T> fn){
		for(ListIterator<T> it = lst.listIterator();it.hasNext();) {
			T elem = it.next();
			it.set(fn.apply(elem));
		}
		return lst;	
	}
	
	public List<T> filter(List<T> lst, Predicate<T> op){
		for(ListIterator<T> it = lst.listIterator();it.hasNext();) {
			T elem = it.next();
			if(!op.test(elem)) {
				it.remove();
			}
		}
		return lst;
		
	}
	
	public boolean for_all(List<T> lst, Predicate<T> op){
		for(ListIterator<T> it = lst.listIterator();it.hasNext();) {
			T elem = it.next();
			if(!op.test(elem)) {
				return false;
			}
		}
		return true;
		
	}
	
	public boolean exists(List<T> lst, Predicate<T> op){
		for(ListIterator<T> it = lst.listIterator();it.hasNext();) {
			T elem = it.next();
			if(op.test(elem)) {
				System.out.println("index: "+it.previousIndex());
				return true;
			}
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		List<Integer> lst = new ArrayList<>();
		
		for(int i = 0;i<150;i++) {
			lst.add(i);
		}
		
		FList op = new FList<Integer>(lst);
		Function<Integer,Integer> add1 = x -> x+1;
		op.map(lst, add1);
		System.out.println(lst);
		Predicate<Integer> divi2 = x -> x%2==0;
		System.out.println(op.filter(lst, divi2));
		Predicate<Integer> whereis8 = x -> x==8;
		System.out.println(op.exists(lst, whereis8));
		
		
	}
	
	

}
