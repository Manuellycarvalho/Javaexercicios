package org.example;

import java.util.Scanner;

public class desconto {
    private static final Scanner scanner = new Scanner(System.in);

    public double descontoINSS(double salarioBruto) {
        return salarioBruto * 0.2;
    }

    public double descontoIRPF(double salarioBruto) {
        return salarioBruto * 0.1;
    }

    public double descontoPlanoSaude(double salarioBruto) {
        return salarioBruto * 0.05;
    }

    public double acrescimoHorasExtras(double salarioBruto, int horasExtras) {
        double valorHoraNormal = salarioBruto / 160;
        double valorHoraExtra = valorHoraNormal * 1.5;
        return horasExtras * valorHoraExtra;
    }

    public double salarioLiquido(double salarioBruto, double descontoINSS, double descontoIRPF, double descontoPlanoSaude, double acrescimoHorasExtras) {
        return salarioBruto - descontoINSS - descontoIRPF - descontoPlanoSaude + acrescimoHorasExtras;
    }

    public static double receberSalarioBruto() {
        double salario;
        do {
            System.out.print("Informe seu salário bruto: ");
            salario = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer do Scanner
            if (!validarSalario(salario)) {
                System.out.println("Salário fora da faixa válida (500 a 30000). Informe novamente.");
            }
        } while (!validarSalario(salario));
        return salario;
    }

    public static int receberHorasExtras() {
        System.out.print("Informe a quantidade de horas extras realizadas: ");
        return scanner.nextInt();
    }

    public static boolean validarSalario(double salario) {
        return salario >= 500 && salario <= 30000;
    }
}
