package com.iocruz.bookscode.controllers;

import java.util.List;

import javax.validation.Valid;

import com.iocruz.bookscode.infra.FileSaver;
import com.iocruz.bookscode.models.Produto;
import com.iocruz.bookscode.models.TipoPreco;
import com.iocruz.bookscode.repositories.ProdutoRepository;
import com.iocruz.bookscode.validators.ProdutoValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * ProdutoController
 */
@Controller
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FileSaver fileSaver;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new ProdutoValidator());
    }

    @RequestMapping("form")
    public ModelAndView form(Produto produto) {
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());

        return modelAndView;
    }

    @PostMapping
    public ModelAndView create(
            MultipartFile sumario, 
            @Valid Produto produto, 
            BindingResult bindingResult,
            RedirectAttributes redirect
        ) {
            
        produto.setSumarioPath(fileSaver.write(sumario));

        if (bindingResult.hasErrors()) {
            return form(produto);
        }

        produtoRepository.save(produto);
        redirect.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");

        return new ModelAndView("redirect:/produtos");
    }

    @GetMapping
    public ModelAndView listar() {
        
        ModelAndView modelAndView = new ModelAndView("produtos/list");
        List<Produto> produtos = produtoRepository.findAll();
        modelAndView.addObject("produtos", produtos);

        return modelAndView;
    }
    
}