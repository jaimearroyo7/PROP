package interficie;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.ConsultaBooleana;
import dominio.ConsultaDocumentosParecidos;
import dominio.Documento;
import dominio.ExpBool;
import dominio.Pair;
import dominio.Texto;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.SpinnerNumberModel;

public class Ventana14 extends JFrame implements Serializable{

	private JPanel contentPane;
	private JTextField titulo;
	private JTextField autor;
	private JTextField metodo;
	private ArrayList<Pair<String, String>> aux = new ArrayList<Pair<String, String>>();

	public Ventana14(final CtrlPresentacio c) {
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
		addWindowListener(exitListener);
		setBounds(100, 100, 588, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.setLocationRelativeTo(null);
		
		
		JLabel lblConsultas = new JLabel("A partir de un documento");
		lblConsultas.setBounds(159, 12, 219, 15);
		contentPane.add(lblConsultas);
		
		
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
		btnExit.setBounds(12, 404, 117, 25);
		contentPane.add(btnExit);
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.llamarp13();
				dispose();
				}
		});
		btnVolver.setBounds(455, 404, 117, 25);
		contentPane.add(btnVolver);
		
		JLabel lblIngreseTitulo = new JLabel("Ingrese titulo:");
		lblIngreseTitulo.setBounds(27, 47, 117, 15);
		contentPane.add(lblIngreseTitulo);
		
		JLabel lblIngreseAutor = new JLabel("Ingrese autor:");
		lblIngreseAutor.setBounds(27, 77, 117, 15);
		contentPane.add(lblIngreseAutor);
		
		titulo = new JTextField();
		titulo.setBounds(159, 45, 219, 19);
		contentPane.add(titulo);
		titulo.setColumns(10);
		
		autor = new JTextField();
		autor.setBounds(159, 75, 219, 19);
		contentPane.add(autor);
		autor.setColumns(10);
		
		JLabel lblMtodoTfidflogbool = new JLabel("Método TFIDF (log/bool):");
		lblMtodoTfidflogbool.setBounds(27, 104, 190, 15);
		contentPane.add(lblMtodoTfidflogbool);
		
		metodo = new JTextField();
		metodo.setBounds(213, 102, 165, 19);
		contentPane.add(metodo);
		metodo.setColumns(10);
		
		
		final JLabel Vacos = new JLabel("Campos vacios!");
		Vacos.setBounds(414, 59, 123, 15);
		contentPane.add(Vacos);
		Vacos.setVisible(false);
		
		final JLabel errorSel = new JLabel("Selecciona un documento!");
		errorSel.setBounds(359, 262, 200, 15);
		contentPane.add(errorSel);
		errorSel.setVisible(false);
		
		final JLabel NEXI = new JLabel("No existe!");
		NEXI.setBounds(414, 59, 120, 15);
		contentPane.add(NEXI);
		NEXI.setVisible(false);
		
		JLabel lblNmeroDeDocumentos = new JLabel("Número de documentos:");
		lblNmeroDeDocumentos.setBounds(27, 131, 200, 15);
		contentPane.add(lblNmeroDeDocumentos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 184, 303, 194);
		contentPane.add(scrollPane);
		
		final JList list = new JList();
		scrollPane.setViewportView(list);
		
		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(223, 129, 28, 20);
		contentPane.add(spinner);
		
		final JLabel errormetodo = new JLabel("Introduce Método TFIDF!");
		errormetodo.setBounds(396, 104, 194, 15);
		contentPane.add(errormetodo);
		errormetodo.setVisible(false);
		
		JButton Buscar = new JButton("Buscar");
		Buscar.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
				errorSel.setVisible(false);
				boolean empieza = true;
				if(metodo.getText().isEmpty() || metodo.getText().equals(null) || (metodo.getText().equals("log") == false && metodo.getText().equals("bool") == false)){
					errormetodo.setVisible(true);
					empieza = false;
				}
				else errormetodo.setVisible(false);
				
				boolean trobat = false;
				if(titulo.getText().isEmpty() || autor.getText().isEmpty() || titulo.getText() == null || autor.getText() == null) {
					Vacos.setVisible(true);
					NEXI.setVisible(false);
				}
				else{
					Vacos.setVisible(false);
					NEXI.setVisible(true);
					for(int i = 0; i < c.cd().conjunto().getDocs().size(); ++i){
						if(c.cd().conjunto().getDocs().get(i).getAutor().equals(autor.getText()) && c.cd().conjunto().getDocs().get(i).getTitulo().equals(titulo.getText())){
							i = c.cd().conjunto().getDocs().size(); 
							trobat = true;
							NEXI.setVisible(false);
						}
					}
				if(trobat && empieza) {
					NEXI.setVisible(false);
					ConsultaDocumentosParecidos.TFIDF_MODE mode = null;
					ArrayList<Pair<String,String>> result = null;
				try {
                    if (metodo.equals("log")) mode = ConsultaDocumentosParecidos.TFIDF_MODE.LOG;
                    else if (metodo.equals("bool")) mode = ConsultaDocumentosParecidos.TFIDF_MODE.BOOLEAN;
                    int num = (int) spinner.getValue();
                    String value = String.valueOf(num);
					result = c.cd().conjunto().consultardocumentosparecidos(titulo.getText(), autor.getText(), value, mode);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DefaultListModel dlm = new DefaultListModel();
				
				//errorSel.setVisible(false);
				for(int i = 0; i < result.size(); ++i){
					Pair<String,String> auxi = new Pair<String, String>();
					auxi.setFirst(result.get(i).first());
					auxi.setSecond(result.get(i).second());
					aux.add(auxi);
					String s = result.get(i).second() + ": " + result.get(i).first();
					dlm.addElement(s);
				}
				list.setModel(dlm);
					}
				}
				
			}
		});
		Buscar.setBounds(414, 126, 95, 25);
		contentPane.add(Buscar);
		
		JButton btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex() == -1){
					errorSel.setVisible(true);
				}
				else {
					errorSel.setVisible(false);
					int i = list.getSelectedIndex();
					c.setAutor(aux.get(i).second());
					c.setTitulo(aux.get(i).first());
					c.llamarp3();
					dispose();
				}
			}
		});
		btnVer.setBounds(396, 224, 117, 25);
		contentPane.add(btnVer);
	}
}
