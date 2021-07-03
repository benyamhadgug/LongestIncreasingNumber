package com.simplilearn;

import java.util.ArrayList;
import java.util.List;

public class Main {
	private RandomNumberFiller numberFiller;
	public final static int  ARRAY_SIZE=10;
	private Integer[] numbers;
	public static void main(String[] args) {
		Main main= new Main(); 
		System.out.println("Generated Array is : " + main);
		Integer[] result= main.getLongestIncreasingSequence();
		main.display(result);
	}
	
	public Main() {
		this.numbers= new Integer[ARRAY_SIZE];
		this.numberFiller=new RandomNumberFiller();
		this.numberFiller.fillRandomNumbers(this.numbers);
	}
	public Integer[] getLongestIncreasingSequence() {
		Integer[] result=this.getIncreasingSequence(this.numbers, 0);
		for(int i=1; i < this.numbers.length; i++) {
			Integer[] temp= this.getIncreasingSequence(this.numbers, i);
			if(result.length < temp.length) {
				result=temp;
			}
		}
		return result;
	}
	private Integer[] getIncreasingSequence(Integer[] numbers, int starting) {
		
		List<Integer> result= new ArrayList();
		result.add(numbers[starting]);
		if(numbers.length <= 1)
			return result.toArray(new Integer[result.size()]);
		
		for(int i= starting + 1; i < numbers.length; i++) {
			if(numbers[i] < result.get(result.size()-1))
				continue; 
			result.add(numbers[i]);
		}
		return result.toArray(new Integer[result.size()]);
	}
	private void display(Integer[] numbers) {
		System.out.print("Longest Increasing Sequence is : ");
		if(numbers == null || numbers.length <= 0 ) {
			System.out.println("[]");
			return;
		}
		System.out.print("[");
		for(int i=0; i < numbers.length; i++) 
			System.out.print(numbers[i] + ", ");
		System.out.println("]");
	}
	@Override
	public String toString() {
		StringBuilder builder= new StringBuilder( "Array randomly generated : [" + numbers[0]); 
		for(Integer num: this.numbers)
			builder.append(", " + num );
		builder.append("]");
		return builder.toString();
	}
}
