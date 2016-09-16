package com.example.prayas;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prayas.pollingprayas.Prayaspolling;

import java.util.ArrayList;

public class customlistviewpolling extends BaseAdapter
{
	private final Activity context;
	 private final ArrayList<Prayaspolling> itemname ;
	 public static String  URL =Homepage.ip;   
	 public static ImageView ivi;
	 public static Bitmap bitmap;
	 public static	 ImageButton sharei1;
	 
	 public customlistviewpolling(Activity context, ArrayList<Prayaspolling> itemname) 
	 {
	 // TODO Auto-generated constructor stub
	 
	 this.context=context;
	 this.itemname=itemname;
	 
	 }
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater=context.getLayoutInflater();
		 View rowView=inflater.inflate(R.layout.customlistviewpolling,null,true);
		   
		 TextView txtTitle = (TextView) rowView.findViewById(R.id.tvcustomlist1);
		
		 TextView extratxt = (TextView) rowView.findViewById(R.id.tvcustomlist2);
		 TextView extratxt1 = (TextView) rowView.findViewById(R.id.tvcustomlist3);
		 //ImageView iv1= (ImageView) rowView.findViewById(R.id.c_imageView1);
		 
		 txtTitle.setText(itemname.get(position).Title);
		 
		 
		 extratxt.setText( itemname.get(position).date);
		 extratxt1.setText(itemname.get(position).Time);

		 /*LayoutParams params=(LayoutParams) rowView.getLayoutParams();
		 params.height=40;
		 rowView.setLayoutParams(params);
		 */
		 return rowView;
		 

		//return null;
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
	}

		
}
