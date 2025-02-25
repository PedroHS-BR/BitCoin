package com.example.bitcoin;

import Beans.BlockChain;
import Beans.Transacao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    public static void criarTransacao(double valor, String origem, String destino) {
        blockChain.AdicionarTransacao(new Transacao(valor, origem, destino));
        System.out.println(blockChain.calculaValorTotal());
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
        if (blockChain.getBlocosEmEspera().size() == 0) {
            bloco1Button.setText("0 BTC");
            bloco2Button.setText("0 BTC");
            return;
        }

        bloco1Button.setText(blockChain.getBlocosEmEspera().getFirst().getValorTotal() + " BTC");
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