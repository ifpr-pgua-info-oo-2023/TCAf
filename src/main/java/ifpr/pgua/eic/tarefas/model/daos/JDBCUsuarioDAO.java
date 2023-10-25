package ifpr.pgua.eic.tarefas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.github.hugoperlin.results.Resultado;
import java.sql.Statement;

import ifpr.pgua.eic.tarefas.model.entities.Usuario;


public class JDBCUsuarioDAO implements UsuarioDAO {
    private static final String INSERTPESSOA = "INSERT INTO  TCA_usuario (nome_usuario, nome_login_usuario, email_usuario, senha_usuario) VALUES (?,?,?,?)";
    private static final String SELECTVALIDALOGIN = "SELECT " +
    "*FROM TCA_usuario U " +
    "WHERE U.nome_login_usuario = ? AND U.senha_usuario = ?";


   
    private FabricaConexoes fabrica;

   
    public JDBCUsuarioDAO(FabricaConexoes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public Resultado criar(Usuario usuario) {
        
          try(Connection con = fabrica.getConnection();) {

            PreparedStatement pstm = con.prepareStatement(INSERTPESSOA, Statement.RETURN_GENERATED_KEYS);
         
                
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getNomeLogin());
            pstm.setString(4, usuario.getSenha());
            int ret = pstm.executeUpdate();
           

           if(ret == 1){
                ResultSet rs = pstm.getGeneratedKeys();
                rs.next();
               
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

    @Override
    public Resultado realizarLogin(String nomeUsuario, String senha) {
    
        try (Connection con = fabrica.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SELECTVALIDALOGIN)) {
    
            pstmt.setString(1, nomeUsuario);
            pstmt.setString(2, senha);
    
            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {

             
               
                 
                    return Resultado.sucesso(null,null);
                }
                return Resultado.erro(null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Resultado.erro("Erro ao realizar o login.");
        }
    }

   

    
}
