package ifpr.pgua.eic.tarefas.controllers;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.App;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioAdm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class CriarContaAdm {

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNomeUsuario;

    @FXML
    private TextField tfSenha;

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfSenhaAdm;

    private RepositorioAdm repositorio;
    


    
    public CriarContaAdm(RepositorioAdm repositorio) {
        this.repositorio = repositorio;
    }


    @FXML
    void criarContaAdm(ActionEvent event) {
        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String nomeUsuario = tfNomeUsuario.getText();
        String senha = tfSenha.getText();
        String cpf = tfCpf.getText();
        String telefone = tfTelefone.getText();
        String senhaAdm = tfSenhaAdm.getText();
        
        
        Resultado resultado = repositorio.criarContaAdm(nome, email, nomeUsuario, senha, cpf, telefone, senhaAdm);
             
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
