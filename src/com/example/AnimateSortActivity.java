package com.example;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

public class AnimateSortActivity extends Activity {
	
    int[] inputArray;
    String inputValue;
    int[] outputArray;
    String outputValue;
    String sortType;
    
    TextView id1;
    TextView id2;
    TextView id3;
    TextView id4;
    TextView id5;
    TextView id6;
    TextView id7;
    TextView id8;
    TextView id9;
    TextView id10;
    
    TextView id1View;
    TextView id2View;
    TextView id3View;
    TextView id4View;
    TextView id5View;
    TextView id6View;
    TextView id7View;
    TextView id8View;
    TextView id9View;
    TextView id10View;
    
	Animation fade_name1 ;
    Animation fade_name2 ;
    Animation fade_name3 ;
    Animation fade_name4 ;
    Animation fade_name5 ;
    Animation fade_name6 ;
    Animation fade_name7 ;        
    Animation fade_name8 ;
    Animation fade_name9 ;
    Animation fade_name10 ; 
    
    Animation fade_loop1;
    Animation fade_loop2;
    Animation fade_loop3;
    Animation fade_loop4;
    Animation fade_loop5;
    Animation fade_loop6;
    Animation fade_loop7;
    Animation fade_loop8;
    Animation fade_loop9;
    Animation fade_loop10;
    
    int[] sortedArray;
    int t,u = 0;
    int i,j = 0;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		final Context context = this;
		
		inputArray = getIntent().getIntArrayExtra("inputArray");
        inputValue = getIntent().getStringExtra("inputValue");
        outputArray = getIntent().getIntArrayExtra("outputArray");
        sortType = getIntent().getStringExtra("sortType");
        outputValue = getIntent().getStringExtra("outputValue");
		
        setContentView(R.layout.animatesort);
        
		fade_name1 = AnimationUtils.loadAnimation(this, R.anim.fineanim);
        fade_name2 = AnimationUtils.loadAnimation(this, R.anim.fineanim);
        fade_name3 = AnimationUtils.loadAnimation(this, R.anim.fineanim);
        fade_name4 = AnimationUtils.loadAnimation(this, R.anim.fineanim);
        fade_name5 = AnimationUtils.loadAnimation(this, R.anim.fineanim);
        fade_name6 = AnimationUtils.loadAnimation(this, R.anim.fineanim);
        fade_name7 = AnimationUtils.loadAnimation(this, R.anim.fineanim);        
        fade_name8 = AnimationUtils.loadAnimation(this, R.anim.fineanim);
        fade_name9 = AnimationUtils.loadAnimation(this, R.anim.fineanim);
        fade_name10 = AnimationUtils.loadAnimation(this, R.anim.fineanim);
        
        fade_loop1 = AnimationUtils.loadAnimation(this, R.anim.fineanim2);
        fade_loop2 = AnimationUtils.loadAnimation(this, R.anim.fineanim2);
        fade_loop3 = AnimationUtils.loadAnimation(this, R.anim.fineanim2);
        fade_loop4 = AnimationUtils.loadAnimation(this, R.anim.fineanim2);        
        fade_loop5 = AnimationUtils.loadAnimation(this, R.anim.fineanim2);
        fade_loop6 = AnimationUtils.loadAnimation(this, R.anim.fineanim2);
        fade_loop7 = AnimationUtils.loadAnimation(this, R.anim.fineanim2);
        fade_loop8 = AnimationUtils.loadAnimation(this, R.anim.fineanim2);
        fade_loop9 = AnimationUtils.loadAnimation(this, R.anim.fineanim2);
        fade_loop10 = AnimationUtils.loadAnimation(this, R.anim.fineanim2);        
        
        id1 = (TextView) findViewById(R.id.id1);
        id1.setText(String.valueOf(inputArray[0]));
//        id1.startAnimation(fade_name1);
    	id1View = (TextView) findViewById(R.id.id1View);
    	id1View.setWidth(2* inputArray[0]);
    	
    	id2 = (TextView) findViewById(R.id.id2);
    	id3 = (TextView) findViewById(R.id.id3);
    	id4 = (TextView) findViewById(R.id.id4); 
    	id5 = (TextView) findViewById(R.id.id5);
    	id6 = (TextView) findViewById(R.id.id6);
    	id7 = (TextView) findViewById(R.id.id7);
    	id8 = (TextView) findViewById(R.id.id8);
    	id9 = (TextView) findViewById(R.id.id9);
    	id10 = (TextView) findViewById(R.id.id10);
    	
