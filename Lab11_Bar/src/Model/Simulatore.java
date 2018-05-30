package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Simulatore {

	// Parametri
	private int numEventiSimulazione;

	private int numTavoliDisponibili;

	private int time;

	// modello mondo
	private List<Tavolo> tavoli;
	private PriorityQueue<Event> queue;

	public Simulatore() {

	}

	// OUTPUT
	private int soddisfatti;
	private int insoddisfatti;

	public void init() {

		this.queue = new PriorityQueue<Event>();
		this.tavoli = new ArrayList();
		tavoli.add(new Tavolo(10));
		tavoli.add(new Tavolo(10));
		tavoli.add(new Tavolo(8));
		tavoli.add(new Tavolo(8));
		tavoli.add(new Tavolo(8));
		tavoli.add(new Tavolo(8));
		tavoli.add(new Tavolo(6));
		tavoli.add(new Tavolo(6));
		tavoli.add(new Tavolo(6));
		tavoli.add(new Tavolo(6));
		tavoli.add(new Tavolo(4));
		tavoli.add(new Tavolo(4));
		tavoli.add(new Tavolo(4));
		tavoli.add(new Tavolo(4));
		tavoli.add(new Tavolo(4));

		for (int i = 0; i < numEventiSimulazione; i++) {

			Event e = new Event(time, EventType.ARRIVO_GRUPPO_CLIENTI, (int) (Math.random() * 10), Math.random(),
					60 * (1 + (int) Math.random() * 2));

			queue.add(e);
		}

		time = 0;
		numEventiSimulazione = 2000;
		numTavoliDisponibili = 15;

		soddisfatti = 0;
		insoddisfatti = 0;

	}

	public void run() {
		Event e;

		while ((e = queue.poll()) != null) {
			if (numEventiSimulazione == 0) {
				break;
			}

			processEvent(e);
			numEventiSimulazione--;
		}

	}

	private void processEvent(Event e) {

		switch (e.getTipo()) {
		case ARRIVO_GRUPPO_CLIENTI:
			
			boolean servito=false;
			
			for(Tavolo a:tavoli) {
				if(a.getNumPostidisponibili()>=e.getNumpersone() 
						&& a.isOccupato()==false ) {
					
					if (e.getNumpersone()>=0.5*a.getNumPostidisponibili()) {
						a.setOccupato();
						soddisfatti++;
						servito=true;
					}
					
				}
					
			
			}
			
			if(servito==false) {
				if(e.getTolleranza()<=0.9) {
					insoddisfatti++;
				}
			}
			break;
			
			
		case USCITA:
			
			break;
		
			
			
			
			

	

		}
	}
}
