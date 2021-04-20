package br.com.gellog.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class TesteOutro extends JFrame {
	private String[] print1, print2;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteOutro frame = new TesteOutro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TesteOutro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0,0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		final JTextPane textPane = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridwidth = 8;
		gbc_textPane.gridheight = 4;
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.insets = new Insets(0, 0, 5, 5);
		gbc_textPane.gridx = 0;
		gbc_textPane.gridy = 0;
		contentPane.add(textPane, gbc_textPane);
		
		
		
		textPane.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				 print1 = textPane.getText().split("\\r?\\n");		
			}
		});
		
		
ArrayList<String> medida = new ArrayList<String>();
medida.add("kg");
medida.add("kg.");
medida.add("quilos");
medida.add("kilos");
medida.add("gramas");
medida.add("gr.");
medida.add("gr");
medida.add("unidade");
medida.add("duzia");
medida.add("duzia");
medida.add("fatia");
medida.add("inteiro");
medida.add("meio");
medida.add("vidro");
medida.add("vidrinho");
medida.add("litros");
medida.add("litrão");
medida.add("litrao");
medida.add("caixa");
medida.add("caixinha");
medida.add("lata");
medida.add("latinha");
medida.add("latao");
medida.add("pacote");
medida.add("saco");
medida.add("saquinho");

ArrayList<String> produto = new ArrayList<String>();

produto.add("arroz");
produto.add("feijao");
produto.add("macarrão");
produto.add("macarrao");
produto.add("leite");
produto.add("leite condensado");
produto.add("leite desnatado");
produto.add("leite de coco");
produto.add("leite integral");
produto.add("pao");
produto.add("pão");
produto.add("mateiga");
produto.add("queijo");


		
	//	for (String string : print1) {
		//	listaCompras.add(string);
		//} 
		
		
		JTextPane textPane_1 = new JTextPane();
		GridBagConstraints gbc_textPane_1 = new GridBagConstraints();
		gbc_textPane_1.gridwidth = 8;
		gbc_textPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_textPane_1.fill = GridBagConstraints.BOTH;
		gbc_textPane_1.gridx = 0;
		gbc_textPane_1.gridy = 4;
		contentPane.add(textPane_1, gbc_textPane_1);
		
		
		JButton btnEnviar = new JButton("Enviar");		
		GridBagConstraints gbc_btnEnviar = new GridBagConstraints();
		gbc_btnEnviar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEnviar.anchor = GridBagConstraints.NORTH;
		gbc_btnEnviar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEnviar.gridx = 0;
		gbc_btnEnviar.gridy = 7;
		contentPane.add(btnEnviar, gbc_btnEnviar);
		
		
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, Arrays.toString(print1));
			}
		});

		
		

		   
	        
	        






		
	
		
	}

}
