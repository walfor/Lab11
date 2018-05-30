package Model;

public class Tavolo {
	private int numPostidisponibili;
	
	private boolean occupato;

	public Tavolo(int numPostidisponibili) {
		super();
		this.numPostidisponibili = numPostidisponibili;
	
		this.occupato = false;
	}

	public int getNumPostidisponibili() {
		return numPostidisponibili;
	}

	public void setNumPostidisponibili(int numPostidisponibili) {
		this.numPostidisponibili = numPostidisponibili;
	}

	
	public boolean isOccupato() {
		return occupato;
	}

	public void setOccupato() {
		if (this.occupato == true) {
			this.occupato = false;
		} else {
			this.occupato = true;
		}
	}

}
