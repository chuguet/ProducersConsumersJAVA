package es.hsl.pc.code.consumers;

import es.hsl.pc.code.containers.Container;

public class Consumer implements Runnable {

	private final Container container;
	private final Integer idConsumer;

	/**
	 * Constructor de la clase
	 * 
	 * @param container
	 *            Contenedor común a los consumidores y el productor
	 * @param idConsumer
	 *            Identificador del consumidor
	 */
	public Consumer(final Container container, final Integer idConsumer) {
		this.container = container;
		this.idConsumer = idConsumer;
	}

	@Override
	/**
	 * Implementación de la hebra
	 */
	public void run() {
		while (Boolean.TRUE) {
			System.out.println("El consumidor " + idConsumer + " consume: " + this.container.get());
		}
	}

}
