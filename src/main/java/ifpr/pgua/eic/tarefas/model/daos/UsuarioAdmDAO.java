package ifpr.pgua.eic.tarefas.model.daos;

import com.github.hugoperlin.results.Resultado;
import ifpr.pgua.eic.tarefas.model.entities.UsuarioAdm;

public interface UsuarioAdmDAO {
    
    Resultado criar(UsuarioAdm usuarioAdm);

 
    Resultado listar();
    Resultado getById(int id);

    Resultado atualizar(int id, UsuarioAdm novo);
    Resultado delete(int id);
}
