package portsin;

public interface Registro {

	public void cargarParticipante(String nombre, String region, String telefono, String email)
			throws RegistroException;
}
