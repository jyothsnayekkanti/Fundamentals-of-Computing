package com.algorithms;

import java.util.Calendar;
import java.util.Random;
import java.util.StringTokenizer;

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
	
	public static String getInputString(int[] inputArray,String token){
		String inputString = "";
		int[] inputIntArray = inputArray;
		for(int i=0; i<inputIntArray.length; i++){
			if(i==0)
			{
				System.out.println("inputIntArray["+i+"]"+inputIntArray[i]);
                inputString = ""+inputIntArray[i];
			}
			else
			inputString = inputString + token + inputIntArray[i];
		}
		return inputString;
	}

    public static int[] getInputArray(String inputText, String token)
    {
        int[] array;
        System.out.println("inputTextinputTextinputTextinputText"+inputText);
        if(token.equalsIgnoreCase(""))
        {
            array = new int[inputText.length()];
            for(int i=0; i< inputText.length(); i++)
            {
                System.out.println("inputText.charAt("+i+")"+inputText.charAt(i));
                array[i] =  Integer.parseInt(""+inputText.charAt(i));
            }
            
            for(int i=0; i<array.length; i++)
            {
                System.out.println(i+"th element is : "+array[i]);
            }
            return array;
        }
        else{
        StringTokenizer st = new StringTokenizer(inputText, token);
        array = new int[st.countTokens()];
        int i = 0;
        while(st.hasMoreElements())
        {
            array[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        return array;
        }
    }

}
