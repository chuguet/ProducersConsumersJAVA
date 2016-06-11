package es.hsl.pc.code.main;

import es.hsl.pc.code.consumers.Consumer;
import es.hsl.pc.code.containers.Container;
import es.hsl.pc.code.producers.Producer;

public class Main {

	private static Container container;
	private static Thread producer;
	private static Thread[] consumers;
	private static final Integer CANTIDADCONSUMIDORES = 5;

	public static void main(String[] args) {
		container = new Container();
		producer = new Thread(new Producer(container, 1));
		consumers = new Thread[CANTIDADCONSUMIDORES];

		for (int i = 0; i < CANTIDADCONSUMIDORES; i++) {
			consumers[i] = new Thread(new Consumer(container, i));
			consumers[i].start();
		}

		producer.start();
	}

}
