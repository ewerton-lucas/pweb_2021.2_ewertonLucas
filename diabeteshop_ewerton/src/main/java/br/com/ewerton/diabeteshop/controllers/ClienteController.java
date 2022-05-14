package br.com.ewerton.diabeteshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ewerton.diabeteshop.models.Cliente;
import br.com.ewerton.diabeteshop.services.ClienteService;

@Controller
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/clientes/listar")
    public ModelAndView listarClientes(){
        ModelAndView modelAndView = new ModelAndView("clientes/listar");
        modelAndView.addObject("clientes", clienteService.getClientes());
        return modelAndView;
    }

    @GetMapping("/clientes/novo")
    public ModelAndView formNovoCliente() {
        ModelAndView modelAndView = new ModelAndView("clientes/novo");
        modelAndView.addObject(new Cliente());
        return modelAndView;
    }
    
    @PostMapping("/clientes/novo")
    public String salvarCliente(Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/clientes/listar";
    }

    @GetMapping("/clientes/editar/{id}")
    public ModelAndView formEditarCliente(@PathVariable("id") long id) {
        Cliente cliente = clienteService.getClienteById(id);
        ModelAndView modelAndView = new ModelAndView("clientes/editar");
        modelAndView.addObject(cliente);
        return modelAndView;
    }

    @PostMapping("/clientes/editar/{id}")
    public ModelAndView editarCliente(@PathVariable("id") long id, Cliente cliente) {
        clienteService.saveCliente(cliente);
        return new ModelAndView("redirect:/clientes/detalhes/{id}");
    }

    @GetMapping("/clientes/detalhes/{id}")
    public ModelAndView detalhesCliente(@PathVariable("id") Long id){
        Cliente cliente = clienteService.getClienteById(id);
        ModelAndView modelAndView = new ModelAndView("clientes/detalhes");
        modelAndView.addObject("cliente", cliente);
        return modelAndView;
    }

    @GetMapping("/clientes/remover/{id}")
    public ModelAndView removerCliente(@PathVariable("id") long id) {
        Cliente cliente = clienteService.getClienteById(id);
        clienteService.removeCliente(cliente);
        return new ModelAndView("redirect:/clientes/listar");
    }

}
