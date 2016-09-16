package com.example.prayas;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.prayas.chatcustom.chatinfo;

import java.util.ArrayList;

public class customadapterchat extends BaseAdapter {
	 private final Activity context;
	 private final ArrayList<chatinfo> itemname ;
		
	 public customadapterchat(Activity context, ArrayList<chatinfo> itemname) {
		 this.context=context;
		 this.itemname=itemname;
	 }
		 
/*	 
	 public View getView1(int position,View view,ViewGroup parent) {
		 LayoutInflater inflater=context.getLayoutInflater();
		 View rowView=inflater.inflate(R.layout.chatcustom, null,true);
		   
		 TextView chatmsg = (TextView) rowView.findViewById(R.id.chatcustomtextView1);
		 
		 TextView chattime = (TextView) rowView.findViewById(R.id.chatcustomtextView2);
		 
		 chatmsg.setText(itemname.get(position).msg.toString());
		 chattime.setText(itemname.get(position).time.toString());
			
		 
		 return rowView;
		 
		 }
*/
/*
 * txtTitle.setText(itemname.get(position).new_t);
	 extratxt.setText( itemname.get(position).news_d);
	 
 * */
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
		return arg0;
	}

	@Override
	public View getView(int position, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
	
		 LayoutInflater inflater=context.getLayoutInflater();
		 View rowView=null;
		   


		 	if(itemname.get(position).reciver.toString().equals(loginprayas.username))
		 		
		 {
		 		Log.d("sender","if");
		 	//	rowView= inflater.inflate(R.layout.sender_message_layout, null);;
		 	//	rowView=inflater.inflate(R.layout.receiver_meesage_layout, null);
		 		rowView= inflater.inflate(R.layout.sender_message_layout, null);;
		 		

		 		//chatmsg.layout
		 }
		 	
		 else
		 {
				Log.d("sender","else");
				rowView=inflater.inflate(R.layout.receiver_meesage_layout, null);
				//rowView= inflater.inflate(R.layout.sender_message_layout, null);;
		 		   

		 }

		 TextView chatmsg = (TextView) rowView.findViewById(R.id.sendtextView1);
		 
		 TextView chattime = (TextView) rowView.findViewById(R.id.sendtextView2);
		 	Log.d("position", position+"");
		 	Log.d("position", itemname.get(position).msg.toString());
		 	
			chatmsg.setText(itemname.get(position).msg.toString());
		 	chattime.setText(itemname.get(position).time.toString());
		 	Log.d("sender",chatcustom.sender);
		 	Log.d("user",loginprayas.username);
		 	 
		 		 
		 return rowView;
		 
	//	return null;
	}

}
