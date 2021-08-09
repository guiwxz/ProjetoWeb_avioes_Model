/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author GUI
 */
@Entity
@Table(name="voo")
public class Voo implements Serializable {
    
    @Id
    @SequenceGenerator(name="seq_voo", sequenceName="seq_voo_id", allocationSize=1)
    @GeneratedValue(generator="seq_voo", strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name="descricao", columnDefinition="text")
    private String descricao;
    
    @NotNull(message="O tempo estimado deve ser informado")
    @Column(name="tempoEstimado", nullable=false, columnDefinition="numeric(4,2)")
    private Double tempoEstimado;
    
    @NotNull(message="O campo ativo operação noturna deve ser informado")
    @Column(name="ativo", nullable=false)
    private Boolean ativo;
    
    @NotBlank(message="A periodicidade deve ser informado")
    @Length(max=50, message="A periodicidade não pode ter mais que {max} caracteres")
    @Column(name="periodicidade", length=50, nullable=false)
    private String periodicidade;
    
    @OneToMany(mappedBy="voo", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
    private List<VooAgendado> voosAgendados = new ArrayList<>();
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name="escalas", 
        joinColumns = @JoinColumn(name="id_voo", referencedColumnName="id", nullable=false),
        inverseJoinColumns = @JoinColumn(name="id_aeroporto", referencedColumnName="id", nullable=false)
    )
    private Set<Aeroporto> escalas = new HashSet<>();
    
    public Voo() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(Double tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }

    public List<VooAgendado> getVoosAgendados() {
        return voosAgendados;
    }

    public void setVoosAgendados(List<VooAgendado> voosAgendados) {
        this.voosAgendados = voosAgendados;
    }
    
    public void setVooAgendado(VooAgendado vooAgendado) {
        if (this.voosAgendados == null) {
            this.voosAgendados = new ArrayList();
        }
        this.voosAgendados.add(vooAgendado);
    }

    public Set<Aeroporto> getEscalas() {
        return escalas;
    }

    public void setEscalas(Set<Aeroporto> escalas) {
        this.escalas = escalas;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.getId());
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
        final Voo other = (Voo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
