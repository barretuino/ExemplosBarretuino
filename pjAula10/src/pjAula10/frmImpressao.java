package pjAula10;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Exemplo de Chamada para Relat�rio
 * @author Paulo Barreto
 * @date 27/04/2019
 */
public class frmImpressao extends JFrame 
			implements ActionListener{
	private JButton btGerar = new JButton("Gerar Relat�rio");
	
	//M�todo Construtor
	public frmImpressao() {
		super("Exemplo de Impress�o com iReport");
		setSize(300, 200);
		setLayout(new FlowLayout());
		
		btGerar.addActionListener(this);
		btGerar.setMnemonic('P');
		add(btGerar);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == btGerar) {
			//Impress�o do Relat�rio
			//1� Passo - Definir o objeto relat�rio
			JasperPrint rel = null;
			try {
				//2� Passo - Conex�o com o Banco
				Connection con = ConnectionFactory.getConnection();
				
				//3� Passo - Instanciar o relat�rio
				String nomeRelatorio = "relFabricante.jasper";
					
			    HashMap parametros = new HashMap();
				parametros.put("p_Titulo", "Paulo Barreto");
				parametros.put("p_Data", new Date());
				
				try {
					//Relatorio, MapParametros, Conex�o
					rel = JasperFillManager.
							fillReport(nomeRelatorio, parametros, con);
				} catch (JRException e) {
					e.printStackTrace();
				}
				
				//4� Passo - Visualiza��o do Relat�rio
				JasperViewer.viewReport(rel);
			}catch(SQLException erro) {
				System.out.println("Erro de SQL " + erro);
			}
		}		
	}
	public static void main(String[] args) {
		frmImpressao form = new frmImpressao();
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
