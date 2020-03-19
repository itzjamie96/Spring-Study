package com.word.service;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterService {
	
	private WordDao wordDao;
	
	//생성자
	//<constructor-arg ref="wordDao"/>를 통해서 wordDao받음
	public WordRegisterService(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	//Dao를 받아서 db에 등록
	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already registered");
		}
	}

	//중복 검증 = DB에 있니?
	public boolean verify(String wordKey) {
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true:false;
	}
	
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}

}
