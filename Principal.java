package interficie;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Point;

public class Principal extends JFrame {

	private JPanel contentPane;
	private boolean volver;

	
	public Principal(final CtrlPresentacio c) {
		setLocation(new Point(0, 0));
		volver = false;
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		
		JButton btnAadir = new JButton("Añadir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.llamarp2();
				dispose();
			}
		});
		btnAadir.setBounds(56, 12, 369, 25);
		contentPane.add(btnAadir);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.llamarp4();
				dispose();
			}
		});
		btnConsultar.setBounds(56, 49, 369, 25);
		contentPane.add(btnConsultar);
		
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
		btnExit.setBounds(308, 235, 117, 25);
		contentPane.add(btnExit);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver = true;
				c.llamarp8();
				dispose();
			}
		});
		btnBorrar.setBounds(56, 86, 369, 25);
		contentPane.add(btnBorrar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver = true;
				c.llamarp9();
				dispose();
			}
		});
		btnModificar.setBounds(56, 123, 369, 25);
		contentPane.add(btnModificar);
		
		
	}
	public boolean getVolver() {
		return volver;
	}
}

