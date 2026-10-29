
/*
    Create a list that points ifnront and behind each part
@author Zach Jessup
@date 10/30/26
*/

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class IUDoubleLinkedList<T> implements IndexedUnsortedList<T>{

    private Node<T> head;
    private Node<T> tail;
    private int modCount;
    private int size;

        /**Initialize new empty list */
    public IUDoubleLinkedList(){
        head = tail = null;
        size = modCount = 0;
    }
    @Override
    public void addToFront(T element) {
        Node<T> newNode = new Node<T>(element);
        newNode.setNextNode(head);
        if (!isEmpty()){
        head.setPrevNode(newNode);
        }
        head = newNode;
        if(tail == null){
            tail = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public void addToRear(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addToRear'");
    }

    @Override
    public void add(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void addAfter(T element, T target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAfter'");
    }

    @Override
    public void add(int index, T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public T removeFirst() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFirst'");
    }

    @Override
    public T removeLast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeLast'");
    }

    @Override
    public T remove(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public T remove(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void set(int index, T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public T get(int index) {//TODO which end is closer
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        T returnElement = null;
        Node<T> node = head;
        for(int i = 0; i<index; i++){
            node = node.getNextNode();
        }
        returnElement = node.getElement();
        return returnElement;
    }

    @Override
    public int indexOf(T element) {
        int currentIndex = 0;
        int returnIndex = -1;
        Node<T> currentNode = head;
        while(currentNode != null && returnIndex < 0){
            if(!currentNode.getElement().equals(element)){
            returnIndex = currentIndex;
            }else{
            currentNode = currentNode.getNextNode();
            currentIndex++;
            }
        }
        return returnIndex;
    }

    @Override
    public T first() {
        return head.getElement();
    }

    @Override
    public T last() {
        return tail.getElement();
    }

    @Override
    public boolean contains(T target) {
        return indexOf(target)>-1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public ListIterator listIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator listIterator(int startingIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }
    
}
