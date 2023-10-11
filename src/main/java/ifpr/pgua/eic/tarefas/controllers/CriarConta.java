package ifpr.pgua.eic.tarefas.controllers;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.App;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class CriarConta {

    
    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfNomeUsuario;

    @FXML
    private TextField tfSenha;

    private RepositorioUsuario repositorio;


    
    public CriarConta(RepositorioUsuario repositorio) {
        this.repositorio = repositorio;
    }

    @FXML
    void criarConta(ActionEvent event) {
        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String nomeUsuario = tfNomeUsuario.getText();
        String senha = tfSenha.getText();

        Resultado resultado = repositorio.criarConta(nome, email, nomeUsuario, senha);

        Alert alert;
        
        if(resultado.foiErro()){
            alert = new Alert(AlertType.ERROR, resultado.getMsg());
        }else{
            alert = new Alert(AlertType.INFORMATION, resultado.getMsg());
        }

        alert.showAndWait();
    }


    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }

}
