package com.word;

public class WordSet {

	//단어의 key와 value를 받아서 한 세트로 만들어주는 객체
	
	private String wordKey;
	private String wordValue;
	
	public WordSet(String wordKey, String wordValue) {
		this.wordKey = wordKey;
		this.wordValue = wordValue;
	}

	public String getWordKey() {
		return wordKey;
	}

	public void setWordKey(String wordKey) {
		this.wordKey = wordKey;
	}

	public String getWordValue() {
		return wordValue;
	}

	public void setWordValue(String wordValue) {
		this.wordValue = wordValue;
	}
	
	
	
	

}
