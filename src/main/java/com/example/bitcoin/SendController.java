package com.example.bitcoin;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SendController {

    @FXML
    TextField valorTextField;
    @FXML
    TextField destinoTextField;


    public void criarTransacao(){
        String input = valorTextField.getText();
        String destino = destinoTextField.getText();

        if (isNumeric(input)) {
            double valor = Double.parseDouble(input);
            HelloController.criarTransacao(valor, "aaa", destino);
        } else {
            System.out.println("Entrada inválida! Digite um número.");
        }

    }

    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str); // Tenta converter para número
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
