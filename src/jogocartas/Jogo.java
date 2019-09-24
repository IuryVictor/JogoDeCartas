package jogocartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Jogo {
	private Scanner scan = new Scanner(System.in);
	private Baralho baralho;
	private Jogador[] jogadores;
	
	public Jogo() {
		baralho = new Baralho();
		baralho.embaralhar();
	}
	
	public void inserirJogadores() {
		
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
	
	public void verificarTrinca(ArrayList<Carta> cardsJog, int j) {
		ArrayList<Carta> trinca = new ArrayList<>();
		Carta c;
		
		System.out.println("Escolha as cartas para formar a trinca:");
		for(int i = 0; i < 3; i++) {
			int x = scan.nextInt();
			c = cardsJog.get(x - 1);
			trinca.add(c);
		}
		
		Collections.sort(trinca);
		
		if(trinca.get(0).getNAIPE().compareTo(trinca.get(1).getNAIPE()) == 0) {
			if(trinca.get(0).getNAIPE().compareTo(trinca.get(2).getNAIPE()) == 0) {
				if(trinca.get(0).getFACE() == trinca.get(1).getFACE() - 1) {
					if(trinca.get(0).getFACE() == trinca.get(2).getFACE() - 2){
						jogadores[j % 2].setJogos();
						System.out.println("Trinca baixada");
						for(Carta h : trinca) {
							cardsJog.remove(h);
						}
						return;
					}
				}else if(trinca.get(0).getFACE() == trinca.get(1).getFACE() + 1) {
					if(trinca.get(0).getFACE() == trinca.get(2).getFACE() + 2) {
						jogadores[j % 2].setJogos();
						System.out.println("Trinca baixada");
						for(Carta h : trinca) {
							cardsJog.remove(h);
						}
						return;
					}
				}
			}
		}else if(trinca.get(0).getFACE() == trinca.get(1).getFACE()) {
			if(trinca.get(0).getFACE() == trinca.get(2).getFACE()) {
				if(trinca.get(0).getNAIPE().compareTo(trinca.get(1).getNAIPE()) != 0) {
					if(trinca.get(0).getNAIPE().compareTo(trinca.get(2).getNAIPE()) != 0) {
						if(trinca.get(1).getNAIPE().compareTo(trinca.get(2).getNAIPE()) != 0) {
							jogadores[j % 2].setJogos();
							System.out.println("Trinca baixada");
							for(Carta h : trinca) {
								cardsJog.remove(h);
							}
							return;
						}
					}
				}
			}
		}
		
		System.out.println("Trinca incorreta");
		
	}
	
	public boolean verificarVencedor(int j) {
		if(jogadores[j % 2].getJogos() == 3) {
			return false;
		}
		
		return true;
	}
	
	public void iniciarJogo() {
		boolean b = true;
		int i = 0;
		Carta y = null;
		
		do {
			System.out.println("\n" + jogadores[i % 2].getNome() + ", faça sua jogada");
			jogadores[i % 2].mostrarCartas();
			System.out.print("\n1 - Puxar do baralho\n2 - Puxar do lixo(" + y + ")\nOpção desejada: ");
			
			switch(scan.nextInt()){
				case 1:
					baralho.puxarBaralho(jogadores[i % 2].getCartas());
					jogadores[i % 2].mostrarCartas();
					
					System.out.print("Quer baixar uma trinca?(1 - Sim, 2 - Não)? ");
					if(scan.nextInt() == 1) {
						verificarTrinca(jogadores[i % 2].getCartas(), i);
						b = verificarVencedor(i);
					}
					jogadores[i % 2].mostrarCartas();
					y = baralho.descartar(jogadores[i % 2].getCartas());
					jogadores[i % 2].mostrarCartas();
					i++;
					
					break;
				case 2:
					if(y == null) {
						System.out.println("Não existe nenhuma carta no lixo");
					}else {
						baralho.puxarLixo(jogadores[i % 2].getCartas(), y);
						jogadores[i % 2].mostrarCartas();
						
						System.out.print("Quer baixar jogo(1 - Sim, 2 - Não)? ");
						if(scan.nextInt() == 1) {
							verificarTrinca(jogadores[i % 2].getCartas(), i);
							b = verificarVencedor(i);
						}
						jogadores[i % 2].mostrarCartas();
						y = baralho.descartar(jogadores[i % 2].getCartas());
						jogadores[i % 2].mostrarCartas();
						i++;
						
					}
					
					break;
				default:
					System.out.println("Opção invalida");
			}
			
			
		}while(b);
		
		System.out.println(jogadores[--i % 2].getNome() + " venceu");
	}
}
