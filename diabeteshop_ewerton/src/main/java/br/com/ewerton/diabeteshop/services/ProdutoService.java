package br.com.ewerton.diabeteshop.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ewerton.diabeteshop.models.Produto;
import br.com.ewerton.diabeteshop.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepo;

    public List<Produto> getProdutos(){
        return produtoRepo.findAll();
    }

    @Transactional
    public void saveProduto(Produto produto){
        produtoRepo.save(produto);
    }

    public Produto getProdutoById(Long id) {
		return produtoRepo.findById(id).get();
	}

    @Transactional
    public void removeProduto(Produto produto) {
        produtoRepo.delete(produto);
	}

    public double calcularVolume(double altura, double largura, double profundidade){
        return altura*largura*profundidade;
    }

}
