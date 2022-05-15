package br.com.ewerton.diabeteshop.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ewerton.diabeteshop.models.Cliente;
import br.com.ewerton.diabeteshop.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepo;

    public List<Cliente> getClientes(){
        return clienteRepo.findAll();
    }

    @Transactional
    public void saveCliente(Cliente cliente){
        clienteRepo.save(cliente);
    }

    public Cliente getClienteById(Long id) {
		return clienteRepo.findById(id).get();
	}

    @Transactional
    public void removeCliente(Cliente cliente) {
        clienteRepo.delete(cliente);
	}
    
}
