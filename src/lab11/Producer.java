package lab11;

import java.util.*;

public class Producer extends Thread {
	PQ q;

	Producer(PQ q) {
		this.q = q;
	}

	public void run() {
		Integer i;
		int j;
		String s = this.getName();
		while (true) {
			i = new Integer(new Random().nextInt(34));
			j = new Random().nextInt(1000);

			System.out.println(s + " Thread-Producer produced number: " + i);
			q.put(i);
			try {
				System.out.println("Break in work for Producer: " + s + " is: " + j + " miliseconds");
				Thread.sleep(j);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
