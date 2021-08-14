package objeto2;

public class Grilo extends Thread {
	
	private String nome;
	private int min = 10;
	private int max = 30;
	private int posicaoAtual;
	private int chegada;
	private int pulos;
	
	//Construtor
	public Grilo(String nome, int chegada) {
		this.nome = nome;
		this.chegada = chegada;
		start();
	}

	public void run() {
		//Exibe a Thread atual 
		//Thread t = Thread.currentThread();
		//System.out.println(t.getName());
		
		//Log de distancia percorrida pelo Grilo
		while(posicaoAtual < chegada) {
			int pulo = (int)Math.floor(Math.random()*(max-min+1)+min);
			posicaoAtual += pulo;
			System.out.println(nome + " pulou " + pulo + "cm. " + nome + " percorreu " + posicaoAtual + "cm");
			
		//Contar o Número de Pulos
			pulos++;
		}
		
		//Exibe que o Grilo atingiu a linha de chegada
		if(posicaoAtual >= chegada) {
			System.out.println(nome + " atingiu a linha de chegada!" + " Total de pulos: " + pulos);
		}
		
	}
}
