package Beans;

public class Carteira {
    private String chavePrivada;
    private String chavePublica;
    private double saldo;

    public Carteira(String chavePrivada) {
        this.chavePrivada = chavePrivada;
        this.saldo = 0.0;
    }
}
