package com.iocruz.bookscode.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Preco implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal preco;
    private TipoPreco tipo;

    /**
     * @return the preco
     */
    public BigDecimal getPreco() {
        return preco;
    }
    
    /**
     * @param preco the preco to set
     */
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    /**
     * @return the tipo
     */
    public TipoPreco getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoPreco tipo) {
        this.tipo = tipo;
    }

}