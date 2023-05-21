package data;

import java.sql.PreparedStatement;

import portsout.CargarParticipante;
import portsout.ErrorException;
import portsout.ParticipanteRecord;

public class ParticipanteJDBC implements CargarParticipante {

	public void almacenarParticipante(ParticipanteRecord participante) throws ErrorException {
		PreparedStatement st = null;
		try {
//		 Conn conection = new Conn("jdbc:mysql://localhost:3306/participantes");
//		 Connection dbConn = (Connection) conection.open(); 
//		 st = dbConn.prepareStatement("insert into participantes(nombre, telefono, region) values(?,?,?)");
//		 
//		  st.setString(1, participante.nombre());
//		  st.setString(2, participante.telefono());
//		  st.setString(3, participante.region());
//		  st.executeUpdate();
		} catch (Exception e) {
			throw new ErrorException("Error en la base");
		}
	}

	@Override
	public void actualizar(String email, String txt) {
		// TODO Auto-generated method stub

	}

}
