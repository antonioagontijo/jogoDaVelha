package jogoDaVelha;

import java.util.Random;

public final class ComputadorB extends Computador {
	
	/*
	 O computador B, herda  todos os metodos e atributos da superclasse.
	 As jogadas são totalmente alatórias.
 	 */

	@Override
    public String jogadaComputador(){//este metodos utiliza polimorfismo de sobreposição
        String p = new String();
        Random linha = new Random();//Para gerar valores aleatorios
        int i = linha.nextInt(9); //0 a 8
        
        switch (i) {
            case 0:
                p = "1";
                break;
            case 1:
                p = "2";
                break;
            case 2:
                p = "3";
                break;
            case 3:
                p = "4";
                break;
            case 4:
                p = "5";
                break;
            case 5:
                p = "6";
                break;
            case 6:
                p = "7";
                break;
            case 7:
                p = "8";
                break;
            case 8:
                p = "9";
                break;
            default:
                break;
        }
        return p;
    }
   
    
}
