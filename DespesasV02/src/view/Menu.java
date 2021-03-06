package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.HashMap;

import javax.swing.border.Border;

import controle.SaldoDiarioControle;
import modelo.ArmazenaArquivoModelo;
import modelo.DespesaModelo;
import modelo.ReceitaModelo;
import modelo.SaldoModelo;

/**
 * Classe responsavel por imprimir na tela a interface grafica do Menu para o usuario
 * @author danielalves
 * @version 2.0
 */
public class Menu extends JFrame{
	private Container container;
	private GridLayout grid;
	private JButton buttonDespesa;
	private JButton buttonReceita;
	private JButton buttonHistorico;
	private JLabel labelTitle;
	private JLabel labelDespesa;
	private JLabel labelReceita;
	private JLabel labelSaldo;
	private JLabel labelValor;
	private JLabel labelHistorico;
	private JPanel panel1;
	private JPanel panel2;
//	private JPanel panel3;
	private JPanel panel4;
	private DespesaModelo despesaControle;
	private ReceitaModelo receitaControle;
	private SaldoModelo saldo;
	private HashMap<LocalDate, SaldoDiarioControle> mapa;
	private String filePathMapa;
	private String filePathSaldo;
	
	/**
	 * Construtor de Menu, que recebe os parametros e produz uma interface para selecionar uma opcao com saldo no final da janela.
	 * Com a opcao de adicionar saldo, receita e vizualizar ou remover historico de operacoes
	 * @param mapa HashMap com LocalDate, SaldoDiarioControle como key e value
	 * @param filePathMapa endereco de arquivo com mapa
	 * @param filePathSaldo endereco de arquivo com Saldo
	 * @param despesaControle classe DespesaControle
	 * @param receitaControle classe ReceitaControle
	 * @param saldo classe SaldoModelo
	 */
	public Menu(HashMap<LocalDate, SaldoDiarioControle> mapa, String filePathMapa, String filePathSaldo, DespesaModelo despesaControle, ReceitaModelo receitaControle, SaldoModelo saldo){
		this.mapa = mapa;
		this.filePathMapa = filePathMapa;
		this.filePathSaldo= filePathSaldo;
		this.saldo = saldo; 
		this.despesaControle = despesaControle;
		this.receitaControle = receitaControle;
		//Inicia layout padrao Grid e inicia Label
		grid = new GridLayout(3,2); // 4 linhas e 2 colunas 
		labelTitle = new JLabel();  
		labelDespesa = new JLabel();
		labelReceita = new JLabel();
		labelSaldo = new JLabel();
		labelValor = new JLabel();
		labelHistorico = new JLabel();
		
		// Cria container grid
		container = getContentPane();
		container.setLayout(grid);
		 
		// Cria painel
		panel1 = new JPanel(); 
		panel2 = new JPanel();
//		panel3 = new JPanel();
		panel4 = new JPanel();
		 
		// Arruma paineis 2 e 4
		panel1.setLayout(new GridLayout(1, 1));
		panel2.setLayout(new GridLayout(3, 3));
//		panel3.setLayout(new GridLayout(1, 1));
		panel4.setLayout(new GridLayout(1, 2));
		 
		// Defina a cor da borda do Grid 
		Border border = BorderFactory.createLineBorder(new Color(240, 240, 240) , 3);
		Border border_2 = BorderFactory.createLineBorder(new Color(240, 240, 240), 4);
		 
		// Cria label CONTROLE FINANCEIRO  para painel 1
		labelTitle.setText("<html><u>CONTROLE FINANCEIRO</u>");  //Set text of label
		labelTitle.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 24));
		labelTitle.setBackground(new Color(240, 240, 240));
		labelTitle.setOpaque(true); 
		labelTitle.setVerticalAlignment(JLabel.CENTER); 
		labelTitle.setHorizontalAlignment(JLabel.CENTER);
		labelTitle.setOpaque(true); 
		
		// Cria label para o painel 2 para despesa, receita e historico
		labelDespesa.setText("Nova Despesa");   
		labelDespesa.setFont(new Font("Serif", Font.PLAIN, 20));
		labelDespesa.setBackground(Color.white);
		labelDespesa.setOpaque(true);
		labelDespesa.setVerticalAlignment(JLabel.CENTER); 
		labelDespesa.setHorizontalAlignment(JLabel.CENTER);
		labelDespesa.setOpaque(true); 
		labelDespesa.setBorder(border);
		labelDespesa.setForeground(Color.black);
		 
		labelReceita.setText("Nova Receita");  
		labelReceita.setFont(new Font("Serif", Font.PLAIN, 20));
		labelReceita.setBackground(Color.white);
		labelReceita.setOpaque(true);
		labelReceita.setVerticalAlignment(JLabel.CENTER); 
		labelReceita.setHorizontalAlignment(JLabel.CENTER);
		labelReceita.setOpaque(true);
		labelReceita.setBorder(border);
		labelReceita.setForeground(Color.black);
		
		labelHistorico.setText("Historico");  
		labelHistorico.setFont(new Font("Serif", Font.PLAIN, 20));
		labelHistorico.setBackground(Color.white);
		labelHistorico.setOpaque(true);
		labelHistorico.setVerticalAlignment(JLabel.CENTER); 
		labelHistorico.setHorizontalAlignment(JLabel.CENTER);
		labelHistorico.setOpaque(true);
		labelHistorico.setBorder(border);
		labelHistorico.setForeground(Color.black);
		
		// Cria label para painel 3
		
		    // Futuro Calend??rio
		
		//Cria label para painel 4
		labelSaldo.setText("Saldo:"); 
		labelSaldo.setFont(new Font("Serif", Font.PLAIN, 22));
		labelSaldo.setBackground(Color.white);
		labelSaldo.setOpaque(true);
		labelSaldo.setVerticalAlignment(JLabel.CENTER); 
		labelSaldo.setHorizontalAlignment(JLabel.CENTER);
		labelSaldo.setOpaque(true);
		labelSaldo.setBorder(border);
		labelSaldo.setForeground(Color.black);
		labelSaldo.setBorder(border_2); 
		
		labelValor.setText("R$ " + saldo.getSaldoControle().getTotal().toString()); 
		labelValor.setFont(new Font("Serif", Font.PLAIN, 22));
		labelValor.setBackground(new Color(240, 240, 240));
		labelValor.setOpaque(true);
		labelValor.setVerticalAlignment(JLabel.CENTER); 
		labelValor.setHorizontalAlignment(JLabel.CENTER);
		labelValor.setOpaque(true); 
		labelValor.setBorder(border); 
		labelValor.setForeground(Color.black);
		
		// Cria bot??o 1 e 2 para painel 2
		buttonDespesa = new JButton("Adicionar"); 
		buttonReceita = new JButton("Adicionar");
		buttonHistorico = new JButton("Visualizar");
		buttonDespesa.setBackground(new Color(215, 215, 215));
		buttonReceita.setBackground(new Color(215, 215, 215));
		buttonHistorico.setBackground(new Color(215, 215, 215));
		buttonDespesa.setBorder(border);
		buttonReceita.setBorder(border);
		buttonHistorico.setBorder(border);
		
		// Action nos botoes
		buttonDespesa.addActionListener(new ButtonDespesa());
		buttonReceita.addActionListener(new ButtonReceita());
		buttonHistorico.addActionListener(new ButtonHistorico());
		
		
		// Adiciona cada objeto nos paineis
		panel1.add(labelTitle);
		panel2.add(labelDespesa);
		panel2.add(buttonDespesa);
		panel2.add(labelReceita);
		panel2.add(buttonReceita);
		panel2.add(labelHistorico);
		panel2.add(buttonHistorico);
		panel4.add(labelSaldo);
		panel4.add(labelValor);
	
		// Coloca paineis no container
		container.add(panel1, BorderLayout.NORTH);
		container.add(panel2, BorderLayout.NORTH);
