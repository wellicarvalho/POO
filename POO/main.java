import entity.Conta;
import facade.Fachada;
import facade.IFachada;
import exception.ExcecaoElementoInexistente;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        IFachada fachada = new Fachada();
        Conta c = new Conta("Adao", "1", 100);
        Conta c2 = new Conta("Eva", "2", 500);
        fachada.inserirConta(c);
        fachada.inserirConta(c2);
        fachada.mostrarContas();

        Scanner scanner = new Scanner(System.in);

        int escolha = 1;
        while (escolha != 0) {
            System.out.println("-------------- MENU ---------------");
            System.out.println("[0] - Sair");
            System.out.println("[1] - Inserir Conta");
            System.out.println("[2] - Remover Conta");
            System.out.println("[3] - Alterar Conta");
            System.out.println("[4] - Buscar Conta");
            System.out.println("[5] - Relatorio de todas contas");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    try {
                        System.out.print("Numero da Conta: ");
                        String numeroConta = scanner.next();

                        System.out.print("Titular da Conta: ");
                        String titular = scanner.next();
                        System.out.print("Insira o valor inicial: R$ ");
                        double saldo = scanner.nextDouble();

                        fachada.inserirConta(new Conta(numeroConta, titular, saldo));

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Numero da Conta: ");
                        String numero = scanner.next();
                        fachada.removerConta(numero);
                        System.out.println("Conta removida com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Lista de contas está vazia!");
                    }
                    break;

                case 3:
                    System.out.print("Digite o numero da conta que deseja alterar: ");
                    String numC = scanner.next();
                    fachada.alterarConta(numC);
                    break;
                case 4:
                    try {
                        System.out.print("Numero da Conta: ");
                        String num = scanner.next();
                        System.out.println(fachada.buscarConta(num));

                    } catch (ExcecaoElementoInexistente e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    fachada.mostrarContas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção indisponivel!");
            }
            System.out.println();
        }
    }
}
