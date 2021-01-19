package jogoDaVelha;

public final class ComputadorA extends Computador {

	/*
    O computador A, herda  todos os metodos e atributos da superclasse.
    As jogadas são em sequancia. Ele checa se a posição esta livre, e 
    se estiver, ele marca sua jogada ali. Ou seja, ele tenta 
    primeiro marca na posição 0,0, se estiver livre, ele marca, se não, ele 
    tenta 0,1, e assim sucessivamente.
    */
    @Override
    public String jogadaComputador(){//este metodos utiliza polimorfismo de sobreposição
        String coordenada = new String();
        
        if(this.getPosicao()[0][0].equals("free"))
            coordenada = "1";
        else if(this.getPosicao()[0][1].equals("free"))
            coordenada = "2";
        else if(this.getPosicao()[0][2].equals("free"))
            coordenada = "3";
        else if(this.getPosicao()[1][0].equals("free"))
            coordenada = "4";
        else if(this.getPosicao()[1][1].equals("free"))
            coordenada = "5";
        else if(this.getPosicao()[1][2].equals("free"))
            coordenada = "6";
        else if(this.getPosicao()[2][0].equals("free"))
            coordenada = "7";
        else if(this.getPosicao()[2][1].equals("free"))
            coordenada = "8";
        else if(this.getPosicao()[2][2].equals("free"))
            coordenada = "9";
        
        return coordenada;
        
    }
}
