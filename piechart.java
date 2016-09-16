package com.example.prayas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class piechart extends Activity implements OnItemSelectedListener{

	
	public static String NAMESPACE = "http://tempuri.org/";
	public static String  URL = Homepage.ipadd;
	public static String SOAP_ACTION = "http://tempuri.org/selectrescuedetails";
	String METHOD_NAME = "selectrescuedetails"; 
	Spinner pcs1;

	Button b1;
	
	public static class res {

		String flewaway;
		String founddead;
		String insgiven;
		String notfound;
		String open;
		String rescued;
		
		
}
	
	String[] animal = { "dog", "cat", "horse", "other",  };  

	public static ArrayList<res> n1=new ArrayList<res>();
	public static String flewaway;
	public static String founddead;
	public static String insgiven;
	public static String notfound;
	public static String open;
	public static String rescued;
	public static double db1,db2,db3,db4,db5,db6;
	public static String formattedDate;
	public static String animaltype;

	@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
    
	setContentView(R.layout.fragment_main);
	
	Calendar c = Calendar.getInstance();
	System.out.println("Current time => " + c.getTime());

	SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
	formattedDate = df.format(c.getTime());
	Toast.makeText(piechart.this, formattedDate, 1).show();
	pcs1=(Spinner)findViewById(R.id.piechartspinner1);
	
	
	pcs1.setOnItemSelectedListener(this);
	 ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,animal);  
    aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
    //Setting the ArrayAdapter data on the Spinner  
    pcs1.setAdapter(aa);  
    
    
	b1=(Button)findViewById(R.id.btn_chart);
	

	b1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			animaltype=pcs1.getSelectedItem().toString();
		    		
			DoLogin2 d2=new DoLogin2();
			d2.execute();
			
			//Toast.makeText(piechart.this, d1+"", Toast.LENGTH_LONG).show();
			
			
		}
	});
	}
	private void openChart(){
		 
        // Pie Chart Section Names
       
       Toast.makeText(piechart.this,String.valueOf(db2),1).show();
       String[] code = new String[] {
            "Flewaway", "FoundDead", "Instruction Given", "Notfound",
            "Open", "rescued"
        };
 
        
        // Pie Chart Section Value
        double[] distribution = { db1, db2, db3, db4, db5, db6 } ;
 
        
        // Color of each Pie Chart Sections
        int[] colors = { Color.BLUE, Color.MAGENTA, Color.GREEN, Color.CYAN, Color.RED,
                        Color.YELLOW };
 
        // Instantiating CategorySeries to plot Pie Chart
        CategorySeries distributionSeries = new CategorySeries("Prayas Rescue count as on "+ formattedDate);
        for(int i=0 ;i < distribution.length;i++){
            // Adding a slice with its values and name to the Pie Chart
         
        	distributionSeries.add(code[i], distribution[i]);
      
        }
 
        // Instantiating a renderer for the Pie Chart
        DefaultRenderer defaultRenderer  = new DefaultRenderer();
        for(int i = 0 ;i<distribution.length;i++){
            SimpleSeriesRenderer seriesRenderer = new SimpleSeriesRenderer();
            seriesRenderer.setColor(colors[i]);
            seriesRenderer.setDisplayChartValues(true);
            seriesRenderer.setChartValuesTextSize(35);
           
            // Adding a renderer for a slice
            defaultRenderer.addSeriesRenderer(seriesRenderer);
        }
 
        defaultRenderer.setChartTitle("Prayas Rescue count as on "+formattedDate);
        defaultRenderer.setChartTitleTextSize(35);
       
        defaultRenderer.setLabelsTextSize(35);
        defaultRenderer.setLegendTextSize(35);
        
        defaultRenderer.setZoomButtonsVisible(true);
 
        // Creating an intent to plot bar chart using dataset and multipleRenderer
        Intent intent = ChartFactory.getPieChartIntent(getBaseContext(), distributionSeries , defaultRenderer, "AChartEnginePieChartDemo");
 
        // Start Activity
        startActivity(intent);
 
    }
	
	class DoLogin2 extends AsyncTask<Void, Void, String>
{
	private ProgressDialog pdia;
	
	@Override
	protected String doInBackground(Void... params) {
		// TODO Auto-generated method stub
		
		try
		{
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
	        request.addProperty("date", formattedDate);
	        request.addProperty("anitype", animaltype);

	        //request.addProperty("password", e2.getText().toString());
	        
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet=true;
	        envelope.setOutputSoapObject(request);
	        
	        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        
	        androidHttpTransport.call(SOAP_ACTION, envelope);
	        SoapPrimitive resultstr = (SoapPrimitive)envelope.getResponse();
	        
	        Log.d("message","MEssage : "+resultstr.toString());
	        
	       
	        return resultstr.toString();
	    
	        
	        

		}
		catch(Exception e)
		{
			Log.e("error13", e.toString());
			return "fail,fail";
			
		}
			
		
		
	}
	
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		pdia = new ProgressDialog(piechart.this);
		pdia.setCanceledOnTouchOutside(false);
        pdia.setMessage("Loading...");
        pdia.show(); 
	}
	
	
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);    	    	
		Log.d("data", result);
		
		pdia.dismiss();
		
		//Toast.makeText(piechart.this,result, Toast.LENGTH_LONG).show();
		

		String pro[]=result.split(">");
//Toast.makeText(piechart.this,pro[0] , Toast.LENGTH_LONG).show();
				for(int i=0;i<pro.length;i++)
		{
			String prodata1[]=pro[i].split("`");
		
			//Toast.makeText(news.class, pro[i],100).show();
			res n2=new res();
			
	//	n2.news_d=prodata1[0];
		flewaway=prodata1[0];	
		db1 = Double.parseDouble(flewaway);
	    founddead=prodata1[1];
	    db2 = Double.parseDouble(founddead);
	    insgiven=prodata1[2];
	    db3 = Double.parseDouble(insgiven);
	    
	    notfound=prodata1[3];
	    db4 = Double.parseDouble(notfound);
	    
	    open=prodata1[4];
	    db5 = Double.parseDouble(open);
	    
	    rescued=prodata1[5];
	    db6 = Double.parseDouble(rescued);
	    
		n1.add(n2);
		//Toast.makeText(piechart.this,String.valueOf(db1) , Toast.LENGTH_LONG).show();
			
		}
				openChart();
				
				
		//for(int i=0;i<n1.size();i++)
	   // {
	      
	    	//String add="http://192.168.1.146/prayasregmember/upload/"+news.ial1.get(i);
	    //	Toast.makeText(news.this,ial1.get(i), Toast.LENGTH_LONG).show();
		    	
	    	//LoadImage li1=new LoadImage();
	   	//	li1.execute(add);    			
	   	     
	   // }
    	
	
		//Toast.makeText(news.this, ial1.get(1), Toast.LENGTH_LONG).show();

	  				
		
		//cd=new customadapter(news.this, n1);
			
	
	        
	   	    			
		
		
		
	
	}
	
	
		
}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
				
	
	
	
	}
	
	

