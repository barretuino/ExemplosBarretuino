package pjAula1;

/**
 * Modelagem Conceitual de Produto
 * @author Paulo Barreto
 * @data 27/10/2018
 */

public class Produto {
	//Atributos
	private int codigo;
	private String descricao;
	private boolean status;
	public float valor;
	
	public void setCodigo(int codigo) {
		if(codigo > 0) {
			this.codigo = codigo;
		}else {
			System.out.println("Valor inválido");
		}
	}
	public int getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		String retorno = "Código: " + getCodigo()
						 + " Descrição: " + getDescricao()
						 + " Valor: R$ " + getValor()
						 + " Status " + 
						    (isStatus() ? "Ativo" : "Excluído");
		
		return retorno;
	}
}
