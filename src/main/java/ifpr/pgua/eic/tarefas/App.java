package ifpr.pgua.eic.tarefas;


import ifpr.pgua.eic.tarefas.controllers.CriarConta;
import ifpr.pgua.eic.tarefas.controllers.CriarContaAdm;
import ifpr.pgua.eic.tarefas.controllers.ListarAdm;
import ifpr.pgua.eic.tarefas.controllers.Login;
import ifpr.pgua.eic.tarefas.controllers.PrincipalAdm;
import ifpr.pgua.eic.tarefas.model.daos.FabricaConexoes;
import ifpr.pgua.eic.tarefas.model.daos.JDBCUsuarioAdmDAO;
import ifpr.pgua.eic.tarefas.model.daos.JDBCUsuarioDAO;
import ifpr.pgua.eic.tarefas.model.daos.UsuarioAdmDAO;
import ifpr.pgua.eic.tarefas.model.daos.UsuarioDAO;
import ifpr.pgua.eic.tarefas.model.entities.Usuario;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioAdm;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioUsuario;
import io.github.hugoperlin.navigatorfx.BaseAppNavigator;
import io.github.hugoperlin.navigatorfx.ScreenRegistryFXML;

/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    private UsuarioDAO usuarioDAO = new JDBCUsuarioDAO(FabricaConexoes.getInstance());
    private RepositorioUsuario repositorioUsuario = new RepositorioUsuario(usuarioDAO);

    private UsuarioAdmDAO usuarioAdmDAO = new JDBCUsuarioAdmDAO(FabricaConexoes.getInstance());
    private RepositorioAdm repositorioAdm = new RepositorioAdm(usuarioAdmDAO);

   

    
    
 
    
    
    public static void main(String[] args) {
        launch();
    }
    

    @Override
    public String getHome() {
      
        return "LOGIN";
    }


    @Override
    public String getAppTitle() {
       
        return "Coleção de Músicas";
    }

    @Override
    public void registrarTelas() {
          registraTela("LOGIN", new ScreenRegistryFXML(App.class, "login.fxml", o->new Login(repositorioUsuario,repositorioAdm)));
          

      
    
    registraTela("CRIARCONTA",
    new ScreenRegistryFXML(App.class, 
        "criar_conta.fxml", 
        o->new CriarConta(repositorioUsuario)
    ));

     registraTela("CRIARCONTAADM",
    new ScreenRegistryFXML(App.class, 
        "criar_conta_adm.fxml", 
        o->new CriarContaAdm(repositorioAdm)
    ));
    
    

    registraTela("TELAPRINCIPALADM",
    new ScreenRegistryFXML(App.class, 
        "principal_adm.fxml", 
        o->new PrincipalAdm()
    ));
     registraTela("LISTARADM",
    new ScreenRegistryFXML(App.class, 
        "listar_adm.fxml", 
        o->new ListarAdm(repositorioAdm)
    ));
    

        }
}


   