/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Renato
 */
@Entity
@Table(name = "locacao")
public class Locacao implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_locacao", sequenceName = "seq_locacao_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_locacao", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    @Temporal(TemporalType.DATE)
    @Column(name = "emprestimo", nullable = false)
    private Calendar emprestimo;
    @Temporal(TemporalType.DATE)
    @Column(name = "devolucao")
    private Calendar devolucao;
    //Referencia a classe pessoa como chave estrangeira
    @NotNull(message = "O campo pessoa não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "codigo", nullable = false,
            foreignKey = @ForeignKey(name = "fk_locacao_pessoa"))
    private Pessoa pessoa;
    @NotNull(message = "O campo pessoa não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "filme", referencedColumnName = "codigo", nullable = false,
            foreignKey = @ForeignKey(name = "fk_locacao_filme"))
    private Filme filme;

    public Locacao() {


    }

   
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Calendar getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Calendar emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Calendar getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Calendar devolucao) {
        this.devolucao = devolucao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    
    }
    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

}
