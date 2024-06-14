package org.example;

import java.util.Scanner;

public class Exercicio2 {
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        exibirMenuPrincipal();
        scanner.close();
    }

    public static void exibirMenuPrincipal() {
        int opcao;
        do {
            System.out.println("\n==== MENU PRINCIPAL ====");
            System.out.println("[" + GREEN + "1" + RESET + "] " + GREEN + "Calcular Folha de Pagamento" + RESET);
            System.out.println("[" + RED + "2" + RESET + "] " + RED + "Sair" + RESET);
            System.out.print("\nDigite sua escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    calcularFolhaPagamento();
                    break;
                case 2:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
                    break;
            }
        } while (opcao != 2);
    }

    public static void calcularFolhaPagamento() {
        System.out.println("\n==== CÁLCULO DA FOLHA DE PAGAMENTO ====");
        double salarioBruto = desconto.receberSalarioBruto();

        if (!desconto.validarSalario(salarioBruto)) {
            System.out.println("Salário fora da faixa válida (500 a 30000). Saindo...");
            return;
        }

        desconto desconto = new desconto();

        double descontoINSS = desconto.descontoINSS(salarioBruto);
        double descontoIRPF = desconto.descontoIRPF(salarioBruto);
        double descontoPlanoSaude = desconto.descontoPlanoSaude(salarioBruto);

        System.out.println("\n=== FOLHA DE PAGAMENTO ===");
        System.out.println("Salário Bruto: R$ " + salarioBruto);
        System.out.println("Desconto INSS (20%): R$ " + descontoINSS);
        System.out.println("Desconto IRPF (10%): R$ " + descontoIRPF);
        System.out.println("Desconto Plano de Saúde (5%): R$ " + descontoPlanoSaude);

        int horasExtras = desconto.receberHorasExtras();
        double acrescimoHorasExtras = desconto.acrescimoHorasExtras(salarioBruto, horasExtras);
        double salarioLiquido = desconto.salarioLiquido(salarioBruto, descontoINSS, descontoIRPF, descontoPlanoSaude, acrescimoHorasExtras);

        System.out.println("\n=== RESUMO ===");
        System.out.println("Acréscimo por Horas Extras: R$ " + acrescimoHorasExtras);
        System.out.println("Salário Líquido: R$ " + salarioLiquido);
    }
}
