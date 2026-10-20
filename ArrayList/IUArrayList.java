import java.util.Arrays;
import java.util.ConcurrentModificationException;
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
		if(rear >= array.length){
		array = Arrays.copyOf(array, array.length*2);
		}
	}

	@Override
	public void addToFront(T element) { 
		expandCapacity();
		for(int i = rear; i>0; i--){
			array[i] = array[i-1];
		}
		array[0] = element;
		rear++;
		modCount++;
	}

	@Override
	public void addToRear(T element) { 
		expandCapacity();
		array[rear] = element;
		rear++;
		modCount++;
	}

	@Override
	public void add(T element) { 
		addToRear(element);
	}

	@Override
	public void addAfter(T element, T target) {
		if(isEmpty()){
		throw new NoSuchElementException();
		} 
		expandCapacity();
		int newIndex = indexOf(target);
		for(int i = rear; i>newIndex+2; i--){
			array[i] = array[i-1];
		}
		array[newIndex+1] = element;
		rear++;
		modCount++;
	}

	@Override
	public void add(int index, T element) {
		T newElement = get(index);
		addAfter(element, newElement);
	}

	@Override
	public T removeFirst() {
		if(isEmpty()){
		throw new NoSuchElementException();
		} 
		T removedElement = array[0];
		for(int i = 0; i<rear-1; i++){
			array[i] = array[i+1];
		}
		array[rear-1] = null;
		rear--;
		modCount++;
		return removedElement;
	}

	@Override
	public T removeLast() {
		if(isEmpty()){
		throw new NoSuchElementException();
		}
		T removedElement = array[rear-1]; 
		array[rear-1] = null;
		return removedElement;
	}

	@Override
	public T remove(T element) {
		if(isEmpty()){
		throw new NoSuchElementException();
		}
		int removedIndex = indexOf(element);
		T removedElement = array[removedIndex];
		for(int i = removedIndex; i<rear-1; i++){
			array[i] = array[i+1];
		}
		array[rear-1] = null;
		rear--;
		modCount++;
		return removedElement;
	}

	@Override
	public T remove(int index) {
		T removedElement = get(index);
		removedElement = remove(removedElement); 
		return removedElement;
	}

	@Override
	public void set(int index, T element) { 
		array[index] = element;
		modCount++;
	}

	@Override
	public T get(int index) { 
		if(index<0 || index>= rear){
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}

	@Override
	public int indexOf(T element) {
		int index = NOT_FOUND;
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
		if(isEmpty()){
		throw new NoSuchElementException();
		}
		return array[0];
		
	}

	@Override
	public T last() { 
		if(isEmpty()){
		throw new NoSuchElementException();
		}
		return array[rear-1];
	}

	@Override
	public boolean contains(T target) {//missed the in class code
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
			if(iterModCount != modCount){
				throw new ConcurrentModificationException();
			}
			return nextIndex < rear;
		}

		@Override
		public T next() {
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			nextIndex++; 
			canRemove = true;
			return array[nextIndex-1];
		}
		
		@Override
		public void remove() {
			if(iterModCount != modCount){
				throw new ConcurrentModificationException();
			}
			if(!canRemove){
				throw new IllegalStateException();
			}
			canRemove = false;
			for(int i = nextIndex-1; i<rear-1; i++){
				array[i] = array[i+1];
			}
			rear--;//removed something
			array[rear] = null;//no memory leak
			modCount++;//changed something
			iterModCount++;//WE changed something
			nextIndex--;//fewer elements than before
		}
	}//end of Iterator
}//end of ArrayList