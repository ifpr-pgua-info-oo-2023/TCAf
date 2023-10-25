package ifpr.pgua.eic.tarefas.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.App;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioAdm;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class Login {

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfSenha;
    private RepositorioUsuario repositorio;
    private RepositorioAdm repositorioAdm;

    
    
    public Login(RepositorioUsuario repositorio, RepositorioAdm repositorioAdm) {
        this.repositorio = repositorio;
        this.repositorioAdm = repositorioAdm;
    }
    

    @FXML
    void cadastrarConta(ActionEvent event) {
        App.pushScreen("CRIARCONTA");
    }

    @FXML
    void cadastrarContaAdm(ActionEvent event) {
        App.pushScreen("CRIARCONTAADM");
    }

    @FXML
    void loginTela(ActionEvent event) {
        String nomeUsuario = tfNome.getText();
        String senha = tfSenha.getText();

       Resultado resultado = repositorio.realizarLogin(nomeUsuario, senha);
       Resultado resultadoADM = repositorioAdm.realizarLogin(nomeUsuario, senha);

        
        
       if(resultado.foiSucesso()){
           App.pushScreen("TELAPRINCIPALADM");
       }else{
            
            if(resultadoADM.foiSucesso()){
                
                App.pushScreen("TELAPRINCIPALADM");
                
            }else{
                Alert alert;
                alert = new Alert(AlertType.INFORMATION, resultadoADM.getMsg());
                alert.showAndWait();
            }
            
           
        }

       
    }

}
