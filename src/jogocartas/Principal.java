package jogocartas;

public class Principal {
	public static void main(String[] args) {
		Jogo jog = new Jogo();
		
		jog.inserirJogadores();
		jog.distribuirCartas(9);
		jog.mostrarCartas();
		jog.iniciarJogo();
		
	}
}