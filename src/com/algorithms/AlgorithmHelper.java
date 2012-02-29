package com.algorithms;

import java.util.Calendar;
import java.util.Random;

public class AlgorithmHelper {

	public static int[] getRandonNumberArray(int length)
	{
		int[] randomArray = new int[length];
		for(int i=0; i<length; i++){
			randomArray[i] = getRandomNumber();
		}
		return randomArray;
	}


	public static int getRandomNumber()
	{
		Random random = new Random();
		int num = random.nextInt(100);
		return num;
	} 

	public static long getCurrentTimeInMillisecs(){
		Calendar cal = Calendar.getInstance();
		return cal.getTimeInMillis();
	}
	
	public static String getInputString(int[] inputArray){
		String inputString = "";
		int[] inputIntArray = inputArray;
		for(int i=0; i<inputIntArray.length; i++){
			if(i==0)
			{
				inputString = ""+inputIntArray[i];
			}
			else
			inputString = inputString + "," + inputIntArray[i];
		}
		return inputString;
	}	

}
