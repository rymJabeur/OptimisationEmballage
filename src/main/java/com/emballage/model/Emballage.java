package com.emballage.model;

import java.util.List;

public class Emballage {
	/**
	 * Un emballage contient une liste de carton le libelle d'un emballage est
	 * la suite d'articles des cartons delimite par un separateur
	 */
	private List<Integer> articlesAEmballer;
	private List<Carton> listCarton;
	private int nbCarton;
	private String libelleEmballage;

	public int getNbCarton() {
		return nbCarton;
	}

	public void setNbCarton(int nbCarton) {
		this.nbCarton = nbCarton;
	}

	public List<Integer> getArticlesAEmballer() {
		return articlesAEmballer;
	}

	public void setArticlesAEmballer(List<Integer> articlesAEmballer) {
		this.articlesAEmballer = articlesAEmballer;
	}

	public List<Carton> getListCarton() {
		return listCarton;
	}

	public void setListCarton(List<Carton> listCarton) {
		this.listCarton = listCarton;
	}

	public String getLibelleEmballage() {
		return libelleEmballage;
	}

	public void setLibelleEmballage(String libelleEmballage) {
		this.libelleEmballage = libelleEmballage;
	}

}
