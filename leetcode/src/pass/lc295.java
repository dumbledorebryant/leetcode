package pass;

import java.util.PriorityQueue;

public class lc295 {

}

class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> l = new PriorityQueue<>((a,b)->b-a);
    PriorityQueue<Integer> r = new PriorityQueue<>((a,b)->a-b);

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        int len_l = l.size();
        int len_r = r.size();

        // if l == r, put the num in the left
        if (len_l == len_r){
            if (r.isEmpty() || num <= r.peek()){
                l.add(num);
            }
            else {
                l.add(r.poll());
                r.add(num);
            }
            
        }

        // if l > r, put the num in the right
        if (len_l > len_r){
            if (num < l.peek()){
                r.add(l.poll());
                l.add(num);
            }
            else {
                r.add(num);
            }
        }
    }
    
    public double findMedian() {
        if (l.size() > r.size()) return l.peek();
        else return (l.peek() + r.peek()) / 2.0;
    }
}
