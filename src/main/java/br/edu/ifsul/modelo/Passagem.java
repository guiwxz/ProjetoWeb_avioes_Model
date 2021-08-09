/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author GUI
 */
@Entity
@Table(name="passagem")
public class Passagem implements Serializable {
    
    @Id
    @SequenceGenerator(name="seq_passagem", sequenceName="seq_passagem_id", allocationSize=1)
    @GeneratedValue(generator="seq_passagem", strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message="A data da compra deve ser informada")
    @Column(name="data_compra", nullable=false)
    private Calendar dataCompra;
    
    @NotNull(message="A bagagem deve ser informado")
    @Column(name="bagagem", nullable=false)
    private Integer bagagem;

    @NotNull(message="A pessoa deve ser informado")
    @ManyToOne
    @JoinColumn(name="pessoa_id", referencedColumnName="id", nullable=false)
    private Pessoa pessoa;
    
    @NotNull(message="A classe deve ser informado")
    @ManyToOne
    @JoinColumn(name="classe_id", referencedColumnName="id", nullable=false)
    private Classe classe;
    
    @NotNull(message="O agendamento do voo deve ser informado")
    @ManyToOne
    @JoinColumn(name="voo_agendado_id", referencedColumnName="id", nullable=false)
    private VooAgendado vooAgendado;
    
    public Passagem() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Calendar dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Integer getBagagem() {
        return bagagem;
    }

    public void setBagagem(Integer bagagem) {
        this.bagagem = bagagem;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public VooAgendado getVooAgendado() {
        return vooAgendado;
    }

    public void setVooAgendado(VooAgendado vooAgendado) {
        this.vooAgendado = vooAgendado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Passagem other = (Passagem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
