package br.com.ewerton.diabeteshop.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ewerton.diabeteshop.models.Produto;
import br.com.ewerton.diabeteshop.repositories.ProdutoRepository;

@Controller
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepo;

    @GetMapping("/produtos/listar")
    public ModelAndView listar(){
        List<Produto> produtos = produtoRepo.findAll();
        ModelAndView modelAndView = new ModelAndView("produtos/listar");
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }
    
    @GetMapping("/produtos/novo")
    public ModelAndView formNovoProduto() {
        ModelAndView modelAndView = new ModelAndView("produtos/novo");
        modelAndView.addObject(new Produto());
        return modelAndView;
    }
    
    @PostMapping("/produtos/novo")
    public String novoProduto(Produto salvarProduto) {
        salvarProduto.calcularVolume();
        salvarProduto.setData_cadastro(LocalDate.now());
        this.produtoRepo.save(salvarProduto);
        return "redirect:/produtos/listar";
    }
    
}
