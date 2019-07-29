package com.iocruz.bookscode.controllers;

import java.util.concurrent.Callable;

import com.iocruz.bookscode.models.Carrinho;
import com.iocruz.bookscode.models.DadosPagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * PagamentoController
 */
@Controller
@RequestMapping("/pagamento")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class PagamentoController {

    @Autowired
    private Carrinho carrinho;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${application.payment.url}")
    private String paymentUrl;

    @PostMapping("/finalizar")
    public Callable<ModelAndView> finalizar(RedirectAttributes redirectAttributes) {

        return () -> {

            redirectAttributes.addFlashAttribute("mensagem", "Pagamento realizado com sucesso");
            ModelAndView modelAndView = new ModelAndView("redirect:/produtos");

            try {

                restTemplate.postForObject(paymentUrl, new DadosPagamento(carrinho.getTotal()), String.class);
                redirectAttributes.addFlashAttribute("mensagem", "Pagamento realizado com sucesso");

            } catch (Exception e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute("mensagem", "Não foi possível efetuar o pagamento");
            }

            return modelAndView;
        };
    }
}