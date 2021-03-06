/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Filme;
import br.edu.ifsul.modelo.ItensLocacao;
import br.edu.ifsul.modelo.Locacao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Renato
 */
public class TestePersistirItens {
       EntityManagerFactory emf;
    EntityManager em;
    public TestePersistirItens() {
    }
    
    @Before
    public void setUp() {
         emf = Persistence.createEntityManagerFactory("APLICACAOLOCADORAPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
   @Test
    public void persistirFilme(){
        boolean exception = false;
        try{
            ItensLocacao i = new ItensLocacao();
            Locacao l = em.find(Locacao.class, 1);
            Filme f = em.find(Filme.class, 2);
            i.setLocacao(l);
            i.setFilme(f);
            em.getTransaction().begin();
            em.persist(i);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        //verifico se não ocorreu exceção para passar no teste
        Assert.assertEquals(false, exception);
    }
}
