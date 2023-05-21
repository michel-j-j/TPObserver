package portsout;

public interface CargarParticipante extends Observador {
	public void almacenarParticipante(ParticipanteRecord participante) throws ErrorException;
}
