package org.example;
import java.util.Scanner;


public class calculos {

    public static double mediaAritmetica(double nota1, double nota2) {
        return (nota1 + nota2) / 2;
    }

    public static double mediaPonderada(double nota1, double nota2, double peso1, double peso2) {
        return (nota1 * peso1 + nota2 * peso2) / (peso1 + peso2);
    }

    public static void mostrarResultado(double media) {
        if (media >= 7) {
            System.out.println("Aluno aprovado com média: " + media);
        } else {
            System.out.println("Aluno reprovado com média: " + media);
        }
    }

    public static double receberNota(String mensagem, Scanner scanner) {
        double nota;
        do {
            System.out.print(mensagem);
            nota = scanner.nextDouble();
        } while (!validarNota(nota));
        return nota;
    }

    public static double receberPeso(String mensagem, Scanner scanner) {
        System.out.print(mensagem);
        return scanner.nextDouble();
    }

    public static boolean validarNota(double nota) {
        if (nota >= 0 && nota <= 10) {
            return true;
        } else {
            System.out.println("Nota inválida. A nota deve estar entre 0 e 10.");
            return false;
        }
    }
}
