// Sky Johnson
//Evan Mikesell

package edu.sdsu.cs.datastructures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class HeapPriQueue <E extends Comparable<? super E>> implements IPriorityQueue<E>  {

    private PriorityQueue<E> prQueue;
    private Comparator<E> comp;

    //default constructor
    public HeapPriQueue(){
        prQueue = new PriorityQueue<>();
        comp = comparator();
    }

    public HeapPriQueue(Comparator<E> comparator){
        prQueue = new PriorityQueue<>();
        comp = comparator;
    }

    public Comparator<E> comparator() {
        return Comparator.naturalOrder();
    }


    public void enqueue(E item) {
        prQueue.offer(item);
    }

    public E poll() {
        return prQueue.poll();
    }


    public E peek() {
        return prQueue.peek();
    }


    public int size() {
        return prQueue.size();
    }

    public void clear() {
        prQueue.clear();
    }

    public boolean isEmpty() {
        return prQueue.isEmpty();
    }

    public Iterator<E> iterator() {
        return prQueue.iterator();
    }
}
