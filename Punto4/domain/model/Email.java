package model;

import portsout.ErrorException;

public class Email {
	private String email;

	Email(String email) {
		if (email.isEmpty())
			throw new ErrorException("El email esta vacio");
		if (!validarEmail(email))
			throw new ErrorException("El email no es valido, deber tener la forma: abc@123.com");

		this.email = email;

	}

	String obtenerEmail() {
		return this.email;
	}

	Boolean validarEmail(String email) {
		return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
	}
}