package br.com.ewerton.diabeteshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ewerton.diabeteshop.models.Dependente;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Long>{
    
}
