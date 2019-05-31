package br.barretuino.integrador;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


public class CustomDataSource implements JRDataSource
{

	private Object[][] data =
	{

			{new Integer(1),"Chopp e Pêssego DRAFT & FRUIT",
				new Integer(1),new Double(1.99)},
			{new Integer(2),"Chá com Pêssego",
				new Integer(1),new Double(1.700)},
			{new Integer(3),"Alho Especial Aperitivo",
				new Integer(2),new Double(14.590)},
			{new Integer(4),"Molho à Bolonhesa",
				new Integer(2),new Double(14.500)},
			{new Integer(5),"Aceto Italiano Bâlsâmico",
				new Integer(2),new Double(21.350)},
			{new Integer(6),"Condimento à Base de Óleo para Peixe",
				new Integer(2),new Double(16.200)},
			{new Integer(7),"Escova Dental COLGATE Micro Sonic",
				new Integer(7),new Double(19.190)},
			{new Integer(8),"Molho de Pimenta",
				new Integer(2),new Double(2.460)},
			{new Integer(9),"Baby Beef de Alcatra Alcatra Bovina",
				new Integer(6),new Double(18.650)},
			{new Integer(10),"Francês Baron Darignac",
				new Integer(8),new Double(31.000)},
			{new Integer(11),"Lombo Condimentado Fatiado",
				new Integer(4),new Double(12.000)},
			{new Integer(12),"Fondue de Chocolate Suiço",
				new Integer(4),new Double(36.990)},
			{new Integer(13),"Nacional Tinto Cabernet Sauvignon",
				new Integer(8),new Double(19.990)},
			{new Integer(14),"Esfoliante Pré-Shampoo",new Integer(7),
				new Double(23.250)},
			{new Integer(15),"Cebola Triturada",
				new Integer(2),new Double(4.550)},
			{new Integer(16),"Bolo Sabor Chocolate",
				new Integer(3),new Double(8.490)},
			{new Integer(17),"Coelho Congelado em Cortes",
				new Integer(6),new Double(18.470)},
			{new Integer(18),"Nacional Branco Chardonnay",
				new Integer(8),new Double(33.490)},
			{new Integer(19),"Brigadeiro HAMNES",
				new Integer(3),new Double(13.190)},
			{new Integer(20),"Croutons Sabor Alho",
				new Integer(3),new Double(4.050)}


	};

	private int index = -1;

	
	public CustomDataSource() {
	}

	public boolean next() throws JRException{
		index++;

		return (index < getData().length);
	}

	public Object getFieldValue(JRField field) throws JRException{
		Object value = null;

		String fieldName = field.getName();

		if ("id".equals(fieldName))
		{
			value = getData()[index][0];
		}
		else if ("nome".equals(fieldName))
		{
			value = getData()[index][1];
		}
		else if ("qtdEstoque".equals(fieldName))
		{
			value = getData()[index][2];
		}
		else if ("preco".equals(fieldName))
		{
			value = getData()[index][3];
		}

		return value;
	}

	public Object[][] getData() {
		return data;
	}

	public void setData(Object[][] data) {
		this.data = data;
	}
}