import java.util.Scanner;
import java.util.ArrayList;
public class Cadastrar_Produto {
	// Listas
	public ArrayList<Integer> codigo_produto=new ArrayList<>();
	public ArrayList<String> lista_nomes= new ArrayList<>();
	public ArrayList<Integer> lista_quantidade=new ArrayList<>();
	public ArrayList<Double> lista_precos=new ArrayList<>();
	
	
public void Cadastrar_produtos() {
	// Scanners (Eu sempre crio 2 Scanners, 1 para letras e 1 para numeros.)
	Scanner inputl=new Scanner(System.in);
	Scanner inputn=new Scanner(System.in);
	while(true) {
	try { // "Try except" do "Python" é substituido pelo "Try catch" no "Java"
	System.out.print("Entre com o nome do produto: ");
	// NOME DO PRODUTO
	String nome_produto=inputl.nextLine().toUpperCase().strip();
	if (nome_produto.isEmpty()) {// O comando "isEmpty" é utilizado para que uma variavel do tipo "String" nao fique vazia.
		System.out.println("Produto inválido! Tente novamente.");
		continue;
	}
	if (!nome_produto.matches("^[A-ZÁ-ÚÂ-ÛÃ-ÕÇ ]+$")) { // "matches("^[A-ZÁ-Ú ]+$")" é exatamente como se fosse o "isalpha" do "Python". Nao permite que entre com uma informação diferente de letras
		System.out.println("Produto inválido! Tente novamente");
		continue;
	}
	System.out.println();
	System.out.println("Nome registrado com sucesso!");
	System.out.println();
	System.out.print("Entre com o valor do produto: ");
	// VALOR DO PRODUTO
	Double valor_produto=inputn.nextDouble();
	if (valor_produto>0) {
		System.out.println();
		System.out.println("Valor registrado com sucesso!");
	}else {
		System.out.println("Valor inválido! Tente novamente");
		continue;
	}
	System.out.println();
	System.out.print("Entre com a quantidade do produto: ");
	// QUANTIDADE DO PRODUTO
	int quantidade_produto=inputn.nextInt();
	if (quantidade_produto>0) {
		// CODIGO DO PRODUTO
		int novo_codigo=lista_nomes.size()+1; // Codigo é gerado automaticamente apos ser validado todas as informações do produto
		System.out.println();
		System.out.printf("[Código Produto: %02d], Produto registrado: %s, Valor Produto: %.2f, Quantidade: %d", novo_codigo, nome_produto, valor_produto, quantidade_produto); // Esse "%02d" é muito importante pois o "0" representa que as primeiras casas podem ser os primeiros algarismos e ai o java os recebe normalmente. Caso nao haja a presença daquele "0" o "Java" nao entende os algarismos "1-9" e da erro. E o numero "2" depois do zero diz ao "Java" que ele precisa ler pelo menos dois algarismos na tela, ou seja invez de ser o 1° numero vai ser o numero 01 ou 02 etc.
		//System.out.printf("Produto registrado: \nQuantidade: %d",nome_produto,quantidade_produto); // "%s" é utilizado para registrar uma variavel no modelo de "String/texto", e "%d" é utilizado para registrar uma variavel no modelo "int/numeros"
		System.out.println();
		System.out.println();
		// Comandos para atualizar as minhas listas
		codigo_produto.add(novo_codigo);
		lista_nomes.add(nome_produto);
		lista_precos.add(valor_produto);
		lista_quantidade.add(quantidade_produto);
		break;
	}else {
		System.out.println("Quantidade inválida! Tente novamente.");
		continue;
	}
	}
	catch (Exception e) { // Aqui eu denomino o erro como uma variavel chamada "e".
		System.out.println("Ocorreu um erro inesperado. Erro: "+e.getMessage()); // Codigo para mostrar o erro que aconteceu
		inputn.nextLine(); // Isso aqui serve para limpar o cache caso alguma informação inválida seja inserida na variavel
		continue;
	}
	}
}

}
