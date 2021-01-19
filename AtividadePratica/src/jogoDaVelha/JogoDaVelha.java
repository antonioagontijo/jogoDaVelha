package jogoDaVelha;

import java.util.Scanner;

public class JogoDaVelha {

	public static void main(String[] args) {
		
		//Instanciações iniciais do programa, para receber informações do usuario, e criação dos objetos das classe criadas
		Scanner entrada = new Scanner(System.in);
        Scanner dificuldade = new Scanner(System.in);
        Scanner entrada2 = new Scanner(System.in);
        Tabuleiro partida = new Tabuleiro();//Objeto da classe desenvolvida Tabuleiro
        ComputadorA maquinaA = new ComputadorA();//Objeto da classe desenvolvida ComputadorA
        ComputadorB maquinaB = new ComputadorB();//Objeto da classe desenvolvida ComputadorB
        ComputadorC maquinaC = new ComputadorC();//Objeto da classe desenvolvida ComputadorC
        Jogador player = new Jogador();//Objeto da classe desenvolvida Jogaddor
        String posicao;//vai receber as jogadas tanto do usuario, quanto da maquina
        int posicao2;
        boolean quemJoga, continuar = true;//variavel 'quemJoga' True vez do jogador, false vez da maquina.
        //continuar serve para saber se o usuario continuará jogando ou não
        
        
        System.out.println("--------Atividade Pratica---------");
        System.out.println("Antônio Augusto dos Santos Gontijo");
        System.out.println("          RU: 2378297");
        System.out.println("            UNINTER");
        System.out.println("      Belo Horizonte - 2020");
        System.out.println("----------------------------------\n");
        
        while(continuar){//Para saber se o jogo vai continuar. se for falso o jogo encerra
            int rodada = 0;//marca as rodadas, se chegar a 9, o jogo da velha
            //Menu do jogo
            System.out.println("====JOGO DA VELHA====");
            System.out.println("Escolha a dificuldade");
            System.out.println("1...............Fácil");
            System.out.println("2..............Normal");
            System.out.println("3.............Dificil");
            System.out.println("=====================");
            System.out.println("Vitorias:..........."+player.getVitorias());
            System.out.println("Derrotas:..........."+player.getDerrotas());
            System.out.println("Empates:............"+player.getVelhas());
            System.out.println("=====================");
            
            partida.cleanTabuleiro();
            
            //Esse trecho, é responsavel por escolher a dificuldade do jogador, e decidir quem começa------------------
            int nivel = dificuldade.nextInt();
            while(nivel<=0 || nivel>=4){
                System.out.println("OPÇÃO INVALIDA!");
                System.out.println("Informe a dificuldade...");
                nivel = dificuldade.nextInt();
            }//O jogador informa o nivel de dificuldade, de 1 a 3, quee é salvo na variavel 'nivel'

            quemJoga = partida.defPlayerOne();//Se quem joga recebr true, jogador começa
            System.out.println("Cara ou Coroa...");
            if(quemJoga)
                System.out.println("CARA!\nVocê começa.");
            else 
                System.out.println("COROA!\nO computador começa.");
            //---------------------------------------------------------------------------------------------------------
            
            
            //INICIO DA PARTIDA----------------------------------------------------------------------------------------
            while(true){
                if(quemJoga){//JOGADOR.................................................................
                    partida.printTabuleiro();
                do {                
                    System.out.print("Informe a posição...");
                    posicao2 = entrada.nextInt();
                    posicao = player.play(posicao2);
                    while(!partida.checkJogada(posicao)){//while para aceitar apenas jogadas validas do usuario
                        System.out.println("JOGADA INVALIDA!");
                        System.out.print("Informe a posição...");
                        posicao = entrada.next();
                    }
                    partida.jogada(posicao,"X");//salva as jogadas no tabuleiro
                    maquinaA.scanTabuleiro(posicao, "X");// salva jogadas no objeto computador
                    maquinaB.scanTabuleiro(posicao, "X");
                    maquinaC.scanTabuleiro(posicao, "X");
                    quemJoga = false;   

                } while (quemJoga);

                
                rodada++;
                if(!partida.checkVencedor(rodada).equals("NULL"))// ao final de cada jogada, o jogo checa se há um vencedor
                    break;
                }
                //....................................................................................


                if(!quemJoga){//MAQUINA...............................................................
                do {               
                    posicao = null;
                    //Switch case para saber qual nivel de dificuldade será jogada pela maquina
                    switch (nivel){
                        case 1:
                            posicao = maquinaA.jogadaComputador();
                            break;
                        case 2:
                            posicao = maquinaB.jogadaComputador();
                            while(!partida.checkJogada(posicao)){
                            posicao = maquinaB.jogadaComputador();
                                }       
                            break;
                        case 3:
                            posicao = maquinaC.jogadaComputador();
                            while(!partida.checkJogada(posicao)){
                            posicao = maquinaC.jogadaComputador();
                                }
                            break;
                        default:
                            break;
                    }
                    partida.jogada(posicao, "O");//salva nas jogada no tabuleiro
                    maquinaA.scanTabuleiro(posicao, "O");// salva jogadas no objeto computador
                    maquinaB.scanTabuleiro(posicao, "O");
                    maquinaC.scanTabuleiro(posicao, "O");
                    quemJoga = true;

                } while (!quemJoga);

                
                rodada++;
                if(!partida.checkVencedor(rodada).equals("NULL"))
                    break;
                }//....................................................................................
                
            }
            
            //Mostrnado o vencedor, e deseja continuar.................................................
            partida.printTabuleiro();
            if(partida.checkVencedor(rodada).equals("DEU VELHA!!")){
                System.out.println("DEU VELHA!!");
                player.draw();//contador de empate
            }
            else{
                System.out.println("O "+partida.checkVencedor(rodada)+ " foi o vencedor!!!!");//mostra o vencedor
                if(partida.checkVencedor(rodada).equals("JOGADOR"))
                    player.win();//contador de vitorias
                else
                    player.lose();//contador de derrotas
            }
            //Deseja continuar? recebe s ou n do usuario, e modifica a variavel 'continuar'
            System.out.print("Deseja jogar novamente? S/N ");
            String cont = entrada2.next();               
            while(!cont.equals("s") && !cont.equals("n")){//while para impedir que outra caracteres sejam aceitos
                System.out.println("OPÇÃO INVÁLIDA");
                System.out.print("Deseja jogar novamente? S/N ");
                cont = entrada2.next();
            }
            if(cont.equals("n"))
                continuar = false;
            
            //limpeza do tebuleiro para inicio da nova partida
            partida.cleanTabuleiro();
            maquinaA.cleanTabuleiroMaquina();
            maquinaB.cleanTabuleiroMaquina();
            maquinaC.cleanTabuleiroMaquina();
            
            System.out.print("\n\n");
        }
        //.........................................................................................
        
        
        //FIM DA PARTIDA------------------------------------------------------------------------------------------------
        System.out.println("OBRIGADO POR JOGAR!!\n\n");

	}

}
