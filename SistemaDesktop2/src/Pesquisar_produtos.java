import java.util.Scanner;
public class Pesquisar_produtos {
	public void pesquisar_produto(Cadastrar_Produto estoque) {
		Scanner inputl=new Scanner(System.in);
		Scanner inputn= new Scanner(System.in);
		while(true) { 
		try {
			 if(estoque.codigo_produto.isEmpty()) { // Aqui eu utilizo o comando "isEmpty" para poder verificar se a lista de codigos dos produtos está vazia
				 System.out.println("Ainda não possuimos nenhum produto registrado no sistema para pesquisar. Tente novamente mais tarde"); // Print para falar que a lista esta vazia caso se enquandre no comando .isEmpty
				 System.out.println();
				 return;
			 }
			 System.out.println("Escolha uma das opções a seguir:  1- Pesquisar produto através do codigo  2- Pesquisar produto através do nome  3- Voltar ao menu principal"); // Menu de opçoes
			 int opcao_escolha=inputn.nextInt();
			 if (opcao_escolha==1) { // Opcao de pesquisar com o codigo
				 System.out.println("Digite o código do produto: "); 
				 int codigop=inputn.nextInt();
				 int indice=-1;
				 for (int i=0; i<estoque.codigo_produto.size();i++) { // Aqui eu tenho um "loop" para percorrer a lista de codigo de 1 por 1, ate chegar no ultimo codigo
					 if (estoque.codigo_produto.get(i)==codigop) { // Aqui tem um codigo para poder verificar o codigo que a pessoa digitou e sicroniza com algum codigo equivalente na lista de codigo
						 indice=i; // Aqui eu atualizo o "indice" para ser igual a "i"
						 break; // Encerro o loop for
					 }
				 }
				 if (indice !=-1) { // Se indice for diference de -1 o sistema exibe o produto que corresponder com o codigo digitado
					 System.out.println("======  Produto encontrado com sucesso!  ======");
					 System.out.printf("Código: %02d, Nome: %s, Preço: %.2f, Estoque: %d\n",
							 estoque.codigo_produto.get(indice), // Variavel utilizada para poder mostar no print formatado
							 estoque.lista_nomes.get(indice), // Variavel utilizada para poder mostar no print formatado
							 estoque.lista_precos.get(indice), // Variavel utilizada para poder mostar no print formatado
							 estoque.lista_quantidade.get(indice)); // Variavel utilizada para poder mostar no print formatado
					 
				 }else {
					 System.out.println("Produto não encontrado! Tente um codigo diferente do que você acabou de digitar");
					 continue; // Continue para poder nao encerrar o sistema
				 }
			 }else if (opcao_escolha==2) { // Opcao de pesquisar com o nome
				 System.out.print("Digite o nome do produto: ");
				 String nomep=inputl.nextLine().toUpperCase().strip();
				 boolean encontrou_texto=false;
				 System.err.println("=====  Resultado da pesquisa  =====");
				 for (int i=0;i<estoque.lista_nomes.size();i++) {
					 if (estoque.lista_nomes.get(i).contains(nomep)) {
						 System.out.printf("Código: %d, Nome: %s, Preço: %.2f, Quantidade: %d\n",
								 estoque.codigo_produto.get(i),
								 estoque.lista_nomes.get(i),
								 estoque.lista_precos.get(i),
								 estoque.lista_quantidade.get(i));
						 
						 encontrou_texto=true;
					 }
				 }
				 if (!encontrou_texto) {
					 System.out.println("Produto não encontrado! Tente um nome diferente do que você acabou de digitar");
					 continue;
				 }
			 }else if(opcao_escolha==3) { // Opcao de sair
				 System.out.println("Voltando ao menu principal...");
				 break;
			 }else {
				 System.out.println("Opção inválida! Tente novamente.");
				 continue;
			 }
			 
			 
		}catch (Exception e) {
				 System.out.printf("Ocorreu um erro inesperado: "+e.getMessage());
				 inputn.nextLine();
			 }
		
		}
	}
}
