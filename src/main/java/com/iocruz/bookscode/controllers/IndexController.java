package com.iocruz.bookscode.controllers;

import com.iocruz.bookscode.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * IndexController
 */
@Controller
public class IndexController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @RequestMapping("/")
    @Cacheable(value = "produtosHome")
    public ModelAndView index() {

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("produtos", produtoRepository.findAll());

        return modelAndView;
    }
    
}