//		container.add(panel3, BorderLayout.SOUTH); 
		container.add(panel4, BorderLayout.SOUTH);
		
		   
		// Set layout  
		this.setResizable(false); 
		this.setSize(400,400);
		this.setTitle("Controle Financeiro");
		this.setVisible(true); 
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	ArmazenaArquivoModelo armazena = new ArmazenaArquivoModelo(mapa, filePathMapa, filePathSaldo, saldo);
				//Armazena dados do Mapa
				armazena.ImprimeMapa();
				armazena.ImprimeSaldo();
				System.out.println("saindo");
				//System.exit(0);
		    }
		});
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Exit the app
		
		ImageIcon pig = new ImageIcon("dollar-icon4.jpg"); //Get the picture from downloaded
		this.setIconImage(pig.getImage()); //Change icon of this
		this.getContentPane().setBackground(new Color(234, 233, 233)); //BackGround color
		
	}
	
	/**
	 * Classe privada ButtonDespesa, eh chamada quando o botao de Despesa eh clicado.
	 * Uma vez realizada essa acao, sera redirecionado para a interface Despesa
	 * @author danielalves
	 * @version 2.0
	 */
	private class ButtonDespesa implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Despesa aciona_despesa = new Despesa(mapa, filePathMapa, filePathSaldo, despesaControle, receitaControle, saldo);
			aciona_despesa.setVisible(true);
			setVisible(false);
		}
	} 
	
	/**
	 * Classe privada ButtonReceita, eh chamada quando o botao de Receita eh clicado.
	 * Uma vez realizada essa acao, sera redirecionado para a interface Receita
	 * @author danielalves
	 * @version 2.0
	 */
	private class ButtonReceita implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Receita aciona_receita = new Receita(mapa, filePathMapa, filePathSaldo, despesaControle, receitaControle, saldo);
			aciona_receita.setVisible(true);
			setVisible(false);
		}
	}
	
	/**
	 * Classe privada ButtonHistorico, eh chamada quando o botao de Historico eh clicado.
	 * Uma vez realizada essa acao, sera redirecionado para a interface Historico
	 * @author danielalves
	 * @version 2.0
	 */
	private class ButtonHistorico implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Historico aciona_historico = new Historico(mapa, filePathMapa, filePathSaldo, despesaControle, receitaControle, saldo);
			aciona_historico.setVisible(true);
			setVisible(false);
		}
	}
	
	
}
