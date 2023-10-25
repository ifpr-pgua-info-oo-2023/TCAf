package ifpr.pgua.eic.tarefas.controllers;

import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class PrincipalAdm implements Initializable {

    @FXML
    private Label lbNome;
    private RepositorioAdm repositorioAdm;

    
    
    public PrincipalAdm( RepositorioAdm repositorioAdm) {
        
        this.repositorioAdm = repositorioAdm;
    }
   

    @FXML
    void listarUsuarios(ActionEvent event) {
        App.pushScreen("LISTARADM");
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
   
        //lstAdm.getItems().clear();
        Resultado resultado = repositorioAdm.mostrarPerfil();
        

        if(resultado.foiErro()){
            Alert alert = new Alert(AlertType.ERROR, resultado.getMsg());
            alert.showAndWait();
        }else{
            ArrayList<UsuarioAdm> lista = (ArrayList<UsuarioAdm>) resultado.comoSucesso().getObj();


            if (!lista.isEmpty()) {
                UsuarioAdm usuarioAdm = lista.get(0);
                lbNome.setText("  Nome De Usuario: \n  "+usuarioAdm.getNome()+ "\n"+
                "  NickName: \n  "+usuarioAdm.getNomeLogin()+ "\n"+
                "  Cpf: \n  "+usuarioAdm.getCpf()+ "\n"+
                "  Email: \n  "+usuarioAdm.getEmail()+ "\n"
                
                );
            } else {
                // Lide com o caso em que a lista está vazia.
            }
           
        
        }
        //taDados.clear();
       
       
            
        
}

}

