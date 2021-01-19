package jogoDaVelha;

public abstract class Computador {
	
	/*
	 Classe abstrata Computador, é uma superclasse
	 todos os metodos aqui, são herdados pelas subclasse, atraves da herança
	 */
	//ATRIBUTOS
	protected String[][] posicao = {{"free","free","free"},
			                        {"free","free","free"},
                                    {"free","free","free"}};

	//METODOS PUBLICOS  
	public void scanTabuleiro(String p, String i){
		/*
		 * Os computadores também armazenam, pois ele precisam saber 
		 * como está o tabuleiro, para realizar suas jogadas
		 */
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
	
	public void cleanTabuleiroMaquina(){//Metodo que limpa o tabuleiro, para o inicio de uma nova partida
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			this.setPosicao(i, j, "free");
			}
		}
	}
	
	public void printTabuleiro() {//Metodo que mostra o tabuleiro, embora, esse metodo não seja usado pelo programa principal
		//ele foi usado durante a a construção para checar o funcionamento do codigo
		System.out.println("=====PC======");
		System.out.println("| "+this.getPosicao()[0][0]+" | "+this.getPosicao()[0][1]+" | "+this.getPosicao()[0][2]+" |");
		System.out.println("| "+this.getPosicao()[1][0]+" | "+this.getPosicao()[1][1]+" | "+this.getPosicao()[1][2]+" |");
		System.out.println("| "+this.getPosicao()[2][0]+" | "+this.getPosicao()[2][1]+" | "+this.getPosicao()[2][2]+" |");
		System.out.println("=============");
	}
	
	
	public String jogadaComputador(){//Metodo referancia das subclasse para o polimorfismo
		return null;
	}
	
	//METEODOS ESPECIAIS
	public Computador() {
	
	}
	public String[][] getPosicao() {
	return posicao;
	}
	public void setPosicao(int i, int j, String p) {
	this.posicao[i][j] = p;
	}
}
