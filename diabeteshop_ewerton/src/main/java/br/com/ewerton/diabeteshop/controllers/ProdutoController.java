package br.com.ewerton.diabeteshop.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ewerton.diabeteshop.models.Produto;
import br.com.ewerton.diabeteshop.services.ProdutoService;

@Controller
public class ProdutoController {
   
    @Autowired
    ProdutoService produtoService;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("produtos", produtoService.getProdutos());
        return modelAndView;
    }

    @GetMapping("/produtos/listar")
    public ModelAndView listarProdutos(){
        ModelAndView modelAndView = new ModelAndView("produtos/listar");
        modelAndView.addObject("produtos", produtoService.getProdutos());
        return modelAndView;
    }
    
    @GetMapping("/produtos/novo")
    public ModelAndView formNovoProduto(){
        ModelAndView modelAndView = new ModelAndView("produtos/novo");
        modelAndView.addObject(new Produto());
        return modelAndView;
    }
    
    @PostMapping("/produtos/novo")
    public String salvarProduto(Produto produto){

        double altura = produto.getAltura_produto();
        double largura = produto.getLargura_produto();
        double profundidade = produto.getProfundidade_produto();

        produto.setVolume_produto(produtoService.calcularVolume(altura, largura, profundidade));

        produto.setData_cadastro(LocalDate.now());

        produtoService.saveProduto(produto);

        return "redirect:/";
    }

    @GetMapping("/produtos/editar/{id}")
    public ModelAndView formEditarProduto(@PathVariable("id") long id){
        Produto produto = produtoService.getProdutoById(id);
        ModelAndView modelAndView = new ModelAndView("produtos/editar");
        modelAndView.addObject(produto);
        return modelAndView;
    }

    @PostMapping("/produtos/editar/{id}")
    public ModelAndView editarProduto(@PathVariable("id") long id, Produto produto) {

        double altura = produto.getAltura_produto();
        double largura = produto.getLargura_produto();
        double profundidade = produto.getProfundidade_produto();

        produto.setVolume_produto(produtoService.calcularVolume(altura, largura, profundidade));

        produto.setData_cadastro(produtoService.getProdutoById(id).getData_cadastro());

        produtoService.saveProduto(produto);

        return new ModelAndView("redirect:/produtos/listar");
    }

    @GetMapping("/produtos/remover/{id}")
    public ModelAndView removerProduto(@PathVariable("id") long id){
        Produto produto = produtoService.getProdutoById(id);
        produtoService.removeProduto(produto);
        return new ModelAndView("redirect:/produtos/listar");
    }
    
}
