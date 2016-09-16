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

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

public class dogsym extends Activity
{
	Button dob1,dob2,dob3,dob4,dob5,dob6,dob7,dob8,dob9,dob10;
	TextView e1;
	CheckBox dogc1,dogc2,dogc3;
	public static TextView t1,t2;
	public static int P_id,D_id,k=0;;


	public static String s1="Anisocoria",s2="";
	public static String dname[],ddetail1[],ddetail;
	public static int d[];
	int i=0;

	public static class diseas
	{
		String Dis_name;
		String Dis_details;
		
		
	}
	
	/*public static class anpart
	{
		String Dis_id;
		String An_name;
		
	}*/
	
	//public static anpart n3=new anpart();
	//public ArrayList<anpart> n4=new ArrayList<anpart>();
	
	
	public static diseas n2=new diseas();
	public ArrayList<diseas> n1=new ArrayList<diseas>();


	public static String NAMESPACE = "http://tempuri.org/";
	public static String  URL = Homepage.ipadd;
	public static String SOAP_ACTION = "http://tempuri.org/select_for_diseas";
	String METHOD_NAME = "select_for_diseas"; 
	
	
	public static String SOAP_ACTION1 = "http://tempuri.org/select_for_part";
	String METHOD_NAME1 = "select_for_part"; 


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dogsym);
		
		dob1=(Button)findViewById(R.id.dogear);
		dob2=(Button)findViewById(R.id.dogeye);
		dob3=(Button)findViewById(R.id.dogneck1);
		dob4=(Button)findViewById(R.id.dogback);
		dob5=(Button)findViewById(R.id.dogshoulder);
		dob6=(Button)findViewById(R.id.dogabdomen);
		dob7=(Button)findViewById(R.id.dogfeet1);
		dob8=(Button)findViewById(R.id.dogfeet2);
		dob9=(Button)findViewById(R.id.doghips);
		dob10=(Button)findViewById(R.id.dogtail);
		e1=(TextView)findViewById(R.id.dogtv1);
		
		
		dogc1=(CheckBox)findViewById(R.id.dogcheckBox1);
		dogc2=(CheckBox)findViewById(R.id.dogcheckBox2);
		dogc3=(CheckBox)findViewById(R.id.dogcheckBox3);
	
	
	//dogc1.setVisibility(TRIM_MEMORY_UI_HIDDEN);	
	//dogc2.setVisibility(TRIM_MEMORY_UI_HIDDEN);	
	//dogc3.setVisibility(TRIM_MEMORY_UI_HIDDEN);	
		
	
	
		dob1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				e1.setText(dob1.getText());
				P_id=1;
				
				DoLogin3 ob1=new DoLogin3();
				ob1.execute();
				
				dogc1=(CheckBox)findViewById(R.id.dogcheckBox1);
				dogc2=(CheckBox)findViewById(R.id.dogcheckBox2);
				dogc3=(CheckBox)findViewById(R.id.dogcheckBox3);
				s1=dogc1.getText().toString();
			//	dogc1.setVisibility(TRIM_MEMORY_COMPLETE);
			//	dogc2.setVisibility(TRIM_MEMORY_COMPLETE);
			//	dogc3.setVisibility(TRIM_MEMORY_COMPLETE);
			//	t1=(TextView)findViewById(R.id.disdetailtv1);
				//t2=(TextView)findViewById(R.id.textView2);
				
				
				for(int j=0;j<3;j++)
				{
					D_id=d[j];
					DoLogin2 obj2=new DoLogin2();
					obj2.execute();
				}
				
				dogc1.setText(dname[0]);
				dogc2.setText(dname[1]);
				dogc3.setText(dname[2]);
				dogc1.setChecked(false);
				dogc2.setChecked(false);
				dogc3.setChecked(false);
				//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
				
				
				dogc1.setOnClickListener(new View.OnClickListener() {
					
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						s1=dogc1.getText().toString();
						
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						//DoLogin2 obj2=new DoLogin2();
						//obj2.execute();
						
						dsym1.t3.setText(dname[0]);
						dsym1.t5.setText(ddetail1[0]);
						
						dogc1.setChecked(true);
						dogc2.setChecked(false);
						dogc3.setChecked(false);
					}
				});
				
				dogc2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=dogc2.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj3=new DoLogin2();
						obj3.execute();

						dogc2.setChecked(true);
						
						dogc1.setChecked(false);
						dogc3.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});
				
				dogc3.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=dogc3.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj4=new DoLogin2();
						obj4.execute();
						dogc1.setChecked(true);
						
						dogc2.setChecked(false);
						dogc1.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});

				


				
			}
		});
		
		
		
		dob2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				e1.setText(dob2.getText());
				dogc1=(CheckBox)findViewById(R.id.dogcheckBox1);
				dogc2=(CheckBox)findViewById(R.id.dogcheckBox2);
				dogc3=(CheckBox)findViewById(R.id.dogcheckBox3);
				s1=dogc1.getText().toString();
			//	dogc1.setVisibility(TRIM_MEMORY_COMPLETE);
			//	dogc2.setVisibility(TRIM_MEMORY_COMPLETE);
			//	dogc3.setVisibility(TRIM_MEMORY_COMPLETE);
			//	t1=(TextView)findViewById(R.id.disdetailtv1);
				//t2=(TextView)findViewById(R.id.textView2);
				
				dogc1.setText("dis1");
				dogc2.setText("dis2");
				dogc3.setText("dis3");
				dogc1.setChecked(false);
				dogc2.setChecked(false);
				dogc3.setChecked(false);
				//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
				
				
				dogc1.setOnClickListener(new View.OnClickListener() {
					
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						s1=dogc1.getText().toString();
						
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj2=new DoLogin2();
						obj2.execute();
						
						dogc1.setChecked(true);
						dogc2.setChecked(false);
						dogc3.setChecked(false);
					}
				});
				
				dogc2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=dogc2.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj3=new DoLogin2();
						obj3.execute();

						dogc2.setChecked(true);
						
						dogc1.setChecked(false);
						dogc3.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});
				
				dogc3.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=dogc3.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj4=new DoLogin2();
						obj4.execute();
						dogc1.setChecked(true);
						
						dogc2.setChecked(false);
						dogc1.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});

				

				
			}
		});
		
		dob3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				e1.setText(dob3.getText());
				dogc1=(CheckBox)findViewById(R.id.dogcheckBox1);
				dogc2=(CheckBox)findViewById(R.id.dogcheckBox2);
				dogc3=(CheckBox)findViewById(R.id.dogcheckBox3);
				s1=dogc1.getText().toString();
			//	dogc1.setVisibility(TRIM_MEMORY_COMPLETE);
			//	dogc2.setVisibility(TRIM_MEMORY_COMPLETE);
			//	dogc3.setVisibility(TRIM_MEMORY_COMPLETE);
			//	t1=(TextView)findViewById(R.id.disdetailtv1);
				//t2=(TextView)findViewById(R.id.textView2);
				
				dogc1.setText("dis1");
				dogc2.setText("dis2");
				dogc3.setText("dis3");
				dogc1.setChecked(false);
				dogc2.setChecked(false);
				dogc3.setChecked(false);
				//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
				
				
				dogc1.setOnClickListener(new View.OnClickListener() {
					
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						s1=dogc1.getText().toString();
						
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj2=new DoLogin2();
						obj2.execute();
						
						dogc1.setChecked(true);
						dogc2.setChecked(false);
						dogc3.setChecked(false);
					}
				});
				
				dogc2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=dogc2.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj3=new DoLogin2();
						obj3.execute();

						dogc2.setChecked(true);
						
						dogc1.setChecked(false);
						dogc3.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});
				
				dogc3.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=dogc3.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj4=new DoLogin2();
						obj4.execute();
						dogc1.setChecked(true);
						
						dogc2.setChecked(false);
						dogc1.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});

				

				
			}
		});
		
		dob4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				e1.setText(dob4.getText());

				dogc1=(CheckBox)findViewById(R.id.dogcheckBox1);
				dogc2=(CheckBox)findViewById(R.id.dogcheckBox2);
				dogc3=(CheckBox)findViewById(R.id.dogcheckBox3);
				s1=dogc1.getText().toString();
			//	dogc1.setVisibility(TRIM_MEMORY_COMPLETE);
			//	dogc2.setVisibility(TRIM_MEMORY_COMPLETE);
			//	dogc3.setVisibility(TRIM_MEMORY_COMPLETE);
			//	t1=(TextView)findViewById(R.id.disdetailtv1);
				//t2=(TextView)findViewById(R.id.textView2);
				
				dogc1.setText("dis1");
				dogc2.setText("dis2");
				dogc3.setText("dis3");
				dogc1.setChecked(false);
				dogc2.setChecked(false);
				dogc3.setChecked(false);
				//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
				
				
				dogc1.setOnClickListener(new View.OnClickListener() {
					
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						s1=dogc1.getText().toString();
						
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						//DoLogin2 obj2=new DoLogin2();
						//obj2.execute();
						
						
						
						dogc1.setChecked(true);
						dogc2.setChecked(false);
						dogc3.setChecked(false);
					}
				});
				
				dogc2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=dogc2.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj3=new DoLogin2();
						obj3.execute();

						dogc2.setChecked(true);
						
						dogc1.setChecked(false);
						dogc3.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});
				
				dogc3.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=dogc3.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj4=new DoLogin2();
						obj4.execute();
						dogc1.setChecked(true);
						
						dogc2.setChecked(false);
						dogc1.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});

				


			}
		});
		dob5.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
		// TODO Auto-generated method stub

				e1.setText(dob5.getText());
			
				dogc1=(CheckBox)findViewById(R.id.dogcheckBox1);
				dogc2=(CheckBox)findViewById(R.id.dogcheckBox2);
				dogc3=(CheckBox)findViewById(R.id.dogcheckBox3);
				s1=dogc1.getText().toString();
			//	dogc1.setVisibility(TRIM_MEMORY_COMPLETE);
			//	dogc2.setVisibility(TRIM_MEMORY_COMPLETE);
			//	dogc3.setVisibility(TRIM_MEMORY_COMPLETE);
			//	t1=(TextView)findViewById(R.id.disdetailtv1);
				//t2=(TextView)findViewById(R.id.textView2);
				
				dogc1.setText("dis1");
				dogc2.setText("dis2");
				dogc3.setText("dis3");
				dogc1.setChecked(false);
				dogc2.setChecked(false);
				dogc3.setChecked(false);
				//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
				
				
				dogc1.setOnClickListener(new View.OnClickListener() {
					
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						s1=dogc1.getText().toString();
						
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj2=new DoLogin2();
						obj2.execute();
						
						dogc1.setChecked(true);
						dogc2.setChecked(false);
						dogc3.setChecked(false);
					}
				});
				
				dogc2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=dogc2.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj3=new DoLogin2();
						obj3.execute();

						dogc2.setChecked(true);
						
						dogc1.setChecked(false);
						dogc3.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});
				
				dogc3.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=dogc3.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj4=new DoLogin2();
						obj4.execute();
						dogc1.setChecked(true);
						
						dogc2.setChecked(false);
						dogc1.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});

				


			}
		});

		dob6.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
		// TODO Auto-generated method stub
				e1.setText(dob6.getText());
				dogc1=(CheckBox)findViewById(R.id.dogcheckBox1);
				dogc2=(CheckBox)findViewById(R.id.dogcheckBox2);
				dogc3=(CheckBox)findViewById(R.id.dogcheckBox3);
				s1=dogc1.getText().toString();
			//	dogc1.setVisibility(TRIM_MEMORY_COMPLETE);
			//	dogc2.setVisibility(TRIM_MEMORY_COMPLETE);
			//	dogc3.setVisibility(TRIM_MEMORY_COMPLETE);
			//	t1=(TextView)findViewById(R.id.disdetailtv1);
				//t2=(TextView)findViewById(R.id.textView2);
				
				dogc1.setText("dis1");
				dogc2.setText("dis2");
				dogc3.setText("dis3");
				dogc1.setChecked(false);
				dogc2.setChecked(false);
				dogc3.setChecked(false);
				//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
				
				
				dogc1.setOnClickListener(new View.OnClickListener() {
					
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						s1=dogc1.getText().toString();
						
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj2=new DoLogin2();
						obj2.execute();
						
						dogc1.setChecked(true);
						dogc2.setChecked(false);
						dogc3.setChecked(false);
					}
				});
				
				dogc2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=dogc2.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj3=new DoLogin2();
						obj3.execute();

						dogc2.setChecked(true);
						
						dogc1.setChecked(false);
						dogc3.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});
				
				dogc3.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=dogc3.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj4=new DoLogin2();
						obj4.execute();
						dogc1.setChecked(true);
						
						dogc2.setChecked(false);
						dogc1.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});

				


			}
		});

		dob7.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				e1.setText(dob7.getText());
				dogc1=(CheckBox)findViewById(R.id.dogcheckBox1);
				dogc2=(CheckBox)findViewById(R.id.dogcheckBox2);
				dogc3=(CheckBox)findViewById(R.id.dogcheckBox3);
				s1=dogc1.getText().toString();
			//	dogc1.setVisibility(TRIM_MEMORY_COMPLETE);
			//	dogc2.setVisibility(TRIM_MEMORY_COMPLETE);
			//	dogc3.setVisibility(TRIM_MEMORY_COMPLETE);
			//	t1=(TextView)findViewById(R.id.disdetailtv1);
				//t2=(TextView)findViewById(R.id.textView2);
				
				dogc1.setText("dis1");
				dogc2.setText("dis2");
				dogc3.setText("dis3");
				dogc1.setChecked(false);
				dogc2.setChecked(false);
				dogc3.setChecked(false);
				//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
				
				
				dogc1.setOnClickListener(new View.OnClickListener() {
					
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						s1=dogc1.getText().toString();
						
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj2=new DoLogin2();
						obj2.execute();
						
						dogc1.setChecked(true);
						dogc2.setChecked(false);
						dogc3.setChecked(false);
					}
				});
				
				dogc2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=dogc2.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj3=new DoLogin2();
						obj3.execute();

						dogc2.setChecked(true);
						
						dogc1.setChecked(false);
						dogc3.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});
				
				dogc3.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=dogc3.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj4=new DoLogin2();
						obj4.execute();
						dogc1.setChecked(true);
						
						dogc2.setChecked(false);
						dogc1.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});

				


			}
		});
		dob8.setOnClickListener(new View.OnClickListener() {
	
			@Override
		public void onClick(View arg0) {
		// TODO Auto-generated method stub
				e1.setText(dob8.getText());
				dogc1=(CheckBox)findViewById(R.id.dogcheckBox1);
				dogc2=(CheckBox)findViewById(R.id.dogcheckBox2);
				dogc3=(CheckBox)findViewById(R.id.dogcheckBox3);
				s1=dogc1.getText().toString();
			//	dogc1.setVisibility(TRIM_MEMORY_COMPLETE);
			//	dogc2.setVisibility(TRIM_MEMORY_COMPLETE);
			//	dogc3.setVisibility(TRIM_MEMORY_COMPLETE);
			//	t1=(TextView)findViewById(R.id.disdetailtv1);
				//t2=(TextView)findViewById(R.id.textView2);
				
				dogc1.setText("dis1");
				dogc2.setText("dis2");
				dogc3.setText("dis3");
				dogc1.setChecked(false);
				dogc2.setChecked(false);
				dogc3.setChecked(false);
				//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
				
				
				dogc1.setOnClickListener(new View.OnClickListener() {
					
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						s1=dogc1.getText().toString();
						
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj2=new DoLogin2();
						obj2.execute();
						
						dogc1.setChecked(true);
						dogc2.setChecked(false);
						dogc3.setChecked(false);
					}
				});
				
				dogc2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=dogc2.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj3=new DoLogin2();
						obj3.execute();

						dogc2.setChecked(true);
						
						dogc1.setChecked(false);
						dogc3.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});
				
				dogc3.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=dogc3.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj4=new DoLogin2();
						obj4.execute();
						dogc1.setChecked(true);
						
						dogc2.setChecked(false);
						dogc1.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});

				


			}
		});

		dob9.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
		// TODO Auto-generated method stub
				e1.setText(dob9.getText());

				dogc1=(CheckBox)findViewById(R.id.dogcheckBox1);
				dogc2=(CheckBox)findViewById(R.id.dogcheckBox2);
				dogc3=(CheckBox)findViewById(R.id.dogcheckBox3);
				s1=dogc1.getText().toString();
			//	dogc1.setVisibility(TRIM_MEMORY_COMPLETE);
			//	dogc2.setVisibility(TRIM_MEMORY_COMPLETE);
			//	dogc3.setVisibility(TRIM_MEMORY_COMPLETE);
			//	t1=(TextView)findViewById(R.id.disdetailtv1);
				//t2=(TextView)findViewById(R.id.textView2);
				
				dogc1.setText("dis1");
				dogc2.setText("dis2");
				dogc3.setText("dis3");
				dogc1.setChecked(false);
				dogc2.setChecked(false);
				dogc3.setChecked(false);
				//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
				
				
				dogc1.setOnClickListener(new View.OnClickListener() {
					
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						s1=dogc1.getText().toString();
						
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj2=new DoLogin2();
						obj2.execute();
						
						dogc1.setChecked(true);
						dogc2.setChecked(false);
						dogc3.setChecked(false);
					}
				});
				
				dogc2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=dogc2.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj3=new DoLogin2();
						obj3.execute();

						dogc2.setChecked(true);
						
						dogc1.setChecked(false);
						dogc3.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});
				
				dogc3.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=dogc3.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj4=new DoLogin2();
						obj4.execute();
						dogc1.setChecked(true);
						
						dogc2.setChecked(false);
						dogc1.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});

				


			}	
		});

		dob10.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				e1.setText(dob10.getText());

				dogc1=(CheckBox)findViewById(R.id.dogcheckBox1);
				dogc2=(CheckBox)findViewById(R.id.dogcheckBox2);
				dogc3=(CheckBox)findViewById(R.id.dogcheckBox3);
				s1=dogc1.getText().toString();
			//	dogc1.setVisibility(TRIM_MEMORY_COMPLETE);
			//	dogc2.setVisibility(TRIM_MEMORY_COMPLETE);
			//	dogc3.setVisibility(TRIM_MEMORY_COMPLETE);
			//	t1=(TextView)findViewById(R.id.disdetailtv1);
				//t2=(TextView)findViewById(R.id.textView2);
				
				dogc1.setText("dis1");
				dogc2.setText("dis2");
				dogc3.setText("dis3");
				dogc1.setChecked(false);
				dogc2.setChecked(false);
				dogc3.setChecked(false);
				//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
				
				
				dogc1.setOnClickListener(new View.OnClickListener() {
					
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						s1=dogc1.getText().toString();
						
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj2=new DoLogin2();
						obj2.execute();
						
						dogc1.setChecked(true);
						dogc2.setChecked(false);
						dogc3.setChecked(false);
					}
				});
				
				dogc2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=dogc2.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj3=new DoLogin2();
						obj3.execute();

						dogc2.setChecked(true);
						
						dogc1.setChecked(false);
						dogc3.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});
				
				dogc3.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=dogc3.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj4=new DoLogin2();
						obj4.execute();
						dogc1.setChecked(true);
						
						dogc2.setChecked(false);
						dogc1.setChecked(false);
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
	        request.addProperty("D_id",D_id);

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
		pdia = new ProgressDialog(dogsym.this);
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
		//Toast.makeText(getApplicationContext(), pro[0].toString(), Toast.LENGTH_SHORT).show();
		
		n2.Dis_name=pro[0];
		n2.Dis_details=pro[1];
		dname[k]=pro[0];
		ddetail1[k]=pro[1];
		k++;
		
		ddetail=pro[1];
	//	Toast.makeText(getApplicationContext(), ddetail, 200).show();
		n1.add(n2);
		//dsym1.t3.setText(n2.Dis_name);
		//dsym1.t5.setText(ddetail);
		
		//t2.setText(n2.Dis_name);
		//t1.setText(n2.Dis_details);

			//Log.d("data",n2.news_d);
			
		
	}
}

	