    	id2View = (TextView) findViewById(R.id.id2View);
    	id3View = (TextView) findViewById(R.id.id3View);
    	id4View = (TextView) findViewById(R.id.id4View); 
    	id5View = (TextView) findViewById(R.id.id5View);
    	id6View = (TextView) findViewById(R.id.id6View);
    	id7View = (TextView) findViewById(R.id.id7View);
    	id8View = (TextView) findViewById(R.id.id8View);
    	id9View = (TextView) findViewById(R.id.id9View);
    	id10View = (TextView) findViewById(R.id.id10View);    	
    	

        id2 = (TextView) findViewById(R.id.id2);
        id2.setText(String.valueOf(inputArray[1]));
//        id1.startAnimation(fade_name1);
    	id2View = (TextView) findViewById(R.id.id2View);
    	id2View.setWidth(2* inputArray[1]);
        id3 = (TextView) findViewById(R.id.id3);
        id3.setText(String.valueOf(inputArray[2]));
//        id1.startAnimation(fade_name1);
    	id3View = (TextView) findViewById(R.id.id3View);
    	id3View.setWidth(2* inputArray[2]);
        id4 = (TextView) findViewById(R.id.id4);
        id4.setText(String.valueOf(inputArray[3]));
//        id1.startAnimation(fade_name1);
    	id4View = (TextView) findViewById(R.id.id4View);
    	id4View.setWidth(2* inputArray[3]);
        id5 = (TextView) findViewById(R.id.id5);
        id5.setText(String.valueOf(inputArray[4]));
//        id1.startAnimation(fade_name1);
    	id5View = (TextView) findViewById(R.id.id5View);
    	id5View.setWidth(2* inputArray[4]);
        id6 = (TextView) findViewById(R.id.id6);
        id6.setText(String.valueOf(inputArray[5]))
        ;
//        id1.startAnimation(fade_name1);
    	id6View = (TextView) findViewById(R.id.id6View);
    	id6View.setWidth(2* inputArray[5]);
        id7 = (TextView) findViewById(R.id.id7);
        id7.setText(String.valueOf(inputArray[6]));
//        id1.startAnimation(fade_name1);
    	id7View = (TextView) findViewById(R.id.id7View);
    	id7View.setWidth(2* inputArray[6]);
        id8 = (TextView) findViewById(R.id.id8);
        id8.setText(String.valueOf(inputArray[7]));
//        id1.startAnimation(fade_name1);
    	id8View = (TextView) findViewById(R.id.id8View);
    	id8View.setWidth(2* inputArray[7]);
        id9 = (TextView) findViewById(R.id.id9);
        id9.setText(String.valueOf(inputArray[8]));
//        id1.startAnimation(fade_name1);
    	id9View = (TextView) findViewById(R.id.id9View);
    	id9View.setWidth(2* inputArray[8]);    	
        id10 = (TextView) findViewById(R.id.id10);
        id10.setText(String.valueOf(inputArray[9]));
//        id1.startAnimation(fade_name1);
    	id10View = (TextView) findViewById(R.id.id10View);
    	id10View.setWidth(2* inputArray[9]);
    	
