package chapter2_sorting.PriorityQueues;
import edu.princeton.cs.algs4.*;
/******************************************************************************
 *  Compilation:  javac OrderedArrayMaxPQ.java
 *  Execution:    java OrderedArrayMaxPQ
 *  Dependencies: StdOut.java
 *
 *  Priority queue implementation with an ordered array.
 *
 *  Limitations
 *  -----------
 *   - no array resizing
 *   - does not check for overflow or underflow.
 *
 *
 ******************************************************************************/

public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;          // elements
    private int n;             // number of elements

    // set inititial size of heap to hold size elements
    public OrderedArrayMaxPQ(int capacity) {
        pq = (Key[]) (new Comparable[capacity]);
        n = 0;
    }


    public boolean isEmpty() { return n == 0;  }
    public int size()        { return n;       }

    //TODO  删除操作O(1)
    public Key delMax()      { return pq[--n]; }
    //TODO  插入操作 O(N)
    public void insert(Key key) {
        int i = n-1;
        while (i >= 0 && less(key, pq[i])) {
            //向后移动一位  直到key到达合适位置
            pq[i+1] = pq[i];
            i--;
        }
        pq[i+1] = key;
        n++;
    }



    /***************************************************************************
     * Helper functions.
     ***************************************************************************/
    private boolean less(Key v, Key w) {
        return v.compareTo(w) < 0;
    }

    /***************************************************************************
     * Test routine.
     ***************************************************************************/
    public static void main(String[] args) {
        OrderedArrayMaxPQ<String> pq = new OrderedArrayMaxPQ<String>(10);
        pq.insert("this");
        pq.insert("is");
        pq.insert("a");
        pq.insert("test");

        //TODO output: this > test > is > a
        while (!pq.isEmpty())
            StdOut.println(pq.delMax());
    }

}