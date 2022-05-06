package br.com.ewerton.diabeteshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ewerton.diabeteshop.models.Cliente;
import br.com.ewerton.diabeteshop.models.Dependente;
import br.com.ewerton.diabeteshop.repositories.ClienteRepository;
import br.com.ewerton.diabeteshop.repositories.DependenteRepository;

@Controller
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepo;

    @Autowired
    DependenteRepository dependenteRepo;

    @GetMapping("/clientes/listar")
    public ModelAndView listar(){
        List<Cliente> clientes = clienteRepo.findAll();
        ModelAndView modelAndView = new ModelAndView("clientes/listar");
        modelAndView.addObject("clientes", clientes);
        return modelAndView;
    }

    @GetMapping("/clientes/novo")
    public ModelAndView formNovoCliente() {
        ModelAndView modelAndView = new ModelAndView("clientes/novo");
        modelAndView.addObject(new Cliente());
        return modelAndView;
    }
    
    @PostMapping("/clientes/novo")
    public String novoCliente(Cliente salvarCliente) {
        this.clienteRepo.save(salvarCliente);
        return "redirect:/clientes/listar";
    }

    @GetMapping("/clientes/editar/{id}")
    public ModelAndView formEditarCliente(@PathVariable("id") long id) {
        Cliente cliente = clienteRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        ModelAndView modelAndView = new ModelAndView("clientes/editar");
        modelAndView.addObject(cliente);
        return modelAndView;
    }

    @PostMapping("/clientes/editar/{id}")
    public ModelAndView editarCliente(@PathVariable("id") long id, Cliente editarCliente) {
        this.clienteRepo.save(editarCliente);
        return new ModelAndView("redirect:/clientes/detalhes/{id}");
    }

    @GetMapping("/clientes/remover/{id}")
    public ModelAndView removerCliente(@PathVariable("id") long id) {
        Cliente removerCliente = clienteRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        clienteRepo.delete(removerCliente);
        return new ModelAndView("redirect:/clientes/listar");
    }

    @GetMapping("/clientes/detalhes/{id}")
    public ModelAndView detalhesCliente(@PathVariable("id") Long id){
        Cliente cliente = clienteRepo.getById(id);
        ModelAndView modelAndView = new ModelAndView("clientes/detalhes");
        modelAndView.addObject("cliente", cliente);

        Iterable<Dependente> dependentes = dependenteRepo.findByCliente(cliente);
        modelAndView.addObject("dependentes", dependentes);
        
        return modelAndView;
    }

    @PostMapping("/clientes/detalhes/{id}")
    public String novoDependente(@PathVariable("id") Long id, Dependente dependente) {
        Cliente cliente = clienteRepo.getById(id);
        dependente.setCliente(cliente);
        dependenteRepo.save(dependente);
        return "redirect:/clientes/detalhes/{id}";
    }

}
