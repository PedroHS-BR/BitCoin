package com.example.bitcoin;

import Beans.Bloco;
import Beans.Transacao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private Button bloco1Button;

    public void initialize() {
        // Criar um objeto Aluno e pegar o nome
        Bloco bloco1 = new Bloco();
        bloco1.addTransacao(new Transacao(150,"asd","dsa"));

        // Alterar o texto do botão
        bloco1Button.setText(bloco1.getValorTotal() + " BTC");
    }
}