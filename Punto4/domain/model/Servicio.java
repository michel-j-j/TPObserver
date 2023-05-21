package model;

import java.util.Objects;

import portsin.Registro;
import portsin.RegistroException;
import portsout.CargarParticipante;
import portsout.ErrorException;

public class Servicio extends Observado implements Registro {
	CargarParticipante carga;

	public Servicio(CargarParticipante carga) {
		this.carga = Objects.requireNonNull(carga);
	}

	@Override
	public void cargarParticipante(String nombre, String region, String telefono, String email)
			throws RegistroException {
		try {
			Participante participante = new Participante(nombre, region, telefono, email);
			carga.almacenarParticipante(participante.cargarRecord());
			notificar(email, "Participante registrado con exito.");
		} catch (ErrorException e) {
			throw new RegistroException(e.obtenerMsj());
		}
	}

}
