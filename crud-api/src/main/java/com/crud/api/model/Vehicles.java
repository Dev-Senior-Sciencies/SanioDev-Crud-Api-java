package com.crud.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Vehicles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column(nullable = false)
	public String nome;
	
	@Column(nullable = false)
	public String placa;
	
	@Column(nullable = false, unique = true)
	public String marca_name;
	
	@Column(nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.TABLE)
	public Long marca_Id;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca_name() {
		return marca_name;
	}

	public void setMarca_name(String marca_name) {
		this.marca_name = marca_name;
	}

	public Long getMarca_Id() {
		return marca_Id;
	}

	public void setMarca_Id(Long marca_Id) {
		this.marca_Id = marca_Id;
	}
	
}
