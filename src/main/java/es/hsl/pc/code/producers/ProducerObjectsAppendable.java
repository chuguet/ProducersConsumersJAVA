package es.hsl.pc.code.producers;

import es.hsl.pc.code.containers.ContainerObjects;

public class ProducerObjectsAppendable implements Runnable {

	private final ContainerObjects container;
	private final Integer idProducer;
	private final Appendable appendable;

	/**
	 * Constructor de la clase
	 * 
	 * @param container
	 *            Contenedor común a los consumidores y el productor
	 * @param idProducer
	 *            Identificador del productor
	 */
	public ProducerObjectsAppendable(final ContainerObjects container, final Integer idProducer, final Appendable appendable) {
		this.container = container;
		this.idProducer = idProducer;
		this.appendable = appendable;
	}

	/**
	 * Implementación de la hebra
	 */
	@Override
	public void run() {
		while (Boolean.TRUE) {
			this.container.put(appendable);
			System.out.println("El productor " + this.idProducer + " pone: " + appendable);
			try {
				this.wait();
			} catch (InterruptedException e) {
				System.err.println("Productor " + this.idProducer + ": Error en run -> " + e.getMessage());
			}
		}
	}

}
