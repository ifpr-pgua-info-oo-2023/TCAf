package ifpr.pgua.eic.tarefas.model.entities;

import java.sql.Date;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String nomeLogin;
    private String senha;
    private Date dataRegistro;

  
    
    public Usuario(String nome, String nomeLogin,  String email,String senha) {
        this.nome = nome;
        this.nomeLogin = nomeLogin;
        this.email = email;
        this.senha = senha;
    }
    
    public Usuario(int id, String nome, String nomeLogin, String email, String senha, Date dataRegistro) {
        this.id = id;
        this.nome = nome;
      
        this.nomeLogin = nomeLogin;
        this.email = email;
        this.senha = senha;
        this.dataRegistro = dataRegistro;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNomeLogin() {
        return nomeLogin;
    }
    public void setNomeLogin(String nomeLogin) {
        this.nomeLogin = nomeLogin;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Date getDataRegistro() {
        return dataRegistro;
    }
    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    @Override
public String toString() {
    return nome; 
}
}
