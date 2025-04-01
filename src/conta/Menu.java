package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {
	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner leia = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario;
		float saldo, limite;
		String titular;

		System.out.println("\nCriar Contas\n");

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);
		
		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                    Banco CHSB                       ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.next();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "\nBanco CHSB - Sempre por você!                             ");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");

				System.out.println("Digite o Número da Agência: ");
				agencia = leia.nextInt();

				System.out.println("Digite o Nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				do {
					System.out.println("Digite o Tipo da Conta (1 para CC e 2 para CP): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o Limite de Crédito (R$): ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}

				case 2 -> {
					System.out.println("Digite o dia do Aniversário da Conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}

				}

				KeyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
				contas.listarTodas();
				KeyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");

				KeyPress();
				break;

			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");

				KeyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");

				KeyPress();
				break;

			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");

				KeyPress();
				break;

			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

				KeyPress();
				break;

			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

				KeyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);

				KeyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
				+ "                                                          ");
		System.out.println("**********************************************************");
		System.out.println("Projeto Desenvolvido por: Carlos Henrique da Silva Barbosa");
		System.out.println("c.henrique.silvabarbosa@gmail.com                         ");
		System.out.println("https://github.com/Henrykeeh                              ");
		System.out.println("**********************************************************" + Cores.TEXT_RESET);
	}

	public static void KeyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de Enter!");
		}
	}
}