/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Aeroporto;
import br.edu.ifsul.modelo.Classe;
import br.edu.ifsul.modelo.Passagem;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Voo;
import br.edu.ifsul.modelo.VooAgendado;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author GUI
 */
public class TesteInserirVoo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoWeb_avioes_ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Voo v = new Voo();
        
        v.setDescricao("Voo de David até Passo Fundo com escala em Ciríaco");
        v.setAtivo(true);
        v.setPeriodicidade("Diária");
        v.setTempoEstimado(10.0);
        
        VooAgendado vooAgendado = new VooAgendado();
        vooAgendado.setAeronave("GOL");
        vooAgendado.setData(Calendar.getInstance());
        vooAgendado.setTotalPassageiros(300);
        vooAgendado.setVoo(v);
        
        Passagem pp = new Passagem();
        Classe c = em.find(Classe.class, 1);
        Pessoa p = em.find(Pessoa.class, 1);
        pp.setBagagem(20);
        pp.setClasse(c);
        pp.setPessoa(p);
        pp.setDataCompra(Calendar.getInstance());
        pp.setVooAgendado(vooAgendado);
        
        vooAgendado.setPassagem(pp);
        
        v.setVooAgendado(vooAgendado);
        
        
        em.getTransaction().begin();
        em.persist(v);
        em.persist(vooAgendado);
        em.persist(pp);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
}
