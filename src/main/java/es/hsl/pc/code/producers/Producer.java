package es.hsl.pc.code.producers;

import java.util.Random;

import es.hsl.pc.code.containers.Container;

public class Producer implements Runnable {

	private final Random random;
	private final Container container;
	private final Integer idProducer;
	private final Integer TIEMPOESPERA = 1500;

	/**
     * Constructor de la clase
     * @param container Contenedor común a los consumidores y el productor
     * @param idProducer Identificador del productor
     */
    public Producer(final Container container, final Integer idProducer) 
    {
        this.container = container;
        this.idProducer = idProducer;
        random = new Random();
    }

	/**
	 * Implementación de la hebra
	 */
	@Override
	public void run() {
		while (Boolean.TRUE) {
			final Integer push = random.nextInt(300);
			this.container.put(push);
			System.out.println("El productor " + this.idProducer + " pone: " + push);
			try {
				Thread.sleep(TIEMPOESPERA);
			} catch (InterruptedException e) {
				System.err.println("Productor " + this.idProducer + ": Error en run -> " + e.getMessage());
			}
		}
	}

}
