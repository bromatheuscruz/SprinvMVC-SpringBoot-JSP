package com.iocruz.bookscode.models;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Carrinho
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class Carrinho {

    Map<CarrinhoItem, Integer> itens = new LinkedHashMap<CarrinhoItem, Integer>();
    
    final Integer ADICIONA_MAIS_UM = 1;

    public void add(CarrinhoItem carrinhoItem) {

        if (existe(carrinhoItem)) {
            addMaisUm(carrinhoItem);
            return;
        }
        
        itens.put(carrinhoItem, ADICIONA_MAIS_UM);
    }

    public Integer getQuantidade(CarrinhoItem carrinhoItem) {
        if (!itens.containsKey(carrinhoItem)) {
            itens.put(carrinhoItem, Integer.valueOf(0));
        }

        return itens.get(carrinhoItem);
    }

    public void addMaisUm(CarrinhoItem carrinhoItem) {
        Integer quantidadeAntiga = itens.get(carrinhoItem);
        itens.put(carrinhoItem, quantidadeAntiga + ADICIONA_MAIS_UM);
    }

    public boolean existe(CarrinhoItem carrinhoItem) {
        return this.itens.containsKey(carrinhoItem);
    }

    public Integer getQuantidade() {
        return this.itens
            .values()
            .stream()
            .reduce(0, (proximo, acumulador) -> proximo + acumulador);
    }

    public Collection<CarrinhoItem> getItens() {
        return itens.keySet();
    }

    public BigDecimal getTotal(CarrinhoItem carrinhoItem) {
        return carrinhoItem.getTotal(getQuantidade(carrinhoItem));
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        
        for (CarrinhoItem var : itens.keySet()) {
            total = total.add(getTotal(var));
        }

        return total;

    }
}