package pjAula2;

import java.util.Date;

/**
 * Classe de Modelagem Conceitual
 * @author Paulo Barreto
 * @data 10/11/2018
 */

public class Funcionario {
	//Atributos
	private int matricula;
	private String nome = "vazio";
	private Date dataAdmissao;
	private Date dataDemissao;
	private float salarioBase = -123;
	private boolean afastado;

	//Construtor (Método)
	public Funcionario(int matricula, String nome) {
		this.matricula = matricula;
		this.nome = nome;
		System.out.println("Construtor 1");
	}
	
	public Funcionario(String nome, int matricula) {
		this.matricula = matricula;
		this.nome = nome;
		System.out.println("Construtor 2");
	}
	
	public Funcionario(Date dataAdmissao, Date dataDemissao) {
		this.dataAdmissao = dataAdmissao;
		this.dataDemissao = dataDemissao;
	}
	
	public Funcionario(int matricula, String nome, 
			Date dataAdmissao, Date dataDemissao, boolean afastado) {
		this(matricula, nome);
		this.dataAdmissao = dataAdmissao;
		this.dataDemissao = dataDemissao;
		this.afastado = afastado;
	}
	
	//Métodos
	public float calculaSalario(float fator) {
		return (getSalarioBase() * fator);
	}
	
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public Date getDataDemissao() {
		return dataDemissao;
	}
	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}
	public float getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(float salarioBase) {
		this.salarioBase = salarioBase;
	}
	public boolean isAfastado() {
		return afastado;
	}
	public void setAfastado(boolean afastado) {
		this.afastado = afastado;
	}
}
