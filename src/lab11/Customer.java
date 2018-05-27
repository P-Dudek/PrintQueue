package lab11;

public class Customer extends Thread {
	PQ q;

	Customer(PQ q) {
		this.q = q;
	}

	public void run() {
		while(true) {
		System.out.println("Delivered to Customer: " + q.get());
		}
	}
}
