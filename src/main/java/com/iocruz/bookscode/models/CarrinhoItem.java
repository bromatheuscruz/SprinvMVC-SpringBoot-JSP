package com.iocruz.bookscode.models;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.stereotype.Component;

/**
 * CarrinhoItem
 */
@Component
public class CarrinhoItem implements Serializable{

    private static final long serialVersionUID = 1L;

    private Produto produto;
    private TipoPreco tipoPreco;

    public CarrinhoItem() {
    }

    public CarrinhoItem(Produto produto, TipoPreco tipoPreco) {
        this.produto = produto;
        this.tipoPreco = tipoPreco;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the tipoPreco
     */
    public TipoPreco getTipoPreco() {
        return tipoPreco;
    }

    /**
     * @param tipoPreco the tipoPreco to set
     */
    public void setTipoPreco(TipoPreco tipoPreco) {
        this.tipoPreco = tipoPreco;
    }

    public BigDecimal getPreco() {
        return produto.precoPara(tipoPreco);
    }

    public BigDecimal getTotal(Integer quantidade) {
        System.out.println(quantidade);
        return this.getPreco().multiply(new BigDecimal(quantidade));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((produto == null) ? 0 : produto.hashCode());
        result = prime * result + ((tipoPreco == null) ? 0 : tipoPreco.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CarrinhoItem other = (CarrinhoItem) obj;
        if (produto == null) {
            if (other.produto != null)
                return false;
        } else if (!produto.equals(other.produto))
            return false;
        if (tipoPreco != other.tipoPreco)
            return false;
        return true;
    }
}