		int length = inputArray.length;
		sortedArray = inputArray;
		for(i=0; i<10; i++){
			
//			try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}			
			
			for(j=1; j<9;j++){
//				try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
				
				if(sortedArray[j-1]>sortedArray[j])
				{



					
//					getNumberView(j-1).startAnimation(fade_loop1);
            		t = 0;
            		u = 0;
					t = sortedArray[j-1];
					u = sortedArray[j];
					sortedArray[j-1]=u;
					sortedArray[j]=t;  
					getNumberView(j-1).setText(String.valueOf(u));
					getLineView(j-1).setText(String.valueOf(u));
					getLineView(j-1).setBackgroundColor(Color.BLUE);
					getNumberView(j-1).setBackgroundColor(Color.BLUE);
					//					getLineView(j-1).setBackgroundColor(Color.WHITE);
					getNumberView(j).setText(String.valueOf(t));
					getLineView(j).setText(String.valueOf(t));
					getLineView(j).setBackgroundColor(Color.RED);
					getNumberView(j).setBackgroundColor(Color.RED);
					//					getLineView(j).setBackgroundColor(Color.WHITE); 
					
					
					//getNumberView(j-1).startAnimation(fade_loop1);
					fade_loop1.setAnimationListener(new AnimationListener() {
						
						@Override
						public void onAnimationStart(Animation animation) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onAnimationRepeat(Animation animation) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onAnimationEnd(Animation animation) {
							getNumberView(j).setText(String.valueOf(t));
//							getLineView(j).setBackgroundColor(Color.WHITE);
							//getNumberView(j).startAnimation(fade_loop2);

						}
					});
					
					
					        					
				}
				else
				{
//					getNumberView(j-1).setBackgroundColor(Color.WHITE);
					//getNumberView(j-1).startAnimation(fade_loop2);
//					getNumberView(j).setBackgroundColor(Color.WHITE);
					//getNumberView(j).startAnimation(fade_loop2);					
				}
			}
		}
    	
    	
    	
//        fade_name1.setAnimationListener(new AnimationListener() {
//            public void onAnimationEnd(Animation animation) {
//            	
//            	id2.setText(String.valueOf(inputArray[1]));
//            	id2.startAnimation(fade_name2);
//            	id2View = (TextView) findViewById(R.id.id2View);
//            	id2View.setWidth(2* inputArray[1]);            	
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation arg0) {
//                // TODO Auto-generated method stub
//            }
//
//            @Override
//            public void onAnimationStart(Animation arg0) {
//                // TODO Auto-generated method stub
//            }
//        });
//        
//        fade_name2.setAnimationListener(new AnimationListener() {
//            public void onAnimationEnd(Animation animation) {
//            	
//            	id3.setText(String.valueOf(inputArray[2]));
//            	id3.startAnimation(fade_name3);
//            	id3View = (TextView) findViewById(R.id.id3View);
//            	id3View.setWidth(2* inputArray[2]);            	
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation arg0) {
//                // TODO Auto-generated method stub
//            }
//
//            @Override
//            public void onAnimationStart(Animation arg0) {
//                // TODO Auto-generated method stub
//            }
//        });
//        
//        fade_name3.setAnimationListener(new AnimationListener() {
//            public void onAnimationEnd(Animation animation) {
//            	
//            	id4.setText(String.valueOf(inputArray[3]));
//            	id4.startAnimation(fade_name4);
//            	id4View = (TextView) findViewById(R.id.id4View);
//            	id4View.setWidth(2* inputArray[3]);            	
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation arg0) {
//                // TODO Auto-generated method stub
//            }
//
//            @Override
//            public void onAnimationStart(Animation arg0) {
//                // TODO Auto-generated method stub
//            }
//        });
//        
//        fade_name4.setAnimationListener(new AnimationListener() {
//            public void onAnimationEnd(Animation animation) {
//            	
//            	id5.setText(String.valueOf(inputArray[4]));
//            	id5.startAnimation(fade_name5);
//            	id5View = (TextView) findViewById(R.id.id5View);
//            	id5View.setWidth(2* inputArray[4]);            	
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation arg0) {
//                // TODO Auto-generated method stub
//            }
//
//            @Override
//            public void onAnimationStart(Animation arg0) {
//                // TODO Auto-generated method stub
//            }
//        });
//        
//        fade_name5.setAnimationListener(new AnimationListener() {
//            public void onAnimationEnd(Animation animation) {
//            	
//            	id6.setText(String.valueOf(inputArray[5]));
//            	id6.startAnimation(fade_name6);
//            	id6View = (TextView) findViewById(R.id.id6View);
//            	id6View.setWidth(2* inputArray[5]);            	
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation arg0) {
//                // TODO Auto-generated method stub
//            }
//
//            @Override
//            public void onAnimationStart(Animation arg0) {
//                // TODO Auto-generated method stub
//            }
//        });
//        
//        fade_name6.setAnimationListener(new AnimationListener() {
//            public void onAnimationEnd(Animation animation) {
//            	
//            	id7.setText(String.valueOf(inputArray[6]));
//            	id7.startAnimation(fade_name7);
//            	id7View = (TextView) findViewById(R.id.id7View);
//            	id7View.setWidth(2* inputArray[6]);            	
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation arg0) {
//                // TODO Auto-generated method stub
//            }
//
//            @Override
//            public void onAnimationStart(Animation arg0) {
//                // TODO Auto-generated method stub
//            }
//        });
//        
//        fade_name7.setAnimationListener(new AnimationListener() {
//            public void onAnimationEnd(Animation animation) {
//            	
//            	id8.setText(String.valueOf(inputArray[7]));
//            	id8.startAnimation(fade_name8);
//            	id8View = (TextView) findViewById(R.id.id8View);
//            	id8View.setWidth(2* inputArray[7]);            	
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation arg0) {
//                // TODO Auto-generated method stub
//            }
//
//            @Override
//            public void onAnimationStart(Animation arg0) {
//                // TODO Auto-generated method stub
//            }
//        });
//        
//        fade_name8.setAnimationListener(new AnimationListener() {
//            public void onAnimationEnd(Animation animation) {
//            	
//            	id9.setText(String.valueOf(inputArray[8]));
//            	id9.startAnimation(fade_name9);
//            	id9View = (TextView) findViewById(R.id.id9View);
//            	id9View.setWidth(2* inputArray[8]);            	
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation arg0) {
//                // TODO Auto-generated method stub
//            }
//
//            @Override
//            public void onAnimationStart(Animation arg0) {
//                // TODO Auto-generated method stub
//            }
//        });
//        
//        fade_name9.setAnimationListener(new AnimationListener() {
//            public void onAnimationEnd(Animation animation) {
//            	
//            	id10.setText(String.valueOf(inputArray[9]));
//            	id10.startAnimation(fade_name10);
//            	id10View = (TextView) findViewById(R.id.id10View);
//            	id10View.setWidth(2* inputArray[9]);            	
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation arg0) {
//                // TODO Auto-generated method stub
//            }
//
//            @Override
//            public void onAnimationStart(Animation arg0) {
//                // TODO Auto-generated method stub
//            }
//        });
//        
//        fade_name10.setAnimationListener(new AnimationListener() {
//			
//			@Override
//			public void onAnimationStart(Animation animation) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void onAnimationRepeat(Animation animation) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void onAnimationEnd(Animation animation) {
//        		int length = inputArray.length;
//        		sortedArray = inputArray;
//        		for(i=0; i<10; i++){
//        			for(j=1; j<9;j++){
//        				if(sortedArray[j-1]>sortedArray[j])
//        				{
////        						try {
////        							Thread.sleep(1000);
////        						} catch (InterruptedException e) {
////        							// TODO Auto-generated catch block
////        							e.printStackTrace();
////        						}
//        					getLineView(j-1).setBackgroundColor(Color.RED);
//        					getLineView(j).setBackgroundColor(Color.BLUE);
//        					getNumberView(j).startAnimation(fade_loop1);
//                    		t = 0;
//                    		u = 0;
//        					t = sortedArray[j-1];
//        					u = sortedArray[j];
//        					sortedArray[j-1]=u;
//        					sortedArray[j]=t;  
//        					getNumberView(j-1).setText(String.valueOf(u));
//        					getLineView(j-1).setBackgroundColor(Color.WHITE);
//							getNumberView(j).setText(String.valueOf(t));
//							getLineView(j).setBackgroundColor(Color.WHITE); 
//							
//							
//        					//getNumberView(j-1).startAnimation(fade_loop1);
//        					fade_loop1.setAnimationListener(new AnimationListener() {
//								
//								@Override
//								public void onAnimationStart(Animation animation) {
//									// TODO Auto-generated method stub
//									
//								}
//								
//								@Override
//								public void onAnimationRepeat(Animation animation) {
//									// TODO Auto-generated method stub
//									
//								}
//								
//								@Override
//								public void onAnimationEnd(Animation animation) {
//									getNumberView(j).setText(String.valueOf(t));
//									getLineView(j).setBackgroundColor(Color.WHITE);
//									//getNumberView(j).startAnimation(fade_loop2);
//
//								}
//							});
//        					
//        					
//        					        					
//        				}
//        				else
//        				{
//        					getNumberView(j).startAnimation(fade_loop1);
//        				}
//        			}
//        		}
//				
//			}
//		});
        

        

        
//        fade_name10.setAnimationListener(new AnimationListener() {
//            public void onAnimationEnd(Animation animation) {
////            	id1View.setBackgroundColor(Color.YELLOW);
////            	id2View.setBackgroundColor(Color.YELLOW);	
//        		int length = inputArray.length;
//        		sortedArray = inputArray;
//        		
//        		id1View.setBackgroundColor(Color.YELLOW);
//        		id2View.setBackgroundColor(Color.YELLOW);
//        		
//        		if(sortedArray[0] > sortedArray[1])
//        		{
//            		id1View.setBackgroundColor(Color.RED);
//            		id2View.setBackgroundColor(Color.BLUE); 
//            		id1.startAnimation(fade_loop1);
//            		int t = 0;
//					t = sortedArray[0];
//					sortedArray[0]=sortedArray[1];
//					sortedArray[1]=t;
//					id1.setText(String.valueOf(sortedArray[0]));
//					id2.setText(String.valueOf(t));
//					id1View.setBackgroundColor(Color.WHITE);
//					id2View.setBackgroundColor(Color.WHITE);
//        		}
//        		else{
//        			id1.startAnimation(fade_loop1);
//        		}
//        		
//        		fade_loop1.setAnimationListener(new AnimationListener() {
//					
//					@Override
//					public void onAnimationStart(Animation animation) {
//						// TODO Auto-generated method stub
//						
//					}
//					
//					@Override
//					public void onAnimationRepeat(Animation animation) {
//						// TODO Auto-generated method stub
//						
//					}
//					
//					@Override
//					public void onAnimationEnd(Animation animation) {
//		        		if(sortedArray[1] > sortedArray[2])
//		        		{
//		            		id2View.setBackgroundColor(Color.RED);
//		            		id3View.setBackgroundColor(Color.BLUE); 
//		            		id2.startAnimation(fade_loop2);
//		            		int t = 0;
//							t = sortedArray[1];
//							sortedArray[1]=sortedArray[2];
//							sortedArray[2]=t;
//							id2.setText(String.valueOf(sortedArray[1]));
//							id3.setText(String.valueOf(t));
//							id2View.setBackgroundColor(Color.WHITE);
//							id3View.setBackgroundColor(Color.WHITE);					
//		        		}
//		        		else{
//		        			id2.startAnimation(fade_loop2);
//		        		}						
//					}
//				});
//
//        		fade_loop2.setAnimationListener(new AnimationListener() {
//					
//					@Override
//					public void onAnimationStart(Animation animation) {
//						// TODO Auto-generated method stub
//						
//					}
//					
//					@Override
//					public void onAnimationRepeat(Animation animation) {
//						// TODO Auto-generated method stub
//						
//					}
//					
//					@Override
//					public void onAnimationEnd(Animation animation) {
//		        		if(sortedArray[2] > sortedArray[3])
//		        		{
//		            		id3View.setBackgroundColor(Color.RED);
//		            		id4View.setBackgroundColor(Color.BLUE); 
//		            		id3.startAnimation(fade_loop3);
//		            		int t = 0;
//							t = sortedArray[2];
//							sortedArray[2]=sortedArray[3];
//							sortedArray[3]=t;
//							id3.setText(String.valueOf(sortedArray[2]));
//							id4.setText(String.valueOf(t));
//							id3View.setBackgroundColor(Color.WHITE);
//							id4View.setBackgroundColor(Color.WHITE);					
//		        		}
//		        		else{
//		        			id3.startAnimation(fade_loop3);
//		        		}						
//					}
//				});        		
//
//        		fade_loop3.setAnimationListener(new AnimationListener() {
//					
//					@Override
//					public void onAnimationStart(Animation animation) {
//						// TODO Auto-generated method stub
//						
//					}
//					
//					@Override
//					public void onAnimationRepeat(Animation animation) {
//						// TODO Auto-generated method stub
//						
//					}
//					
//					@Override
//					public void onAnimationEnd(Animation animation) {
//		        		if(sortedArray[3] > sortedArray[4])
//		        		{
//		            		id4View.setBackgroundColor(Color.RED);
//		            		id5View.setBackgroundColor(Color.BLUE); 
//		            		id4.startAnimation(fade_loop4);
//		            		int t = 0;
//							t = sortedArray[3];
//							sortedArray[3]=sortedArray[4];
//							sortedArray[4]=t;
//							id4.setText(String.valueOf(sortedArray[3]));
//							id5.setText(String.valueOf(t));
//							id4View.setBackgroundColor(Color.WHITE);
//							id5View.setBackgroundColor(Color.WHITE);					
//		        		}
//		        		else{
//		        			id4.startAnimation(fade_loop4);
//		        		}						
//					}
//				}); 
//        		
//        		
//        		
//        		int i, j,t=0;
//        		for(i = 0; i < length; i++){
//        			for(j = 1; j < (length-i); j++){
////    					(getLineView(j-1)).setBackgroundColor(Color.YELLOW);
////    					(getLineView(j)).setBackgroundColor(Color.YELLOW);
//        				if(sortedArray[j-1] > sortedArray[j]){
////        					(getNumberView(j-1)).setBackgroundColor(Color.RED);
////        					(getNumberView(j)).setBackgroundColor(Color.BLUE);
////        					t = sortedArray[j-1];
////        					sortedArray[j-1]=sortedArray[j];
////        					sortedArray[j]=t;
////        					(getNumberView(j-1)).setWidth(2 * sortedArray[j-i]);
////        					(getNumberView(j)).setWidth(2 * sortedArray[j]);
////        					int x = sortedArray[j-i];
////        					(getNumberView(j-1)).setText(String.valueOf(x));
//        				//	(getLineView(j-1)).setWidth(2 * x);					
////        					(getNumberView(j)).setText(String.valueOf(t));
//        				//	(getLineView(j)).setWidth(2 * t);
////        					(getNumberView(j-1)).setBackgroundColor(Color.WHITE);
////        					(getNumberView(j)).setBackgroundColor(Color.WHITE);        					
//        				}
//        			}
//        		}             	
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation arg0) {
//                // TODO Auto-generated method stub
//            }
//
//            @Override
//            public void onAnimationStart(Animation arg0) {
//                // TODO Auto-generated method stub
//            }
//        });        
        
//        (getNumberView(0)).setText("hjkhkh");
        
//        id1.setBackgroundColor(Color.YELLOW);
//        id2.setBackgroundColor(Color.YELLOW);
        
//		int length = inputArray.length;
//		int[] sortedArray = inputArray;
//		int i, j,t=0;
//		for(i = 0; i < length; i++){
//			for(j = 1; j < (length-i); j++){
//				if(sortedArray[j-1] > sortedArray[j]){
//					t = sortedArray[j-1];
//					sortedArray[j-1]=sortedArray[j];
//					sortedArray[j]=t;
////					(getNumberView(j-1)).setWidth(2 * sortedArray[j-i]);
////					(getNumberView(j)).setWidth(2 * sortedArray[j]);
//					int x = sortedArray[j-i];
//					(getNumberView(j-1)).setText(String.valueOf(x));
//				//	(getLineView(j-1)).setWidth(2 * x);					
//					(getNumberView(j)).setText(String.valueOf(t));
//				//	(getLineView(j)).setWidth(2 * t);										
//				}
//			}
//		}        
        
        
                
//        	TextView id1 = (TextView) findViewById(R.id.id1);
//        	id1.setText(String.valueOf(inputArray[0]));
//        	TextView id2 = (TextView) findViewById(R.id.id2);
//        	id2.setText(String.valueOf(inputArray[1]));
//        	TextView id3 = (TextView) findViewById(R.id.id3);
//        	id3.setText(String.valueOf(inputArray[2]));
//        	TextView id4 = (TextView) findViewById(R.id.id4);
//        	id4.setText(String.valueOf(inputArray[3]));
//        	TextView id5 = (TextView) findViewById(R.id.id5);
//        	id5.setText(String.valueOf(inputArray[4]));
//        	TextView id6 = (TextView) findViewById(R.id.id6);
//        	id6.setText(String.valueOf(inputArray[5]));
//        	TextView id7 = (TextView) findViewById(R.id.id7);
//        	id7.setText(String.valueOf(inputArray[6]));
//        	TextView id8 = (TextView) findViewById(R.id.id8);
//        	id8.setText(String.valueOf(inputArray[7]));
//        	TextView id9 = (TextView) findViewById(R.id.id9);
//        	id9.setText(String.valueOf(inputArray[8]));
//        	TextView id10 = (TextView) findViewById(R.id.id10);
//        	id10.setText(String.valueOf(inputArray[9]));        	
//
//        	TextView id1View = (TextView) findViewById(R.id.id1View);
//        	id1View.setWidth(2* inputArray[0]);
//        	TextView id2View = (TextView) findViewById(R.id.id2View);
//        	id2View.setWidth(2* inputArray[1]);
//        	TextView id3View = (TextView) findViewById(R.id.id3View);
//        	id3View.setWidth(2* inputArray[2]);
//        	TextView id4View = (TextView) findViewById(R.id.id4View);
//        	id4View.setWidth(2* inputArray[3]); 
//        	TextView id5View = (TextView) findViewById(R.id.id5View);
//        	id5View.setWidth(2* inputArray[4]);
//        	TextView id6View = (TextView) findViewById(R.id.id6View);
//        	id6View.setWidth(2* inputArray[5]); 
//        	TextView id7View = (TextView) findViewById(R.id.id7View);
//        	id7View.setWidth(2* inputArray[6]);
//        	TextView id8View = (TextView) findViewById(R.id.id8View);
//        	id8View.setWidth(2* inputArray[7]); 
//        	TextView id9View = (TextView) findViewById(R.id.id9View);
//        	id9View.setWidth(2* inputArray[8]);
//        	TextView id10View = (TextView) findViewById(R.id.id10View);
//        	id10View.setWidth(2* inputArray[9]);         	
    }
    
	public void animate(int inputArray[])
	{
		int length = inputArray.length;
		int[] sortedArray = inputArray;
		int i, j,t=0;
		for(i = 0; i < length; i++){
			for(j = 1; j < (length-i); j++){
				if(sortedArray[j-1] > sortedArray[j]){
					t = sortedArray[j-1];
					sortedArray[j-1]=sortedArray[j];
					sortedArray[j]=t;
				}
			}
		}		
	} 
	
	public TextView getNumberView(int index)
	{
		switch(index){
		case 0:
			return (TextView) findViewById(R.id.id1);
		case 1:
			return (TextView) findViewById(R.id.id2);
		case 2:
			return (TextView) findViewById(R.id.id3);
		case 3:
			return (TextView) findViewById(R.id.id4);			
		case 4:
			return (TextView) findViewById(R.id.id5);
		case 5:
			return (TextView) findViewById(R.id.id6);
		case 6:
			return (TextView) findViewById(R.id.id7);
		case 7:
			return (TextView) findViewById(R.id.id8);
		case 8:
			return (TextView) findViewById(R.id.id9);
		case 9:
			return (TextView) findViewById(R.id.id10);
		}
		return (TextView) findViewById(R.id.id1);
	}
	
	public TextView getLineView(int index)
	{
		switch(index){
		case 0:
			return (TextView) findViewById(R.id.id1View);
		case 1:
			return (TextView) findViewById(R.id.id2View);
		case 2:
			return (TextView) findViewById(R.id.id3View);
		case 3:
			return (TextView) findViewById(R.id.id4View);			
		case 4:
			return (TextView) findViewById(R.id.id5View);
		case 5:
			return (TextView) findViewById(R.id.id6View);
		case 6:
			return (TextView) findViewById(R.id.id7View);
		case 7:
			return (TextView) findViewById(R.id.id8View);
		case 8:
			return (TextView) findViewById(R.id.id9View);
		case 9:
			return (TextView) findViewById(R.id.id10View);
		}
		return (TextView) findViewById(R.id.id1View);
		
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
//            PathEffect pe = new DashPathEffect(new float[] {10, 5, 5, 5}, 3);
//            paint.setPathEffect(pe);
            for(int x = 0; x<20; x++){
            canvas.drawLine(0, 20, 240, 20, paint);
            }
//            canvas.drawLine(0, 40, 140, 40, paint);
//            canvas.drawLine(0, 60, 200, 60, paint);
//            canvas.drawLine(0, 80, 10, 80, paint);
//            canvas.drawLine(0, 100, 250, 100, paint);
//            canvas.drawLine(0, 120, 100, 120, paint);
//            canvas.drawPath(path, paint);
        }
        
        
        
        
/*        @Override
        public boolean onTouchEvent(final MotionEvent motionEvent){
            //path.lineTo(motionEvent.getX(), motionEvent.getY());
            path.moveTo(4, -10);
            path.lineTo(20, 0);
            path.lineTo(-9, 0);
            path.close();
            path.offset(60, 40);
            return true;
        }
*/
//        private void createRoundRect(Canvas canvas) {
//            RectF rectangle = new RectF( 10, 15, 25, 25);
//            canvas.drawRoundRect(rectangle,1,1,paint);
//        }
//
//        private void usingPath(Canvas canvas) {
//            Path path = new Path();
//            path.moveTo(4, -10);
//            path.lineTo(20, 0);
//            path.lineTo(-9, 0);
//            path.close();
//            path.offset(60, 40);
//            canvas.drawPath(path, paint);
//        }

    }
}