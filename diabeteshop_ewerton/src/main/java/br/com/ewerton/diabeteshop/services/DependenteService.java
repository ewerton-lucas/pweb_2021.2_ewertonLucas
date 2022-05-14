package br.com.ewerton.diabeteshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ewerton.diabeteshop.models.Dependente;
import br.com.ewerton.diabeteshop.repositories.DependenteRepository;

@Service
public class DependenteService {
    
    @Autowired
    DependenteRepository dependenteRepo;

    public List<Dependente> getDependentes(){
        return dependenteRepo.findAll();
    }

    public void saveDependente(Dependente dependente){
        dependenteRepo.save(dependente);
    }

    public Dependente getDependenteById(Long id) {
		return dependenteRepo.findById(id).get();
	}

    public void removeDependente(Dependente dependente) {
        dependenteRepo.delete(dependente);
	}
    
}
