package us.lsi.flujossecuenciales;

import java.util.Iterator;
import java.util.function.Predicate;

public class IteratorFilter<E> implements Iterator<E>,Iterable<E> {
	
	private Iterator<E> iterator;
	private Predicate<E> p;
	private E ret;
	
	
	public static <E> IteratorFilter<E> of(Iterator<E> iterator, Predicate<E> p){
		return new IteratorFilter<>(iterator,p);
	}
	
	public IteratorFilter(Iterator<E> iterator, Predicate<E> p) {
		super();
		this.iterator = iterator;
		this.p = p;
		this.ret = first(this.iterator,this.p);
	}

	public static <E> E first(Iterator<E> s, Predicate<E> h) {
		E r = null;
		while(s.hasNext() && r==null){
			E e = s.next();
			if(h.test(e)) r = e;
		}
		return r;
	}

	@Override
	public boolean hasNext() {
		return this.ret != null;
	}


	@Override
	public E next() {
		E old = ret;
		this.ret = first(this.iterator,this.p);
		return old;
	}
	
	@Override
	public Iterator<E> iterator() {
		return this;
	}
	
}

