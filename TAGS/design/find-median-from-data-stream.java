/*
 Median is the middle value in an ordered integer list. If the size of the list
is even, there is no middle value. So the median is the mean of the two middle
value. Examples:  [2,3,4] , the median is 3  [2,3] , the median is (2 + 3) / 2 =
2.5   Design a data structure that supports the following two operations:   void
addNum(int num) - Add a integer number from the data stream to the data
structure.  double findMedian() - Return the median of all elements so far.
For example:  add(1)
add(2)
findMedian() -> 1.5
add(3)
findMedian() -> 2  Credits: Special thanks to @Louis1992 for adding this problem
and creating all test cases.   Subscribe to see which companies asked this
question    Show Tags   Heap  Design
*/

public class MedianFinder {
    PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(Collections.reverseOrder());
    // Adds a number into the data structure.
    public void addNum(int num) {
        maxheap.offer(num);
        minheap.offer(maxheap.poll());
        if(maxheap.size() < minheap.size()){
            maxheap.offer(minheap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return maxheap.size() == minheap.size() ? (maxheap.peek() + minheap.peek()) / 2.0 : maxheap.peek();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();


// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
