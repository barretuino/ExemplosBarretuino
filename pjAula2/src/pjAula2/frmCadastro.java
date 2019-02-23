package pjAula2;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class frmCadastro extends JFrame{
	public frmCadastro() {
		super("Nosso Primeiro Frame");
		setSize(400, 400);
		setLayout(new FlowLayout());
		
		//Declarar o objetos
		JTextField txtNome;
		
		//Construção 
		txtNome = new JTextField(20);
		
		//Adicionar visualmente o elemento ao Frame
		add(txtNome);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		frmCadastro frame = new frmCadastro();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}