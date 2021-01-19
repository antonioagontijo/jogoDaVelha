package jogoDaVelha;

import java.util.Random;

public class Tabuleiro {
	
	/*
	 Classe Tabuleiro, ela armazena as jogadas, checa vencedor, define o primeiro jogador,
	 */

	//ATRIBUTOS
    private String[][] posicao ={{"1","2","3"},{"4","5","6"},{"7","8","9"}};
    private String winner = "NULL";
    

    //METODOS PUBLICOS
    public boolean checkJogada(String p){//Metodos que checxa se jogada é valida
        for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                            if(posicao[i][j].equals(p))
                                return true;
                    }
            }
        return false;
    }
    
    public boolean defPlayerOne() {//Metodo que define o primeiro jogador aleatoriamente
        Random aleatorio = new Random();//Para gerar valores aleatorios
        int primeiro = aleatorio.nextInt(2); //0 1 
        if(primeiro == 0)
            return true;//jogador é o primeiro
        else
            return false;// computador é o primeiro
    }
    
    public void jogada(String p, String i) {//Metodo que armazena as informações no tabuleiro
        switch (p) {
	        case "1":
				this.setPosicao(0, 0, i);
				break;
			case "2":
				this.setPosicao(0, 1, i);
				break;
			case "3":
				this.setPosicao(0, 2, i);
				break;
			case "4":
				this.setPosicao(1, 0, i);
				break;
			case "5":
				this.setPosicao(1, 1, i);
				break;
			case "6":
				this.setPosicao(1, 2, i);
				break;
			case "7":
				this.setPosicao(2, 0, i);
				break;
			case "8":
				this.setPosicao(2, 1, i);
				break;
			case "9":
				this.setPosicao(2, 2, i);
				break;
			default:
				break;
        }
    }
    
    public void cleanTabuleiro(){//Metodo que limpa o tabuleiro, para o inicio de uma nova partida
        int cont = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.setPosicao(i, j, ""+cont);
                cont++;
            }
        }
        this.setWinner("NULL");
    }
    
    public String checkVencedor(int rodada) {//Metodo que checa se há vencedor
        String[] tabela = new String[8];
        if(rodada==9)
            this.setWinner("DEU VELHA!!");
        
        tabela[0]=this.getPosicao()[0][0]+this.getPosicao()[0][1]+this.getPosicao()[0][2];
        tabela[1]=this.getPosicao()[1][0]+this.getPosicao()[1][1]+this.getPosicao()[1][2];
        tabela[2]=this.getPosicao()[2][0]+this.getPosicao()[2][1]+this.getPosicao()[2][2];
        tabela[3]=this.getPosicao()[0][0]+this.getPosicao()[1][0]+this.getPosicao()[2][0];
        tabela[4]=this.getPosicao()[0][1]+this.getPosicao()[1][1]+this.getPosicao()[2][1];
        tabela[5]=this.getPosicao()[0][2]+this.getPosicao()[1][2]+this.getPosicao()[2][2];
        tabela[6]=this.getPosicao()[0][0]+this.getPosicao()[1][1]+this.getPosicao()[2][2];
        tabela[7]=this.getPosicao()[0][2]+this.getPosicao()[1][1]+this.getPosicao()[2][0];
        
        for (String tabela1 : tabela) {
            if (tabela1.equals("XXX")) {
                winner = "JOGADOR";
            } else if (tabela1.equals("OOO")) {
                winner = "COMPUTADOR";
            }
        }
        return winner;
    }
    
    public void printTabuleiro() {//Metodo que mostra o tabuleiro
        System.out.println("=============");
        System.out.println("| "+this.getPosicao()[0][0]+" | "+this.getPosicao()[0][1]+" | "+this.getPosicao()[0][2]+" |");
        System.out.println("| "+this.getPosicao()[1][0]+" | "+this.getPosicao()[1][1]+" | "+this.getPosicao()[1][2]+" |");
        System.out.println("| "+this.getPosicao()[2][0]+" | "+this.getPosicao()[2][1]+" | "+this.getPosicao()[2][2]+" |");
        System.out.println("=============");
        }

    //METODOS ESPECIAIS

    public Tabuleiro() {
           
    }
    public String[][] getPosicao() {
        return posicao;
    }
    public void setPosicao(int i, int j, String p) {
        this.posicao[i][j] = p;
    }
    public String getWinner() {
        return winner;
    }
    public void setWinner(String winner) {
        this.winner = winner;
    }

}
