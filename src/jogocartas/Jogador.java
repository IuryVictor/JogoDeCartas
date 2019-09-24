package jogocartas;

import java.util.ArrayList;

public class Jogador {
	private final String NOME;
	
	private ArrayList<Carta> cartas;
	
	private int jogos;
	
	public Jogador(String nome) {
		NOME = nome;
	}
	
	public String getNome() {
		return NOME;
	}
	
	public ArrayList<Carta> getCartas(){
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public void setJogos() {
		jogos++;
	}
	
	public int getJogos(){
		return jogos;
	}
	
	public void mostrarCartas() {
		int i = 1;
		System.out.println("\n-------Cartas de " + NOME + "-------");
		for(Carta c : cartas) {
			System.out.println(i + " - " + c);
			i++;
		}
	}
	
}