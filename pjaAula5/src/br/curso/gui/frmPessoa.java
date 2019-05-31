package br.curso.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.curso.modelagem.Pessoa;
import br.curso.modelagem.SituacaoCadastral;
import br.curso.persistencia.Repositorio;

public class frmPessoa extends JFrame implements ActionListener {

	//Atributos
	//1º Passo Declaração dos Objetos
	JLabel lbCodigo, lbNome, lbEndereco, lbSituacao, lbPeso;
	JTextField txtCodigo, txtNome, txtEndereco, txtPeso;
	JComboBox<SituacaoCadastral> cbxSituacao;
	JButton btCadastrar, btPesquisar, btExcluir, btSair;
	JPanel pnCampos, pnBotoes;
	GridLayout gridCampos, gridBotoes;
	Pessoa pessoa;
	List<Pessoa> listPessoa = new ArrayList<Pessoa>();
	
	public frmPessoa() throws HeadlessException {
		//2º Passo Instanciar os objetos visuais
		super("Cadastro de Pessoa");
		setSize(400,200);
		setLayout(new BorderLayout());
		
		lbCodigo = new JLabel("Código");
		lbNome = new JLabel("Nome");
		lbEndereco = new JLabel("Endereço");
		lbSituacao = new JLabel("Situação Cadastral");
		lbPeso = new JLabel("Peso");
		txtCodigo = new JTextField(20);
		txtNome = new JTextField(20);
		txtEndereco = new JTextField(20);
		txtPeso = new JTextField(4);
		//Objeto de Combo
		cbxSituacao = new JComboBox<SituacaoCadastral>
							(SituacaoCadastral.values());
		
		gridCampos = new GridLayout(5,2,4,4);
		gridBotoes = new GridLayout(1,4,4,4);
		
		btCadastrar = new JButton("Cadastrar");
		btPesquisar = new JButton("Pesquisar");
		btExcluir = new JButton("Excluir");
		btSair = new JButton("Sair");
		
		pnCampos = new JPanel(gridCampos);
		pnBotoes = new JPanel(gridBotoes);
		
		//3º Passo adicionando Visualmente os componentes
		pnCampos.add(lbCodigo);
		pnCampos.add(txtCodigo);
		pnCampos.add(lbNome);
		pnCampos.add(txtNome);
		pnCampos.add(lbEndereco);
		pnCampos.add(txtEndereco);
		pnCampos.add(lbSituacao);
		pnCampos.add(cbxSituacao);
		pnCampos.add(lbPeso);
		pnCampos.add(txtPeso);
		
		pnBotoes.add(btCadastrar);
		pnBotoes.add(btExcluir);
		pnBotoes.add(btPesquisar);
		pnBotoes.add(btSair);
		
		add(pnCampos, BorderLayout.CENTER);
		add(pnBotoes, BorderLayout.SOUTH);
		
		/*
		 * Mudando a localização
		 * pnBotoes.setLayout(BorderLayout.NORTH);
		 */
		
		//4º Passo - Adicionando ações (action)
		btCadastrar.addActionListener(this);
		btExcluir.addActionListener(this);
		btPesquisar.addActionListener(this);
		btSair.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btCadastrar){
			adicionar();
		}
		if(e.getSource() == btExcluir){
			excluir();
		}
		if(e.getSource() == btPesquisar){
			pesquisar();
		}
		if(e.getSource() == btSair){
			System.exit(0);
		}
	}

	private void excluir() {
		pesquisar();
		if(pessoa != null){
			int opcao = JOptionPane.showConfirmDialog(null, 
					"Deseja excluir a Pessoa Selecionad?");
			switch(opcao){
			case 0:
				listPessoa.remove(pessoa);
				limparDados();
				JOptionPane.showMessageDialog(null, "Excluído com sucesso");
				break;
			}
		}
	}

	private void pesquisar() {
		int codigo = Integer.parseInt(txtCodigo.getText());
		pessoa = null;
		for(Pessoa p : listPessoa){
			if(p.getCodigo() == codigo){
				pessoa = p;
				txtNome.setText(p.getNome());
				//txtEndereco.setText(p.getEndereco());
				txtPeso.setText(p.getPeso().toString());
				cbxSituacao.setSelectedItem(p.getSituacaoCadastral());
			}
		}		
		if(pessoa == null){
			JOptionPane.showMessageDialog(null, "Pessoa não encontrada");
		}
	}

	private void adicionar() {
		//Receber campos visuais e transformar em Objeto
		pessoa = new Pessoa();
		try{			
			pessoa.setCodigo(Integer.parseInt(txtCodigo.getText()));
			pessoa.setNome(txtNome.getText());
			
			/*Endereco endereco = new Endereco();
			endereco.setLogradouro(txtLogradouro.getText());			
			pessoa.setEndereco(endereco);*/			
			pessoa.setSituacaoCadastral(
					(SituacaoCadastral)cbxSituacao.getSelectedItem());
			pessoa.setPeso(Float.parseFloat(txtPeso.getText()));
			
			listPessoa.add(pessoa);
			
			//Adicionando ao arquivo texto
			Repositorio repositorio =
					new Repositorio("./arquivos/saida.txt");
			try {
				repositorio.escrever("./arquivos/saida.txt", 
														listPessoa);
			} catch (IOException e) {
				e.printStackTrace();
			}	
			
			JOptionPane.showConfirmDialog(null, "Inserido com sucesso");
			limparDados();
			System.out.println(listPessoa);
		}catch(NumberFormatException erro){
			JOptionPane.showMessageDialog(null, "Código Inválido!",
					"Tipo de Dado Incorreto", 
					JOptionPane.ERROR_MESSAGE);
		}		
	}

	private void limparDados() {
		txtCodigo.setText("");
		txtNome.setText("");
		txtEndereco.setText("");
		cbxSituacao.setSelectedIndex(0);
		txtPeso.setText("");
		txtCodigo.requestFocus();		
	}

	public static void main(String[] args) {
		frmPessoa form = new frmPessoa();
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}