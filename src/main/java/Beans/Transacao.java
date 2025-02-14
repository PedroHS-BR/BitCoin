package Beans;

public class Transacao {
    private double valor;
    private String origem;
    private String destino;
    private int id;
    private static int contador = 0;

    public Transacao(double valor, String origem, String destino) {
        this.id = ++contador;
        this.valor = valor;
        this.origem = origem;
        this.destino = destino;
    }


    //verifica no banco de dados se os endereçoes de origem e destino são validos
    public boolean validaEndereco() { return true;}

    //verifica se a origem tem saldo suficiente
    public boolean validaValor() { return true;}



    public double getValor() {
        return valor;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public int getId() {
        return id;
    }

    public static int getContador() {
        return contador;
    }
}
