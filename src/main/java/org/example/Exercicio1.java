package org.example;

import java.util.Scanner;

public class Exercicio1 {
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("==== COMEÇO ====");
        System.out.println("[" + GREEN + "1" + RESET + "]" + GREEN + " Entrar" + RESET);
        System.out.println("[" + RED + "2" + RESET + "]" + RED + " Sair" + RESET);
        System.out.print("\nDigite aqui sua escolha: ");

        int comeco = scanner.nextInt();
        scanner.nextLine();

        switch (comeco) {
            case 1:
                realizarCalculos();
                break;
            case 2:
                System.out.println("Até a próxima :) ...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }

        scanner.close();
    }

    public static void realizarCalculos() {
        double nota1 = calculos.receberNota("Informe a primeira nota: ", scanner);
        double nota2 = calculos.receberNota("Informe a segunda nota: ", scanner);

        System.out.println("---- Escolha a opção: ----");
        System.out.println("[1] - Aritmética");
        System.out.println("[2] - Ponderada");
        System.out.print("Digite aqui sua escolha: ");

        int escolha = scanner.nextInt();
        scanner.nextLine();

        double media = 0;

        if (escolha == 1) {
            System.out.println("Você escolheu a opção 1 (Aritmética)");
            media = calculos.mediaAritmetica(nota1, nota2);
        } else if (escolha == 2) {
            System.out.println("Você escolheu a opção 2 (Ponderada)");
            double peso1 = calculos.receberPeso("Informe o peso da primeira nota: ", scanner);
            double peso2 = calculos.receberPeso("Informe o peso da segunda nota: ", scanner);
            media = calculos.mediaPonderada(nota1, nota2, peso1, peso2);
        } else {
            System.out.println("Opção inválida. Tente novamente.");
            return;
        }

        calculos.mostrarResultado(media);
    }
}
