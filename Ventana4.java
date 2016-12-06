package interficie;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistencia.CtrlPersistencia;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Ventana4 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Ventana4(final CtrlPresentacio c) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Lista de títulos de un autor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.llamarp5();
				dispose();
			}
		});
		btnNewButton.setBounds(106, 12+15, 277, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lísta de autores dado un prefijo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.llamarp6();
				dispose();
			}
		});
		btnNewButton_1.setBounds(106, 35+15, 277, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Contenido de un Documento");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.llamarp3();
				dispose();
			}
		});
		btnNewButton_2.setBounds(106, 60+15, 277, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Documentos Parecidos");
		btnNewButton_3.setBounds(106, 85+15, 277, 25);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Expresión booleana");
		btnNewButton_4.setBounds(106, 85+25+15, 277, 25);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Documentos Relevantes");
		btnNewButton_5.setBounds(106, 133+15, 277, 25);
		contentPane.add(btnNewButton_5);
		
		JLabel lblConsultas = new JLabel("Consultas");
		lblConsultas.setBounds(196, 0, 96, 15);
		contentPane.add(lblConsultas);
		
		JButton btnExit = new JButton("Exit");
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
		contentPane.add(btnExit);
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.llamarp1();
				dispose();
				}
		});
		btnVolver.setBounds(297, 235, 117, 25);
		contentPane.add(btnVolver);
	}
}
