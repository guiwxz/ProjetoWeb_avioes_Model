/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Aeroporto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author GUI
 */
public class TesteInserirAeroporto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoWeb_avioes_ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Aeroporto a = new Aeroporto();
        Cidade c = em.find(Cidade.class, 1);
        
        a.setCidade(c);
        a.setNome("Aeroporto do Canabarro");
        a.setOperacaoNoturna(true);
        
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
}
