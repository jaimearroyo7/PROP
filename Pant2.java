package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JTextField;

import dominio.Documento;
import dominio.Texto;
import javax.swing.JLabel;

public class Pant2 extends JFrame {

	private JPanel contentPane;
	private JTextField titulo;
	private JTextField autor;
	private JTextField Categoria;
	private JTextField texto;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Pant2(final CtrlPresentacio c) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final Documento d = new Documento();
		
		final JLabel errortit = new JLabel("Introduce un título!");
		errortit.setVisible(false);
		errortit.setBounds(271, 14, 137, 15);
		contentPane.add(errortit);
		
		final JLabel erroraut = new JLabel("Introduce un autor!");
		erroraut.setVisible(false);
		erroraut.setBounds(271, 45, 152, 15);
		contentPane.add(erroraut);
		
		final JLabel errorcat = new JLabel("Introduce categoria!");
		errorcat.setVisible(false);
		errorcat.setBounds(271, 75, 152, 15);
		contentPane.add(errorcat);
		
		final JLabel errortext = new JLabel("Introduce texto!");
		errortext.setVisible(false);
		errortext.setBounds(271, 106, 137, 15);
		contentPane.add(errortext);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean sigue = true;
				if(titulo.getText().isEmpty() || titulo.getText() == null){
					errortit.setVisible(true);
					sigue = false;
				}
				else errortit.setVisible(false);
				
				if(autor.getText().isEmpty() || autor.getText() == null){
					erroraut.setVisible(true);
					sigue = false;
				}
				else erroraut.setVisible(false);
				
				if(Categoria.getText().isEmpty() || Categoria.getText() == null){
					errorcat.setVisible(true);
					sigue = false;
				}
				else errorcat.setVisible(false);
				
				if(texto.getText().isEmpty() || texto.getText() == null){
					errortext.setVisible(true);
					sigue = false;
				}
				else errortext.setVisible(false);
				
				if(sigue){
				d.setTitulo(titulo.getText());
				d.setAutor(autor.getText());
				d.setCategoria(Categoria.getText());
				Texto t = new Texto(texto.getText());
				try {
					d.setTexto(t);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					c.cd().conjunto().addDoc(d);
				} catch (ParseException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				c.llamarp1();
				dispose();
				}
			}
		});
		btnAceptar.setBounds(139, 152, 117, 25);
		contentPane.add(btnAceptar);
		
		titulo = new JTextField();
		titulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		titulo.setBounds(139, 12, 114, 19);
		contentPane.add(titulo);
		titulo.setColumns(10);
		
		autor = new JTextField();
		autor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		autor.setBounds(139, 43, 114, 19);
		contentPane.add(autor);
		autor.setColumns(10);
		
		Categoria = new JTextField();
		Categoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		Categoria.setBounds(139, 73, 114, 19);
		contentPane.add(Categoria);
		Categoria.setColumns(10);
		
		texto = new JTextField();
		texto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		texto.setText("");
		texto.setBounds(139, 104, 114, 19);
		contentPane.add(texto);
		texto.setColumns(10);
		
		JLabel lblTtulo = new JLabel("Título");
		lblTtulo.setBounds(61, 14, 70, 15);
		contentPane.add(lblTtulo);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(61, 45, 70, 15);
		contentPane.add(lblAutor);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(51, 75, 70, 15);
		contentPane.add(lblCategoria);
		
		JLabel lblTexto = new JLabel("Texto");
		lblTexto.setBounds(61, 106, 70, 15);
		contentPane.add(lblTexto);
		
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
		btnVolver.setBounds(321, 235, 117, 25);
		contentPane.add(btnVolver);
		
		
		
		
	}
}
