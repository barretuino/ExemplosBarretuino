package pjAula1;

public class Teste {
	public static void main(String[] args) {
		Produto novo = new Produto();
		
		novo.valor = 100;
		System.out.println("Valor é " + novo.valor);
		System.out.println(1 + 1);
		System.out.println(3 + (2 + "1"));
		
		//Como eu acesso o código do produto?
		novo.setCodigo(123);
		novo.setDescricao("Detergente");
		novo.setStatus(true);
		
		System.out.println("Código do Produto: " + novo.getCodigo());
		System.out.println("Descrição: " + novo.getDescricao());
		System.out.println("Status: " + 
						(novo.isStatus() ? "Ativo" : "Excluído"));

	}
}
