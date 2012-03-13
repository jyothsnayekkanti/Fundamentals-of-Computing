package com.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AnimateSortActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		final Context context = this;
        setContentView(R.layout.animation);
        
	    Button animateButton = (Button)findViewById(R.id.animateButton);
	    animateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		        setContentView(new DrawView(context));			
			}
		});        
        
//        setContentView(new DrawView(this));
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
            canvas.drawLine(0, 20, 240, 20, paint);
            canvas.drawLine(0, 40, 140, 40, paint);
            canvas.drawLine(0, 60, 200, 60, paint);
            canvas.drawLine(0, 80, 10, 80, paint);
            canvas.drawLine(0, 100, 250, 100, paint);
            canvas.drawLine(0, 120, 100, 120, paint);
            canvas.drawRect(0, 10, 60, 140, paint);
            //canvas.drawPath(path, paint);
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