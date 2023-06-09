package data;

import portsout.Observador;

public class EnConsola implements Observador {

	private final String FRIO = "Hace frio, se encendera la caldera";
	private final String CALOR = "Hace calor, se encenderá el aire acondicionado";

	private final Integer temperaturaBaja = 12;
	private final Integer temperaturaAlta = 17;

	@Override
	public void update(String temperatura) {
		Float temp = Float.parseFloat(temperatura);
		if (temp < temperaturaBaja)
			System.out.println(FRIO);
		if (temp > temperaturaAlta)
			System.out.println(CALOR);
	}

}
