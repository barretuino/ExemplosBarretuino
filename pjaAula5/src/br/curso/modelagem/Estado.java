package br.curso.modelagem;

public enum Estado {
	AC("Acre", 11),
	AL("Alagoas", 12),
	SP("São Paulo", 35);
	
	private String estado;
	private Integer codIBGE;
	
	Estado(String estado, Integer codIBGE){
		this.estado = estado;
		this.codIBGE = codIBGE;
	}
	
	public String getEstado(){
		return estado;
	}
	
	public Integer getCodIBGE(){
		return codIBGE;
	}
	
	@Override
	public String toString() {		
		return getEstado();
	}
}
