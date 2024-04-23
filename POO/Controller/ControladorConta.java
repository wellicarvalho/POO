package controller;

import entity.Conta;
import repository.IRepositorioConta;
import repository.RepositorioConta;
import exception.ExcecaoElementoInexistente;

public class ControladorConta implements IControladorConta {
    private IRepositorioConta reposConta;

    public ControladorConta() {
        inicializarRepositorioConta();
    }

    private void inicializarRepositorioConta() {
        this.reposConta = new RepositorioConta();
    }

    public void inserirConta(Conta c) {
        this.reposConta.inserirConta(c);
    }

    public void alterarConta(String numero) {
        this.reposConta.alterarConta(numero);
    }

    public void removerConta(String numero) {
        reposConta.removerConta(numero);
    }

    public Conta buscarConta(String numero) throws ExcecaoElementoInexistente {
        return reposConta.buscarConta(numero);
    }

    public boolean verificarExistenciaConta(String numero) {
        return reposConta.verificarExistenciaConta(numero);
    }

    public void mostrarContas() {
        this.reposConta.mostrarContas();
    }
}
