package jogocartas;

import java.util.Random;

public class Baralho {
	private Carta[] cartas;
	private Random aleatorio;
	private int contador = 0;
	
	public Baralho() {
		int cont = 0;
		cartas = new Carta[52];
		String[] naipes = {"Copas", "Espadas", "Ouros", "Paus"};
		
		for(int i = 0; i < naipes.length; i++) {
			for(int j = 0; j < 13; j++, cont++) {
				if(j == 0) {
					cartas[cont] = new Carta("A", naipes[i]);
				}else if(j == 10) {
					cartas[cont] = new Carta("J", naipes[i]);
				}else if(j == 11) {
					cartas[cont] = new Carta("Q", naipes[i]);
				}else if(j == 12) {
					cartas[cont] = new Carta("K", naipes[i]);
				}else {
					String s = "" + (j+1);
					cartas[cont] = new Carta(s, naipes[i]);
				}
			}
		}
		
		aleatorio = new Random();
	}
	
	public void mostrarBaralho() {
		for(int i = 0; i < cartas.length; i++) {
			System.out.println(cartas[i]);
		}
		System.out.println("---------------------------------------------------------");
	}
	
	public void embaralhar() {
		Carta aux;
		
		for(int i = 0; i < cartas.length; i++) {
			int card1 = aleatorio.nextInt(cartas.length);
			int card2 = aleatorio.nextInt(cartas.length);
			
			aux = cartas[card1];
			cartas[card1] = cartas[card2];
			cartas[card2] = aux;
		}
	}
	
	public Carta[] distribuirCartas(int qtdCartas) {
		Carta[] cards = new Carta[qtdCartas];
		
		for(int i = 0; i < qtdCartas; i++) {
			cards[i] = cartas[contador];
			contador++;
		}
		
		return cards;
	}
}