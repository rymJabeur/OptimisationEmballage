package com.emballage.app;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;

import com.emballage.model.Emballage;
import com.emballage.services.EmballageService;

public class EmballageApp {
	private static Logger logger = Logger.getLogger(EmballageApp.class);

	private static String separateur = "/" ;
	private static int tailleMax = 10;
	

	
	public static void main(String[] args) {
		try {

			EmballageService emballageService = ServiceLocator.getEmballageService();
			Integer[] articles = { 1, 6, 3, 8, 2, 4, 6, 1, 9, 8, 5, 5, 7, 3, 7 };
			Emballage result = emballageService.emballerCartons(new ArrayList(Arrays.asList(articles)), tailleMax,
					separateur);
			System.out.println("Le resultat de l'emballage est : " + result.getLibelleEmballage()
					+ "=> le nombre de cartons utilise est : " + result.getNbCarton());

		} catch (Exception e) {
			logger.error("Une erreur est survenue : " + e.getMessage());
		}
	}
}
