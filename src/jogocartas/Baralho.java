package jogocartas;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Baralho {
	private ArrayList<Carta> cartas;
	private Carta c;
	private Scanner scan = new Scanner(System.in);
	private Random aleatorio;
	private int contador = 0;
	
	public Baralho() {
		cartas = new ArrayList<>();
		
		String[] naipes = {"Copas", "Espadas", "Ouros", "Paus"};
		
		for(int i = 0; i < naipes.length; i++) {
			for(int j = 0; j < 13; j++) {
				c = new Carta(j+1, naipes[i]);
				cartas.add(c);
				
			}
		}
		
		aleatorio = new Random();
	}
	
	
	public void mostrarBaralho() {
		for(Carta c : cartas) {
			System.out.println(c);
		}
		
		System.out.println("---------------------------------------------------------");
	}
	
	public void embaralhar() {
		Carta aux;
		
		for(int i = 0; i < cartas.size(); i++) {
			int card1 = aleatorio.nextInt(cartas.size());
			int card2 = aleatorio.nextInt(cartas.size());
			
			aux = cartas.get(card1);
			cartas.set(card1, cartas.get(card2));
			cartas.set(card2, aux);
		}
	}
	
	public ArrayList<Carta> distribuirCartas(int qtdCartas) {
		ArrayList<Carta> cards = new ArrayList<>();
		
		for(int i = 0; i < qtdCartas; i++) {
			cards.add(cartas.get(contador));
			contador++;
		}
		
		return cards;
	}
	
	public void puxarBaralho(ArrayList<Carta> cardsJog) {
		cardsJog.add(cartas.get(contador));
		contador++;
	}
	
	public Carta descartar(ArrayList<Carta> cardsJog) {
		int x;
		Carta a;
		
		do {
			System.out.print("Descarte uma carta: ");
			x = scan.nextInt();
			
			if(x < 1 || x > 10) {
				System.out.println("Jogada invalida, escolha outra carta");
			}
			
		}while(x < 1 || x > 10);
		
		a = cardsJog.get(x - 1);
		cardsJog.remove(x - 1);
		
		return a;
	}
	
	public void puxarLixo(ArrayList<Carta> cardsJog, Carta c) {
		cardsJog.add(c);
	}

}