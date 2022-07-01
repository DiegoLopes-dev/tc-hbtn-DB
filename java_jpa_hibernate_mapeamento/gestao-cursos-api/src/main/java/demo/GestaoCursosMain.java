package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestaoCursosMain {
    public static void main(String[] args) {

        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        List<Telefone> telefones1 = new ArrayList<>();
        telefones1.add(new Telefone(1L, "065", "993038547"));
        telefones1.add(new Telefone(2L, "042", "36951949"));

        List<Telefone> telefones2 = new ArrayList<>();
        telefones2.add(new Telefone(3L, "025", "99303852247"));
        telefones2.add(new Telefone(4L, "0423", "3695192249"));

        List<Endereco> enderecos1 = new ArrayList<>();
        enderecos1.add(new Endereco(1L, "Rua mexico", "Rua mexico Quadra 15 lote 8",
                "8", "Mapim", "Várzea Grande", "MT", 78143312));
        enderecos1.add(new Endereco(2L, "Rua guatemala", "Rua guatelama Quadra 5 lote 18",
                "10", "Imperial", "Cuiabá", "MT", 78143322));

        List<Endereco> enderecos2 = new ArrayList<>();
        enderecos2.add(new Endereco(3L, "Rua Brasil", "Rua Brsil Quadra 15 lote 8",
                "8", "Brasil", "Várzea Grande", "MT", 78143312));
        enderecos2.add(new Endereco(4L, "Rua Maratinga", "Rua Maratinga Quadra 5 lote 18",
                "10", "Guatatinga", "Goiania", "MT", 78143322));


        Aluno aluno1 = new Aluno(1L, "Alefe Patrick", "01", new Date(),
                "alefepdias@gmail.com", enderecos1, telefones1);

        Aluno aluno2 = new Aluno(2L, "Elenice Ferreira Dias", "02", new Date(),
                "elenice@gmail.com", enderecos2, telefones2);

        alunoModel.create(aluno1);
        alunoModel.create(aluno2);

        System.out.println(alunoModel.findAll());

        System.out.println(alunoModel.findById(1L));

        Professor professor = new Professor(1L, "Lucas Adriano Dias Ramos",
                "592", "lucasadrianodias@gmail.com");

        MaterialCurso materialCurso = new MaterialCurso(1L, "http://youtube.com/ProgramandoNaWeb");

        Curso curso1 = new Curso(1L, "Java Script", "JS", List.of(aluno1, aluno2), professor, materialCurso);

        Curso curso2 = new Curso(2L, "Java Script", "JS", List.of(aluno1, aluno2), professor, materialCurso);

        cursoModel.create(curso1);
        cursoModel.create(curso2);

        System.out.println(cursoModel.findAll());

        System.out.println(cursoModel.findById(1L));

        Aluno alunoUpdate = new Aluno(2L, "Lucas ADriano Dias", "03", new Date(),
                "lucasadrianodias@gmail.com", enderecos2, telefones2);

        alunoModel.update(alunoUpdate);

        System.out.println(alunoModel.findById(2L));

        Curso cursoUpdate = new Curso(2L, "Java OO", "JOO", List.of(aluno1, aluno2), professor, materialCurso);

        cursoModel.update(cursoUpdate);

        System.out.println(cursoModel.findById(2L));

        System.out.println("Excluindo todos Alunos e odos os professores");

        cursoModel.delete(curso1);
        cursoModel.delete(curso2);

        alunoModel.delete(aluno1);
        alunoModel.delete(aluno2);

        System.out.println("Lista de alunos" + alunoModel.findAll());
        System.out.println("Lista de cursos" + cursoModel.findAll());


    }
}