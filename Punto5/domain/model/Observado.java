package model;

import java.util.List;

import portsin.Observador;
import portsin.RestauranteApi;

public abstract class Observado implements RestauranteApi {

	List<Observador> observadores;

	public void agregarObservador(Observador observador) {
		this.observadores.add(observador);
	}

	public void notificar(String precioVenta) {
		for (Observador observador : observadores) {
			observador.actualizar(precioVenta);
		}
	}
}
