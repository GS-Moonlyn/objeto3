package objeto2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class mainApp {
public class ThreadGroupDemo {	
	
}
	//Valor que o grilo deve percorrer para chegar no final
	static int linhaChegada = 200;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Semaphore
		Semaphore semaphore = new Semaphore(5);
		
		int maxGrilo = 3;
		int nGrilo = 2;
	
		//Divide o numero de grilos pelo numero maximo de grilos por grupo para determinar o numero de grupos
        int nGrupo = ((Double) Math.ceil(Double.valueOf(nGrilo) / maxGrilo)).intValue(); // 4
        int resto = nGrilo % maxGrilo;
        int grilosInseridos = 0;

        //Cria ThreadGroups de acordo com o valor de nGrupo
        List<ThreadGroup> tgs = new ArrayList<>();
        for (int i = 0; i < nGrupo; i++) {
            tgs.add(new ThreadGroup("G" + (i + 1)));
        }

        //Verifica quantos grilos sobraram apos a divisao
        for(int i = 0; i < nGrupo; i++) {
            int limite;
            if(i == nGrupo - 1 && resto != 0) {
                limite = resto;
            } else {
                limite = maxGrilo;
            }

            //Adiciona os grilos a um ThreadGroup
            for(int j = 0; j < limite; j++) {
            	grilosInseridos++;
                new Grilo(tgs.get(i), "Grilo " + grilosInseridos, linhaChegada, semaphore).threadStart();
            }
            
            
        }
			 
	 }
			
			
}





