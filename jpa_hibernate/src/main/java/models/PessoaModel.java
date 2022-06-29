package jpa_hibernate.src.main.java.models;

import entities.Pessoa;
import entities.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class PessoaModel {

    public void create(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Pessoa criada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            em.merge(p);

            em.getTransaction().commit();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        em.close();
        emf.close();
    }

    public void delete(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            Pessoa pessoa = em.find(Pessoa.class, p.getId());
            em.remove(pessoa);

            em.getTransaction().commit();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        em.close();
        emf.close();
    }

    public Pessoa findById(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        Pessoa pessoa = null;

        try{
            pessoa = em.find(Pessoa.class, p.getId());
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        em.close();
        emf.close();
        return pessoa;
    }

    public List<Pessoa> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        List<Pessoa> pessoas = new ArrayList<>();

        try{
            pessoas = em.createQuery("from Pessoa").getResultList();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        em.close();
        emf.close();
        return pessoas;
    }
}