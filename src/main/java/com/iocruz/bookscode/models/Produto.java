package com.iocruz.bookscode.models;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Produto
 */
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    private String descricao;

    private Integer paginas;

    @ElementCollection
    private List<Preco> precos;

    @DateTimeFormat
    private Calendar dataLancamento;

    private String sumarioPath;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the paginas
     */
    public Integer getPaginas() {
        return paginas;
    }

    /**
     * @param paginas the paginas to set
     */
    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    /**
     * @return the precos
     */
    public List<Preco> getPrecos() {
        return precos;
    }

    /**
     * @param precos the precos to set
     */
    public void setPrecos(List<Preco> precos) {
        this.precos = precos;
    }

    /**
     * @return the dataLancamento
     */
    public Calendar getDataLancamento() {
        return dataLancamento;
    }

    /**
     * @param dataLancamento the dataLancamento to set
     */
    public void setDataLancamento(Calendar dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    /**
     * @return the sumario
     */
    public String getSumarioPath() {
        return sumarioPath;
    }

    /**
     * @param sumario the sumario to set
     */
    public void setSumarioPath(String sumarioPath) {
        this.sumarioPath = sumarioPath;
    }

    public BigDecimal precoPara(TipoPreco tipoPreco) {
        return this.precos
            .stream()
            .filter(preco -> preco.getTipo().equals(tipoPreco))
            .findFirst()
            .get()
            .getPreco();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        Produto other = (Produto) obj;
        if (id != other.id)
            return false;
        return true;
    }
}