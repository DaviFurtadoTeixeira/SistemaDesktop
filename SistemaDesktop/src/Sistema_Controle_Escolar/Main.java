package Sistema_Controle_Escolar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner inputl=new Scanner(System.in);
		Scanner inputn=new Scanner(System.in);
		while(true){
		System.out.println("Escolha uma das opções a seguir: 1- Cadastrar aluno   2- Cadastrar notas   3- Pesquisar aluno   4- Sair");
		int opcao_escolha=inputn.nextInt();
		if (opcao_escolha==1) {
			System.out.println("Digite o nome do aluno a seguir:");
			String nome_aluno=inputl.nextLine();
			System.out.println("Nome validado com sucesso!");
			System.out.println("Digite a idade do aluno a seguir:");
			int idade_aluno=inputn.nextInt();
			System.out.println("Idade validada com sucesso!");
			System.out.println("Em qual tempo escolar ele(a) está? 1-Infantil   2- Fundamental   3- Ensino Médio   4- Sair");
			int tempo_escolar=inputn.nextInt();
			if (tempo_escolar==1) {
				
			}
			System.out.println("Digite a série que você deseja matrículalo(a):");
			int serie_aluno=inputn.nextInt();
			System.out.println("Série registrada com sucesso!");
			System.out.print("Nome registrado=");
			System.out.println(nome_aluno);
			System.out.print("Idade registrada=");
			System.out.println(idade_aluno);
			System.out.print("Série registrada=");
			System.out.println(serie_aluno);
		}else if(opcao_escolha==2) {
			System.out.println("Digite o nome completo do aluno:");
			String digitar_aluno=inputl.nextLine();
			System.out.println("Nome verificado com sucesso!");
			System.out.println("Confirme o nome do aluno porfavor:");
			String confirmar_aluno=inputl.nextLine();
			if (confirmar_aluno==digitar_aluno) {
				System.out.println("Nome confirmado com sucesso!");
			}else {
				System.out.println("Nome não corresponde, tente novamente.");
			}
			System.out.println("Digite a pontuação do aluno");
			float nota_aluno=inputn.nextFloat();
			System.out.println("Nota registrada com sucesso!");
			System.out.print("A nota foi registrada para o aluno: ");
			System.out.println(digitar_aluno);
			System.out.print("Nota registrada de: ");
			System.out.println(nota_aluno);
		}
		}



	}
	
}
