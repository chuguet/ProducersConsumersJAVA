package es.hsl.pc.code.containers;

public class Container {

	private Integer content;
	private Boolean filledContainer = Boolean.FALSE;

	/**
	 * Obtiene de forma concurrente o síncrona el elemento que hay en el
	 * contenedor
	 * 
	 * @return Contenido el contenedor
	 */
	public synchronized Integer get() {
		while (!this.filledContainer) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("Contenedor: Error en get -> " + e.getMessage());
			}
		}
		this.filledContainer = Boolean.FALSE;
		notify();
		return content;
	}

	/**
	 * Introduce de forma concurrente o síncrona un elemento en el contenedor
	 * 
	 * @param value
	 *            Elemento a introducir en el contenedor
	 */
	public synchronized void put(Integer value) {
		while (this.filledContainer) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("Contenedor: Error en put -> " + e.getMessage());
			}
		}
		this.content = value;
		this.filledContainer = Boolean.TRUE;
		notify();
	}

}
