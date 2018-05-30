package Model;



public class Event implements Comparable<Event> {
	private int time;
	private EventType tipo;
	private int numpersone;
	private double tolleranza;
	private double durata;

	public Event(int time, EventType tipo, int numpersone, double tolleranza, int durata) {
		super();
		this.time = time;
		this.tipo = tipo;
		this.numpersone = numpersone;
		this.tolleranza = tolleranza;
		this.durata = durata;
	}

	public int getTime() {
		return time;
	}

	public EventType getTipo() {
		return tipo;
	}

	public int getNumpersone() {
		return numpersone;
	}

	public double getTolleranza() {
		return tolleranza;
	}

	public double getDurata() {
		return durata;
	}

	
	@Override
	public int compareTo(Event other) {
		return Integer.compare(time, other.time);
	}

}