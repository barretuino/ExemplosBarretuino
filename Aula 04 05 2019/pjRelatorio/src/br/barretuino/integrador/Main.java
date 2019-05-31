package br.barretuino.integrador;
import java.io.File;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	    String path = "src/br/barretuino/integrador/relatorio/RelatorioCustomDataSource.jasper";
	    File file = new File(path);
	    file = file.getAbsoluteFile( );
		
	    String arquivo = file.getPath();
	    
		try {
			JasperPrint jp = JasperFillManager.fillReport(arquivo, 
					null, UsandoCustomJRDataSource.test());	 
			//exibe o relatório com viewReport
			JasperViewer.viewReport(jp, false);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
