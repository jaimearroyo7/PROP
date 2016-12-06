package interficie;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JTextArea;

import dominio.Texto;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JScrollPane;

public class Ventana6 extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JList list;

	public Ventana6(final CtrlPresentacio c) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrefijo = new JLabel("Prefijo:");
		lblPrefijo.setBounds(67, 23, 70, 15);
		contentPane.add(lblPrefijo);
		
		textField = new JTextField();
		textField.setBounds(138, 21, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 67, 187, 140);
		contentPane.add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> al = c.cd().conjunto().consultarAutoresPrefijo(textField.getText());
				DefaultListModel dlm = new DefaultListModel();
				for(int i = 0; i < al.size(); ++i){
					dlm.addElement(al.get(i));
				}
				list.setModel(dlm);
			}
		});
		btnBuscar.setBounds(285, 21, 100, 19);
		contentPane.add(btnBuscar);
		
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
				c.llamarp4();
				dispose();
				}
		});
		btnVolver.setBounds(284, 235, 117, 25);
		contentPane.add(btnVolver);
		
		JButton button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.llamarp1();
				dispose();
			}
		});
		button.setBounds(426, 247, 24, 25);
		contentPane.add(button);
	}
}
