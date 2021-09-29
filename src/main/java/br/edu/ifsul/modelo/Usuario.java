/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author GUI
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
    
    @Id
    @NotBlank(message = "O nome de usuario deve ser informado")
    @Length(max = 30, message = "O nome de usuario não pode ter mais que {max} caracteres")
    @Column(name = "nome_usuario", length = 30, nullable = false)
    private String nomeUsuario;
    
    @NotBlank(message = "A senha deve ser informado")
    @Length(max = 30, message = "A senha não pode ter mais que {max} caracteres")
    @Column(name = "senha", length = 30, nullable = false)
    private String senha;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
   
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name="permissoes", 
        joinColumns = @JoinColumn(name="nome_usuario", referencedColumnName="nome_usuario", nullable=false),
        inverseJoinColumns = @JoinColumn(name="nome", referencedColumnName="nome", nullable=false)
    )
    private Set<Permissao> permissoes = new HashSet<>();
    
    public Usuario(){
        
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.nomeUsuario);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nomeUsuario, other.nomeUsuario)) {
            return false;
        }
        return true;
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
    
    
}
