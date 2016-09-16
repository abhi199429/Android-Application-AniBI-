package com.example.prayas;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prayas.news.News;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;



public class customadapter  extends BaseAdapter {
	 
	 private final Activity context;
	 private final ArrayList<News> itemname ;
	 public static String  URL =Homepage.ip;   
	 public static ImageView ivi;
	 public static Bitmap bitmap;
public static	 ImageButton sharei1;
	 public customadapter(Activity context, ArrayList<News> itemname) {
	 
	 // TODO Auto-generated constructor stub
	 
	 this.context=context;
	 this.itemname=itemname;
	 
	 }
	 
	 
	 
	 public View getView(int position,View view,ViewGroup parent) {
	 LayoutInflater inflater=context.getLayoutInflater();
	 View rowView=inflater.inflate(R.layout.customadapter, null,true);
	   
	 TextView txtTitle = (TextView) rowView.findViewById(R.id.c_textView1);
	 
	 TextView extratxt = (TextView) rowView.findViewById(R.id.c_textView2);
	 TextView extratxt1 = (TextView) rowView.findViewById(R.id.c_textView3);
	 //ImageView iv1= (ImageView) rowView.findViewById(R.id.c_imageView1);
	 
	 txtTitle.setText(itemname.get(position).new_t);
	 extratxt.setText( itemname.get(position).news_d);
	 extratxt1.setText(itemname.get(position).date);
	 String add=Homepage.ip+itemname.get(position).Image;
	 
	 sharei1=(ImageButton)rowView.findViewById(R.id.shareimageButton1);
	
	 sharei1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent sendIntent = new Intent();
			sendIntent.setAction(Intent.ACTION_SEND);
			sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
			sendIntent.setType("text/plain");
			context.startActivity(Intent.createChooser(sendIntent,"myapp"));
		  // context.startActivity(Intent.createChooser(sendIntent, "Share using"));


			
		}
	});
	 ivi=(ImageView)rowView.findViewById(R.id.c_imageView1);
	    	    		Log.d("url", add);
	 Picasso.with(context).load(add).resize(100, 100).into(ivi); 
	 return rowView;
	 
	 }

	
	 
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return itemname.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	};


	
	

	 public  class LoadImage extends AsyncTask<String, String, Bitmap> {
	   
	         protected Bitmap doInBackground(String... args) {
	             try {
	                   bitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());
	 
	            } catch (Exception e) {
	                  e.printStackTrace();
	            }
	            return bitmap;
	         }
	 
	         protected void onPostExecute(Bitmap image) {
	 
	        	 
	             if(image != null){
	           // 	 pDialog.dismiss();
	    			 
	            	 ivi.setImageBitmap(image);
	             
	             }else{
	 
	             //pDialog.dismiss();
	             Toast.makeText(context, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();
	 
	             }
	         }
	     }
		

	





}			
	
	
	    
	    


	 

