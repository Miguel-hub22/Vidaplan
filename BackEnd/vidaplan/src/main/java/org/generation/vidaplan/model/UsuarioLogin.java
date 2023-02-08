package org.generation.vidaplan.model;


public class UsuarioLogin {
   private Long id;
   private String nome;
   private String usuarioEmail;
   private String cpf;
   private String endereço;
   private String senha;
   private String token;

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
public String getEndereço() {
	return endereço;
}
public void setEndereço(String endereço) {
	this.endereço = endereço;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
   
}
