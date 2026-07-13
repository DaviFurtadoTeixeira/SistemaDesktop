import java.util.Scanner;
public class Sistema_Estacionamento {
	public static void main(String[] args) {
		// Este sistema está incompleto, possui apenas o basico da progamação e tem alguns erros que não foram solucionados.
		Scanner inputl=new Scanner(System.in);
		Scanner inputn=new Scanner(System.in);
		int vagas=20;
		int valor_hora=5;
		while(true) {
			System.out.println("============ Estacionamento Denis ============");
			System.out.println("Estacionamento limitados a veículos de 4 rodas! R$ 5/Hora");
			System.out.println();
			System.out.println();
			System.out.println("Escolha uma das opções a seguir:   1- Registrar veículo   2- Consultar Vagas   3- Solicitar saída   4- Sair");
			int escolher_opcao=inputn.nextInt();
			if (escolher_opcao==1) {
				if (vagas==0) {
					System.out.println("Vagas esgotadas");
					System.out.println();
				}else if(vagas>0) {
				System.out.println("Digite o modelo do veículo logo abaixo:   1- SUV   2- Sedan   3- Hatche   4- Picape   5- Outro");
				int modelo_veiculo=inputl.nextInt();
				if (modelo_veiculo==1) {
					System.out.println("Veiculo registrado com sucesso!");
					System.out.println();
					vagas-=1;
				}else if(modelo_veiculo==2) {
					System.out.println("Veiculo registrado com sucesso!");
					System.out.println();
					vagas-=1;
				}else if(modelo_veiculo==3) {
					System.out.println("Veiculo registrado com sucesso!");
					System.out.println();
					vagas-=1;
				}else if(modelo_veiculo==4) {
					System.out.println("Veiculo registrado com sucesso!");
					System.out.println();
					vagas-=1;
				}else if(modelo_veiculo==5) {
					System.out.print("Descreva o seu veículo e diga o modelo dele: ");
					String descrever_veiculo=inputl.nextLine();
					System.out.println("Veiculo registrado com sucesso!");
					System.out.println();
					vagas-=1;
				}else {
					System.out.println("Opção de modelo inválido");
				}
			}else {
				System.out.println("Ocorreu um erro! Tente novamente em outro momento");
				continue;
			}

			}else if(escolher_opcao==2) {
				System.out.print("Esta é a quantidade de vagas disponível: ");
				System.out.println(vagas);
				System.out.println();
				continue;
			}else if(escolher_opcao==3) {
				if (vagas==20) {
					System.out.println("Não possuimos nenhum carro estacionado neste momento, tente novamente mais tarde.");
					System.out.println();
					continue;
				}else if(vagas<20) {
				System.out.print("Digite o horário de chegada: ");
				int horario_chegada=inputn.nextInt();
				if (horario_chegada<=24 && horario_chegada>=0) {
					System.out.println("Horário de chegada registrado com sucesso!");
				}else {
					System.out.println("Horário de chegada inválido! Tente novamente");
					continue;
				}
				System.out.print("Digite o horário de saída: ");
				int horario_saida=inputn.nextInt();
				if (horario_saida<=horario_chegada) {
					System.out.println("Horário de saída não pode ser menor ou igual ao horário de chegada! Tente novamente");
					continue;
				}else {
					System.out.println("Horário de saída registrada com sucesso");
				}
				int quantidade_horas=horario_saida-horario_chegada;
				System.out.println();
				System.out.print("Essa é a quantidade de horas que você passou no estacionamento: ");
				System.out.println(quantidade_horas);
				System.out.print("O valor total a ser pago é de R$");
				System.out.println(quantidade_horas*valor_hora);
				System.out.println();
				vagas+=1;
				}
			}else if (escolher_opcao==4) {
				System.out.println("Espero que tenhamos ajudado, deixando o progama...");
				break;
			}
		}
	}

}
