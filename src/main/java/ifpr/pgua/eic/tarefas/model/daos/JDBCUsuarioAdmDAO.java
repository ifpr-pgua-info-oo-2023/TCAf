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

   

    
}
