package br.com.gellog.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.Normalizer;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private String[] print1;
	private JPanel contentPane;
	private String regex, aux;
	static JTextArea txA_Resultado, txP_Lista;
	static JButton btnEnviar;
	
	public static void main(String[] args) {
		//jframe 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
					    public void windowOpened( WindowEvent e ){
					    	btnEnviar.requestFocus();
					    }
					}); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		//campo para colar a lista
		txP_Lista = new JTextArea();
		contentPane.add(txP_Lista, BorderLayout.NORTH);
		txP_Lista.setText("Cole ou digite sua lista aqui!!");
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		txP_Lista
				.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 50)));
		txP_Lista.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				//trata a lista inserido, separando numero de palavra, removendo quebras de linhas desnecessárias e virgulas
				regex = txP_Lista.getText().replaceAll("(\\d)([A-Za-z])", "$1 $2");
				regex = regex.replaceAll("(?m)^[ \t]*\r?\n", "");
				regex = regex.replaceAll(",", "\n");
				regex = Normalizer.normalize(regex, Normalizer.Form.NFD);
				regex = regex.replaceAll("[^\\p{ASCII}]", "");
				regex = regex.toLowerCase();
				print1 = regex.split("\\r?\\n");
				txP_Lista.setText("Cole ou digite sua lista aqui!!");

			}
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				super.focusGained(e);
				txP_Lista.setText("");
			}
		});

		//Criação da base de dados para comparar com a lista do usuário
		
		final ArrayList<String> quantidade = new ArrayList<String>();
		quantidade.add("um");
		quantidade.add("dois");
		quantidade.add("tres");
		quantidade.add("quatro");
		quantidade.add("cinco");
		quantidade.add("seis");
		quantidade.add("sete");
		quantidade.add("oito");
		quantidade.add("nove");
		quantidade.add("dez");
		quantidade.add("onze");
		quantidade.add("doze");
		quantidade.add("treze");
		quantidade.add("quatorze");
		quantidade.add("quinze");
		quantidade.add("dezesseis");
		quantidade.add("dezessete");
		quantidade.add("dezoito");
		quantidade.add("dezenove");
		quantidade.add("vinte");
		quantidade.add("trinta");
		quantidade.add("quarenta");
		quantidade.add("cinquenta");
		quantidade.add("cem");
		quantidade.add("duzentos");
		quantidade.add("trezentos");
		quantidade.add("quatrossentos");
		quantidade.add("quinhentos");
		quantidade.add("mil");

		final ArrayList<String> medida = new ArrayList<String>();
		medida.add("kg");
		medida.add("kg.");
		medida.add("quilo");
		medida.add("quilos");
		medida.add("kilos");
		medida.add("kilo");
		medida.add("gramas");
		medida.add("gr.");
		medida.add("gr");
		medida.add("unidade");
		medida.add("unidades");
		medida.add("duzia");
		medida.add("duzias");
		medida.add("fatia");
		medida.add("fatias");
		medida.add("inteiro");
		medida.add("inteira");
		medida.add("meio");
		medida.add("vidro");
		medida.add("vidros");
		medida.add("vidrinho");
		medida.add("litros");
		medida.add("litro");
		medida.add("litrao");
		medida.add("litroes");
		medida.add("caixa");
		medida.add("caixas");
		medida.add("caixinha");
		medida.add("caixinhas");
		medida.add("lata");
		medida.add("latas");
		medida.add("latinha");
		medida.add("latinhas");
		medida.add("pacote");
		medida.add("pacotes");
		medida.add("saco");
		medida.add("sacos");
		medida.add("saquinho");
		medida.add("saquinhos");
		medida.add("penca");

		final ArrayList<String> produto = new ArrayList<String>();
		produto.add("arroz");
		produto.add("feijao");
		produto.add("macarrao");
		produto.add("leite");
		produto.add("leites");
		produto.add("pao");
		produto.add("paes");
		produto.add("mateiga");
		produto.add("mateigas");
		produto.add("queijo");
		produto.add("queijos");
		produto.add("leitecondensado");
		produto.add("leitedecoco");
		produto.add("banana");
		produto.add("maça");
		produto.add("maca");
		produto.add("laranja");
		

		final ArrayList<String> tipo = new ArrayList<String>();
		tipo.add("agulhinha");
		tipo.add("chedar");
		tipo.add("chedar");
		tipo.add("comsal");
		tipo.add("curado");
		tipo.add("diet");
		tipo.add("desal");
		tipo.add("doce");
		tipo.add("integral");
		tipo.add("desnatado");
		tipo.add("light");
		tipo.add("ricota");
		tipo.add("parmesao");
		tipo.add("minas");
		tipo.add("minaspadrao");
		tipo.add("minasfrescal");
		tipo.add("padrao");
		tipo.add("frescal");
		tipo.add("mussarela");
		tipo.add("muçarela");
		tipo.add("mozzarela");
		tipo.add("gorgonzola");
		tipo.add("parmesao");
		tipo.add("gouda");
		tipo.add("meiacura");
		tipo.add("prato");
		tipo.add("semsal");
		tipo.add("parborizado");
		tipo.add("preto");
		tipo.add("branco");
		tipo.add("vermelho");
		tipo.add("roxo");
		tipo.add("caturra");
		tipo.add("prata");
		tipo.add("nanica");
		tipo.add("fugi");
		tipo.add("gala");
		tipo.add("serradagua");
		tipo.add("serrad'gua");
		tipo.add("serrada'gua");
		tipo.add("serradeagua");
		tipo.add("serradaagua");
		tipo.add("perario");
		tipo.add("bananamaça");
		tipo.add("bananamaca");
		tipo.add("argentina");
		

		final ArrayList<String> marca = new ArrayList<String>();

		marca.add("pratofino");
		marca.add("tiaju");
		marca.add("camil");
		marca.add("tiojoao");
		marca.add("oize");
		marca.add("vilma");
		marca.add("amalia");
		marca.add("itambe");
		marca.add("portoalegre");
		marca.add("cemil");
		marca.add("piracanjuva");
		marca.add("cotoches");
		marca.add("ducoco");

		//botao que envia a lista
		btnEnviar = new JButton("Enviar Lista");
		contentPane.add(btnEnviar, BorderLayout.SOUTH);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[][] listaCompras = new String[print1.length][5];
				
				//compara palavras digitadas pelo usuario com a base de dados do programa
				for (int x = 0; x < print1.length; x++) {
					String[] lista = print1[x].split(" ");
					for (int y = 0; y < lista.length; y++) {
						
						// compara uma única palavra
						if (lista[y].matches("[0-9]+")) {
							listaCompras[x][0] = lista[y];
							continue;
						}
						if (quantidade.contains(lista[y])) {
							listaCompras[x][0] = lista[y];
							continue;
						}
						if (medida.contains(lista[y])) {
							listaCompras[x][1] = lista[y];
							continue;
						}
						//compara a Junção de 3 palavras
						if ((y + 2) < lista.length) {
							if (lista[y + 2] != null) {
								aux = lista[y] + lista[y + 1] + lista[y + 2];
								if (produto.contains(aux)) {
									listaCompras[x][2] = lista[y] + " " + lista[y + 1] + " " + lista[y + 2];
									continue;
								}
								if (tipo.contains(aux)) {
									listaCompras[x][3] = lista[y] + " " + lista[y + 1] + " " + lista[y + 2];
									continue;
								}
								if (marca.contains(aux)) {
									listaCompras[x][4] = lista[y] + " " + lista[y + 1] + " " + lista[y + 2];
									continue;
								}
							}
						}

						// compara a junção de 2 palavras
						if ((y + 1) < lista.length) {
							if (lista[y + 1] != null) {
								aux = lista[y] + lista[y + 1];

								if (produto.contains(aux)) {
									listaCompras[x][2] = lista[y] + " " + lista[y + 1];
									continue;
								}
								if (tipo.contains(aux)) {
									listaCompras[x][3] = lista[y] + " " + lista[y + 1];
									continue;
								}
								if (marca.contains(aux)) {
									listaCompras[x][4] = lista[y] + " " + lista[y + 1];
									continue;
								}
							}
						}

						//compara unica palavra novamente
						if (produto.contains(lista[y])) {
							listaCompras[x][2] = lista[y];
							continue;
						}
						if (tipo.contains(lista[y])) {
							listaCompras[x][3] = lista[y];
							continue;
						}
						if (marca.contains(lista[y])) {
							listaCompras[x][4] = lista[y];
						}

					}
				}
				
				//campo que mostra o resultado
				txA_Resultado = new JTextArea();
				contentPane.add(txA_Resultado, BorderLayout.CENTER);

				
				txA_Resultado.append("Quantidade");
				txA_Resultado.append("\t\t");
				txA_Resultado.append("Medida");
				txA_Resultado.append("\t\t");
				txA_Resultado.append("Produto");
				txA_Resultado.append("\t\t");
				txA_Resultado.append("Tipo");
				txA_Resultado.append("\t\t");
				txA_Resultado.append("Marca");
				txA_Resultado.append("\n");
				for (int x = 0; x < listaCompras.length; x++) {
					for (int y = 0; y < listaCompras[x].length; y++) {
						
						txA_Resultado.append(listaCompras[x][y]);
						txA_Resultado.append("\t\t");
						
					}
					txA_Resultado.append("\n");
				}
			}
		});
	}
}