package pjAula1;

public class Teste {
	public static void main(String[] args) {
		Produto novo = new Produto();
		
		novo.valor = 100;
		System.out.println("Valor � " + novo.valor);
		System.out.println(1 + 1);
		System.out.println(3 + (2 + "1"));
		
		//Como eu acesso o c�digo do produto?
		novo.setCodigo(123);
		novo.setDescricao("Detergente");
		novo.setStatus(true);
		
		System.out.println("C�digo do Produto: " + novo.getCodigo());
		System.out.println("Descri��o: " + novo.getDescricao());
		System.out.println("Status: " + 
						(novo.isStatus() ? "Ativo" : "Exclu�do"));

	}
}
