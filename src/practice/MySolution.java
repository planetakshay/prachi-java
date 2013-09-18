package practice;

/**
 * Problems asked in proofpoint phone screen.
 * 
 * @author Prachi
 *
 */
class Node {

	int data;
	Node link;
}

public class MySolution {
	public boolean isCyclic(Node head) {

		if (head == null) {

			return false;
		}
		Node slow = head;
		Node fast = head;

		while (slow != null) {

			slow = slow.link;

			if (fast.link == null) {

				return false;
			} else {

				fast = fast.link.link;
			}
		}

		if (slow == fast) {

			return true;
		}
		
		return false;

	}

	public String getWordsInReverseOrder(String str) {

		char[] array = str.toCharArray();

		array = reverseWordString(array, 0, array.length);

		int start = 0, end = 0;

		while (end < array.length) {

			while (array[end] != 32) {

				end++;
			}
			end--;
			reverseWordString(array, start, end);
			end = end + 2;
			start = end;

		}

		return str;
	}

	public char[] reverseWordString(char[] chars, int start, int end) {

		char c = '\0';
		while (start < end) {
			c = chars[start];

			chars[start] = chars[end];
			chars[end] = c;

			start++;
			end--;
		}
		return chars;
	}
}

// This is the sentence --> sentence the is This


/**
 * 
 * 
public interface TwoSum {
    /**
     * Stores @param input in an internal data structure.
    
    void store(int input);
 
    /**
     * Returns true if there is any pair of numbers in the internal data structure which
     * have sum @param val, and false otherwise.
     * For example, if the numbers 1, -2, 3, and 6 had been stored,
     * the method should return true for 4, -1, and 9, but false for 10, 5, and 0
     
    boolean test(int val);
}

public class TwoSumImpl implements TwoSum {

    List<Integer> data = new LinkedList<Integer>();
    Set<Integer> sum= new HashSet<Integer>();
    
    void store(int input) {
    

    
        if(data.size() >= 1) {
        
            for(int val : data) {
            
                sum.add(val + input);
                }            
                }
        data.add(input);

        }
    }
    
    boolean test(int val) {
    
    return sum.contains(val);

    }
}

store(1)
store(-2)
test(-1) : true
store(3)


/* Provide a partial implementation of the BlockingQueue interface from Java 1.5,
 * in particular providing a thread-safe queue supporting the following operations:
 
public interface BlockingQueue<T>
{
    // Retrieves and removes the head of the queue, waiting if no elements are present
    public T take();
 
    // Adds the specified element to this queue, waiting if necessary for space to become available
    public void put (T obj);
}



public class BlockingQueueImpl<T> implements BlockingQueue<T> {

    public static final QUEUE_SIZE = 10;
    
    List<T> blockingQueue = new LinkedList<T>();
    
    public void put(T obj) {
    
    synchronized(blockingQueue) {
    
        if( blockingQueue.size() == QUEUE_SIZE) {
        
                wait();
        }
     }   
        blockingQueue.add(obj);
        
        notifyAll();

    }
    
    public T take() {
    
        notifyAll();
        
        if(blockingQueue.size == 0) {
        
            wait();
        }
        
        return blockingQueue.poll();
    }

}

 * 
 */
