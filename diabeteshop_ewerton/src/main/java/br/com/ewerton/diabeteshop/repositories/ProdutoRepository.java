package br.com.ewerton.diabeteshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ewerton.diabeteshop.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
