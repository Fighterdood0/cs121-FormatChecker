import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Array-based implementation of IndexedUnsortedList.
 * An Iterator with working remove() method is implemented, but
 * ListIterator is unsupported. 
 * 
 * @author 
 *
 * @param <T> type to store
 */
public class IUArrayList<T> implements IndexedUnsortedList<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private static final int NOT_FOUND = -1;
	
	private T[] array;
	private int rear;
	private int modCount;
	
	/** Creates an empty list with default initial capacity */
	public IUArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	/** 
	 * Creates an empty list with the given initial capacity
	 * @param initialCapacity
	 */
	@SuppressWarnings("unchecked")
	public IUArrayList(int initialCapacity) {
		array = (T[])(new Object[initialCapacity]);
		rear = 0;
		modCount = 0;
	}
	
	/** Double the capacity of array */
	private void expandCapacity() { //thank you for this
		array = Arrays.copyOf(array, array.length*2);
	}

	@Override
	public void addToFront(T element) {
		// TODO 
		if(rear >= array.length){ //if full
			expandCapacity();
		}
		for(int i = rear; i>0; i--){
			array[i] = array[i-1];
		}
		array[0] = element;
		rear++;
	}

	@Override
	public void addToRear(T element) {
		// TODO 
		if(rear >= array.length){ //if full
			expandCapacity();
		}
		array[rear] = element;
		rear++;
		
	}

	@Override
	public void add(T element) {
		// TODO 
		addToRear(element);
	}

	@Override
	public void addAfter(T element, T target) {
		// TODO 
		
	}

	@Override
	public void add(int index, T element) {
		// TODO 
		
	}

	@Override
	public T removeFirst() {
		// TODO 
		return null;
	}

	@Override
	public T removeLast() {
		// TODO 
		return null;
	}

	@Override
	public T remove(T element) {
		// TODO
		return null;
	}

	@Override
	public T remove(int index) {
		// TODO 
		return null;
	}

	@Override
	public void set(int index, T element) {
		// TODO 
		
	}

	@Override
	public T get(int index) {
		// TODO 
		if(index<0 || index>= rear){
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}

	@Override
	public int indexOf(T element) {
		// TODO
		int index = -1;
		int i = 0;
		while(i < rear && index<0){
		if(array[i].equals(element)){
			index = i;
		}
		i++;
	}
		return index;	
	}

	@Override
	public T first() {
		// TODO 
		if(isEmpty()){
		throw new NoSuchElementException();
		}
		return array[0];
		
	}

	@Override
	public T last() {
		// TODO 
		if(isEmpty()){
		throw new NoSuchElementException();
		}
		return array[rear-1];
	}

	@Override
	public boolean contains(T target) {
		// TODO
		boolean c = false;
		if(!isEmpty()){
			int i = 0;
			while(i<rear && c ==false){
				if(array[i].equals(target)){
					c = true;
				}
				i++;
			}
		}
		return c;
	}

	@Override
	public boolean isEmpty() {
		
		return rear==0;
	}

	@Override
	public int size() {
		// TODO 
		return rear;
	}

	@Override
	public Iterator<T> iterator() {
		return new ALIterator();
	}

	@Override
	public ListIterator<T> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<T> listIterator(int startingIndex) {
		throw new UnsupportedOperationException();
	}

	/** Iterator for IUArrayList */
	private class ALIterator implements Iterator<T> {
		private int nextIndex;
		private int iterModCount;
		private boolean canRemove;
	
		/** Initialize a new Iterator for IUArrayList */
		public ALIterator() {
			nextIndex = 0;
			iterModCount = modCount;
			canRemove = false;
		}

		@Override
		public boolean hasNext() {
			// TODO 
			return false;
		}

		@Override
		public T next() {
			// TODO 
			return null;
		}
		
		@Override
		public void remove() {
			// TODO
			
		}
	}
}