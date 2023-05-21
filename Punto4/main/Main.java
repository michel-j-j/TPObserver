import data.ParticipanteJDBC;
import email.EnEmail;
import model.Servicio;
import ui.Ventana;

public class Main {
	public static void main(String[] args) {
		var servicio = new Servicio(new ParticipanteJDBC());
		servicio.agregarObservador(new EnEmail(""));
		new Ventana(servicio);
	}
}
