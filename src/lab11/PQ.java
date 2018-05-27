package lab11;
import java.util.*;

public class PQ {
	private boolean valueSet = false;
	private Queue<Integer> q = new LinkedList();
	PQ() {
		q.add(34);
		q.add(32);
	}
	
	public synchronized void setVal(boolean b) {
		valueSet = b;
	}
	public synchronized void put(Integer i) {
		while(valueSet)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		q.add(i);
		valueSet = true;
		notifyAll();
	}
	public synchronized Integer get() {		
		while(!valueSet)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}	
		System.out.println("Numbers in Storage Queue: " + Arrays.toString(q.toArray()));
		Integer i = q.remove();
		System.out.println("Number send to Client: " + i);		
		valueSet = false;
		notifyAll();
		return i;
	}
}
