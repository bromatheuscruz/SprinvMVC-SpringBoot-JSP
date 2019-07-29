package com.iocruz.bookscode.controllers;

import java.util.Optional;

import com.iocruz.bookscode.models.Carrinho;
import com.iocruz.bookscode.models.CarrinhoItem;
import com.iocruz.bookscode.models.Produto;
import com.iocruz.bookscode.models.TipoPreco;
import com.iocruz.bookscode.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

/**
 * CarrinhoCompraController
 */
@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    Carrinho carrinho;

    @Autowired
    ProdutoRepository produtoRepository;

    @RequestMapping("/add")
    public ModelAndView add(Integer produtoid, TipoPreco tipoPreco) {
        ModelAndView modelAndView = new ModelAndView("redirect:/produtos");
        
        Optional<Produto> produtoOptional = produtoRepository.findById(produtoid);

        CarrinhoItem carrinhoItem = this.criaItem(produtoOptional.get(), tipoPreco);
        carrinho.add(carrinhoItem);

        return modelAndView;
    }

    @RequestMapping("/itens")
    public ModelAndView itens() {
        ModelAndView modelAndView = new ModelAndView("carrinho/itens");
        return modelAndView;
    }

    private CarrinhoItem criaItem(Produto produto, TipoPreco tipoPreco) {
        
        if (produto != null && tipoPreco != null) {
            CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipoPreco);
            return carrinhoItem;
        }

        return null;
	}
	
}