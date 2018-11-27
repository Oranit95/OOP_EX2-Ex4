package GIS;

import java.util.Collection;
import java.util.Iterator;

public class project implements GIS_project {

	@Override
	public boolean add(GIS_layer e) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends GIS_layer> c) {
		return false;
	}

	@Override
	public void clear() {		
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Iterator<GIS_layer> iterator() {
		return null;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public Meta_data get_Meta_data() {
		return null;
	}

}
