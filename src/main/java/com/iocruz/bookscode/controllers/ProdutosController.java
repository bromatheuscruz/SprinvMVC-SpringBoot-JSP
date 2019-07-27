package com.iocruz.bookscode.controllers;

import com.iocruz.bookscode.models.Produto;
import com.iocruz.bookscode.models.TipoPreco;
import com.iocruz.bookscode.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ProdutoController
 */
@Controller
public class ProdutosController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @RequestMapping("/produtos/form")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());

        return modelAndView;
    }

    @RequestMapping("/produtos")
    public String produtos(Produto produto) {
        
        produtoRepository.save(produto);
        return "produtos/ok";    
    }
    
}