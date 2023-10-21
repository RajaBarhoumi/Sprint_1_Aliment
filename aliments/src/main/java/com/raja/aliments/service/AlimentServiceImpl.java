package com.raja.aliments.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raja.aliments.dto.AlimentDTO;
import com.raja.aliments.entities.Famille;
import com.raja.aliments.repos.AlimentRepository;
import com.raja.aliments.entities.Aliment;

@Service
public class AlimentServiceImpl implements AlimentService {

	@Autowired
	AlimentRepository alimentRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public AlimentDTO saveAliment(AlimentDTO p) {
		return convertEntityToDto(alimentRepository.save(convertDtoToEntity(p)));
	}

	@Override
	public AlimentDTO updateAliment(AlimentDTO p) {
		return convertEntityToDto(alimentRepository.save(convertDtoToEntity(p)));
	}

	@Override
	public AlimentDTO getAliment(Long id) {
		return convertEntityToDto(alimentRepository.findById(id).get());
	}

	@Override
	public List<AlimentDTO> getAllAliments() {
		List<Aliment> aliments = alimentRepository.findAll();
		List<AlimentDTO> listalimentsDto = new ArrayList<>(aliments.size());
		for (Aliment p : aliments)
			listalimentsDto.add(convertEntityToDto(p));
		return listalimentsDto;
		// return
		// produitRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	@Override
	public void deleteAliment(Aliment p) {
		alimentRepository.delete(p);
	}

	@Override
	public void deleteAlimentById(Long id) {
		alimentRepository.deleteById(id);
	}

	@Override
	public List<Aliment> findByNomAliment(String nom) {
		return alimentRepository.findByNomAliment(nom);
	}

	@Override
	public List<Aliment> findByNomAlimentContains(String nom) {
		return alimentRepository.findByNomAlimentContains(nom);
	}

	@Override
	public List<Aliment> findByNomPrix(String nom, Double calorie) {
		return alimentRepository.findByNomCalorie(nom, calorie);
	}

	@Override
	public List<Aliment> findByFamilleIdFam(Long id) {
		return alimentRepository.findByFamilleIdFam(id);
	}

	@Override
	public List<Aliment> findByOrderByNomAlimentAsc() {
		return alimentRepository.findByOrderByNomAlimentAsc();
	}

	@Override
	public List<Aliment> trierAlimentNomsCalorie() {
		return alimentRepository.trierAlimentNomsCalorie();
	}

	@Override
	public List<Aliment> findByFamille(Famille categorie) {
		return alimentRepository.findByFamille(categorie);
	}

	@Override
	public AlimentDTO convertEntityToDto(Aliment aliment) {
		/*
		 * ProduitDTO produitDTO = new ProduitDTO();
		 * produitDTO.setIdProduit(produit.getIdProduit());
		 * produitDTO.setNomProduit(produit.getNomProduit());
		 * produitDTO.setPrixProduit(produit.getPrixProduit());
		 * produitDTO.setDateCreation(produit.getDateCreation());
		 * produitDTO.setCategorie(produit.getCategorie()); return produitDTO;
		 */

		/*
		 * return
		 * ProduitDTO.builder().idProduit(produit.getIdProduit()).nomProduit(produit.
		 * getNomProduit())
		 * .prixProduit(produit.getPrixProduit()).dateCreation(produit.getDateCreation()
		 * ) .categorie(produit.getCategorie()).build();
		 */

		/*
		 * ProduitDTO produitDTO = modelMapper.map(produit, ProduitDTO.class); return
		 * produitDTO;
		 */
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		AlimentDTO alimentDTO = modelMapper.map(aliment, AlimentDTO.class);

		return alimentDTO;
	}

	@Override
	public Aliment convertDtoToEntity(AlimentDTO alimentDto) {
		/*
		 * Produit produit = new Produit();
		 * produit.setIdProduit(produitDto.getIdProduit());
		 * produit.setNomProduit(produitDto.getNomProduit());
		 * produit.setPrixProduit(produitDto.getPrixProduit());
		 * produit.setDateCreation(produitDto.getDateCreation());
		 * produit.setCategorie(produitDto.getCategorie()); return produit;
		 */

		Aliment aliment = new Aliment();
		aliment = modelMapper.map(alimentDto, Aliment.class);
		return aliment;
	}

}
