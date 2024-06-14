package org.example;

public class Emprestimo {
    private static final double MAXIMO_EMPRESTIMO = 200000;
    private static final double JUROS_EMPRESTIMO = 0.35;
    private static final double MAXIMO_PARCELA_SALARIO = 0.15;

    private double salarioAtual;
    private double valorEmprestimo;
    private double valorTotalPago;
    private double valorParcela;

    public Emprestimo(double salarioAtual, double valorEmprestimo) {
        this.salarioAtual = salarioAtual;
        this.valorEmprestimo = valorEmprestimo;
    }

    public boolean validarEmprestimo() {
        if (valorEmprestimo > MAXIMO_EMPRESTIMO) {
            return false;
        }

        double valorParcelaMaxima = salarioAtual * MAXIMO_PARCELA_SALARIO;
        double valorTotalEmprestimo = valorEmprestimo * (1 + JUROS_EMPRESTIMO);

        if (valorTotalEmprestimo / 24 > valorParcelaMaxima) {
            return false;
        }

        return true;
    }

    public void calcularParcelas() {
        this.valorTotalPago = valorEmprestimo * (1 + JUROS_EMPRESTIMO);
        this.valorParcela = valorTotalPago / 24;
    }

    public void exibirDetalhesEmprestimo() {
        System.out.println("\n=== DETALHES DO EMPRÉSTIMO ===");
        System.out.println("Valor do Empréstimo: R$ " + valorEmprestimo);
        System.out.println("Valor Total a Ser Pago: R$ " + valorTotalPago);
        System.out.println("Valor de Cada Parcela: R$ " + valorParcela);
    }
}
