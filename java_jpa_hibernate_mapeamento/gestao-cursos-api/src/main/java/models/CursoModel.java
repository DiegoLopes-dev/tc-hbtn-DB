package models;

import entities.Aluno;
import entities.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CursoModel {
    public void create(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
            System.out.println("Curso criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Curso findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        Curso curso = em.find(Curso.class, id);
        em.close();
        emf.close();
        return curso;
    }

    @SuppressWarnings("unchecked")
    public List<Curso> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        List<Curso> cursos;

        cursos = em.createQuery("FROM " + Curso.class.getName()).getResultList();
        em.close();
        emf.close();
        return cursos;
    }

    public void update(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        Curso cursoUpdate = em.find(Curso.class, curso.getId());

        em.getTransaction().begin();
        cursoUpdate.setNome(curso.getNome());
        cursoUpdate.setSigla(curso.getSigla());
        cursoUpdate.setAlunos(curso.getAlunos());
        cursoUpdate.setProfessor(curso.getProfessor());
        cursoUpdate.setMaterialCurso(curso.getMaterialCurso());
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public void delete(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        Curso cursoDelete = em.find(Curso.class, curso.getId());


        em.getTransaction().begin();
        em.remove(cursoDelete);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}