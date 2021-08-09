/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Classe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author GUI
 */
public class TesteListarEstados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoWeb_avioes_ModelPU");
        EntityManager em = emf.createEntityManager();
        
        List<Cidade> list = em.createQuery("from Cidade order by nome").getResultList();
        
        list.forEach(e -> {
            System.out.println(" ID: "+e.getId()+"\n Nome: "+e.getNome()+" ("+e.getPais()+")");
        });
        
        em.close();
        emf.close();
    }
    
}
