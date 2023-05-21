package model;

import java.util.List;

import portsout.Observador;

public abstract class Observado {

	List<Observador> observadores;

	public void agregarObservador(Observador observador) {
		observadores.add(observador);
	}

	public void notificar(String temperatura) {

		for (Observador observador : observadores) {
			observador.update(temperatura);
		}
	}
}
