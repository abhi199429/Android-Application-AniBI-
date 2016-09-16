package com.example.prayas;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;
public class backgroundservice  extends Service 
{	
	public static boolean maxspeed=false; 
	public static double lntd;
	public static double latd;
	TimerTask  timerTask2;
	Timer timer=new Timer();
	Handler handler2=new Handler();
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		timerTask2=new TimerTask() {
			@Override
			public void run() {
				handler2.post(new Runnable() {
					@Override
					public void run() {
						getloc();
						Log.d("Location",latd+"-"+lntd);
						
							}
				});				
			}			
		};		
		timer.scheduleAtFixedRate(timerTask2, 1000, 5000);	
		return START_STICKY;
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	public void getloc()
    {	 
    	LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
    	LocationListener locationListener = new LocationListener() 
    	{
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            @Override
    	    public void onProviderEnabled(String provider) {
            }

    	    @Override
    	    public void onProviderDisabled(String provider) {
    	    }

    	    @Override
    	    public void onLocationChanged(Location location) {
    	    	if(location!=null)
    	    	{
    	    		
	    	    	lntd=location.getLongitude();
	    	    	latd=location.getLatitude();
	
    	    	}
    	    }
    	};
    	locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);    	
	}
}