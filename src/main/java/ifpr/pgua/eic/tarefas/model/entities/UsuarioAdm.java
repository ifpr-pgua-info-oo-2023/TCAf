package ifpr.pgua.eic.tarefas.model.entities;

import java.sql.Date;

public class UsuarioAdm {
    private int id;
   
    private String cpf;
    private String nome;
    private String email;
    private String nomeLogin;
    private String senha;
    private String telefone;
   
 
    
  
    public UsuarioAdm(String nome, String email, String nomeLogin, String senha, String cpf, String telefone) {
        
        this.nome = nome;
        this.email = email;
        this.nomeLogin = nomeLogin;
        this.cpf = cpf;
        this.senha = senha;
        this.telefone = telefone;
        
    }
    public UsuarioAdm(int id, String nome, String email, String nomeLogin, String senha, String cpf, Date dataRegistro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.nomeLogin = nomeLogin;
        this.senha = senha;
        this.cpf = cpf;
        this.dataRegistro = dataRegistro;
        
    }
     public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    private Date dataRegistro;
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
     public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String toString(){
        return nome;
    }
}
