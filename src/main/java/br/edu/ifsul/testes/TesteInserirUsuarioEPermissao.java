/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author GUI
 */
public class TesteInserirUsuarioEPermissao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoWeb_avioes_ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Usuario user = new Usuario();
        Usuario user2 = new Usuario();
        Permissao perm = new Permissao();
        Permissao perm2 = new Permissao();
        
        perm.setNome("ADMINISTRADOR");
        perm.setDescricao("Permissão TOP");
        
        perm2.setNome("USUARIO");
        perm2.setDescricao("Permissão básica");
        
        user.setNomeUsuario("guiwxz");
        user.setNome("Guilherme");
        user.setSenha("123456");
        user.getPermissoes().add(perm);
        
        user2.setNomeUsuario("gueds");
        user2.setNome("Gueds");
        user2.setSenha("123456");
        user2.getPermissoes().add(perm2);
        
        
        em.getTransaction().begin();
        em.persist(perm);
        em.persist(perm2);
        em.persist(user);
        em.persist(user2);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
}
