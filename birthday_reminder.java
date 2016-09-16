package com.example.prayas;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

public class birthday_reminder extends Activity 
{
	//ImageView iv1;
	GifView gifView1;
	Button br1;
	private static final String SENDER_ID = "218106780727";
	String regId="" ;
	private NotificationManager mgr=null;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.birthday_reminder);
		//gifView=(GifView)findViewById(R.id.gef1_view);
		//b1=(Button)findViewById(R.id.birthr1);
		//gifView1=(GifView)findViewById(R.id.gef1_view1111);
		br1=(Button)findViewById(R.id.birthr1);
		if(!isMyServiceRunning(backgroundservice.class))
		{
			startService(new Intent(birthday_reminder.this,backgroundservice.class));	
		}
	
		
		br1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent br1=new Intent(birthday_reminder.this, loginprayas.class);
				startActivity(br1);
			}
		});
	}
	
	public boolean isMyServiceRunning(Class<?> serviceClass) {
	    ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
	    for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
	        if (serviceClass.getName().equals(service.service.getClassName())) {
	            return true;
	        }
	    }
	    return false;
	}
    

}
