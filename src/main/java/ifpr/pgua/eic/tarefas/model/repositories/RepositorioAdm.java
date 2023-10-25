package ifpr.pgua.eic.tarefas.model.repositories;


import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.daos.UsuarioAdmDAO;

import ifpr.pgua.eic.tarefas.model.entities.UsuarioAdm;

public class RepositorioAdm {
    
    private UsuarioAdmDAO dao;
    private UsuarioAdm usuarioAdm;
    private String senhaPredefinida = "senha2635"; 

    public RepositorioAdm(UsuarioAdmDAO dao){
        this.dao = dao;
    }

    public Resultado criarContaAdm(String nome, String email, String nomeLogin, String senha, String cpf, String telefone, String senhaAdm){

        if(nome.isEmpty() || nome.isBlank()){
            return Resultado.erro("Nome inválido!");
        }

        if(email.isBlank() || email.isEmpty()){
            return Resultado.erro("Email inválido!");
        }

        if(nomeLogin.isBlank() || nomeLogin.isEmpty()){
            return Resultado.erro("Nome Login inválido!");
        }
         if(senha.isBlank() || senha.isEmpty()){
            return Resultado.erro("Senha inválida!");
        }
          if(cpf.isEmpty() || cpf.isBlank()){
            return Resultado.erro("Cpf inválido!");
        }
        if (senhaAdm == null || !senhaAdm.equals(senhaPredefinida)) {
            return Resultado.erro("Senha incorreta. A senha digitada não corresponde à senha fornecida pelo ADM.");
        }
        if (cpf.length() != 11) {
           return Resultado.erro("CPF inválido - O CPF deve conter 11 dígitos");
        }
        for (int i = 0;i<11;i++) {
            char x = cpf.charAt(i);
    
            // Verifica se o caractere é numerico
            if (x < 48|| x >57) {
                return Resultado.erro("CPF inválido - Caracteres não numéricos encontrados");
            }
        }
     

         usuarioAdm = new UsuarioAdm(nome, email, nomeLogin, senha, cpf,telefone );

        return dao.criar(usuarioAdm);
    }
    
    public Resultado realizarLogin(String nomeUsuario, String senha){
        return dao.realizarLogin(nomeUsuario, senha);
     }


    public Resultado listarUsuarioAdm(){
        return dao.listar();
    }
}
