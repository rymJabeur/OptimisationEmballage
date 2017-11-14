package com.emballage.model;

import java.util.ArrayList;
import java.util.List;

public class Carton {
	/**
	 * un carton est constitué dune liste d'artciles et est définie par sa
	 * taille (total des articles) <= tailleMax
	 * 
	 */

	private int tailleCarton;
	private int tailleMax;
	private List<Integer> articles;

	public Carton() {
	}

	public Carton(int taille) {
		this.tailleMax = taille;
		this.tailleCarton = 0;
		articles = new ArrayList<Integer>();
	}

	public int getTailleCarton() {
		return tailleCarton;
	}

	public void setTailleCarton(int taille) {
		this.tailleCarton = taille;
	}

	public List<Integer> getArticles() {
		return articles;
	}

	public void setArticles(List<Integer> articles) {
		this.articles = articles;
	}

	public int getTailleMax() {
		return tailleMax;
	}

	public void setTailleMax(int tailleMax) {
		this.tailleMax = tailleMax;
	}

	public boolean ajouterArticle(Integer article) {
		boolean result = false;
		if (tailleCarton + article <= tailleMax) {
			articles.add(article);
			tailleCarton += article;
			result = true;
		} else {
			result = false;
		}

		return result;
	}

	public void supprimerArticle(Integer article) {
		articles.remove(article);
		tailleCarton -= article;
	}

}
