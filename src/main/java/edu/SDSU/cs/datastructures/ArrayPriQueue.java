// Sky Johnson
//Evan Mikesell

package edu.sdsu.cs.datastructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class ArrayPriQueue <E extends Comparable<? super E>> implements IPriorityQueue<E>  {

    private ArrayList<E> prQueue;
    private Comparator<E> comp;

    //default constructor
    public ArrayPriQueue(){
        prQueue = new ArrayList<E>();
        comp = comparator();
    }

    public ArrayPriQueue(Comparator<E> comparator) {

        prQueue = new ArrayList<E>();
        comp = comparator;
    }

    public Comparator<E> comparator() {
        return Comparator.naturalOrder();
    }

    //order the items when entered
    public void enqueue(E item) {
        while(prQueue.isEmpty()){
            prQueue.add(item);
        }

        if (comp.compare(item, prQueue.get(prQueue.size()-1)) > 0){     //if the item is greater than the highest priority item in the list
            prQueue.add(item);                                      //adds item to end of the list
        }

        if (comp.compare(item, prQueue.get(0)) < 0){                    //if the item is smaller than the smallest priority item in the list
            prQueue.add(0, item);                          //adds item to beginning of the list
        }

        else {                                                       // uses binarySearch to find where to insert
            int index = binarySearch(prQueue, item, 0, prQueue.size() - 1);
            prQueue.add(index, item);
        }
    }


    public E poll() {
        return prQueue.remove(0);
    }

    public E peek() {
        return prQueue.get(0);           //similar to remove
    }


    public int size() {
        return prQueue.size();                          //using the ArrayList method size()
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

    private int binarySearch(ArrayList<E> list, E target, int low, int high){
        if (low < high) {
            int mid =(high + low) >> 1;                                 // divide by 2
            if (comp.compare(list.get(mid), target) == 0){
                return mid;                                              //if target is found
            }
            if (comp.compare(list.get(mid), target) > 0 ){
                return binarySearch(list, target, low, mid-1);     //if target is in bottom half
            }
            return binarySearch(list, target, mid+1, high);         //if target is in top half
        }
        return high;                                                     //if target is not found in entire list, inserts at the high
    }
}
