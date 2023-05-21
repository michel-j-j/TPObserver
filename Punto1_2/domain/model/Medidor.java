package model;

import java.util.ArrayList;

import portsout.Observador;

public class Medidor extends Observado {

	private String temperatura;
	private ClimaOnline clima;

	public Medidor(ClimaOnline clima) {
		this.clima = clima;
		this.observadores = new ArrayList<Observador>();
	}

	public String leerTemperatura() {
		// leo la temperatura del servicio web
		this.temperatura = this.clima.temperatura();
		this.notificar(temperatura);
		return this.temperatura;

	}
}
