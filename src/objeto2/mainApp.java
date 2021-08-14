package objeto2;

public class mainApp {
public class ThreadGroupDemo {	
	
}
	static int linhaChegada = 200;
	


	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
			Thread t = Thread.currentThread();
			System.out.println(t.getName());
			
			 int NGrilo;
			 NGrilo = 5;
			 
			for (int i = 1; i <= NGrilo; i++) {
			Grilo grilo = new Grilo("Grilo" + i, linhaChegada);
			
			grilo.start();
			
			ThreadGroup tg1 = new ThreadGroup ("G1");
			Thread t1 = new Thread (tg1, "thread 1");
		    Thread t2 = new Thread (tg1, "thread 2");
		    
		    ThreadGroup tg2 = new ThreadGroup ("G2");
		    Thread t3 = new Thread (tg2, "thread 3");
		    Thread t4 = new Thread (tg2, "thread 4");
		    
		    System.out.println("Thread Group Name: "+tg1.getName()); 
		    System.out.println("Thread Group Name: "+tg2.getName());  
	         tg1.list();  tg2.list();
		    

			 
			 }
			
			
	}




}
