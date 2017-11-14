package com.emballage.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.emballage.exceptions.ListeArticleInvalideException;
import com.emballage.model.Emballage;
import com.emballage.services.EmballageService;

@Controller
@Scope("session")
public class EmballageController extends AbstractController {
	private static Logger logger = Logger.getLogger(EmballageController.class);
	private static String separateur = "/";
	private static Integer tailleMax = 10;

	@Autowired
	EmballageService emballageService;

	private String listArticles;
	private String resultatEmballage;

	public String optimiserEmballageAction() {
		try {
			resultatEmballage ="";
			
			emballageService.verificationArticles(listArticles);
			List<Integer> articles = convertToList(listArticles);
			Emballage result = emballageService.emballerCartons(articles, tailleMax, separateur);
			if (result != null && result.getLibelleEmballage() != null ) {
				resultatEmballage = getMessage("resultat.emballlage", result.getLibelleEmballage(),
						result.getNbCarton());
			}
			
		} catch (ListeArticleInvalideException e) {
			addErrorMessage(e.getMessage());
			logger.error(e.getMessage());
		} catch (Exception e) {
			addErrorMessageKey("error.default.message");
			logger.error(e.getMessage(), e);
		}
		
		return "index";
	}

	public List<Integer> convertToList(String articles) {
		List<Integer> listArticles = new ArrayList<Integer>();
		for (int i = 0; i < articles.length(); i++) {
			listArticles.add(Integer.valueOf(String.valueOf(articles.charAt(i))));
		}

		return listArticles;
	}

	public String getListArticles() {
		return listArticles;
	}

	public void setListArticles(String listArticles) {
		this.listArticles = listArticles;
	}

	public EmballageService getEmballageService() {
		return emballageService;
	}

	public void setEmballageService(EmballageService emballageService) {
		this.emballageService = emballageService;
	}

	public String getResultatEmballage() {
		return resultatEmballage;
	}

	public void setResultatEmballage(String resultatEmballage) {
		this.resultatEmballage = resultatEmballage;
	}

}
