package ifpr.pgua.eic.tarefas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.entities.UsuarioAdm;


public class JDBCUsuarioAdmDAO implements UsuarioAdmDAO {
    private static final String INSERTPESSOA ="INSERT INTO  TCA_adm (nome_adm, email_adm,  nome_login_adm, senha_adm,cpf_adm) VALUES (?,?,?,?,?)";
    private static final String INSERTTEL = "INSERT INTO TCA_telefone_adm(fone_adm_pk, cod_adm_pk) VALUES (?,?)";
    private static final String SELECTVALIDALOGIN = "SELECT  "+
    "*FROM TCA_adm U "+
    "WHERE U.nome_login_adm = ? AND U.senha_adm = ?";

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
            pstm.setString(5, usuarioAdm.getCpf());
            
            int ret = pstm.executeUpdate();
            PreparedStatement pstk = con.prepareStatement(INSERTTEL);

             if(ret == 1){
                ResultSet rs = pstm.getGeneratedKeys();
                rs.next();
                int id = rs.getInt(1);
                pstk.setString(1,usuarioAdm.getTelefone());
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
        try (Connection con = fabrica.getConnection()) {
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM TCA_adm");

            ResultSet rs = pstm.executeQuery();

            ArrayList<UsuarioAdm> lista = new ArrayList<>();

            while(rs.next()){
                int id = rs.getInt("cod_adm_pk");
                String nome = rs.getString("nome_adm");
                String email = rs.getString("email_adm");
                String nome_login = rs.getString("nome_login_adm");
                String cpf = rs.getString("cpf_adm");
                String senha = rs.getString("senha_adm");
                Date data  = rs.getDate("data_registro_adm");
              

                UsuarioAdm usuarioAdm = new UsuarioAdm(id,nome, email, nome_login,cpf, senha, (java.sql.Date) data);
                lista.add(usuarioAdm);

            }
            
            return Resultado.sucesso("Lista de artistas", lista);
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    
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
                 String nome = resultSet.getString("nome_adm");
                 return Resultado.sucesso(null,nome);
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
