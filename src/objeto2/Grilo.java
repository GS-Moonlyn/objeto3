package objeto2;

import java.util.concurrent.Semaphore;

public class Grilo {
	
	private String nome;
	private int min = 10;
	private int max = 30;
	private int posicaoAtual;
	private int chegada;
	private int pulos;
	private int pulosInicial;
	private int i = 0;
	private ThreadGroup tg;
	private Semaphore semaphore;
	
	//Construtor
	public Grilo(ThreadGroup tg, String nome, int chegada, Semaphore semaphore) {
		this.tg = tg;
		this.nome = nome;
		this.chegada = chegada;
		this.semaphore = semaphore;
	}

	private void run() {
		
		//
		if(tg.getName().equals("G" + (i+1))) {
			
			System.out.println(tg.getName()+ ": " + "preparando...");
			
			try {
				
				//Permissao
				System.out.println(tg.getName() + " esta esperando para a permissao");
				
				//Adquirindo
				semaphore.acquire();
				System.out.println(tg.getName() + " da a largada!");
				
			}
			
			catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			//Permissao
			System.out.println("Grupo" + tg.getName() + "passa a vez!");
			semaphore.release();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Log de distancia percorrida pelo Grilo
		while(posicaoAtual < chegada) {
			int pulo = (int)Math.floor(Math.random()*(max-min+1)+min);
			posicaoAtual += pulo;
			System.out.println(tg.getName() + ": " + nome + " pulou " + pulo + "cm. " + nome + " percorreu " + posicaoAtual + "cm.");
			
		//Contar o Numero de Pulos
			pulos++;
			
		//Faz com que a thread do grilo durma apos um pulo
			if(pulos != pulosInicial) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(nome + " ficou com preg!");
				pulosInicial = pulos;
			}
			
		}
		
		
		//Exibe que o Grilo atingiu a linha de chegada
		if(posicaoAtual >= chegada) {
			System.out.println(nome + " atingiu a linha de chegada!" + " Total de pulos: " + pulos);
		}
		
		
		
	}
	
	//Function de iniciar a thread
	public void threadStart() {
		new Thread(tg, () -> run(), nome).start();
	}
		
	
}
	

