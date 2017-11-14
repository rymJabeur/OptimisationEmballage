package com.emballage.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.emballage.exceptions.ListeArticleInvalideException;
import com.emballage.model.Carton;
import com.emballage.model.Emballage;
import com.emballage.services.EmballageService;

@Component
public class EmballageServiceImpl implements EmballageService {

	private static Logger logger = Logger.getLogger(EmballageServiceImpl.class);

	/**
	 * permet d'avoir l'emballage optimal
	 */
	public Emballage emballerCartons(List<Integer> articles, int tailleMaxCarton, String separateur) {
		logger.info("Debut de l'emballage");
		Emballage emballage = new Emballage();

		if (articles != null && articles.size() > 0) {
			emballage.setArticlesAEmballer(articles);
			List<Carton> cartons = createCartons(articles, tailleMaxCarton);

			emballage.setListCarton(cartons);
			emballage.setNbCarton(cartons.size());

			String libelle = getLibelleEmbalage(cartons, separateur);

			emballage.setLibelleEmballage(libelle);
		}
		logger.info("Fin emballage");

		return emballage;
	}

	/**
	 * recupère la suite séparé de cartons delimité par un separateur
	 * 
	 * @param cartons
	 * @param separateur
	 * @return
	 */
	private String getLibelleEmbalage(List<Carton> cartons, String separateur) {
		StringBuilder result = new StringBuilder();
		for (Carton carton : cartons) {
			if (!"".equals(result.toString())) {
				result.append(separateur);
			}
			for (int i : carton.getArticles()) {
				result.append(i);
			}
		}

		return result.toString();
	}

	/**
	 * creation de la liste de carton d'un emballage
	 * 
	 * @param articles
	 * @param tailleCartonMax
	 * @return
	 */
	public List<Carton> createCartons(List<Integer> articles, Integer tailleLimit) {
		Collections.sort(articles, Collections.reverseOrder());
		List<Carton> cartons = new ArrayList<Carton>();
		cartons.add(new Carton(tailleLimit));

		for (Integer article : articles) {

			boolean putArticle = false;
			int currentCarton = 0;
			while (!putArticle) {
				if (currentCarton == cartons.size()) {
					// nouveau carton
					Carton carton = new Carton(tailleLimit);
					carton.ajouterArticle(article);
					cartons.add(carton);
					putArticle = true;
				} else if (cartons.get(currentCarton).ajouterArticle(article)) {
					// ajout dans le meme carton
					putArticle = true;
				} else {
					
					currentCarton++;
				}
			}
		}

		return cartons;
	}

	public void verificationArticles(String articles) {
		if (articles == null || articles.isEmpty() || !Pattern.matches("[0-9]+", articles)) {
			throw new ListeArticleInvalideException();
		}
	}

}
