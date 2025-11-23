package br.com.fiap.main;

import javax.swing.JOptionPane;

public class TesteExcecao {
    public static void main(String[] args) {
        try {
            int valor = Integer.parseInt(JOptionPane.showInputDialog("Digite um número para teste de erro"));
            System.out.println("Valor: " + valor);
            int divisao = 10 / 0; // Forçando erro aritmetico
        } catch (NumberFormatException e) {
            System.out.println("Erro: Você digitou uma letra em vez de número.");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("Erro: Tentativa de divisão por zero.");
            e.printStackTrace();
        } finally {
            System.out.println("Teste finalizado.");
        }
    }
}
