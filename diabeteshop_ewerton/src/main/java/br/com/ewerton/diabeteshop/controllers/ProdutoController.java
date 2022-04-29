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

    @GetMapping("/listarProdutos")
    public ModelAndView listarProdutos(){
        List<Produto> lista = produtoRepo.findAll();
        ModelAndView modelAndView = new ModelAndView("listarProdutos");
        modelAndView.addObject("produtos", lista);
        return modelAndView;
    }
    
    @GetMapping("/novoProduto")
    public ModelAndView formNovoProduto() {
        ModelAndView modelAndView = new ModelAndView("/novoProduto");
        modelAndView.addObject(new Produto());
        return modelAndView;
    }
    
    @PostMapping("/novoProduto")
    public String novoProduto(Produto salvarProduto) {
        salvarProduto.calcularVolume();
        salvarProduto.setData_cadastro(LocalDate.now());
        this.produtoRepo.save(salvarProduto);
        return "redirect:/listarProdutos";
    }
    
}
