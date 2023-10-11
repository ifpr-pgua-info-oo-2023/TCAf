package ifpr.pgua.eic.tarefas.model.daos;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.entities.Usuario;

public interface UsuarioDAO {
    
    Resultado criar(Usuario usuario);

 
    Resultado listar();
    Resultado getById(int id);

    Resultado atualizar(int id, Usuario novo);
    Resultado delete(int id);
}
