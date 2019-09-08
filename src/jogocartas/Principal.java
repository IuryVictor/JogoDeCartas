package jogocartas;

public class Principal {
	public static void main(String[] args) {
		Jogo jog = new Jogo();
		
		jog.iniciarJogo();
		jog.distribuirCartas(9);
		jog.mostrarCartas();
	}
}