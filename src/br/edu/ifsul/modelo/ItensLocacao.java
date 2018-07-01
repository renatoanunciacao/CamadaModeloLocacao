/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Renato
 */
@Entity
@Table(name = "itens_locacao")
public class ItensLocacao implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_itens", sequenceName = "seq_itens_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_itens", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    @NotNull(message = "O valor não pode ser nulo")
    @Column(name = "valor_total", columnDefinition = "numeric(12,2)")
    private Double valorTotal;
    @ManyToOne
    @JoinColumn(name = "locacao", referencedColumnName = "codigo", nullable = false,
            foreignKey = @ForeignKey(name = "fk_locacao_codigo"))
    private Locacao locacao;
    @OneToMany(mappedBy = "locacao", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY) //qual atributo aponta para essa classe
    private List<Filme> filme = new ArrayList<>();

    public ItensLocacao() {
        this.valorTotal = 0.0;
    }

    public void adicionarFilmes(Filme obj) {

        this.valorTotal += obj.getValor();
        this.filme.add(obj);
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public List<Filme> getFilme() {
        return filme;
    }

    public void setFilme(List<Filme> filme) {
        this.filme = filme;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
