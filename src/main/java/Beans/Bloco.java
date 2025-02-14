package Beans;

public class Bloco {

    private static int idContador =0;
    private int transacaoContador = 0;
    private int id;
    private Transacao transacao;
    private Transacao[] transacoes;
    private Double valorTotal;

    public Bloco() {
        this.transacoes = new Transacao[10];
        this.id = ++idContador;
    }

    public boolean addTransacao(Transacao transacao) {
        if (transacaoContador >= 10 || transacao == null) return false;
        transacoes[transacaoContador] = transacao;
        transacaoContador++;
        this.calculaValorTotal();
        return true;
    }

    public void calculaValorTotal() {
        double valorTotal = 0;
        for (int i = 0; i < transacaoContador; i++) {
            valorTotal += transacoes[i].getValor();
        }
        this.valorTotal = valorTotal;
    }



    public static int getIdContador() {
        return idContador;
    }

    public int getTransacaoContador() {
        return transacaoContador;
    }

    public int getId() {
        return id;
    }

    public Transacao getTransacao() {
        return transacao;
    }

    public Transacao[] getTransacoes() {
        return transacoes;
    }

    public Double getValorTotal() {
        return valorTotal;
    }
}
