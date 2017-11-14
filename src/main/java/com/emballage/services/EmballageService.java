package com.emballage.services;


import java.util.List;
import org.springframework.stereotype.Service;

import com.emballage.model.Emballage;

@Service
public interface EmballageService {

	public Emballage emballerCartons(List<Integer> articles, int tailleMax, String separateur);
	public void verificationArticles(String listArticle);
}
