package tpLambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;
import java.util.function.Predicate;

public class FList<T> {
	
	public void afficheLst(List<T> l) {
		l.forEach(System.out::println);
	}
	
	public List<T> map(List<T> lst,Function<T,T> fn){
		for(ListIterator<T> it = lst.listIterator();it.hasNext();) {
			T elem = it.next();
			elem = fn.apply(elem);
			it.set(elem);
		}
		return lst;
	}
	
	public List<T> filter(List<T> lst,Predicate<T> op){
		for(ListIterator<T> it = lst.listIterator();it.hasNext();) {
			T elem = it.next();
			if(!op.test(elem)) {
				it.remove();
			}
		}
		return lst;
	}

	public boolean for_all(List<T> lst,Predicate<T> op){
		for(ListIterator<T> it = lst.listIterator();it.hasNext();) {
			T elem = it.next();
			if(!op.test(elem)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean exists(List<T> lst,Predicate<T> op){
		for(ListIterator<T> it = lst.listIterator();it.hasNext();) {
			T elem = it.next();
			if(op.test(elem)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		FList<Integer> lst = new FList<Integer>();
		List<Integer> list = new ArrayList<>();
		Collections.addAll(list,1,2,3,4,5,6);
		list = lst.map(list, x->x+1);
		System.out.println("map : x+=1 :");
		lst.afficheLst(list);
		System.out.println("\n filter x%2 :");
		list = lst.filter(list, x->x%2==0);
		lst.afficheLst(list);
		System.out.println("\nlst_forall x>0:");
		boolean arePositive = lst.for_all(list, x->x>0);
		System.out.println(arePositive);
		System.out.println("\nlst_exists : ");
		boolean is7here = lst.exists(list, x->x==3);
		System.out.println(is7here);
	}
}
