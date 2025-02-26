package com.example.bitcoin;

import Beans.BlockChain;
import Beans.Transacao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button bloco1Button;
    @FXML
    private Button bloco2Button;

    private static BlockChain blockChain;

    public void criarTransacao(double valor, String origem, String destino) {
        blockChain.AdicionarTransacao(new Transacao(valor, origem, destino));
        System.out.println(blockChain.calculaValorTotal());
        atualizarBotoesDados();
    }

    public void imprimirsaldo(){
        System.out.println(blockChain.calculaValorTotal());
    }

    public void initialize() {
        // Criar um objeto Aluno e pegar o nome
        blockChain = new BlockChain();

        // Alterar o texto do botão
        atualizarBotoesDados();
    }



    public void atualizarBotoesDados(){
        if (blockChain.getBlocosEmEspera().isEmpty()) {
            bloco1Button.setText("0 BTC");
            bloco2Button.setText("0 BTC");
            System.out.println("nenhum bloco");
            return;
        }

        bloco1Button.setText(blockChain.getBlocosEmEspera().getFirst().getValorTotal() + " BTC");
        Transacao[] transacoes = blockChain.getBlocosEmEspera().getFirst().getTransacoes();
        for (int i = 0; i < 10; i++){
            if (transacoes[i] != null) {
                System.out.println("tem transação");
            }
            else System.out.println("não tem transação");
        }
        if (blockChain.getBlocosEmEspera().size() == 1) bloco2Button.setText("0 BTC");
        else if (blockChain.getBlocosEmEspera().size() == 2) bloco2Button.setText(blockChain.getBlocosEmEspera().get(1).getValorTotal() + " BTC");
        else bloco2Button.setText(blockChain.getBlocosEmEspera().size() - 1 + " Blocos");
    }


    public void openSendWindow(){
        this.openWindow("SendWindow.fxml", "Enviar");
    }

    public void openImportWindow() {
        this.openWindow("ImportWindow.fxml", "Importar");
    }

    public void opemReceiveWindow(){
        this.openWindow("ReceiveWindow.fxml", "Receber");
    }

    public void openWindow(String janela, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(janela));
            Parent root = loader.load();

            //SendWindowController controller = loader.getController();
            //controller.setMainController(this);

            Stage novaJanela = new Stage();
            novaJanela.initModality(Modality.APPLICATION_MODAL); // Bloqueia interação com a janela principal
            novaJanela.setScene(new Scene(root));
            novaJanela.showAndWait(); // Espera a nova janela ser fechada antes de voltar à principal
            novaJanela.setResizable(false);
            novaJanela.setTitle(titulo);
            Image icon = new Image("file:/C:/Users/pedro/IdeaProjects/Learning Javafx/src/Bitcoin.png");
            novaJanela.getIcons().add(icon);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}