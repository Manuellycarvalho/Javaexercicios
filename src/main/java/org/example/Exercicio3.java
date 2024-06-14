package org.example;

import java.util.Scanner;

public class Exercicio3 {
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("==== MENU PRINCIPAL ====");
        System.out.println("[" + GREEN + "1" + RESET + "] " + GREEN + "Simular Empréstimo" + RESET);
        System.out.println("[" + RED + "2" + RESET + "] " + RED + "Sair" + RESET);
        System.out.print("\nDigite sua escolha: ");

        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
                simularEmprestimo();
                break;
            case 2:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida. Saindo...");
                break;
        }

        scanner.close();
    }

    public static void simularEmprestimo() {
        double salarioAtual = solicitarSalarioAtual();
        double valorDesejado = solicitarValorEmprestimo();

        Emprestimo emprestimo = new Emprestimo(salarioAtual, valorDesejado);
        if (emprestimo.validarEmprestimo()) {
            emprestimo.calcularParcelas();
            emprestimo.exibirDetalhesEmprestimo();
        } else {
            System.out.println("Você não pode fazer este empréstimo com as condições atuais.");
        }
    }

    public static double solicitarSalarioAtual() {
        System.out.print("Informe seu salário atual: ");
        return scanner.nextDouble();
    }

    public static double solicitarValorEmprestimo() {
        System.out.print("Informe o valor desejado para o empréstimo: ");
        return scanner.nextDouble();
    }
}
