//o(1) for get using queue + bitset. o(n) for space
public class PhoneDirectory {
    private boolean[] map;
    private int len = 0;
    private Queue<Integer> frees = new LinkedList<>();
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        len = maxNumbers;
        map = new boolean[len];
        for (int i = 0; i < len; i++) {
            map[i] = true;
            frees.offer(i);
        }
    }
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        Integer ret = frees.poll();
        if (ret == null) {
            return -1;
        }
        map[ret] = false;
        return ret;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number > len || number < 0) return false;
        return map[number];
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (number > len || number < 0) return ;
        if (!map[number]) {
            map[number] = true;
            frees.offer(number);
        }
    }
}
//o(n) for space, worse case o(n) for get
public class PhoneDirectory {

    BitSet bitset;
    int max; // max limit allowed
    int smallestFreeIndex; // current smallest index of the free bit

    public PhoneDirectory(int maxNumbers) {
        this.bitset = new BitSet(maxNumbers);
        this.max = maxNumbers;
    }

    public int get() {
        // handle bitset fully allocated
        if(smallestFreeIndex == max) {
            return -1;
        }
        int num = smallestFreeIndex;
        bitset.set(smallestFreeIndex);
        //Only scan for the next free bit, from the previously known smallest free index
        smallestFreeIndex = bitset.nextClearBit(smallestFreeIndex);
        return num;
    }

    public boolean check(int number) {
        return bitset.get(number) == false;
    }

    public void release(int number) {
        //handle release of unallocated ones
        if(bitset.get(number) == false)
            return;
        bitset.clear(number);
        if(number < smallestFreeIndex) {
            smallestFreeIndex = number;
        }
    }
}

//using LinkedHashSet
public class PhoneDirectory {
    LinkedHashSet<Integer> available;

    public PhoneDirectory(int maxNumbers) {
        available = new LinkedHashSet<Integer>();
        for(int i = 0; i < maxNumbers; ++i) {
            available.add(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
    @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(available.isEmpty()) {
            return -1;
        }
        Iterator<Integer> it = available.iterator();
        int number = it.next();
        available.remove(number);
        return number;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return available.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        available.add(number);
    }
}
