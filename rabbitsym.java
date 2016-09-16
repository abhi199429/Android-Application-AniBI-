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

public class rabbitsym extends Activity {
	
	Button reye,rmouth,rear,rback,rneck,rshoul,rhip,rtail,rleg1,rleg2,rleg3;
	TextView rabt1;
	public static TextView t1,t2;


	public static String s1="Anisocoria";
	public static String dname,ddetail;
	CheckBox rabc1,rabc2,rabc3;


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
	setContentView(R.layout.rabbitsym);
	
	reye=(Button)findViewById(R.id.rabeye);
	rmouth=(Button)findViewById(R.id.rabmouth);
	rear=(Button)findViewById(R.id.rabears);
	rback=(Button)findViewById(R.id.rabback);
	rneck=(Button)findViewById(R.id.rabneck);
	rshoul=(Button)findViewById(R.id.rabshoulder);
	rhip=(Button)findViewById(R.id.rabhip);
	rtail=(Button)findViewById(R.id.rabtail);
	rleg1=(Button)findViewById(R.id.rableg1);
	rleg2=(Button)findViewById(R.id.rableg2);
	rleg3=(Button)findViewById(R.id.rableg3);
	
	
	rabt1=(TextView)findViewById(R.id.rabtext);
	
	
	
	
	reye.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			rabt1.setText(reye.getText());

			
			rabc1=(CheckBox)findViewById(R.id.rabcheckBox1);
			rabc2=(CheckBox)findViewById(R.id.rabcheckBox2);
			rabc3=(CheckBox)findViewById(R.id.rabcheckBox3);
			s1=rabc1.getText().toString();
		//	rabc1.setVisibility(TRIM_MEMORY_COMPLETE);
		//	rabc2.setVisibility(TRIM_MEMORY_COMPLETE);
		//	rabc3.setVisibility(TRIM_MEMORY_COMPLETE);
		//	t1=(TextView)findViewById(R.id.disdetailtv1);
			//t2=(TextView)findViewById(R.id.textView2);
			
			rabc1.setText("dis1");
			rabc2.setText("dis2");
			rabc3.setText("dis3");
			rabc1.setChecked(false);
			rabc2.setChecked(false);
			rabc3.setChecked(false);
			//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
			
			
			rabc1.setOnClickListener(new View.OnClickListener() {
				
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					s1=rabc1.getText().toString();
					
					Intent i1=new Intent(getApplicationContext(), dsym1.class);
					startActivity(i1);
				
					DoLogin2 obj2=new DoLogin2();
					obj2.execute();
					
					rabc1.setChecked(true);
					rabc2.setChecked(false);
					rabc3.setChecked(false);
				}
			});
			
			rabc2.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					s1=rabc2.getText().toString();
					Intent i1=new Intent(getApplicationContext(), dsym1.class);
					startActivity(i1);
				
					DoLogin2 obj3=new DoLogin2();
					obj3.execute();

					rabc2.setChecked(true);
					
					rabc1.setChecked(false);
					rabc3.setChecked(false);
					//t2.setText(n2.Dis_name);
					//t1.setText(n2.Dis_details);
				}
			});
			
			rabc3.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					s1=rabc3.getText().toString();
					Intent i1=new Intent(getApplicationContext(), dsym1.class);
					startActivity(i1);
				
					DoLogin2 obj4=new DoLogin2();
					obj4.execute();
					rabc1.setChecked(true);
					
					rabc2.setChecked(false);
					rabc1.setChecked(false);
					//t2.setText(n2.Dis_name);
					//t1.setText(n2.Dis_details);
				}
			});

			


		}
	});
	
rmouth.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			rabt1.setText(rmouth.getText());
			rabc1=(CheckBox)findViewById(R.id.rabcheckBox1);
			rabc2=(CheckBox)findViewById(R.id.rabcheckBox2);
			rabc3=(CheckBox)findViewById(R.id.rabcheckBox3);
			s1=rabc1.getText().toString();
		//	rabc1.setVisibility(TRIM_MEMORY_COMPLETE);
		//	rabc2.setVisibility(TRIM_MEMORY_COMPLETE);
		//	rabc3.setVisibility(TRIM_MEMORY_COMPLETE);
		//	t1=(TextView)findViewById(R.id.disdetailtv1);
			//t2=(TextView)findViewById(R.id.textView2);
			
			rabc1.setText("dis1");
			rabc2.setText("dis2");
			rabc3.setText("dis3");
			rabc1.setChecked(false);
			rabc2.setChecked(false);
			rabc3.setChecked(false);
			//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
			
			
			rabc1.setOnClickListener(new View.OnClickListener() {
				
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					s1=rabc1.getText().toString();
					
					Intent i1=new Intent(getApplicationContext(), dsym1.class);
					startActivity(i1);
				
					DoLogin2 obj2=new DoLogin2();
					obj2.execute();
					
					rabc1.setChecked(true);
					rabc2.setChecked(false);
					rabc3.setChecked(false);
				}
			});
			
			rabc2.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					s1=rabc2.getText().toString();
					Intent i1=new Intent(getApplicationContext(), dsym1.class);
					startActivity(i1);
				
					DoLogin2 obj3=new DoLogin2();
					obj3.execute();

					rabc2.setChecked(true);
					
					rabc1.setChecked(false);
					rabc3.setChecked(false);
					//t2.setText(n2.Dis_name);
					//t1.setText(n2.Dis_details);
				}
			});
			
			rabc3.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					s1=rabc3.getText().toString();
					Intent i1=new Intent(getApplicationContext(), dsym1.class);
					startActivity(i1);
				
					DoLogin2 obj4=new DoLogin2();
					obj4.execute();
					rabc1.setChecked(true);
					
					rabc2.setChecked(false);
					rabc1.setChecked(false);
					//t2.setText(n2.Dis_name);
					//t1.setText(n2.Dis_details);
				}
			});

			

					
		}
	});
	
	
	
