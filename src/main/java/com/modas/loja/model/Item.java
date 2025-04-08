package com.modas.loja.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private Double valor;

	@OneToMany(mappedBy = "item")
	private List<ItemImagens> itemImagesList;

	
	public Item() {
		super();
	}

	public Item(Integer id, String nome, String descricao, Double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}

	public List<ItemImagens> getItemImagesList() {
		return itemImagesList;
	}

	public void setItemImagesList(List<ItemImagens> itemImagesList) {
		this.itemImagesList = itemImagesList;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
