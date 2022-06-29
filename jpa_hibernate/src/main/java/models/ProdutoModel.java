
package jpa_hibernate.src.main.java.models;

import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ProdutoModel {

    public void create(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        emf.close();
    }

    public void update(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            em.merge(p);

            em.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        em.close();
        emf.close();
    }

    public void delete(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            Produto produto = em.find(Produto.class, p.getId());
            em.remove(produto);

            em.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        em.close();
        emf.close();
    }

    public Produto findById(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        Produto produto = null;

        try{
            produto = em.find(Produto.class, p.getId());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        em.close();
        emf.close();
        return produto;
    }

    public List<Produto> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        List<Produto> produtos = new ArrayList<>();

        try{
            produtos = em.createQuery("from Produto").getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        em.close();
        emf.close();
        return produtos;
    }
}