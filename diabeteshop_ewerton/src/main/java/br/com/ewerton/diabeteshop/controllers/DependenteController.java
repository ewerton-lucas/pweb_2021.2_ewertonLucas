package br.com.ewerton.diabeteshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ewerton.diabeteshop.models.Dependente;
import br.com.ewerton.diabeteshop.services.DependenteService;

@Controller
public class DependenteController {
    
    @Autowired
    DependenteService dependenteService;

    @GetMapping("/dependentes/listar")
    public ModelAndView getDependentes(){
        ModelAndView modelAndView = new ModelAndView("dependentes/listar");
        modelAndView.addObject("dependentes", dependenteService.getDependentes());
        return modelAndView;
    }

    @GetMapping("/dependentes/novo")
    public ModelAndView formNovoDependente() {
        ModelAndView modelAndView = new ModelAndView("dependentes/novo");
        modelAndView.addObject(new Dependente());
        return modelAndView;
    }

    @PostMapping("/dependentes/novo")
    public String salvarDependente(Dependente dependente) {
        dependenteService.saveDependente(dependente);
        return "redirect:/dependentes/listar";
    }

    @GetMapping("/dependentes/editar/{id}")
    public ModelAndView formEditarDependente(@PathVariable("id") long id) {
        Dependente dependente = dependenteService.getDependenteById(id);
        ModelAndView modelAndView = new ModelAndView("dependentes/editar");
        modelAndView.addObject(dependente);
        return modelAndView;
    }

    @PostMapping("/dependentes/editar/{id}")
    public ModelAndView editarDependente(@PathVariable("id") long id, Dependente dependente) {
        dependenteService.saveDependente(dependente);
        return new ModelAndView("redirect:/dependentes/listar");
    }

    @GetMapping("/dependentes/remover/{id}")
    public ModelAndView removerDependente(@PathVariable("id") long id) {
        Dependente dependente = dependenteService.getDependenteById(id);
        dependenteService.removeDependente(dependente);
        return new ModelAndView("redirect:/dependentes/listar");
    }
    
}
