package ifpr.pgua.eic.tarefas.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.App;
import ifpr.pgua.eic.tarefas.model.entities.UsuarioAdm;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioAdm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;


public class ListarAdm implements Initializable{

    @FXML
    private ListView<UsuarioAdm> lstAdm;
    @FXML
    private TextArea taDados;

    private RepositorioAdm repositorio;

    public ListarAdm(RepositorioAdm repositorio){
        this.repositorio = repositorio;
    }

    @FXML
    void mostrarDadosAdm(MouseEvent event) {
        taDados.clear();
        UsuarioAdm usuarioAdm = lstAdm.getSelectionModel().getSelectedItem();
        if (usuarioAdm != null){
            taDados.appendText("Cpf: " + usuarioAdm.getCpf() + "\n");
            taDados.appendText("Nome de Login: " + usuarioAdm.getNomeLogin() + "\n");
            taDados.appendText("Data de Registro: " + usuarioAdm.getDataRegistro() + "\n");
            taDados.appendText("Id: " + usuarioAdm.getId() + "\n");
           
        }
    }

    @FXML
    void voltar(ActionEvent event) {

        App.pushScreen("TELAPRINCIPALADM");
    }

  

   

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lstAdm.getItems().clear();
        Resultado resultado = repositorio.listarUsuarioAdm();
        

        if(resultado.foiErro()){
            Alert alert = new Alert(AlertType.ERROR, resultado.getMsg());
            alert.showAndWait();
        }else{
            List lista = (List)resultado.comoSucesso().getObj();
            lstAdm.getItems().addAll(lista);
        }
        
    
    }

}
