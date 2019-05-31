package br.barretuino.integrador;

import java.io.File;
import java.util.Collection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;


public class Main {

	public void relatorio() {

		// Lista com beans
		Collection dados = ProdutoFactory.geraDB();

		// O datasource
		JRBeanCollectionDataSource jrbcds = 
				new JRBeanCollectionDataSource(dados);

		String path = "src/br/barretuino/integrador/relatorio/RelatorioJavaObject.jasper";
		File file = new File(path);
		file = file.getAbsoluteFile( );

		String arquivo = file.getPath();

		try {
			JasperPrint jp = JasperFillManager.fillReport(arquivo, 
					null, jrbcds);	 
			//exibe o relatório com viewReport
			JasperViewer.viewReport(jp, false);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Main().relatorio();
	}
}
