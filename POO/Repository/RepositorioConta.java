package repository;

import entity.Conta;
import exception.ExcecaoElementoInexistente;
import java.util.ArrayList;
import java.util.Scanner;

public class RepositorioConta implements IRepositorioConta{
    public ArrayList<Conta> contas;
    public int qtd_contas;
    public Scanner sc = new Scanner(System.in);

    public RepositorioConta(){
        this.contas = new ArrayList<Conta>();
        this.qtd_contas = contas.size();
    }

    public void inserirConta(Conta c){
        this.contas.add(c);
    }

    public void alterarConta(String numero){
        for (Conta c : contas){
            if (c.getNumero().equals(numero)) {
                System.out.print("Novo nome de Titular: ");
                c.setTitular(sc.nextLine());
                break;
            }
        }
    }
    public void removerConta(String numero){
        if (this.verificarExistenciaConta(numero)) {
            for (Conta c : contas){
                if (c.getNumero().equals(numero)){
                    this.contas.remove(c);
                }
        }
        }
    }

    public Conta buscarConta(String numero) throws ExcecaoElementoInexistente{
        for (Conta c : contas){
            if (c.getNumero().equals(numero)){
                return c;
            }
        }
        throw new ExcecaoElementoInexistente("Conta Não Encontrada");
    }
    public boolean verificarExistenciaConta(String numero){
        for (Conta c : contas){
            if (c.getNumero().equals(numero)){
                return true;
            }
        }
        return false;
        
    }

    public void mostrarContas(){
        for (Conta c : contas){
            System.out.println(c);
        }
    }
}