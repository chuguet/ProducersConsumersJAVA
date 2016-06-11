package es.hsl.pc.code.containers;

import java.util.List;

public class ContainerObjects {

	private Integer numObjects;
	private List<Object> content;
	private Boolean filledContainer = Boolean.FALSE;

	public ContainerObjects(final Integer numObjects) {
		this.numObjects = numObjects;
	}

	public synchronized Object get() {
		Object result = null;
		while (!this.filledContainer) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				System.err.println("Contenedor: Error en get -> " + e.getMessage());
			}
		}
		this.filledContainer = this.content.size() <= numObjects;
		for (Object object : this.content) {
			if (object != null) {
				result = object;
			}
		}
		return result;
	}

	public synchronized void put(Appendable appendable) {
		while (this.filledContainer) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				System.err.println("Contenedor: Error en put -> " + e.getMessage());
			}
		}
		this.content.add(appendable);
		this.filledContainer = this.content.size() > numObjects;
	}

}
