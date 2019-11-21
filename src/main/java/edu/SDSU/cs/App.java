// Sky Johnson
//Evan Mikesell

package edu.sdsu.cs;

import edu.sdsu.cs.datastructures.ArrayPriQueue;
import edu.sdsu.cs.datastructures.HeapPriQueue;
import edu.sdsu.cs.datastructures.UnorderedPriQueue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        HeapPriQueue heap = new HeapPriQueue();
        ArrayPriQueue orderedList = new ArrayPriQueue();
        UnorderedPriQueue unorderedList = new UnorderedPriQueue();



        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("ArrayPriQueue: \n");
            int n = 100000;
            for(int counter = 0; counter < 3; counter++) {

                long startTime = System.nanoTime();

                for (int i = 0; i < n; i++) {
                    orderedList.enqueue(Math.random());
                }

                Long orderedListTime = (System.nanoTime() - startTime);
                writer.write("Offer() with n = " + n + ": ");
                writer.write(orderedListTime.toString() + "ns \n");

                startTime = System.nanoTime();
                orderedList.poll();
                orderedListTime = (System.nanoTime() - startTime);
                writer.write("Poll()  with n = " + n + ": ");
                writer.write(orderedListTime.toString() + "ns \n");

                n *= 2;
                orderedList.clear();
            }
            writer.append("\n\nUnorderedPriQueue: \n");
            n = 100000;
            for(int counter = 0; counter < 3; counter++) {

                long startTime = System.nanoTime();

                for (int i = 0; i < n; i++) {
                    unorderedList.enqueue(Math.random());
                }

                Long unOrderedListTime = (System.nanoTime() - startTime);
                writer.append("Offer() with n = " + n + ": ");
                writer.append(unOrderedListTime.toString() + "ns \n");
                startTime = System.nanoTime();

                unorderedList.poll();

                unOrderedListTime = (System.nanoTime() - startTime);
                writer.append("Poll()  with n = " + n + ": ");
                writer.append(unOrderedListTime.toString() + "ns \n");
                n *= 2;
                unorderedList.clear();
            }
            writer.append("\n\nHeapPriQueue: \n");
            n = 100000;
            for(int counter = 0; counter < 3; counter++) {

                long startTime = System.nanoTime();

                for (int i = 0; i < n; i++) {
                    heap.enqueue(Math.random());
                }

                Long heapTime = (System.nanoTime() - startTime);
                writer.append("Offer() with n = " + n + ": ");
                writer.append(heapTime.toString() + "ns \n");

                startTime = System.nanoTime();

                heap.poll();

                heapTime = (System.nanoTime() - startTime);
                writer.append("Poll()  with n = " + n + ": ");
                writer.append(heapTime.toString() + "ns \n");
                n *= 2;
                heap.clear();
            }
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }









    }
}