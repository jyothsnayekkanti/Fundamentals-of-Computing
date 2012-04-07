package com.example;

import java.util.StringTokenizer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.algorithms.AlgorithmHelper;


public class AnimateConverterActivity extends Activity {
    
    TextView inputvalue;
    TextView positionset;
    TextView calculate;
    TextView result;
    TextView converttosystem;
    TextView steps;
    TextView systemresult;
    
    int inputTypeBase;
    String inputValue;
    int outputType;
    String outputValue;
    int decimalValue;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inputTypeBase = getIntent().getIntExtra("inputType",2);
        inputValue = getIntent().getStringExtra("inputValue");
        outputType = getIntent().getIntExtra("outputType", 2);
        decimalValue = getIntent().getIntExtra("decimalValue", 2);
        outputValue = getIntent().getStringExtra("outputValue");
        
        setContentView(R.layout.animateconverter);
//		 setContentView(new DrawView(context));

        inputvalue = (TextView) findViewById(R.id.inputvalue);
        positionset = (TextView) findViewById(R.id.positionset);
        calculate = (TextView) findViewById(R.id.calculate);
        result = (TextView) findViewById(R.id.result);
        converttosystem = (TextView) findViewById(R.id.converttosystem);
        steps = (TextView) findViewById(R.id.steps);
        
        steps.setText("  ");
        
        systemresult = (TextView) findViewById(R.id.systemresult);


        if(inputTypeBase == 10)
        {
        	inputvalue.setText("");
        }
        else if(inputTypeBase != 16)
        	inputvalue.setText(AlgorithmHelper.getInputString(AlgorithmHelper.getInputArray(inputValue,"")," | "));        
        else
        	inputvalue.setText(getInputString(getInputStringArray(inputValue,"")," | "));	




		final Animation fade_name1 = AnimationUtils.loadAnimation(this, R.anim.fineanim);
        final Animation fade_name2 = AnimationUtils.loadAnimation(this, R.anim.fineanim);
        final Animation fade_name3 = AnimationUtils.loadAnimation(this, R.anim.fineanim);
        final Animation fade_name4 = AnimationUtils.loadAnimation(this, R.anim.fineanim);
        final Animation fade_name5 = AnimationUtils.loadAnimation(this, R.anim.fineanim);
        final Animation fade_name6 = AnimationUtils.loadAnimation(this, R.anim.fineanim);
        final Animation fade_name7 = AnimationUtils.loadAnimation(this, R.anim.fineanim);

        if(inputTypeBase == 10)
        {
            result.setText(""+decimalValue);
            result.startAnimation(fade_name4);        	
        }
        else
        {
        	inputvalue.startAnimation(fade_name1);
        }

