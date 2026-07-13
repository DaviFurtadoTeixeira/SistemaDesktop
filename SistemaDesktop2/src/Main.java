import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Cadastrar_Produto cadastrarp= new Cadastrar_Produto();
		Vender_produto comprarp=new Vender_produto();
		Pesquisar_produtos pesquisarp=new Pesquisar_produtos();
		
		//cadastrarp.Cadastrar_produtos();
		//comprarp.Comprar_produto(cadastrarp);
		//pesquisarp.pesquisar_produto();
		Scanner inputl=new Scanner(System.in);
		Scanner inputn=new Scanner(System.in);
		while(true) {
			System.out.println("=========  Seja muito bem vindo ao SuperMarket!  =========");
			System.out.println("Escolha uma das opções a seguir:  1- Cadastrar Produtos  2- Vender Produtos  3- Pesquisar Produtos  4- Sair");
			int opcao_menu=inputn.nextInt();
			if (opcao_menu==1) {
				cadastrarp.Cadastrar_produtos();
			}else if(opcao_menu==2) {
				comprarp.Comprar_produto(cadastrarp);
			}else if(opcao_menu==3) {
				pesquisarp.pesquisar_produto(cadastrarp);
			}else if(opcao_menu==4) {
				System.out.println("Deixando o progama...");
			break;
			}
		}
	}

}
