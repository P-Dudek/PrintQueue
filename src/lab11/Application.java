package lab11;


public class Application {

	public static void main(String[] args){
		System.out.println("start");
		PQ q = new PQ();
		
		Producer p1 = new Producer(q);
		Producer p2 = new Producer(q);
		Producer p3 = new Producer(q);
		Customer c = new Customer(q);
		
		p1.start();
		p2.start();
		p3.start();
		c.start();
	}
}
