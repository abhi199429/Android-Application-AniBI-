package com.example.prayas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

public class catsym extends Activity
{
	Button cob1,cob2,cob3,cob4,cob5,cob6,cob7,cob8,cob9,cob10;
	TextView ctv1;
	
	CheckBox catc1,catc2,catc3;
	public static TextView t1,t2;


	public static String s1="Anisocoria";
	public static String dname,ddetail;
	

	public static class diseas
	{
		String Dis_name;
		String Dis_details;
		
		
	}
	public static diseas n2=new diseas();
	public ArrayList<diseas> n1=new ArrayList<diseas>();


	public static String NAMESPACE = "http://tempuri.org/";
	public static String  URL = Homepage.ipadd;
	public static String SOAP_ACTION = "http://tempuri.org/select_for_diseas";
	String METHOD_NAME = "select_for_diseas"; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.catsym);
		
		cob1=(Button)findViewById(R.id.catear);
		cob2=(Button)findViewById(R.id.cateye);
		cob3=(Button)findViewById(R.id.catneck);
		cob4=(Button)findViewById(R.id.catfeet1);
		cob5=(Button)findViewById(R.id.catfeet2);
		cob6=(Button)findViewById(R.id.catabdomen);
		cob7=(Button)findViewById(R.id.cattail);
		cob8=(Button)findViewById(R.id.cathip);
		cob9=(Button)findViewById(R.id.catback);
		cob10=(Button)findViewById(R.id.catstomach);
		ctv1=(TextView)findViewById(R.id.cattv1);
		
		catc1=(CheckBox)findViewById(R.id.dogcheckBox1);
		catc2=(CheckBox)findViewById(R.id.dogcheckBox2);
		catc3=(CheckBox)findViewById(R.id.dogcheckBox3);
	
		
		cob1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ctv1.setText(cob1.getText());
				
				catc1=(CheckBox)findViewById(R.id.catcheckBox1);
				catc2=(CheckBox)findViewById(R.id.catcheckBox2);
				catc3=(CheckBox)findViewById(R.id.catcheckBox3);
				s1=catc1.getText().toString();
			//	catc1.setVisibility(TRIM_MEMORY_COMPLETE);
			//	catc2.setVisibility(TRIM_MEMORY_COMPLETE);
			//	catc3.setVisibility(TRIM_MEMORY_COMPLETE);
			//	t1=(TextView)findViewById(R.id.disdetailtv1);
				//t2=(TextView)findViewById(R.id.textView2);
				
				catc1.setText("dis1");
				catc2.setText("dis2");
				catc3.setText("dis3");
				catc1.setChecked(false);
				catc2.setChecked(false);
				catc3.setChecked(false);
				//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
				
				
				catc1.setOnClickListener(new View.OnClickListener() {
					
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						s1=catc1.getText().toString();
						
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj2=new DoLogin2();
						obj2.execute();
						
						catc1.setChecked(true);
						catc2.setChecked(false);
						catc3.setChecked(false);
					}
				});
				
				catc2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=catc2.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj3=new DoLogin2();
						obj3.execute();

						catc2.setChecked(true);
						
						catc1.setChecked(false);
						catc3.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});
				
				catc3.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=catc3.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj4=new DoLogin2();
						obj4.execute();
						catc1.setChecked(true);
						
						catc2.setChecked(false);
						catc1.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});

				


				
			}
		});
		cob2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ctv1.setText(cob2.getText());
				catc1=(CheckBox)findViewById(R.id.birdcheckBox1);
				catc2=(CheckBox)findViewById(R.id.birdcheckBox2);
				catc3=(CheckBox)findViewById(R.id.birdcheckBox3);
				s1=catc1.getText().toString();
			//	catc1.setVisibility(TRIM_MEMORY_COMPLETE);
			//	catc2.setVisibility(TRIM_MEMORY_COMPLETE);
			//	catc3.setVisibility(TRIM_MEMORY_COMPLETE);
			//	t1=(TextView)findViewById(R.id.disdetailtv1);
				//t2=(TextView)findViewById(R.id.textView2);
				
				catc1.setText("dis1");
				catc2.setText("dis2");
				catc3.setText("dis3");
				catc1.setChecked(false);
				catc2.setChecked(false);
				catc3.setChecked(false);
				//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
				
				
				catc1.setOnClickListener(new View.OnClickListener() {
					
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						s1=catc1.getText().toString();
						
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj2=new DoLogin2();
						obj2.execute();
						
						catc1.setChecked(true);
						catc2.setChecked(false);
						catc3.setChecked(false);
					}
				});
				
				catc2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=catc2.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj3=new DoLogin2();
						obj3.execute();

						catc2.setChecked(true);
						
						catc1.setChecked(false);
						catc3.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});
				
				catc3.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=catc3.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj4=new DoLogin2();
						obj4.execute();
						catc1.setChecked(true);
						
						catc2.setChecked(false);
						catc1.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});

				

				
			}
		});

		cob3.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ctv1.setText(cob3.getText());
				catc1=(CheckBox)findViewById(R.id.birdcheckBox1);
				catc2=(CheckBox)findViewById(R.id.birdcheckBox2);
				catc3=(CheckBox)findViewById(R.id.birdcheckBox3);
				s1=catc1.getText().toString();
			//	catc1.setVisibility(TRIM_MEMORY_COMPLETE);
			//	catc2.setVisibility(TRIM_MEMORY_COMPLETE);
			//	catc3.setVisibility(TRIM_MEMORY_COMPLETE);
			//	t1=(TextView)findViewById(R.id.disdetailtv1);
				//t2=(TextView)findViewById(R.id.textView2);
				
				catc1.setText("dis1");
				catc2.setText("dis2");
				catc3.setText("dis3");
				catc1.setChecked(false);
				catc2.setChecked(false);
				catc3.setChecked(false);
				//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
				
				
				catc1.setOnClickListener(new View.OnClickListener() {
					
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						s1=catc1.getText().toString();
						
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj2=new DoLogin2();
						obj2.execute();
						
						catc1.setChecked(true);
						catc2.setChecked(false);
						catc3.setChecked(false);
					}
				});
				
				catc2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=catc2.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj3=new DoLogin2();
						obj3.execute();

						catc2.setChecked(true);
						
						catc1.setChecked(false);
						catc3.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});
				
				catc3.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=catc3.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj4=new DoLogin2();
						obj4.execute();
						catc1.setChecked(true);
						
						catc2.setChecked(false);
						catc1.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});

				

		
			}
		});

		cob4.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ctv1.setText(cob4.getText());
				catc1=(CheckBox)findViewById(R.id.birdcheckBox1);
				catc2=(CheckBox)findViewById(R.id.birdcheckBox2);
				catc3=(CheckBox)findViewById(R.id.birdcheckBox3);
				s1=catc1.getText().toString();
			//	catc1.setVisibility(TRIM_MEMORY_COMPLETE);
			//	catc2.setVisibility(TRIM_MEMORY_COMPLETE);
			//	catc3.setVisibility(TRIM_MEMORY_COMPLETE);
			//	t1=(TextView)findViewById(R.id.disdetailtv1);
				//t2=(TextView)findViewById(R.id.textView2);
				
				catc1.setText("dis1");
				catc2.setText("dis2");
				catc3.setText("dis3");
				catc1.setChecked(false);
				catc2.setChecked(false);
				catc3.setChecked(false);
				//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
				
				
				catc1.setOnClickListener(new View.OnClickListener() {
					
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						s1=catc1.getText().toString();
						
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj2=new DoLogin2();
						obj2.execute();
						
						catc1.setChecked(true);
						catc2.setChecked(false);
						catc3.setChecked(false);
					}
				});
				
				catc2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=catc2.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj3=new DoLogin2();
						obj3.execute();

						catc2.setChecked(true);
						
						catc1.setChecked(false);
						catc3.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});
				
				catc3.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=catc3.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj4=new DoLogin2();
						obj4.execute();
						catc1.setChecked(true);
						
						catc2.setChecked(false);
						catc1.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});

				

		
			}
		});

		cob5.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ctv1.setText(cob5.getText());
				catc1=(CheckBox)findViewById(R.id.birdcheckBox1);
				catc2=(CheckBox)findViewById(R.id.birdcheckBox2);
				catc3=(CheckBox)findViewById(R.id.birdcheckBox3);
				s1=catc1.getText().toString();
			//	catc1.setVisibility(TRIM_MEMORY_COMPLETE);
			//	catc2.setVisibility(TRIM_MEMORY_COMPLETE);
			//	catc3.setVisibility(TRIM_MEMORY_COMPLETE);
			//	t1=(TextView)findViewById(R.id.disdetailtv1);
				//t2=(TextView)findViewById(R.id.textView2);
				
				catc1.setText("dis1");
				catc2.setText("dis2");
				catc3.setText("dis3");
				catc1.setChecked(false);
				catc2.setChecked(false);
				catc3.setChecked(false);
				//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
				
				
				catc1.setOnClickListener(new View.OnClickListener() {
					
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						s1=catc1.getText().toString();
						
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj2=new DoLogin2();
						obj2.execute();
						
						catc1.setChecked(true);
						catc2.setChecked(false);
						catc3.setChecked(false);
					}
				});
				
				catc2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=catc2.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj3=new DoLogin2();
						obj3.execute();

						catc2.setChecked(true);
						
						catc1.setChecked(false);
						catc3.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});
				
				catc3.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=catc3.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj4=new DoLogin2();
						obj4.execute();
						catc1.setChecked(true);
						
						catc2.setChecked(false);
						catc1.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});

				

		
			}
		});

		cob6.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
		// TODO Auto-generated method stub
		ctv1.setText(cob6.getText());
		
		catc1=(CheckBox)findViewById(R.id.birdcheckBox1);
		catc2=(CheckBox)findViewById(R.id.birdcheckBox2);
		catc3=(CheckBox)findViewById(R.id.birdcheckBox3);
		s1=catc1.getText().toString();
	//	catc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	catc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	catc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		catc1.setText("dis1");
		catc2.setText("dis2");
		catc3.setText("dis3");
		catc1.setChecked(false);
		catc2.setChecked(false);
		catc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		catc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=catc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				catc1.setChecked(true);
				catc2.setChecked(false);
				catc3.setChecked(false);
			}
		});
		
		catc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=catc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				catc2.setChecked(true);
				
				catc1.setChecked(false);
				catc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		catc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=catc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				catc1.setChecked(true);
				
				catc2.setChecked(false);
				catc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});

		

			}
		});

		cob7.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
		// TODO Auto-generated method stub
			ctv1.setText(cob7.getText());
			catc1=(CheckBox)findViewById(R.id.birdcheckBox1);
			catc2=(CheckBox)findViewById(R.id.birdcheckBox2);
			catc3=(CheckBox)findViewById(R.id.birdcheckBox3);
			s1=catc1.getText().toString();
		//	catc1.setVisibility(TRIM_MEMORY_COMPLETE);
		//	catc2.setVisibility(TRIM_MEMORY_COMPLETE);
		//	catc3.setVisibility(TRIM_MEMORY_COMPLETE);
		//	t1=(TextView)findViewById(R.id.disdetailtv1);
			//t2=(TextView)findViewById(R.id.textView2);
			
			catc1.setText("dis1");
			catc2.setText("dis2");
			catc3.setText("dis3");
			catc1.setChecked(false);
			catc2.setChecked(false);
			catc3.setChecked(false);
			//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
			
			
			catc1.setOnClickListener(new View.OnClickListener() {
				
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					s1=catc1.getText().toString();
					
					Intent i1=new Intent(getApplicationContext(), dsym1.class);
					startActivity(i1);
				
					DoLogin2 obj2=new DoLogin2();
					obj2.execute();
					
					catc1.setChecked(true);
					catc2.setChecked(false);
					catc3.setChecked(false);
				}
			});
			
			catc2.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					s1=catc2.getText().toString();
					Intent i1=new Intent(getApplicationContext(), dsym1.class);
					startActivity(i1);
				
					DoLogin2 obj3=new DoLogin2();
					obj3.execute();

					catc2.setChecked(true);
					
					catc1.setChecked(false);
					catc3.setChecked(false);
					//t2.setText(n2.Dis_name);
					//t1.setText(n2.Dis_details);
				}
			});
			
			catc3.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					s1=catc3.getText().toString();
					Intent i1=new Intent(getApplicationContext(), dsym1.class);
					startActivity(i1);
				
					DoLogin2 obj4=new DoLogin2();
					obj4.execute();
					catc1.setChecked(true);
					
					catc2.setChecked(false);
					catc1.setChecked(false);
					//t2.setText(n2.Dis_name);
					//t1.setText(n2.Dis_details);
				}
			});

			

		
			}
		});

		cob8.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
		// TODO Auto-generated method stub
		ctv1.setText(cob8.getText());
		catc1=(CheckBox)findViewById(R.id.birdcheckBox1);
		catc2=(CheckBox)findViewById(R.id.birdcheckBox2);
		catc3=(CheckBox)findViewById(R.id.birdcheckBox3);
		s1=catc1.getText().toString();
	//	catc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	catc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	catc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		catc1.setText("dis1");
		catc2.setText("dis2");
		catc3.setText("dis3");
		catc1.setChecked(false);
		catc2.setChecked(false);
		catc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		catc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=catc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				catc1.setChecked(true);
				catc2.setChecked(false);
				catc3.setChecked(false);
			}
		});
		
		catc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=catc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				catc2.setChecked(true);
				
				catc1.setChecked(false);
				catc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		catc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=catc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				catc1.setChecked(true);
				
				catc2.setChecked(false);
				catc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});

		

		
			}	
		});

		cob9.setOnClickListener(new View.OnClickListener() {
	
		@Override
		public void onClick(View arg0) {
		// TODO Auto-generated method stub
		ctv1.setText(cob9.getText());
		catc1=(CheckBox)findViewById(R.id.birdcheckBox1);
		catc2=(CheckBox)findViewById(R.id.birdcheckBox2);
		catc3=(CheckBox)findViewById(R.id.birdcheckBox3);
		s1=catc1.getText().toString();
	//	catc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	catc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	catc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		catc1.setText("dis1");
		catc2.setText("dis2");
		catc3.setText("dis3");
		catc1.setChecked(false);
		catc2.setChecked(false);
		catc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		catc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=catc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				catc1.setChecked(true);
				catc2.setChecked(false);
				catc3.setChecked(false);
			}
		});
		
		catc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=catc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				catc2.setChecked(true);
				
				catc1.setChecked(false);
				catc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		catc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=catc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				catc1.setChecked(true);
				
				catc2.setChecked(false);
				catc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});

		

		
			}
		});	

		cob10.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
		// TODO Auto-generated method stub
		ctv1.setText(cob10.getText());
		catc1=(CheckBox)findViewById(R.id.birdcheckBox1);
		catc2=(CheckBox)findViewById(R.id.birdcheckBox2);
		catc3=(CheckBox)findViewById(R.id.birdcheckBox3);
		s1=catc1.getText().toString();
	//	catc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	catc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	catc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		catc1.setText("dis1");
		catc2.setText("dis2");
		catc3.setText("dis3");
		catc1.setChecked(false);
		catc2.setChecked(false);
		catc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		catc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=catc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				catc1.setChecked(true);
				catc2.setChecked(false);
				catc3.setChecked(false);
			}
		});
		
		catc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=catc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				catc2.setChecked(true);
				
				catc1.setChecked(false);
				catc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		catc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=catc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				catc1.setChecked(true);
				
				catc2.setChecked(false);
				catc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});

		

		
			}
		});



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
	        request.addProperty("Dis_name",s1);

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
		pdia = new ProgressDialog(catsym.this);
		pdia.setCanceledOnTouchOutside(false);
        pdia.setMessage("Loading...");
        pdia.show(); 
	}
	
	
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);    	    	
		
		
		pdia.dismiss();

		String pro[]=result.split("`");
		Toast.makeText(getApplicationContext(), pro[0].toString(), Toast.LENGTH_SHORT).show();
	
		n2.Dis_name=pro[0];
		n2.Dis_details=pro[1];
		ddetail=pro[1];
		Toast.makeText(getApplicationContext(), ddetail, 200).show();
		n1.add(n2);
		dsym1.t3.setText(n2.Dis_name);
		dsym1.t5.setText(ddetail);
		
		//t2.setText(n2.Dis_name);
		//t1.setText(n2.Dis_details);

			//Log.d("data",n2.news_d);
			
		
	}
}


}