class DoLogin3 extends AsyncTask<Void, Void, String>
{
	private ProgressDialog pdia;
	
	@Override
	protected String doInBackground(Void... params) {
		// TODO Auto-generated method stub
		
		try
		{
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME1);
	        request.addProperty("P_id",s2);

	        //request.addProperty("password", e2.getText().toString());
	        
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet=true;
	        envelope.setOutputSoapObject(request);
	        
	        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        
	        androidHttpTransport.call(SOAP_ACTION1, envelope);
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
		pdia = new ProgressDialog(dogsym.this);
		pdia.setCanceledOnTouchOutside(false);
        pdia.setMessage("Loading...");
        pdia.show(); 
	}
	
	
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);    	    	
		//int result1;
		//result1=Integer.parseInt(result);
		pdia.dismiss();
		


		String pr[]=result.split("`");
		//Toast.makeText(getApplicationContext(), pro[0].toString(), Toast.LENGTH_SHORT).show();
	
		//n3.An_name=pr[0];
		//n3.Dis_id=pr[1];
		d[0]=Integer.parseInt(pr[0]);
		d[1]=Integer.parseInt(pr[1]);
		d[2]=Integer.parseInt(pr[2]);
		
		
		//i++;
	//	Toast.makeText(getApplicationContext(), ddetail, 200).show();
		//n4.add(n3);
		
		
		
		//t2.setText(n2.Dis_name);
		//t1.setText(n2.Dis_details);

			//Log.d("data",n2.news_d);
			
		
	}
}

	


}
