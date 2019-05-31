package br.curso.modelagem;

public enum SituacaoCadastral {
	ATIVO("Ativo"),
	ENCERRADO("Encerrado"),
	EXCLUIDO("Excluído"),
	FALECIDO("Falecido"),
	SUSPENDO("Suspenso");
	
	private String descricao;
	
	SituacaoCadastral(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}
	
	@Override
	public String toString(){
		return getDescricao();
	}
}
