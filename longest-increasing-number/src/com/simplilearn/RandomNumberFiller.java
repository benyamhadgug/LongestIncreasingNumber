package com.simplilearn;

import java.util.Random;

public class RandomNumberFiller {
	
	public void fillRandomNumbers(Integer[] numbers) {
		if(numbers == null || numbers.length <= 0 )
			return;
		Random random= new Random();
		random.setSeed(System.currentTimeMillis());
		for(int i=0; i < numbers.length; i++) {
			numbers[i]= random.nextInt(100);
		}
				
	}
}
