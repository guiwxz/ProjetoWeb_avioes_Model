/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
/**
 *
 * @author GUI
 */

@Entity
@Table(name="cidade")
public class Cidade implements Serializable {
    
    @Id
    @SequenceGenerator(name="seq_cidade", sequenceName="seq_cidade_id", allocationSize=1)
    @GeneratedValue(generator="seq_cidade", strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message="O nome deve ser informado")
    @Length(max=50, message="O nom não pode ter mais que {max} caracteres")
    @Column(name="nome", length=50, nullable=false)
    private String nome;
    
    @NotBlank(message="O país deve ser informado")
    @Length(max=50, message="O país não pode ter mais que {max} caracteres")
    @Column(name="pais", length=50, nullable=false)
    private String pais;
    
    public Cidade(){}

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.getId());
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
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
}
