package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import portsin.RestauranteApi;
import portsin.TipoBebida;
import portsin.TipoComida;

public class ventanaComida extends JFrame {

	private JPanel contentPane;
	private JComboBox cbComida;
	private JComboBox cbBebida;
	Integer a;
	private RestauranteApi api;

	public ventanaComida(RestauranteApi api) {
		this.api = Objects.requireNonNull(api);

		a = 1000;
		getContentPane().setBackground(new Color(204, 204, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 413);
		setTitle("Ventana de Comida");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		JLabel lblComida = new JLabel("Comida:");
		lblComida.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblComida.setBounds(25, 43, 71, 30);
		getContentPane().add(lblComida);

		JLabel lblBebida = new JLabel("Bebida:");
		lblBebida.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBebida.setBounds(25, 139, 71, 30);
		getContentPane().add(lblBebida);

		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				api.generarVenta(a.toString());
				a += 1000;
			}
		});
		btnPagar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPagar.setBounds(252, 326, 132, 40);
		getContentPane().add(btnPagar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setBounds(10, 326, 132, 40);
		getContentPane().add(btnVolver);

		cbComida = new JComboBox();
		cbComida.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbComida.setBounds(252, 44, 132, 30);
		getContentPane().add(cbComida);

		cbBebida = new JComboBox();
		cbBebida.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbBebida.setBounds(252, 139, 132, 30);
		getContentPane().add(cbBebida);
		setVisible(true);

		cargarComboBox();
	}

	private void cargarComboBox() {
		for (TipoComida comida : TipoComida.values()) {
			cbComida.addItem(comida);
		}
		for (TipoBebida bebida : TipoBebida.values()) {
			cbBebida.addItem(bebida);
		}
		repaint();
	}
}
