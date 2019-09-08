package jogocartas;

public class Carta {
	private final String FACE;
	private final String NAIPE;
	
	public Carta(String face, String naipe) {
		FACE = face;
		NAIPE = naipe;
	}
	
	@Override
	public String toString() {
		return FACE + " de " + NAIPE;
	}
}