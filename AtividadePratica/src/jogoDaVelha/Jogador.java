package jogoDaVelha;

public class Jogador {
	
	//Classe jogador, conta vitorias, derrotas e empates, e recebe e retorna a jogada do usuario

	//ATRIBUTOS 
	   private int vitorias = 0;
	   private int derrotas = 0;
	   private int velhas= 0;

	   //METODOS PUBLICOS
	   public void win(){
	       this.setVitorias(this.getVitorias()+1);
	   }
	   public void lose(){
	       this.setDerrotas(this.getDerrotas()+1);
	   }
	   public void draw(){
	       this.setVelhas(this.getVelhas()+1);
	   }
	   public String play(int i){
	       String p = Integer.toString(i);
	       return p;
	   }
	   
	   //METODOS ESPECIAIS

	    public int getVitorias() {
	        return vitorias;
	    }
	    private void setVitorias(int vitorias) {
	        this.vitorias = vitorias;
	    }
	    public int getDerrotas() {
	        return derrotas;
	    }
	    private void setDerrotas(int derrotas) {
	        this.derrotas = derrotas;
	    }
	    public int getVelhas() {
	        return velhas;
	    }
	    private void setVelhas(int velhas) {
	        this.velhas = velhas;
	    }
	    
}
