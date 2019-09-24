package jogocartas;

public class Carta implements Comparable<Carta>{
	private final int FACE;
	private final String NAIPE;
	
	public Carta(int face, String naipe) {
		FACE = face;
		NAIPE = naipe;
	}
	
	public int getFACE() {
		return FACE;
	}
	
	public String getNAIPE() {
		return NAIPE;
	}
	
	@Override
	public String toString() {
		if(FACE == 1) {
			return "A" + " de " + NAIPE;
		}else if(FACE == 11) {
			return "J" + " de " + NAIPE;
		}else if(FACE == 12) {
			return "Q" + " de " + NAIPE;
		}else if(FACE == 13) {
			return "K" + " de " + NAIPE;
		}
		
		return FACE + " de " + NAIPE;
	}

	@Override
	public int compareTo(Carta o) {
		if(this.FACE == o.FACE) {
			return 0;
		}else if(this.FACE > o.FACE) {
			return 1;
		}
		
		return -1;
	}

}