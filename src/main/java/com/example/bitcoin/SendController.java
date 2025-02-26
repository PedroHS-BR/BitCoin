package com.example.bitcoin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SendController {

    @FXML
    TextField valorTextField;
    @FXML
    TextField destinoTextField;

    private Parent root;






    public void criarTransacao(ActionEvent event) throws IOException {
        String input = valorTextField.getText();
        String destino = destinoTextField.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        root = loader.load();
        HelloController mainController = loader.getController();

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();

        if (isNumeric(input)) {
            double valor = Double.parseDouble(input);
            mainController.criarTransacao(valor, "asd", destino);
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
