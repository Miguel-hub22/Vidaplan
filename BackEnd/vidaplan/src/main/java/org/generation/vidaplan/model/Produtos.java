package org.generation.vidaplan.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class Produtos {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank (message = "O campo nome é obrigatório")
	@Size (min = 3, max = 40, message = "O campo nome deve ter no minimo 03 caracteres")
	public String nome;
	@NotBlank (message = "O campo descrição é obrigatório")
	@Size (min = 10, max = 1500, message = "O campo descrição deve ter no minimo 10 caracteres")
	public String descricao;
	@NotNull
	//@NumberFormat(style = Style.CURRENCY)
	public BigDecimal preco;
	@NotBlank (message = "O campo embalagem é obrigatório")
	@Size (min = 4, max = 30, message = "O campo embalagem deve ter no minimo 10 caracteres")
	public String embalagem;
	@NotBlank (message = "O campo dicas de plantação é obrigatório")
	@Size (min = 10, max = 500, message = "O campo dicas de plantação deve ter no minimo 10 caracteres")
	public String dicasPlantacao;
	@NotBlank(message = "O campo região é obrigatorio!")
	@Size(min = 3, max = 15, message = "O atributo regiao deve conter no minimo 03 caracteres")
	public String regiao;
	
	@ManyToOne
	@JsonIgnoreProperties ("produtos")
	private Categorias categorias;
	@ManyToOne
	@JsonIgnoreProperties ("produtos")
	private Usuario usuario;
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public String getEmbalagem() {
		return embalagem;
	}
	public void setEmbalagem(String embalagem) {
		this.embalagem = embalagem;
	}
	public String getDicasPlantacao() {
		return dicasPlantacao;
	}
	public void setDicasPlantacao(String dicasPlantacao) {
		this.dicasPlantacao = dicasPlantacao;
	}
	public Categorias getCategorias() {
		return categorias;
	}
	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	
}
	
	