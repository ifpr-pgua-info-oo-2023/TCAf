package ifpr.pgua.eic.tarefas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.entities.UsuarioAdm;


public class JDBCUsuarioAdmDAO implements UsuarioAdmDAO {
    private static final String INSERTPESSOA ="INSERT INTO  TCA_pessoa (nome, email,  nome_login, senha) VALUES (?,?,?,?)";
    private static final String INSERTADM = "INSERT INTO TCA_adm(cpf_adm, id_pessoa_fk) VALUES (?,?)";
    private static final String SELECTVALIDALOGIN = "SELECT U.cpf_adm "+
    "FROM TCA_adm U "+
    "INNER JOIN TCA_pessoa P ON U.id_pessoa_fk = P.id_pessoa "+
    "WHERE P.nome_login = ? AND P.senha = ?";

    private FabricaConexoes fabrica;

   
    public JDBCUsuarioAdmDAO(FabricaConexoes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public Resultado criar(UsuarioAdm usuarioAdm) {
          try(Connection con = fabrica.getConnection();) {
          con.setAutoCommit(false);

            PreparedStatement pstm = con.prepareStatement(INSERTPESSOA, Statement.RETURN_GENERATED_KEYS);
           
            pstm.setString(1, usuarioAdm.getNome());
            pstm.setString(2, usuarioAdm.getEmail());
            pstm.setString(3, usuarioAdm.getNomeLogin());
            pstm.setString(4, usuarioAdm.getSenha());
            
            int ret = pstm.executeUpdate();
            PreparedStatement pstk = con.prepareStatement(INSERTADM);

             if(ret == 1){
                ResultSet rs = pstm.getGeneratedKeys();
                rs.next();
                int id = rs.getInt(1);
                pstk.setString(1,usuarioAdm.getCpf());
                pstk.setInt(2,id);
                
                int retPessoa = pstk.executeUpdate();

                if (retPessoa == 1) {
                    con.commit();
                }

                System.out.println(con.getMetaData().getDatabaseProductName());

                System.out.println(usuarioAdm);
                return Resultado.sucesso("ADM cadastrado", usuarioAdm);
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
    public Resultado atualizar(int id, UsuarioAdm novo) {
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
                } else {
            
            return Resultado.erro("Credenciais inválidas. Tente novamente.");
        }
       }
   } catch (SQLException e) {
       e.printStackTrace();
       return Resultado.erro("Erro ao realizar o login.");
   }
    }

   

    
}
