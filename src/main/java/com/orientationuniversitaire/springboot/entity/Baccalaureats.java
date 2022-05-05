package com.orientationuniversitaire.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bac")
public class Baccalaureats {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_bac")
	@Column(name = "id_bac")
	private int id;

	@Column(name = "nom_bac")
	private String nom;

	@Column(name = "description_bac")
	private String description;

	
	
	public Baccalaureats() {
	}

	public Baccalaureats(int id, String nom, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
