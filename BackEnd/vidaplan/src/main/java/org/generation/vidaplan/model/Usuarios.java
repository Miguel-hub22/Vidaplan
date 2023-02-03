package org.generation.vidaplan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_usuarios")
public class Usuarios {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank (message = "O campo nome é obrigatório")
	@Size (min = 3, max = 40, message = "O campo nome deve ter no minimo 03 caracteres")
	public String nome;
	@NotBlank (message = "O campo usuário é obrigatório")
	@Size (min = 5, max = 40, message = "O campo usuário deve ter no minimo 05 caracteres")
	public String usuarioEmail;
	@NotBlank (message = "O campo cpf é obrigatório")
	@Size (min = 10, max = 11, message = "O campo cpf deve ter no minimo 10 caracteres")
	public String cpf;
	@NotBlank (message = "O campo endereço é obrigatório")
	@Size (min = 10, max = 50, message = "O campo endereço deve ter no minimo 10 caracteres")
	public String endereco;
	@NotBlank (message = "O campo senha é obrigatório")
	@Size (min = 06, max = 50, message = "O campo senha deve ter no minimo 06 caracteres")
	public String senha;
	
	@OneToMany(mappedBy = "usuarios", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties ("usuarios")
	private List<Produtos> produtos;

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

	public String getUsuarioEmail() {
		return usuarioEmail;
	}

	public void setUsuarioEmail(String usuarioEmail) {
		this.usuarioEmail = usuarioEmail;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}
}
