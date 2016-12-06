package interficie;

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

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class Ventana8 extends JFrame {

	private JPanel buscar;
	private JTextField titulo;
	private JTextField autor;
	private JButton btnExit;
	private JTextArea resultado;

	public Ventana8(final CtrlPresentacio c) {
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		buscar = new JPanel();
		buscar.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(buscar);
		buscar.setLayout(null);
		
		titulo = new JTextField();
		titulo.setBounds(104, 12, 311, 19);
		buscar.add(titulo);
		titulo.setColumns(10);
		
		autor = new JTextField();
		autor.setBounds(104, 43, 311, 19);
		buscar.add(autor);
		autor.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 103, 281, 105);
		buscar.add(scrollPane);
		
		resultado = new JTextArea();
		scrollPane.setViewportView(resultado);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tit = titulo.getText();
				String aut = autor.getText();
				Texto t = c.cd().conjunto().consultarTextoDadoTituloAutor(tit, aut);
				resultado.setText(t.getTexto());
			}
		});
		btnBuscar.setBounds(104, 66, 311, 25);
		buscar.add(btnBuscar);
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c.getvolver()) c.llamarp1();				
				else c.llamarp4();
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
		
		JLabel lblTtulo = new JLabel("Título");
		lblTtulo.setBounds(16, 14, 70, 15);
		buscar.add(lblTtulo);
		
		JLabel label = new JLabel("Autor");
		label.setBounds(16, 45, 70, 15);
		buscar.add(label);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tit = titulo.getText();
				String aut = autor.getText();
				int b = c.cd().conjunto().borrardoc(tit, aut);
				if(b == 1) System.out.print("Se ha borrado con éxito");
				else System.out.print("No existe documento");
			}
		});
		btnBorrar.setBounds(322, 103, 117, 25);
		buscar.add(btnBorrar);
		
		JButton button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.llamarp1();
				dispose();
			}
		});
		button.setBounds(425, 247, 25, 25);
		buscar.add(button);
		
	}
	public String gettitulo() {
		return titulo.getText();
	}
	public String getautor() {
		return autor.getText();
	}

}
