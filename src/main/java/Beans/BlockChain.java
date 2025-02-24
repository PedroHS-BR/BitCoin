package Beans;

import java.util.ArrayList;

public class BlockChain {
    private Transacao transacao;

    ArrayList<Bloco> blocosEmEspera = new ArrayList<>();

    public BlockChain(){
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
        this.AdicionarTransacao(new Transacao(10,"nome", "asa"));
    }

    public void AdicionarTransacao(Transacao transacao) {
        Bloco bloco = this.buscarBlocoLivre();
        if (bloco != null) bloco.addTransacao(transacao);
        else {
            bloco = new Bloco();
            blocosEmEspera.add(bloco);
            bloco.addTransacao(transacao);
        }
    }

    public Bloco buscarBlocoLivre(){
        for (Bloco bloco : blocosEmEspera) {
            if (bloco.getTransacaoContador() < 10) return bloco;
        }
        return null;
    }

    public double calculaValorTotal(){
        double valorTotal = 0;
        for (Bloco bloco : blocosEmEspera) {
            valorTotal += bloco.calculaValorTotal();
        }
        return valorTotal;
    }

    public ArrayList<Bloco> getBlocosEmEspera() {
        return blocosEmEspera;
    }
}
