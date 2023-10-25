package ifpr.pgua.eic.tarefas.controllers;

import java.net.URL;

import java.util.ResourceBundle;



import ifpr.pgua.eic.tarefas.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;

public class PrincipalAdm implements Initializable {

    @FXML
    private Label lbNome;

    private String nomeUsuario;
    public void setNomeUsuario(String nome) {
        nomeUsuario = nome;
        lbNome.setText(nomeUsuario);
    }


    @FXML
    void listarUsuarios(ActionEvent event) {
        App.pushScreen("LISTARADM");
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
      
      
        lbNome.setText("nome");
        
}

}

