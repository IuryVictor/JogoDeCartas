package jogocartas;

import java.util.Scanner;

public class Jogo {
	Scanner scan = new Scanner(System.in);
	Baralho baralho;
	Jogador[] jogadores;
	
	public Jogo() {
		baralho = new Baralho();
		baralho.mostrarBaralho();
		baralho.embaralhar();
		baralho.mostrarBaralho();
	}
	
	public void iniciarJogo() {
		
		jogadores = new Jogador[2];
		
		for(int i = 0; i < jogadores.length; i++) {
			System.out.print("Jogador " + (i + 1) + " digite seu nome: ");
			jogadores[i] = new Jogador(scan.next());
		}
	}
	
	public void distribuirCartas(int qtdCartas) {
		for(int i = 0; i < jogadores.length; i++) {
			jogadores[i].setCartas(baralho.distribuirCartas(qtdCartas));
		}
	}
	
	public void mostrarCartas() {
		for(int i = 0; i < jogadores.length; i++) {
			jogadores[i].mostrarCartas();
		}
	}
}
