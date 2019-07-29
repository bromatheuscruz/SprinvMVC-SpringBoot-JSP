package com.iocruz.bookscode.models;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DadosPagamento
 */
public class DadosPagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal value;

    public DadosPagamento() { }

    public DadosPagamento(BigDecimal value) {
        this.value = value;
    }

    /**
     * @return the value
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setvalue(BigDecimal value) {
        this.value = value;
    }
}