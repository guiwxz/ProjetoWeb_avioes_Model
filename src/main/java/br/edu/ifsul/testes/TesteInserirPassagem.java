/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Passagem;
import br.edu.ifsul.modelo.Classe;
import br.edu.ifsul.modelo.Pessoa;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author GUI
 */
public class TesteInserirPassagem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoWeb_avioes_ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Passagem p = new Passagem();
        
        Classe c = em.find(Classe.class, 1);
        Pessoa pp = em.find(Pessoa.class, 1);
        
        p.setBagagem(4);
        p.setDataCompra(Calendar.getInstance());
        p.setPessoa(pp);
        p.setClasse(c);
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
}
