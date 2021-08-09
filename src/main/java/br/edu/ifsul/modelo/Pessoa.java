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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author GUI
 */
@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable{
    
    @Id
    @SequenceGenerator(name="seq_pessoa", sequenceName="seq_pessoa_id", allocationSize=1)
    @GeneratedValue(generator="seq_pessoa", strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message="O nome deve ser informado")
    @Length(max=50, message="O nome não pode ter mais que {max} caracteres")
    @Column(name="nome", length=50, nullable=false)
    private String nome;
    
    @CPF(message="CPF deve ser válido")
    @NotBlank(message="O nome deve ser informado")
    @Length(max=50, message="O cpf não pode ter mais que {max} caracteres")
    @Column(name="cpf", length=14, nullable=false)
    private String cpf;
    
    @Email(message="Email deve ser válido")
    @NotBlank(message="O nome deve ser informado")
    @Length(max=50, message="O email não pode ter mais que {max} caracteres")
    @Column(name="email", length=40, nullable=false)
    private String email;
    
    @NotBlank(message="O telefone deve ser informado")
    @Length(max=50, message="O telefone não pode ter mais que {max} caracteres")
    @Column(name="telefone", length=15, nullable=false)
    private String telefone;
    
    
    public Pessoa(){
        
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
