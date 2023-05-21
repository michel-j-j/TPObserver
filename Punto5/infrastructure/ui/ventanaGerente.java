package ui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import portsin.Observador;

public class ventanaGerente extends JFrame implements Observador {

	private JPanel contentPane;
	private JLabel lblMontoFactura;

	public ventanaGerente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		lblMontoFactura = new JLabel("Total: ");
		lblMontoFactura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMontoFactura.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMontoFactura, BorderLayout.CENTER);

		JLabel lblPantallaDeFactura = new JLabel("Precio de la ultima factura. ");
		lblPantallaDeFactura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPantallaDeFactura.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPantallaDeFactura, BorderLayout.NORTH);

		setVisible(true);
	}

	@Override
	public void actualizar(String ultimaVenta) {
		this.lblMontoFactura.setText("Total: " + ultimaVenta);
		repaint();
	}

}
