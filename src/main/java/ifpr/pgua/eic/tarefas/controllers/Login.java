package ifpr.pgua.eic.tarefas.controllers;

import ifpr.pgua.eic.tarefas.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Login {

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfSenha;

    @FXML
    void cadastrarConta(ActionEvent event) {
        App.pushScreen("CRIARCONTA");
    }

    @FXML
    void cadastrarContaAdm(ActionEvent event) {
        App.pushScreen("CRIARCONTAADM");
    }

    @FXML
    void login(ActionEvent event) {

    }

}
