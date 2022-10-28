package com.cadastro.model;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table (name = "cadastro")
public class Cadastro {

	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name= "nome", nullable = false)
	private String nome;
	
	@Column (name= "email")
	private String email;
	
	@Column (name= " CPF", nullable = false)
	private String CPF;
	
	
	public Cadastro() {
		super();
	}
	
	

	public Cadastro(Long id, String nome, String email, String cpf, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.CPF = cpf;
		
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	

	
	@Override
	public int hashCode() {
		return Objects.hash(CPF, email, id, nome );
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadastro other = (Cadastro) obj;
		return Objects.equals(CPF, other.CPF) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);

	}

	@Override
	public String toString() {
		return "Cadastro [id=" + id + ", nome=" + nome + ", email=" + email + ", CPF=" + CPF + "]";
	}
}
		
	
