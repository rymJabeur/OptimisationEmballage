package com.emballage.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emballage.model.Emballage;
import com.emballage.services.EmballageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmballageTest {
	private static String separateur = "/";
	private static int tailleMax = 10;

	@Autowired
	EmballageService emballageService;

	@Test
	public void test1() {
		Integer[] articles = {1};
		Emballage result = emballageService.emballerCartons(new ArrayList(Arrays.asList(articles)), tailleMax,
				separateur);
		Assert.assertEquals(1, result.getNbCarton());
	}

	@Test
	public void test2() {
		Integer[] articles = { 9, 9, 9 };
		Emballage result = emballageService.emballerCartons(new ArrayList(Arrays.asList(articles)), tailleMax,
				separateur);
		Assert.assertEquals(3, result.getNbCarton());
	}

	@Test
	public void test3() {
		Integer[] articles = { 1, 6, 3, 8, 4, 1, 6, 8, 9, 5, 2, 5, 7, 7, 3 };
		Emballage result = emballageService.emballerCartons(new ArrayList(Arrays.asList(articles)), tailleMax,
				separateur);

		Assert.assertEquals(8, result.getNbCarton());
	}

	@Test
	public void test4() {
		Integer[] articles = new Integer[100];
		for (int i = 0; i < 100; i++) {
			articles[i] = new Random().nextInt(9 - 1);
		}

		int total = getMinCarton(new ArrayList(Arrays.asList(articles)));
		Emballage result = emballageService.emballerCartons(new ArrayList(Arrays.asList(articles)), tailleMax,
				separateur);
		Assert.assertEquals(total, result.getNbCarton());
	}

	public Integer getMinCarton(List<Integer> articles) {

		Double totalArticle = 0d;
		for (Integer i : articles) {
			totalArticle += i;
		}

		Double nbCartonOptimal = totalArticle / tailleMax;

		return (int) Math.ceil(nbCartonOptimal);
	}
}
