package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

import portsout.Observador;

public class EnArchivo implements Observador {
	private String ruta;

	public EnArchivo(String ruta) {
		this.ruta = Objects.requireNonNull(ruta);
	}

	@Override
	public void update(String temperatura) {
		if (temperatura.isEmpty())
			throw new RuntimeException(".");
		try {
			escribirEnDisco(temperatura);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void escribirEnDisco(String txt) throws IOException {
		try {
			File archivo = new File(ruta);
			if (!archivo.exists())
				archivo.createNewFile();

			FileWriter escritor = new FileWriter(archivo, true);
			escritor.write(txt + " " + LocalDate.now());
			escritor.write(System.lineSeparator());
			escritor.close();

		} catch (FileNotFoundException e) {
			throw new RuntimeException("Error al escribir en el archivo.");
		}
	}

}