        fade_name1.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                positionset.setText(getPositionText(inputTypeBase,inputValue.length()));
                positionset.startAnimation(fade_name2);
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            	// Do nothing.
            }

            @Override
            public void onAnimationStart(Animation arg0) {
            	// Do nothing.
            }
        });

        fade_name2.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                calculate.setText(getCalculationStep(getInputStringArray(inputValue,""),getPositionArray(inputTypeBase)));
                calculate.startAnimation(fade_name3);
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            	// Do nothing.
            }

            @Override
            public void onAnimationStart(Animation arg0) {
            	// Do nothing.
            }
        });

        fade_name3.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                result.setText(""+decimalValue);
                result.startAnimation(fade_name4);
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            	// Do nothing.
            }

            @Override
            public void onAnimationStart(Animation arg0) {
            	// Do nothing.
            }
        });

        fade_name4.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
            	if(outputType != 10){            	
                converttosystem.setText(outputType + " | "+decimalValue);
                converttosystem.startAnimation(fade_name5);
            	}
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            	// Do nothing.
            }

            @Override
            public void onAnimationStart(Animation arg0) {
            	// Do nothing.
            }
        });
        
        fade_name5.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {

                int quotient = decimalValue/outputType;
                int reminder = decimalValue%outputType;

                StringBuffer step = new StringBuffer("");
                step.append("      | "+quotient+" - "+reminder);
                while(quotient != 0){
                    reminder = quotient%outputType;
                    quotient = quotient/outputType;
                    step.append("\n");
                    step.append("      | "+quotient+" - "+reminder);
                }

                steps.setText(step.toString());
                steps.startAnimation(fade_name6);
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            	// Do nothing.
            }

            @Override
            public void onAnimationStart(Animation arg0) {
            	// Do nothing.
            }
        });
        
        fade_name6.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                systemresult.setText(outputValue);
                systemresult.startAnimation(fade_name7);
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            	// Do nothing.
            }

            @Override
            public void onAnimationStart(Animation arg0) {
            	// Do nothing.
            }
        });
        

    }

    final static String[] binaryPositionArray = new String[]{"1","2","4","8","16","32","64","128","256","512"};
    final static String[] quaternaryPositionArray = new String[]{"1","4","16","64","256","1024","4096","8192","16384","65536"};
    final static String[] octalPositionArray = new String[]{"1","8","64","512","4096","32768","262144","2097152","16777216","134217728"};
    final static String[] decimalPositionArray = new String[]{"1","10","100","1000","10000","100000","1000000","10000000","100000000","1000000000"};
    final static String[] hexadecimalPositionArray = new String[]{"1","16","256","4096","65536","1048576","16777216","268435456","4294967296","68719476736"};

    private String getCalculationStep(String[] inputArray, String[] postionArray){
        String calculationStep = "";
        int j = inputArray.length-1;
        for(int i=0; i<inputArray.length ; i++){
            if(i==0)
            {
                calculationStep = ""+ inputArray[i] + " * " + postionArray[j];
            }
            else{
            	calculationStep = calculationStep + " + " + inputArray[i] + " * " + postionArray[j];
            }
            j--;
        }
        return calculationStep;
    }

    private String[] getPositionArray(int inputTypeBase)
    {
        String[] positionArray = new String[]{"1","2","4","8","16","32","64","128","256","512"};
        switch(inputTypeBase)
        {
            case 2:
                positionArray =   binaryPositionArray;
                break;
            case 4:
                positionArray =   quaternaryPositionArray;
                break;
            case 8:
                positionArray =   octalPositionArray;
                break;
            case 10:
                positionArray =   decimalPositionArray;
                break;
            case 16:
                positionArray =   hexadecimalPositionArray;
                break;
        }
        return positionArray;
    }

    private String getPositionText(int inputTypeBase, int inputValueSize){
        String positionText = "";
        String[] positionArray = new String[]{"1","2","4","8","16","32","64","128","256","512"};

        positionArray = getPositionArray(inputTypeBase);

        for(int i=(inputValueSize-1); i>=0; i--)
        {
            if(i==inputValueSize-1){
                positionText = ""+positionArray[i];
            }
            else
            positionText = positionText +   " | " +  positionArray[i] ;
        }
        return positionText;
    }

    public class DrawView extends View {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Path path = new Path();
        public DrawView(Context context) {
            super(context);
            paint.setColor(Color.YELLOW); 
        }

        @Override
        public void onDraw(Canvas canvas){
            paint.setStrokeWidth(3);
            for(int x = 0; x<20; x++){
            canvas.drawLine(0, 20, 240, 20, paint);
          canvas.drawLine(0, 40, 140, 40, paint);
          canvas.drawLine(0, 60, 200, 60, paint);
          canvas.drawLine(0, 80, 10, 80, paint);
          canvas.drawLine(0, 100, 250, 100, paint);
          canvas.drawLine(0, 120, 100, 120, paint);            
            }
        }
    }
    
    public static int[] getInputIntArray(String inputText, String token)
    {
        int[] array;
        if(token.equalsIgnoreCase(""))
        {
            array = new int[inputText.length()];
            for(int i=0; i< inputText.length(); i++)
            {
                array[i] =  Integer.parseInt(""+inputText.charAt(i));
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
    
    public static String[] getInputStringArray(String inputText, String token)
    {
        String[] array;
        if(token.equalsIgnoreCase(""))
        {
            array = new String[inputText.length()];
            for(int i=0; i< inputText.length(); i++)
            {
                array[i] =  ""+inputText.charAt(i);
            }
            
            return array;
        }
        else{
        StringTokenizer st = new StringTokenizer(inputText, token);
        array = new String[st.countTokens()];
        int i = 0;
        while(st.hasMoreElements())
        {
            array[i] = st.nextToken();
            i++;
        }
        return array;
        }
    }
 
    
	public static String getInputString(String[] inputArray,String token){
		String inputString = "";
		String[] inputIntArray = inputArray;
		for(int i=0; i<inputIntArray.length; i++){
			if(i==0)
			{
                inputString = ""+inputIntArray[i];
			}
			else
			inputString = inputString + token + inputIntArray[i];
		}
		return inputString;
	}    
    
}