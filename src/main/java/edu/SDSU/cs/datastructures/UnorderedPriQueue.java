// Sky Johnson
//Evan Mikesell

package edu.sdsu.cs.datastructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class UnorderedPriQueue <E extends Comparable<? super E>> implements IPriorityQueue<E>  {

    private ArrayList<E> prQueue;
    private Comparator<E> comp;

    //default constructor
    public UnorderedPriQueue(){
        prQueue = new ArrayList<>();
        comp = comparator();
    }

    public UnorderedPriQueue(Comparator<E> comparator){
        prQueue = new ArrayList<>();
        comp = comparator;
    }

    public void enqueue(E item) {
        prQueue.add(item);
    }


    public E poll() {               //searches for the lowest priority element with sequential search
        E lowest = prQueue.get(0);
        int toRemove = 0;
        for(int i = 0; i < prQueue.size(); i++){
            if(comp.compare(prQueue.get(i), lowest) < 0){
                lowest = prQueue.get(i);
                toRemove = i;
            }
        }
        lowest = prQueue.remove(toRemove);
        return lowest;
    }


    public E peek() {
        E lowest = prQueue.get(0);
        for(int i = 0; i < prQueue.size(); i++){
            if(comp.compare(prQueue.get(i), lowest) < 0){
                lowest = prQueue.get(i);
            }
        }
        return lowest;
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

    public Comparator<E> comparator() {
        return Comparator.naturalOrder();
    }

    public Iterator<E> iterator() {
        return prQueue.iterator();
    }
}
