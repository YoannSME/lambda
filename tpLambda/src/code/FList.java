package code;

import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;
import java.util.function.Predicate;

public class FList<T> {
	public List<T> map(List<T> lst, Function<T,T> fn){
		for(ListIterator<T> it = lst.listIterator();it.hasNext();) {
			T elem = it.next();
			fn.apply(elem);
			it.set(elem);
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
				return true;
			}
		}
		return false;
		
	}
	
	
	

}
