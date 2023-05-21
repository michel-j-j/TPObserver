package model;

import java.util.ArrayList;

import portsin.Observador;

public class Servicio extends Observado {

	public Servicio() {
		this.observadores = new ArrayList<Observador>();
	}

	@Override
	public void generarVenta(String precio) {
		this.notificar(precio);
	}

}
