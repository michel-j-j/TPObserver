package model;

import portsout.Observador;

public abstract class Observado {
	Observador observadores;

	public void agregarObservador(Observador observador) {
		this.observadores = observador;
	}

	public void notificar(String email, String txt) {
		observadores.actualizar(email, txt);
	}
}
