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
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JTextArea;

import dominio.Texto;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;

import java.awt.Font;


public class Ventana7 extends JFrame {

	private JPanel contentPane;
	private JTextField campo;
	private JTextArea contenido;
    
	public Ventana7(final CtrlPresentacio c) {
			this.setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			this.setLocationRelativeTo(null);
			JLabel lblCampoAModificar = new JLabel("Campo a modificar:");
			lblCampoAModificar.setBounds(37, 12, 151, 15);
			contentPane.add(lblCampoAModificar);
			
			JLabel label = new JLabel("");
			label.setBounds(37, 84, 70, 15);
			contentPane.add(label);
			
			JLabel lblEscribaAquiPor = new JLabel("Escriba aqui por lo que desee modificar:");
			lblEscribaAquiPor.setBounds(37, 66, 306, 15);
			contentPane.add(lblEscribaAquiPor);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(37, 97, 282, 99);
			contentPane.add(scrollPane);
			
			contenido = new JTextArea();
			scrollPane.setViewportView(contenido);
			
			campo = new JTextField();
			campo.setBounds(188, 10, 114, 19);
			contentPane.add(campo);
			campo.setColumns(10);
			
			JLabel lblcamposDisponiblesTtuloautorcategoriatexto = new JLabel("(campos disponibles: titulo,autor,categoria,texto) ");
			lblcamposDisponiblesTtuloautorcategoriatexto.setFont(new Font("Dialog", Font.ITALIC, 12));
			lblcamposDisponiblesTtuloautorcategoriatexto.setBounds(37, 39, 391, 15);
			contentPane.add(lblcamposDisponiblesTtuloautorcategoriatexto);
			
			JButton btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						c.cd().conjunto().modificardoc(c.gettitulo(), c.getautor(), campo.getText(), contenido.getText());
					} catch (IOException | ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			btnOk.setBounds(200, 195, 117, 25);
			contentPane.add(btnOk);
			
			JButton btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					c.llamarp3();
					dispose();
					}
			});
			btnVolver.setBounds(281, 232, 117, 25);
			contentPane.add(btnVolver);
			
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
			btnExit.setBounds(37, 235, 117, 25);
			contentPane.add(btnExit);
			
			JButton button = new JButton("<");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					c.llamarp1();
					dispose();
				}
			});
			button.setBounds(420, 247, 18, 25);
			contentPane.add(button);
	}
}
