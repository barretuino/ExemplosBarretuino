package pjAula2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Gerente extends Funcionario {

	private boolean afastado = true;
	
	public Gerente() {
		super(0, null);
	}
	
	public Gerente(int matricula, String nome, Date dataAdmissao, Date dataDemissao, boolean afastado) {
		super(matricula, nome, dataAdmissao, dataDemissao, afastado);
		// TODO Auto-generated constructor stub
	}

	public float calculaSalario(float fator, float comissao) {
		return (super.calculaSalario(fator)) * comissao;
	}
	
	public static void main(String[] args) {
		Gerente sergio = new Gerente();
		float retorno = sergio.calculaSalario(1, (float) 1.60);
		System.out.println(retorno);
		
	}
	
	public boolean isAfastado() {
		return afastado;
	}

	public void setAfastado(boolean afastado) {
		this.afastado = afastado;
	}

	
}
