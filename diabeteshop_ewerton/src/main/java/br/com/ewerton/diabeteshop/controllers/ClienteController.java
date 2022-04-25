package br.com.ewerton.diabeteshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ewerton.diabeteshop.models.Cliente;
import br.com.ewerton.diabeteshop.repositories.ClienteRepository;

@Controller
@RequestMapping("/")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepo;

    @GetMapping
    public String index() {
        return "index.html";
    }

    @GetMapping("/listarClientes")
    public ModelAndView listarClientes(){
        List<Cliente> lista = clienteRepo.findAll();
        ModelAndView modelAndView = new ModelAndView("listarClientes");
        modelAndView.addObject("clientes", lista);
        return modelAndView;
    }
    
    @GetMapping("/novoCliente")
    public ModelAndView formNovoCliente() {
        ModelAndView modelAndView = new ModelAndView("/novoCliente");
        modelAndView.addObject(new Cliente());
        return modelAndView;
    }
    
    @PostMapping("/novoCliente")
    public String novoCliente(Cliente aSalvar) {
        this.clienteRepo.save(aSalvar);
        return "redirect:/listarClientes";
    }

}
