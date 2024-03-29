/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ludvig
 */
public class EntityTester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Book book1 = new Book("Chris Riddel");
        Book book2 = new Book("Kurt Vonnegut");
        try { //i eksemplet nedenunder bruges .begin() en gang, persist to gange, til hvert objekt, og .commit() en gang
            em.getTransaction().begin();
            em.persist(book1);
            em.persist(book2);
            em.getTransaction().commit();
            //Verify that books are managed and has been given a database id
            System.out.println(book1.getId());
            System.out.println(book2.getId());

        } finally {
            em.close(); //forbindelsen lukkes
        }
    }
}
