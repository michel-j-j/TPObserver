package ui;

import javax.swing.JFrame;

import model.Observado;
import model.Servicio;

public class Main {

	public static void main(String[] args) {

		Observado obs1 = new Servicio();
		obs1.agregarObservador(new ventanaGerente());
		JFrame ventan = new ventanaComida(obs1);

	}

}
