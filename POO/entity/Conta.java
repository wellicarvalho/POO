package entity;

public class Conta {
    private String titular;
    private String numero;
    private double saldo;

    public Conta(String titular, String numero, double saldo) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void saque(double valor) {
        if (this.getSaldo() - valor >= 0 && valor > 0) {
            this.setSaldo(this.getSaldo() - valor);
        }
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\nNumero de Conta: %s\nSaldo: R$ %.2f\n", this.getTitular(), this.getNumero(), this.getSaldo());
    }

    @Override
    public boolean equals(Object o) {
        if (o != null) {
            if (o == this) {
                return true;
            }
            if (o instanceof Conta) {
                Conta c = (Conta) o;
                if (c.getNumero().equals(this.getNumero())) {
                    return true;
                }
            }
        }
        return false;
    }
}
