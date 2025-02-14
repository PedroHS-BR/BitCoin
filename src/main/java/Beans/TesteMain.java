package Beans;

public class TesteMain {
    public static void main(String[] args) {
        Transacao transacao = new Transacao(150, "asd", "dsa");
        Transacao transacao2 = new Transacao(250, "asd", "dsa");

        Bloco bloco = new Bloco();

        bloco.addTransacao(transacao);
        bloco.addTransacao(transacao2);

        System.out.println(bloco.getValorTotal());

    }
}
