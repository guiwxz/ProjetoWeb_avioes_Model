/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Classe;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author GUI
 */
public class TesteInserirPessoa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoWeb_avioes_ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Pessoa p = new Pessoa();
        
        p.setNome("Guilherme");
        p.setCpf("03073650009");
        p.setEmail("guiwxz@hotmail.com");
        p.setTelefone("996650672");
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
}
