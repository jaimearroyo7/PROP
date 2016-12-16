package interficie;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import dominio.Pair;
import dominio.Texto;

public class Ventana11 extends JFrame implements Serializable{

	private JPanel contentPane;
	private JTextField textField;

	
	public Ventana11(final CtrlPresentacio c) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		WindowListener exitListener = new WindowAdapter() {

		    @Override
		    public void windowClosing(WindowEvent e) {
		        int confirm = JOptionPane.showOptionDialog(
		             null, "Desea cerrar la aplicacion?", 
		             "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
		             JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == 0) {
		        	try {
						c.acabar();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.exit(1);
		        }
		    }
		};

		this.setLocationRelativeTo(null);
		addWindowListener(exitListener);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(29, 32, 85, 15);
		contentPane.add(lblCategoria);
		
		textField = new JTextField();
		textField.setBounds(132, 30, 260, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(248, 91, 176, 145);
		contentPane.add(scrollPane_1);
		
		final JTextArea contenido = new JTextArea();
		scrollPane_1.setViewportView(contenido);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 91, 192, 145);
		contentPane.add(scrollPane);
		
		final JList list = new JList();
		scrollPane.setViewportView(list);
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Pair<String,String> selected = (Pair<String,String>) list.getSelectedValue();
				Texto t = c.cd().conjunto().consultarTextoDadoTituloAutor(selected.first(), selected.second());
				contenido.setText(t.getTexto());
			}
		});
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Pair<String,String>> lp = c.cd().conjunto().consultarCategoria(textField.getText());
				DefaultListModel dlm = new DefaultListModel();
				for(int i = 0; i < lp.size(); ++i){
					Pair<String,String> p = null;
					p.setFirst(lp.get(i).first());
					p.setSecond(lp.get(i).second());
					dlm.addElement(p); // no se como saldrá este pair.
				
				}
				list.setModel(dlm);
				//list = new JList(titulos);
				
			}
		});
		btnBuscar.setBounds(275, 54, 117, 25);
		contentPane.add(btnBuscar);
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.acabar();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(1);
			}
		});
		btnExit.setBounds(30, 263, 117, 25);
		contentPane.add(btnExit);
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.llamarp4();
				dispose();
				}
		});
		btnVolver.setBounds(321, 263, 117, 25);
		contentPane.add(btnVolver);
	
	}
}
