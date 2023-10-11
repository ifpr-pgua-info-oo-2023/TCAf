package ifpr.pgua.eic.tarefas.model.entities;

import java.sql.Date;

public class UsuarioAdm {
    private String cpf;
    private String nome;
    private String email;
    private String nomeLogin;
    private String senha;
    private Date dataRegistro;
 
    
  
    public UsuarioAdm(String cpf,String nome, String email, String nomeLogin, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.nomeLogin = nomeLogin;
        this.senha = senha;
        
    }
    public UsuarioAdm(String cpf, String nome, String email, String nomeLogin, String senha, Date dataRegistro) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.nomeLogin = nomeLogin;
        this.senha = senha;
        this.dataRegistro = dataRegistro;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
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
}
