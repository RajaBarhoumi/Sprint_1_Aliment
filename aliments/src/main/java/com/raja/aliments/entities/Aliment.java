package com.raja.aliments.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Aliment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long idAliment;
	private String nomAliment;
	private Double calorieAliment;
	private Double lipideAliment;
	private Double glucideAliment;
	private Double proteineAliment;

	@ManyToOne
	private Famille famille;
	
	public Long getIdAliment() {
		return idAliment;
	}

	public void setIdAliment(Long idAliment) {
		this.idAliment = idAliment;
	}

	public String getNomAliment() {
		return nomAliment;
	}

	public void setNomAliment(String nomAliment) {
		this.nomAliment = nomAliment;
	}

	public Double getCalorieAliment() {
		return calorieAliment;
	}

	public void setCalorieAliment(Double calorieAliment) {
		this.calorieAliment = calorieAliment;
	}

	public Double getLipideAliment() {
		return lipideAliment;
	}

	public void setLipideAliment(Double lipideAliment) {
		this.lipideAliment = lipideAliment;
	}

	public Double getGlucideAliment() {
		return glucideAliment;
	}

	public void setGlucideAliment(Double glucideAliment) {
		this.glucideAliment = glucideAliment;
	}

	public Double getProteineAliment() {
		return proteineAliment;
	}

	public void setProteineAliment(Double proteineAliment) {
		this.proteineAliment = proteineAliment;
	}

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	public Aliment() {
		super();
	}

	public Aliment(String nomAliment, Double calorieAliment, Double lipideAliment, Double glucideAliment,
			Double proteineAliment) {
		super();
		this.nomAliment = nomAliment;
		this.calorieAliment = calorieAliment;
		this.lipideAliment = lipideAliment;
		this.glucideAliment = glucideAliment;
		this.proteineAliment = proteineAliment;
	}

	


	

}
