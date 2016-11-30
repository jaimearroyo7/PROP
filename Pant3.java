package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import dominio.Texto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Pant3 extends JFrame {

	private JPanel buscar;
	private JTextField titulo;
	private JTextField autor;
	private JTextField resultado;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Pant3(final CtrlPresentacio c) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		buscar = new JPanel();
		buscar.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(buscar);
		buscar.setLayout(null);
		
		titulo = new JTextField();
		titulo.setBounds(104, 39, 114, 19);
		buscar.add(titulo);
		titulo.setColumns(10);
		
		autor = new JTextField();
		autor.setBounds(279, 39, 114, 19);
		buscar.add(autor);
		autor.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tit = titulo.getText();
				String aut = autor.getText();
				Texto t = c.cd().conjunto().consultarTextoDadoTituloAutor(tit, aut);
				resultado.setText(t.getTexto());
			}
		});
		btnBuscar.setBounds(195, 70, 117, 25);
		buscar.add(btnBuscar);
		
		resultado = new JTextField();
		resultado.setText("");
		resultado.setBounds(148, 107, 207, 64);
		buscar.add(resultado);
		resultado.setColumns(10);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.llamarp4();
				dispose();
			}
		});
		btnVolver.setBounds(298, 235, 117, 25);
		buscar.add(btnVolver);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.cd().acabar();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(1);
			}
		});
		btnExit.setBounds(68, 235, 117, 25);
		buscar.add(btnExit);
		
		
	}
}