rear.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		rabt1.setText(rear.getText());
		rabc1=(CheckBox)findViewById(R.id.rabcheckBox1);
		rabc2=(CheckBox)findViewById(R.id.rabcheckBox2);
		rabc3=(CheckBox)findViewById(R.id.rabcheckBox3);
		s1=rabc1.getText().toString();
	//	rabc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	rabc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	rabc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		rabc1.setText("dis1");
		rabc2.setText("dis2");
		rabc3.setText("dis3");
		rabc1.setChecked(false);
		rabc2.setChecked(false);
		rabc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		rabc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=rabc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				rabc1.setChecked(true);
				rabc2.setChecked(false);
				rabc3.setChecked(false);
			}
		});
		
		rabc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=rabc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				rabc2.setChecked(true);
				
				rabc1.setChecked(false);
				rabc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		rabc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=rabc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				rabc1.setChecked(true);
				
				rabc2.setChecked(false);
				rabc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});

		

		
	}
});



rback.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		rabt1.setText(rback.getText());
		rabc1=(CheckBox)findViewById(R.id.rabcheckBox1);
		rabc2=(CheckBox)findViewById(R.id.rabcheckBox2);
		rabc3=(CheckBox)findViewById(R.id.rabcheckBox3);
		s1=rabc1.getText().toString();
	//	rabc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	rabc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	rabc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		rabc1.setText("dis1");
		rabc2.setText("dis2");
		rabc3.setText("dis3");
		rabc1.setChecked(false);
		rabc2.setChecked(false);
		rabc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		rabc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=rabc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				rabc1.setChecked(true);
				rabc2.setChecked(false);
				rabc3.setChecked(false);
			}
		});
		
		rabc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=rabc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				rabc2.setChecked(true);
				
				rabc1.setChecked(false);
				rabc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		rabc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=rabc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				rabc1.setChecked(true);
				
				rabc2.setChecked(false);
				rabc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});

		

				
	}
});

rneck.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		rabt1.setText(rneck.getText());
		rabc1=(CheckBox)findViewById(R.id.rabcheckBox1);
		rabc2=(CheckBox)findViewById(R.id.rabcheckBox2);
		rabc3=(CheckBox)findViewById(R.id.rabcheckBox3);
		s1=rabc1.getText().toString();
	//	rabc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	rabc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	rabc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		rabc1.setText("dis1");
		rabc2.setText("dis2");
		rabc3.setText("dis3");
		rabc1.setChecked(false);
		rabc2.setChecked(false);
		rabc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		rabc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=rabc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				rabc1.setChecked(true);
				rabc2.setChecked(false);
				rabc3.setChecked(false);
			}
		});
		
		rabc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=rabc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				rabc2.setChecked(true);
				
				rabc1.setChecked(false);
				rabc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		rabc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=rabc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				rabc1.setChecked(true);
				
				rabc2.setChecked(false);
				rabc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});

		

		
	}
});

	
rshoul.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		rabt1.setText(rshoul.getText());
		rabc1=(CheckBox)findViewById(R.id.rabcheckBox1);
		rabc2=(CheckBox)findViewById(R.id.rabcheckBox2);
		rabc3=(CheckBox)findViewById(R.id.rabcheckBox3);
		s1=rabc1.getText().toString();
	//	rabc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	rabc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	rabc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		rabc1.setText("dis1");
		rabc2.setText("dis2");
		rabc3.setText("dis3");
		rabc1.setChecked(false);
		rabc2.setChecked(false);
		rabc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		rabc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=rabc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				rabc1.setChecked(true);
				rabc2.setChecked(false);
				rabc3.setChecked(false);
			}
		});
		
		rabc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=rabc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				rabc2.setChecked(true);
				
				rabc1.setChecked(false);
				rabc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		rabc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=rabc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				rabc1.setChecked(true);
				
				rabc2.setChecked(false);
				rabc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});

		

		
	}
});


