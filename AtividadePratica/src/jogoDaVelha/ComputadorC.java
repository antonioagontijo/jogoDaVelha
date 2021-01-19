package jogoDaVelha;

import java.util.Random;

public final class ComputadorC extends Computador {
	
	/*
	 O computador C,herda  todos os metodos e atributos da superclasse.
	 Primeiro checa se o jogador está preste a ganhar, se sim, ele marca 
	 de forma a impedir a vitoria do jogador, caso contrario ele faz a 
	 jogada aleatoriamente.
	 */
	
	@Override
    public String jogadaComputador(){//este metodos utiliza polimorfismo de sobreposição
         String p = null;
        if((this.getPosicao()[0][0]+this.getPosicao()[0][1]).equals("XX")&&this.getPosicao()[0][2].equals("free"))
            p = "3";
        else if((this.getPosicao()[0][1]+this.getPosicao()[0][2]).equals("XX")&&this.getPosicao()[0][0].equals("free"))
            p = "1";
        else if((this.getPosicao()[0][0]+this.getPosicao()[0][2]).equals("XX")&&this.getPosicao()[0][1].equals("free"))
            p = "2";
        else if((this.getPosicao()[1][0]+this.getPosicao()[1][1]).equals("XX")&&this.getPosicao()[1][2].equals("free"))
            p = "6";
        else if((this.getPosicao()[1][1]+this.getPosicao()[1][2]).equals("XX")&&this.getPosicao()[1][0].equals("free"))
            p = "4";
        else if((this.getPosicao()[1][0]+this.getPosicao()[1][2]).equals("XX")&&this.getPosicao()[1][1].equals("free"))
            p = "5";
        else if((this.getPosicao()[2][0]+this.getPosicao()[2][1]).equals("XX")&&this.getPosicao()[2][2].equals("free"))
            p = "9";
        else if((this.getPosicao()[2][1]+this.getPosicao()[2][2]).equals("XX")&&this.getPosicao()[2][0].equals("free"))
            p = "7";
        else if((this.getPosicao()[2][0]+this.getPosicao()[2][2]).equals("XX")&&this.getPosicao()[2][1].equals("free"))
            p = "8";
        else if((this.getPosicao()[0][0]+this.getPosicao()[1][0]).equals("XX")&&this.getPosicao()[2][0].equals("free"))
            p = "7";
        else if((this.getPosicao()[1][0]+this.getPosicao()[2][0]).equals("XX")&&this.getPosicao()[0][0].equals("free"))
            p = "1";
        else if((this.getPosicao()[0][0]+this.getPosicao()[2][0]).equals("XX")&&this.getPosicao()[1][0].equals("free"))
            p = "4";
        else if((this.getPosicao()[0][1]+this.getPosicao()[1][1]).equals("XX")&&this.getPosicao()[2][1].equals("free"))
            p = "8";
        else if((this.getPosicao()[1][1]+this.getPosicao()[2][1]).equals("XX")&&this.getPosicao()[0][1].equals("free"))
            p = "2";
        else if((this.getPosicao()[0][1]+this.getPosicao()[2][1]).equals("XX")&&this.getPosicao()[1][1].equals("free"))
            p = "5";
        else if((this.getPosicao()[0][2]+this.getPosicao()[1][2]).equals("XX")&&this.getPosicao()[2][2].equals("free"))
            p = "9";
        else if((this.getPosicao()[1][2]+this.getPosicao()[2][2]).equals("XX")&&this.getPosicao()[0][2].equals("free"))
            p = "3";
        else if((this.getPosicao()[0][2]+this.getPosicao()[2][2]).equals("XX")&&this.getPosicao()[1][2].equals("free"))
            p = "6";
        else if((this.getPosicao()[0][0]+this.getPosicao()[1][1]).equals("XX")&&this.getPosicao()[2][2].equals("free"))
            p = "9";
        else if((this.getPosicao()[1][1]+this.getPosicao()[2][2]).equals("XX")&&this.getPosicao()[0][0].equals("free"))
            p = "1";
        else if((this.getPosicao()[0][0]+this.getPosicao()[2][2]).equals("XX")&&this.getPosicao()[1][1].equals("free"))
            p = "5";
        else if((this.getPosicao()[2][0]+this.getPosicao()[1][1]).equals("XX")&&this.getPosicao()[0][2].equals("free"))
            p = "3";
        else if((this.getPosicao()[1][1]+this.getPosicao()[0][2]).equals("XX")&&this.getPosicao()[2][0].equals("free"))
            p = "7";
        else if((this.getPosicao()[2][0]+this.getPosicao()[0][2]).equals("XX")&&this.getPosicao()[1][1].equals("free"))
            p = "5";
        else 
            p = this.jogadaAleatoria();
        
        return p;
    }
    private String jogadaAleatoria(){//Metodo que volta uma valor alatoria de 1 a 9
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
