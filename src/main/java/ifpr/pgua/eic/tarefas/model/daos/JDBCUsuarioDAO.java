package ifpr.pgua.eic.tarefas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.github.hugoperlin.results.Resultado;
import java.sql.Statement;

import ifpr.pgua.eic.tarefas.model.entities.Usuario;


public class JDBCUsuarioDAO implements UsuarioDAO {
    private static final String INSERTPESSOA = "INSERT INTO  TCA_pessoa (nome, nome_login, email, senha) VALUES (?,?,?,?)";
    private static final String INSERTUSUARIO = "INSERT INTO TCA_usuario(id_pessoa_fk) VALUES (?)";
   
    private FabricaConexoes fabrica;

   
    public JDBCUsuarioDAO(FabricaConexoes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public Resultado criar(Usuario usuario) {
        
          try(Connection con = fabrica.getConnection();) {
            con.setAutoCommit(false);

            PreparedStatement pstm = con.prepareStatement(INSERTPESSOA, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement pstk = con.prepareStatement(INSERTUSUARIO);
                
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getNomeLogin());
            pstm.setString(4, usuario.getSenha());
            int ret = pstm.executeUpdate();
           

           if(ret == 1){
                ResultSet rs = pstm.getGeneratedKeys();
                rs.next();
                int id = rs.getInt(1);
                pstk.setInt(1,id);
                int retPessoa = pstk.executeUpdate();

                if (retPessoa == 1) {
                    con.commit();
                }

                System.out.println(con.getMetaData().getDatabaseProductName());

                System.out.println(usuario);
                return Resultado.sucesso("Usuario cadastrado", usuario);
            }
            return Resultado.erro("Erro não identificado!");
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    @Override
    public Resultado getById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public Resultado atualizar(int id, Usuario novo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public Resultado delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

   

    
}
