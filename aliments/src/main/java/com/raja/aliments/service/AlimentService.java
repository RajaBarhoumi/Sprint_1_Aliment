package com.raja.aliments.service;

import java.util.List;

import com.raja.aliments.dto.AlimentDTO;
import com.raja.aliments.entities.Famille;
import com.raja.aliments.entities.Aliment;

public interface AlimentService {
	AlimentDTO saveAliment(AlimentDTO p);

	AlimentDTO getAliment(Long id);

	List<AlimentDTO> getAllAliments();

	AlimentDTO updateAliment(AlimentDTO p);

	void deleteAliment(Aliment p);

	void deleteAlimentById(Long id);

	List<Aliment> findByNomAliment(String nom);

	List<Aliment> findByNomAlimentContains(String nom);

	List<Aliment> findByNomPrix(String nom, Double prix);

	List<Aliment> findByFamille(Famille categorie);

	List<Aliment> findByFamilleIdFam(Long id);

	List<Aliment> findByOrderByNomAlimentAsc();

	List<Aliment> trierAlimentNomsCalorie();

	AlimentDTO convertEntityToDto(Aliment produit);
	
	Aliment convertDtoToEntity(AlimentDTO produitDto);


}
