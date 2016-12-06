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

public class Ventana5 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Ventana5(final CtrlPresentacio c) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(138, 27, 119, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(81, 23, 73, 26);
		contentPane.add(lblAutor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 65, 144, 139);
		contentPane.add(scrollPane);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(221, 65, 205, 139);
		contentPane.add(scrollPane_1);
		
		final JTextArea contenido = new JTextArea();
		scrollPane_1.setViewportView(contenido);
		
		final JList list = new JList();
		scrollPane.setViewportView(list);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String selected = (String) list.getSelectedValue();
				Texto t = c.cd().conjunto().consultarTextoDadoTituloAutor(selected, textField.getText());
				contenido.setText(t.getTexto());
			}
		});
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> al = c.cd().conjunto().consultarTitulosAutor(textField.getText());
				DefaultListModel dlm = new DefaultListModel();
				for(int i = 0; i < al.size(); ++i){
					dlm.addElement(al.get(i));
				}
				list.setModel(dlm);
				//list = new JList(titulos);
				
			}
		});
		btnNewButton.setBounds(288, 27, 100, 19);
		contentPane.add(btnNewButton);
		
		
		
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
		btnVolver.setBounds(288, 235, 117, 25);
		contentPane.add(btnVolver);
		
		JButton button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.llamarp1();
				dispose();
			}
		});
		button.setBounds(429, 247, 21, 25);
		contentPane.add(button);
		
		
		
		
		
		
	}
}