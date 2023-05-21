package email;

import java.util.Objects;
import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import portsout.Observador;

public class EnEmail implements Observador {
	private String emisor;
	private String receptor;
	private String usuario;
	private String contra;
	private String host;

	private static final String EMISOR = "from@example.com";
	private static final String USUARIO = "b78c9f4878db7f";
	private static final String CONTRA = "b4f74a52b601e4";
	private static final String HOST = "sandbox.smtp.mailtrap.io";

	private static final String TITULO = "Notifiacion de usuario";

	public EnEmail(String receptor) {

		this.emisor = Objects.requireNonNull(EMISOR);
		this.receptor = Objects.requireNonNull(receptor);
		this.usuario = Objects.requireNonNull(USUARIO);
		this.contra = Objects.requireNonNull(CONTRA);
		this.host = Objects.requireNonNull(HOST);
	}

	private void notificarEmpleado(String titulo, String msj) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		// create the Session object
		jakarta.mail.Authenticator authenticator = new jakarta.mail.Authenticator() {
			protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(usuario, contra);
			}
		};
		Session session = Session.getDefaultInstance(props, authenticator);

		try {
			// create a MimeMessage object
			Message message = new MimeMessage(session);
			// set From email field
			message.setFrom(new InternetAddress(emisor));
			// set To email field
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receptor));
			// set email subject field
			message.setSubject(titulo);
			// set the content of the email message
			message.setText(msj);
			// send the email message
			Transport.send(message);
			System.out.println("Mensaje Enviado!");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void actualizar(String email, String txt) {
		this.receptor = email;
		notificarEmpleado(TITULO, txt);
	}

}