package br.com.ewerton.diabeteshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ewerton.diabeteshop.models.Cliente;
import br.com.ewerton.diabeteshop.repositories.ClienteRepository;

@Controller
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepo;

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

    @GetMapping("/editar/{id}")
    public ModelAndView formEditarCliente(@PathVariable("id") long id) {
        Cliente cliente = clienteRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        ModelAndView modelAndView = new ModelAndView("clientes/editar");
        modelAndView.addObject(cliente);
        return modelAndView;
    }

    @PostMapping("/editar/{id}")
    public ModelAndView editarCliente(@PathVariable("id") long id, Cliente cliente) {
        this.clienteRepo.save(cliente);
        return new ModelAndView("redirect:/clientes/listar");
    }

    @GetMapping("/remover/{id}")
    public ModelAndView removerCliente(@PathVariable("id") long id) {
        Cliente aRemover = clienteRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));

        clienteRepo.delete(aRemover);
        return new ModelAndView("redirect:/clientes/listar");
    }

}
