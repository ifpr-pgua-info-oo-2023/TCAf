package ifpr.pgua.eic.tarefas.model.repositories;


import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.daos.UsuarioDAO;
import ifpr.pgua.eic.tarefas.model.entities.Usuario;

public class RepositorioUsuario {
    
    private UsuarioDAO dao;

    public RepositorioUsuario(UsuarioDAO dao){
        this.dao = dao;
    }

    public Resultado criarConta(String nome, String email, String nomeLogin, String senha){

        if(nome.isEmpty() || nome.isBlank()){
            return Resultado.erro("Nome inválido!");
        }

        if(email.isBlank() || email.isEmpty()){
            return Resultado.erro("Email inválido!");
        }

        if(nomeLogin.isBlank() || nomeLogin.isEmpty()){
            return Resultado.erro("Nome Login inválido!");
        }
         if(senha.isBlank() || senha.isEmpty()){
            return Resultado.erro("Senha inválida!");
        }

        Usuario usuario = new Usuario(nome, email, nomeLogin, senha);

        return dao.criar(usuario);
    }


    public Resultado listarUsuario(){
        return dao.listar();
    }
}
