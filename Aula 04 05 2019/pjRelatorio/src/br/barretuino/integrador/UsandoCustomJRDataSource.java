package br.barretuino.integrador;
import net.sf.jasperreports.engine.JRDataSource;

public class UsandoCustomJRDataSource {
	public static JRDataSource test()
	{
		return new CustomDataSource();
	}
}
