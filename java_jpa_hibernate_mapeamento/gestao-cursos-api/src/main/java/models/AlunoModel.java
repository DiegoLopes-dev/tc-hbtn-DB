package models;

import entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AlunoModel {

    public void create(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Aluno findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        Aluno aluno = em.find(Aluno.class, id);
        em.close();
        emf.close();
        return aluno;
    }

    @SuppressWarnings("unchecked")
    public List<Aluno> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        List<Aluno> alunos;

        alunos = em.createQuery("FROM " + Aluno.class.getName()).getResultList();
        em.close();
        emf.close();
        return alunos;

    }

    public void update(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        Aluno alunoUpdate = em.find(Aluno.class, aluno.getId());

        em.getTransaction().begin();
        alunoUpdate.setNomeCompleto(aluno.getNomeCompleto());
        alunoUpdate.setMatricula(aluno.getMatricula());
        alunoUpdate.setNascimento(aluno.getNascimento());
        alunoUpdate.setEmail(aluno.getEmail());
        alunoUpdate.setEnderecos(aluno.getEnderecos());
        alunoUpdate.setTelefones(aluno.getTelefones());
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public void delete(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        Aluno alunoDelete = em.find(Aluno.class, aluno.getId());


        em.getTransaction().begin();
        em.remove(alunoDelete);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}