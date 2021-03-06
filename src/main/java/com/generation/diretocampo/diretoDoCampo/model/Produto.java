package com.generation.diretocampo.diretoDoCampo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity							// Anotação que cria uma tabela com os atributos da classe
@Table(name = "tb_produto")		// Anotação que cria nomea a tabela
public class Produto {
  
	@Id														// Criando uma chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)		// Auto_Increment (1, 2, 3 ....)
	private long id;										// Criando uma coluna chamada ID do tipo bitInt
 
	@NotNull				
	@Size(max = 50, message = "Valor minimo de 1 caracter e máximo 50")
	private String nome;
	   
	@NotNull
	@Size(max = 200, message = "Valor minimo de 1 caracter e máximo 200")
	private String descricao;
	       
	@NotNull
	@Size(max = 50, message = "Valor minimo de 1 caracter e máximo 50")
	private String categoria;	// Populado por uma Caixa de Combinação no Front
	
	@NotNull(message = "Esse campo não pode ser nulo")
	private float preco;
	
	@NotNull(message = "Esse campo não pode ser nulo")
	private float quantidade;
				
	private boolean status;		// Se o produto está disponivel
	
	@NotBlank					// Não aceita Nulo ou " "
	private String imagem;
			
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());
		
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public float getPreco() {
		return preco;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public boolean isStatus() {
		return status;
	}

	public String getImagem() {
		return imagem;
	}

	public Date getData() {
		return data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