rhip.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		rabt1.setText(rhip.getText());
		rabc1=(CheckBox)findViewById(R.id.rabcheckBox1);
		rabc2=(CheckBox)findViewById(R.id.rabcheckBox2);
		rabc3=(CheckBox)findViewById(R.id.rabcheckBox3);
		s1=rabc1.getText().toString();
	//	rabc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	rabc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	rabc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		rabc1.setText("dis1");
		rabc2.setText("dis2");
		rabc3.setText("dis3");
		rabc1.setChecked(false);
		rabc2.setChecked(false);
		rabc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		rabc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=rabc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				rabc1.setChecked(true);
				rabc2.setChecked(false);
				rabc3.setChecked(false);
			}
		});
		
		rabc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=rabc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				rabc2.setChecked(true);
				
				rabc1.setChecked(false);
				rabc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		rabc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=rabc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				rabc1.setChecked(true);
				
				rabc2.setChecked(false);
				rabc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});

		

		
	}
});


rtail.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		rabt1.setText(rtail.getText());
		rabc1=(CheckBox)findViewById(R.id.rabcheckBox1);
		rabc2=(CheckBox)findViewById(R.id.rabcheckBox2);
		rabc3=(CheckBox)findViewById(R.id.rabcheckBox3);
		s1=rabc1.getText().toString();
	//	rabc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	rabc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	rabc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		rabc1.setText("dis1");
		rabc2.setText("dis2");
		rabc3.setText("dis3");
		rabc1.setChecked(false);
		rabc2.setChecked(false);
		rabc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		rabc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=rabc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				rabc1.setChecked(true);
				rabc2.setChecked(false);
				rabc3.setChecked(false);
			}
		});
		
		rabc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=rabc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				rabc2.setChecked(true);
				
				rabc1.setChecked(false);
				rabc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		rabc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=rabc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				rabc1.setChecked(true);
				
				rabc2.setChecked(false);
				rabc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});

		

		
	}
});


rleg1.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		rabt1.setText(rleg1.getText());
		rabc1=(CheckBox)findViewById(R.id.rabcheckBox1);
		rabc2=(CheckBox)findViewById(R.id.rabcheckBox2);
		rabc3=(CheckBox)findViewById(R.id.rabcheckBox3);
		s1=rabc1.getText().toString();
	//	rabc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	rabc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	rabc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		rabc1.setText("dis1");
		rabc2.setText("dis2");
		rabc3.setText("dis3");
		rabc1.setChecked(false);
		rabc2.setChecked(false);
		rabc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		rabc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=rabc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				rabc1.setChecked(true);
				rabc2.setChecked(false);
				rabc3.setChecked(false);
			}
		});
		
		rabc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=rabc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				rabc2.setChecked(true);
				
				rabc1.setChecked(false);
				rabc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		rabc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=rabc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				rabc1.setChecked(true);
				
				rabc2.setChecked(false);
				rabc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});

		

		
	}
});

rleg2.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		rabt1.setText(rleg2.getText());
		rabc1=(CheckBox)findViewById(R.id.rabcheckBox1);
		rabc2=(CheckBox)findViewById(R.id.rabcheckBox2);
		rabc3=(CheckBox)findViewById(R.id.rabcheckBox3);
		s1=rabc1.getText().toString();
	//	rabc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	rabc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	rabc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		rabc1.setText("dis1");
		rabc2.setText("dis2");
		rabc3.setText("dis3");
		rabc1.setChecked(false);
		rabc2.setChecked(false);
		rabc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		rabc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=rabc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				rabc1.setChecked(true);
				rabc2.setChecked(false);
				rabc3.setChecked(false);
			}
		});
		
		rabc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=rabc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				rabc2.setChecked(true);
				
				rabc1.setChecked(false);
				rabc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		rabc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=rabc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				rabc1.setChecked(true);
				
				rabc2.setChecked(false);
				rabc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});

		

		
	}
});


rleg3.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		rabt1.setText(rleg3.getText());
		rabc1=(CheckBox)findViewById(R.id.rabcheckBox1);
		rabc2=(CheckBox)findViewById(R.id.rabcheckBox2);
		rabc3=(CheckBox)findViewById(R.id.rabcheckBox3);
		s1=rabc1.getText().toString();
	//	rabc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	rabc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	rabc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		rabc1.setText("dis1");
		rabc2.setText("dis2");
		rabc3.setText("dis3");
		rabc1.setChecked(false);
		rabc2.setChecked(false);
		rabc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		rabc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=rabc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				rabc1.setChecked(true);
				rabc2.setChecked(false);
				rabc3.setChecked(false);
			}
		});
		
		rabc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=rabc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				rabc2.setChecked(true);
				
				rabc1.setChecked(false);
				rabc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		rabc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=rabc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				rabc1.setChecked(true);
				
				rabc2.setChecked(false);
				rabc1.setChecked(false);
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
		pdia = new ProgressDialog(rabbitsym.this);
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
