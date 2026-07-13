import java.util.Scanner; // Importei o Scanner para poder utilizar o "Input"
public class Vender_produto {
public void Comprar_produto(Cadastrar_Produto estoque) { // Aqui "eu" criei uma variavel chamada estoque para poder representar as minhas listas que foram criadas na "funcao/metodo" de cadastrar produtos.
	// Criei 2 Scanners como sempre (1° Scanner é para "String/Letras" e o 2° Scanner é para "Int,Double/Números")
	Scanner inputl=new Scanner(System.in);
	Scanner inputn=new Scanner(System.in);
	while(true) { // Loop de escolha
		try { // "Try catch" para poder corrigir erros
			if(estoque.codigo_produto.isEmpty()) { // Aqui eu utilizo o "estoque" que "eu" criei anteriormente para poder associalo as minhas listas
				System.out.println("Nenhum produto foi cadastrado no sistema ainda! Tente novamente.");
				System.out.println();
				return; // Continue para poder a pessoa continuar interagindo mesmo apos acontecer algum erro.
			}
			System.out.println();
			System.out.print("Entre com o codigo do produto: ");
			int buscar_codigo=inputn.nextInt();
			// Aqui é iniciado a parte mais complexa do código, e particularmente eu não teria feito isso se não fosse a ajuda da IA.
			int indice_padrao=-1; // Aqui o indice é basicamente a lista e ele é criado como =-1 porque caso nao tenha produto na lista, no caso for "0" o java vai dar um erro e encerrar o sistema porque vai ser 0-1.
			for (int i=0; i< estoque.codigo_produto.size();i++) { // Isso aqui é um loop para percorrer a minha lista de codigo para poder saber quantos produtos resgitrados existem.
				if (estoque.codigo_produto.get(i)==buscar_codigo) { // Aqui eu chamo o "i" que foi criado na linha acima utilizando o ".get" e digo que o "i" é igual ao número que a pessoa digitar
					indice_padrao=i; //  E aqui eu substituo o "indice_padrao=-1" por "indice_padrao=i" pois agora nos sabemos qual é exatamente o produto da lista.
					break; // Aqui encerramos o loop "for" com o break.
				}
			}
			if (indice_padrao==-1) { // Aqui eu crio um "if" para poder pegar a situação que eu criei anteriormente com o "indice_padrao=-1"
				System.out.println("Código produto não encontrado! Tente novamente."); // Caso a lista nao possua produto "0-1 = nada" é printado essa informacao.
				System.out.println();
				continue; // Aqui tem um continue para deixar o codigo rolando.
			}
			// Aqui é a parte para poder sicronizar o meu numero de produto escolhina na lista de "codigo_produto" atraves do "buscar_codigo" com as outras listas. Ex: lista_nome,lista_preco,lista_quantidade.
			String nome=estoque.lista_nomes.get(indice_padrao); // Sicronizar com os nomes, tipo se a pessoa escolher o codigo "05" e o produto for "abacaxi", o nome que aparecera será "abacaxi"
			double preco=estoque.lista_precos.get(indice_padrao); // Sicronizar precos com o codigo
			int quantidade=estoque.lista_quantidade.get(indice_padrao); // Sicronizar quantidade com o codigo
			System.out.printf("Produto selecionado: %s, Valor do produto: %.2f, Quantidade do produto: %d\n",nome,preco,quantidade); // Aqui temos um print formatado para poder exibir todas as informaçoes do produto que a pessoa escolheu atraves do codigo de produto.
			// Acima eu fiz a substituicao de variavel de apenas estoque para representar todas as listas para "nome", "quantidade" e "demanda", cada um representa uma lista
			if (quantidade<=0) { // Se a quantidade do produto selecionado atraves do codigo escolhido for menor que ou igual a 0, o sistema imprime uma mensagem falando que o produto esta esgotado
				System.out.println("Produto esgotado! Retorne em outro momento.");
				continue;
			}
			System.out.print("Entre com a quantidade que você deseja comprar: ");
			int demanda=inputn.nextInt();
			if (demanda<=0) { // Se a quantidade do pedido for menor que ou igual a 0, o sistema imprime uma mensagem falando que o pedido esta inválido
				System.out.println("Quantidade inválida. Tente novamente");
				System.out.println();
				continue;
			}
			if (demanda>quantidade) { // Se a quantidade do pedido for maior que a quantidade do produto desejado, o sistema imprime uma mensagem falando que o produto nao tem estoque o suficiente
				System.out.println("Quantidade de produto insuficiente.");
				System.out.println();
				continue;
			}
			
			double valor_total=preco*demanda; // Aqui é feito o calculo a ser pago pela pessoa, de acordo com a quantidade do produto
			int nova_quantidade=quantidade-demanda; // Aqui eu crio uma variavel para substituir a quantidade antiga
			double valor_restante=valor_total; // Aqui eu deixo como "valor_restante = valor total" para poder relacionar eles na hora que for exibir o quanto que a pessoa deve pagar para poder quitar o valor
			double troco=0;
			boolean compra_cancelada=false; // Aqui eu criei um variavel como "boolean" para poder utilizar ela no caso que a pessoa nao pague as compras
			while(valor_restante>0) { // Aqui eu criei outro loop para poder ficar exibindo as opçoes a seguir ate que a pessoa quite o "valor restante"
				System.out.printf("Total a ser pago: R$%.2f | Restante a ser pago: R$%.2f\n",valor_total,valor_restante);
			System.out.println("Escolha uma das seguintes formas de pagamento:  1- Pix  2- Cartão de Crédito  3- Cartão de Débito  4- Dinheiro (Espécie)  5- Cancelar Compra"); // Aqui sao as formas de pagamento presentes no sistema.
			int forma_pagamento=inputn.nextInt();
			switch(forma_pagamento) { // comando "Switch" serve para direcionar o codigo direto para a variavel selecionada, que no caso é "forma_pagamento"
			case 1: // Primeira opcão de pagamento
				System.out.print("Digite a quantidade que você deseja adicionar: R$");
				double dinheiro_pix=inputn.nextDouble();
				if (dinheiro_pix<=0) { // Caso o dinheiro seja menor ou igual a 0 o sistema printa que o valor está inválido
					System.out.println("Quantidade inválida. Tente novamente.");
					continue;
				}else if (dinheiro_pix>valor_restante){ // Caso o valor digitado seja maior que o valor necessário o sistema calcula e fala o valor do troco
					System.out.println("O valor adicionado é maior que o valor necessário para cobrir o valor da compra, irei calcular o seu troco.");
					troco=dinheiro_pix-valor_restante; // Aqui tem o calculo para poder falar o valor do troco quando o dinheiro depositado for maior que o necessário
					System.out.println();
					System.out.printf("Seu troco é de: R$%.2f",troco); // Aqui temos um print formatado para poder exibir o troco
					valor_restante=0; // Aqui eu zero o valor restante para poder sair do "loop" do "while(valor_restante>0)"
				}else {
					valor_restante-=dinheiro_pix;
					System.out.printf("Pix de : R$%.2f recebido com sucesso!\n",dinheiro_pix);
				}
				break;
			case 2: // Segunda opcão de pagamento
				System.out.println("Você possui saldo no cartão de crédito?  1- Sim  2- Não");
				int opcao_saldoc=inputn.nextInt();
				if (opcao_saldoc==1) {
					System.out.println("Caso você possua saldo suficiente aproxime o seu cartão da maquininha.");
					System.out.println("Pagamento efetuado com sucesso! Muito obrigado pela sua presença.");
					valor_restante=0;
				}else if (opcao_saldoc==2) {
					System.out.println("Sem problemas, tente pagar com outra forma.");
				}else {
					System.out.println("Opção inválida! Tente novamente.");
					continue;
				}
				break;
			case 3: // Terceira opcão de pagamento
				System.out.println("Você possui saldo no cartão de débito?  1- Sim  2- Não");
				int opcao_saldod=inputn.nextInt();
				if (opcao_saldod==1) {
					System.out.println("Caso você possua saldo suficiente aproxime o seu cartão da maquininha.");
					System.out.println("Pagamento efetuado com sucesso! Muito obrigado pela sua presença.");
					valor_restante=0;
				}else if (opcao_saldod==2) {
					System.out.println("Sem problemas, tente pagar com outra forma.");
				}else {
					System.out.println("Opção inválida! Tente novamente.");
					continue;
				}
				break;
			case 4: // Quarta opcão de pagamento
				System.out.println("Digite a quantidade que você deseja adicionar: R$");
				double dinheiro_especie=inputn.nextDouble();
				if (dinheiro_especie<=0) { // Caso o dinheiro seja menor ou igual a 0 o sistema printa que o valor está inválido
					System.out.println("Valor inválido. Tente novamente.");
					continue;
				}else if(dinheiro_especie>=valor_restante) { // Caso o valor digitado seja maior que o valor necessário o sistema calcula e fala o valor do troco
					System.out.println("O valor adicionado é maior que o valor necessário para cobrir o valor da compra, irei calcular o seu troco.");		
					troco=dinheiro_especie-valor_restante;
					System.out.println();
					System.out.printf("Seu troco é de: R$%.2f",troco);
					valor_restante=0;
				}else {
					valor_restante-=dinheiro_especie;
					System.out.printf("Valor recebido com sucesso! Restante a ser pago é de: R$%.2f.\n",valor_restante);
					continue;
				}
				break;
			case 5: // Quinta opcão de pagamento
				System.out.println("Caloteiro(a)");
				compra_cancelada=true;
				valor_restante=0;
				break;
			default:
				System.out.println("Opção inválida! Selecione de 1 a 5.");
			}
			}
			if (compra_cancelada) {
				continue;
			}
			// Aqui começamos a parte final do codigo, que é basicamente a exibição do que foi feito pela pessoa, o produto comprado, o valor, quatidade etc.
			estoque.lista_quantidade.set(indice_padrao,nova_quantidade); // Aqui eu utilizo o comando "set" para poder "atualizar" a minha "lista_quantidade"
			// Daqui para baixo tem as exibições das informações de compra e produto
			System.out.println();
			System.out.println("=======  Venda Realizada com sucesso!  =======");
			System.out.printf("Produto: %s\n",nome);
			System.out.printf("Valor total: %.2f\n",valor_total);
			System.out.printf("Quantidade comprada: %d\n",demanda);
			if (troco>0) {
				System.out.printf("Troco devolvido: R$%.2f\n",troco);
			}
			System.out.printf("Estoque restante de %s: %d\n",nome,nova_quantidade);
			System.out.println();
			break;
		}catch(Exception e) {
			System.out.printf("Ocorreu um erro inesperado: "+e.getMessage());
			inputn.next();
		}
	}
}
}
