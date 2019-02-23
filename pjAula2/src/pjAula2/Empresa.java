package pjAula2;

import java.util.Calendar;
import java.util.Date;

public class Empresa {

	public static void main(String[] args) {
		//Chamada ao construtor da classe
		Date dataAdmissao = new Date();
		dataAdmissao.setDate(1);
		dataAdmissao.setHours(0);
		dataAdmissao.setMinutes(0);
		dataAdmissao.setSeconds(0);
		
		Date dataDemissao = new Date();
		
		Funcionario voce = 
					new Funcionario(dataAdmissao, dataDemissao);
		Funcionario ele = new Funcionario
				(123, "Ele", new Date(), new Date(), false); 
					
		
		System.out.println(voce.getMatricula());
		System.out.println(voce.getNome());
		System.out.println(voce.getSalarioBase());	
		System.out.println(voce.getDataAdmissao());
	}

}
