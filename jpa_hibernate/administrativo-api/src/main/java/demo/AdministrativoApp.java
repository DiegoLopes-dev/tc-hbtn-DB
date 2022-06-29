package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.util.List;

public class AdministrativoApp {

    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        // 1) Criando um produto
        produtoModel.create(p1);

        //2) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        // TODO - Testar os demais metódos das classes: ProdutoModel e PessoaModel

        // Testes de ProdutoModel
        System.out.println("Procura produto pelo ID: ---> "+ p1.getId() +" Produto encontrado: " + produtoModel.findById(p1));
        System.out.println("Atualiza o produto: ");
        p1.setNome("Smart TV");
        p1.setPreco(1300.0);
        p1.setQuantidade(1000);
        p1.setStatus(true);
        produtoModel.update(p1);
        System.out.println("Procura produto pelo ID: ");
        System.out.println("Procura produto pelo ID: ---> "+ p1.getId() +" Produto encontrado: " + produtoModel.findById(p1));

        System.out.println("Deleta o produto: ");
        produtoModel.delete(p1);

        produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        // Testes de PessoaModel
        PessoaModel pessoaModel = new PessoaModel();

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("karen Steve Watson");
        pessoa.setCpf("01234567890");
        pessoa.setEmail("watson.ks@ksw.com");
        pessoa.setIdade(47);
        pessoa.setDataNasc("01/01/1975");

        // 1) Criando uma pessoa
        pessoaModel.create(pessoa);

        //2) Buscando todas as pessoas na base de dados
        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas : " + pessoas.size());

        System.out.println("Procura pessoa pelo ID: ---> "+ pessoa.getId() +" Pessoa encontrada: " + pessoaModel.findById(pessoa));
        System.out.println("Atualiza a pessoa: ");

        pessoa.setNome("karl Steve Watson");
        pessoa.setCpf("88888888888");
        pessoa.setEmail("ks.watson@ksw.com");
        pessoa.setIdade(43);
        pessoa.setDataNasc("01/01/1979");

        pessoaModel.update(pessoa);
        System.out.println("Procura pessoa pelo ID: ");
        System.out.println("Procura pessoa pelo ID: ---> "+ pessoa.getId() +" Pessoa encontrada: " + pessoaModel.findById(pessoa));

        System.out.println("Deleta a pessoa: ");
        pessoaModel.delete(pessoa);

        pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontrados : " + pessoas.size());
    }
}