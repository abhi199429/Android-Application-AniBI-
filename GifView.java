package com.example.prayas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

import java.io.InputStream;

public class GifView extends View
{
	private InputStream gifInputStream;
	public Movie gifMovie;
	public long movieDuration;
	private int movieWidth,movieHeight;
	private long movieStart;
	
	
	public GifView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context);
	}
	
	public GifView(Context context, AttributeSet attrs) 
	{
			super(context, attrs);
			init(context);
	}
	
	public GifView(Context context, AttributeSet attrs, int defStyle) 
	{
			super(context, attrs, defStyle);
			init(context);
			}
	private void init(Context context) 
	{
		gifInputStream=context.getResources().openRawResource(R.drawable.birdicon);
		gifMovie=Movie.decodeStream(gifInputStream);
		movieHeight=gifMovie.height();
		movieWidth=gifMovie.width();
		movieDuration=gifMovie.duration();
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		setMeasuredDimension(movieWidth,movieHeight);
	}
	
	public int getMovieWidth() {
		return movieWidth;
	}
	
	public int getMovieHeight() {
		return movieHeight;
	}
	
	public long getMovieDuration() {
		return movieDuration;
	}
	@Override
	protected void onDraw(Canvas canvas) 
	{
		long now=SystemClock.uptimeMillis();
		if(movieStart == 0)
		{
			movieStart=now;
		}
		if(gifMovie!= null)
		{
			int dur=gifMovie.duration();
			if(dur == 0)
			{
				dur=1000;
			}
			int telTime=(int) ((now - movieStart )% dur);
			
			gifMovie.setTime(telTime);
			gifMovie.draw(canvas, 0, 0);
			invalidate();
		}
	}	
}
